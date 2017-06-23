package com.jibinfo.finance.service.impl.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.system.SystemCity;
import com.jibinfo.finance.entity.system.SystemCityExample;
import com.jibinfo.finance.entity.system.SystemCityExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemCityMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemCityService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;


@Service("systemCityService")
public class SystemCityServiceImpl extends AbstractBaseServiceEx<SystemCityExample, SystemCity> implements SystemCityService {

	@Resource
	private SystemCityMapper systemCityMapper;

	@Override
	public BaseMapper<SystemCityExample, SystemCity> getMapper() {
		return systemCityMapper;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemCity model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null == model.getId()){
				model.setCreatedDate(date);
				systemCityMapper.insertSelective(model);
			} else{
				systemCityMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	@Override
	public PageModel<SystemCity> getData(Integer pageNumber,
			Integer pageSize, SystemCity model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		SystemCityExample example = new SystemCityExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");
		
		if (model != null) {
			if(!StringUtils.isEmpty(model.getCode())){
				criteria.andCodeLike("%"+model.getCode()+"%");
			}
			if(!StringUtils.isEmpty(model.getName())){
				criteria.andNameLike("%"+model.getName()+"%");
			}
			if(!StringUtils.isEmpty(model.getShortName())){
				criteria.andShortNameLike("%"+model.getShortName()+"%");
			}
		}

		example.setPaginator(paginator);
		List<SystemCity> systemCitys = systemCityMapper.selectByExample(example);
		int total = systemCityMapper.countByExample(example);
		PageModel<SystemCity> pageModel = new PageModel<>(total, systemCitys);
		
		return pageModel;
	}
	
	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemCity model = systemCityMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemCityMapper.updateByPrimaryKeySelective(model);
				}
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String findMaxCode() {
		String prefix = "C";
		Long maxId = systemCityMapper.findMaxId();
		if(null == maxId){
			maxId = 0L;

		}
		Long IdMax = maxId +1;
		String maxIdStr = IdMax.toString();
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
	public List<Long> getCidByPid(Long provinceId) {
		List<Long> cids = new ArrayList<>();

		SystemCityExample example = new SystemCityExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andPidEqualTo(provinceId);

		List<SystemCity> list = systemCityMapper.selectByExample(example);
		if (null != list && !list.isEmpty()) {
			for (SystemCity systemCity : list) {
				cids.add(systemCity.getId());
			}
		}
		return cids;
	}
}
