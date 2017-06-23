package com.jibinfo.finance.service.impl.quartz;


import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.entity.quartz.QuartzExample;
import com.jibinfo.finance.enums.QuartzEnum;
import com.jibinfo.finance.mapper.quartz.QuartzMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.quartz.QuartzService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.twitter.IdWorkerUtils;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */

@Service("quartzService")
public class QuartzServiceImpl extends AbstractBaseServiceEx<QuartzExample, Quartz> implements QuartzService {

    @Resource
    private QuartzMapper quartzMapper;

    @Override
    public BaseMapper<QuartzExample, Quartz> getMapper() {
        return quartzMapper;
    }


    @Override
    public PageModel<Quartz> getData(Integer pageNumber, Integer pageSize, Quartz model) {
        Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
        QuartzExample example = new QuartzExample();
        QuartzExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
        example.setOrderByClause("ID DESC");
        if(null != model){
            if(StringUtils.isNotEmpty(model.getName())){
                criteria.andNameLike("%"+model.getName()+"%");
            }
        }

        example.setPaginator(paginator);
        List<Quartz> quartzs = quartzMapper.selectByExample(example);
        int total = quartzMapper.countByExample(example);
        PageModel<Quartz> pageModel = new PageModel<>(total, quartzs);
        return pageModel;
    }

    /**
     * c查询具体模块下的可用的定时任务列表
     * @param module
     * @return
     */
    @Override
    public List<Quartz> findByModule(String module) {
        QuartzExample example = new QuartzExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
                .andStatusIn(this.getEnableStatus());
        List<Quartz> quartzs = quartzMapper.selectByExample(example);
        return quartzs;
    }

    /**
     * c查询具体模块下的可用的定时任务列表
     * @param module
     * @return
     */
    @Override
    public List<Quartz> findByModuleInitEnd(String module) {
        QuartzExample example = new QuartzExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
                .andStatusIn(this.getInitEndStatus());
        List<Quartz> quartzs = quartzMapper.selectByExample(example);
        return quartzs;
    }


    @Override
    public ResponseVo saveOrUpdate(Quartz quartz) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        try {
            Date date = new Date();
            quartz.setUpdatedDate(date);
            if(null == quartz.getId()){
                Long id = IdWorkerUtils.getId();
                quartz.setStatus(QuartzEnum.INIT.getStatus());
                quartz.setCreatedDate(date);
                quartz.setJobName("J"+id);
                quartz.setTriggerName("T"+id);
                quartz.setGroupName("G"+id);
                quartz.setIsDel(Constants.NO_DEL);
                quartzMapper.insertSelective(quartz);
            }
            else{
                quartzMapper.updateByPrimaryKeySelective(quartz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }


        return responseVo;
    }

    @Override
    public ResponseVo delete(String ids) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        try {
            String[] split = ids.split(",");
            for (String id : split) {
                Quartz quartz = quartzMapper.selectByPrimaryKey(new Long(id));
                quartz.setIsDel(Constants.YES_DEL);
                quartz.setUpdatedDate(new Date());
                quartzMapper.updateByPrimaryKeySelective(quartz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }
        return responseVo;
    }

    @Override
    public Quartz findByGroup(String group) {
        QuartzExample example = new QuartzExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andGroupNameEqualTo(group);
        List<Quartz> quartzs = quartzMapper.selectByExample(example);
        if(quartzs.size() > 0)
            return quartzs.get(0);
        return null;
    }


    /**
     * NONE = 未知  ,
     * NORMAL = 正常无任务，用这个判断Job是否在运行 ,
     * PAUSED = 暂停状态 ,
     * COMPLETE =完成那一刻，不过一般不用这个判断Job状态 ,
     * ERROR =错误 ,
     * BLOCKED=运行
     * @return
     */
    private List<String> getEnableStatus(){
        List<String> statusList = new ArrayList<String>();
        statusList.add(QuartzEnum.NONE.getStatus());
        statusList.add(QuartzEnum.NORMAL.getStatus());
        statusList.add(QuartzEnum.BLOCKED.getStatus());
        //statusList.add(QuartzEnum.ERROR.getStatus());

        return statusList;
    }

    /**
     * NONE = 未知  ,
     * NORMAL = 正常无任务，用这个判断Job是否在运行 ,
     * PAUSED = 暂停状态 ,
     * COMPLETE =完成那一刻，不过一般不用这个判断Job状态 ,
     * ERROR =错误 ,
     * BLOCKED=运行
     * @return
     */
    private List<String> getInitEndStatus(){
        List<String> statusList = new ArrayList<String>();
        statusList.add(QuartzEnum.NONE.getStatus());
        statusList.add(QuartzEnum.NORMAL.getStatus());
        statusList.add(QuartzEnum.BLOCKED.getStatus());
        statusList.add(QuartzEnum.PAUSED.getStatus());
        statusList.add(QuartzEnum.ERROR.getStatus());
        statusList.add(QuartzEnum.BLOCKED.getStatus());
        return statusList;
    }




}
