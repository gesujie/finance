package com.jibinfo.finance.service.impl.surveys;


import com.jibinfo.finance.dto.SurverysDataDTO;
import com.jibinfo.finance.entity.surveys.SurverysData;
import com.jibinfo.finance.entity.surveys.SurverysDataExample;
import com.jibinfo.finance.mapper.surveys.SurverysDataMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.model.SurverysResult;
import com.jibinfo.finance.service.surveys.SurverysDataService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by admin on 2017/4/24.
 */

@Service("surverysDataService")
public class SurverysDataServiceImpl extends AbstractBaseServiceEx<SurverysDataExample, SurverysData> implements SurverysDataService {

    @Resource
    private SurverysDataMapper surverysDataMapper;

    @Override
    public BaseMapper<SurverysDataExample, SurverysData> getMapper() {
        return surverysDataMapper;
    }


    @Override
    public PageModel<SurverysDataDTO> getData(Integer pageNumber, Integer pageSize, SurverysData surverysData) {
        SurverysDataExample example = new SurverysDataExample();
        SurverysDataExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);

        if(null != surverysData){
            if(StringUtils.isNotEmpty(surverysData.getOptionname())){
                criteria.andOptionnameLike("%"+surverysData.getOptionname()+"%");
            }
            if(null != surverysData.getParOptionId()){
                criteria.andParOptionIdEqualTo(surverysData.getParOptionId());
            }
        }

        Paginator paginator = new Paginator().getPaginator(pageNumber,pageSize);
        example.setOrderByClause("id desc,PAR_OPTION_ID ASC ");
        example.setPaginator(paginator);
        List<SurverysData> surverysDatas = surverysDataMapper.selectByExample(example);
        int count = surverysDataMapper.countByExample(example);
        List<SurverysDataDTO> surverysDataDTOs = new ArrayList<SurverysDataDTO>();
        if(null != surverysDatas && surverysDatas.size() > 0){
            for (SurverysData data : surverysDatas) {
                SurverysDataDTO surverysDataDTO = new SurverysDataDTO();
                BeanUtils.copyProperties(data,surverysDataDTO);
                if(data.getParOptionId() != -1L){
                    SurverysData surverysData1 = surverysDataMapper.selectByPrimaryKey(data.getParOptionId());
                    surverysDataDTO.setParOptionName(surverysData1.getOptionname());
                }
                surverysDataDTOs.add(surverysDataDTO);
            }
        }

        PageModel<SurverysDataDTO> pageModel = new PageModel<>(count,surverysDataDTOs);
        return pageModel;
    }

    @Override
    public ResponseVo saveOrUpdate(SurverysData model) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        Date date = new Date();
        model.setUpdatedDate(date);
        if(null == model.getId()){
            model.setIsDel(Constants.NO_DEL);
            model.setCreatedDate(date);
            model.setCode(this.getCode());
            surverysDataMapper.insertSelective(model);
        }
        else{
            if(model.getParOptionId() != -1L){
                model.setDataType("");
            }

            surverysDataMapper.updateByPrimaryKeySelective(model);
        }

        return responseVo;
    }

    @Override
    public String getCode() {
        String prefix = "S";
        Long maxId = surverysDataMapper.findMaxId();
        if(null == maxId){
            maxId = 0L;

        }
        String maxIdStr = maxId.toString();
        if(maxIdStr.length() >= 6){
            prefix = prefix + maxIdStr;
        }
        else{
            int len = 6 - maxIdStr.length();
            for (int i = 0 ; i < len ; i++){
                maxIdStr = "0"+maxIdStr;
            }
            prefix = prefix + maxIdStr;
        }
        return prefix;
    }

    @Override
    public List<SurverysData> getDataType() {
        SurverysDataExample example = new SurverysDataExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andParOptionIdEqualTo(-1L);
        List<SurverysData> list = surverysDataMapper.selectByExample(example);

        return list;
    }

    /**
     * 获取答题完成的代金券额度
     * @param jsonData  答题数据,json格式
     * @return
     */
    @Override
    public SurverysResult getSurverysResult(String jsonData) {
        SurverysResult surverysResult = new SurverysResult();
        surverysResult.setCode(UUID.randomUUID().toString().replace("-",""));
        surverysResult.setLoanLimit(this.getRandom());

        return surverysResult;
    }




    private double getRandom(){
        Random random = new Random();
        double dv = random.nextDouble();
        BigDecimal bg = new BigDecimal(dv*70).setScale(2, RoundingMode.UP);
        if(bg.doubleValue() >= 50)
            bg = new BigDecimal("50");
        if(bg.doubleValue() < 7 ){
            bg = new BigDecimal("7");
        }
        return bg.doubleValue();
    }


}
