package com.jibinfo.finance.service.impl.system;

import java.util.Date;
import java.util.List;

import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.entity.system.SystemProvinceExample;
import com.jibinfo.finance.entity.system.SystemProvinceExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemProvinceMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemProvinceService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service("systemProvinceService")
public class SystemProvinceServiceImpl extends AbstractBaseServiceEx<SystemProvinceExample, SystemProvince> implements SystemProvinceService {

	@Resource
	private SystemProvinceMapper systemProvinceMapper;

	@Override
	public BaseMapper<SystemProvinceExample, SystemProvince> getMapper() {
		return systemProvinceMapper;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemProvince model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null == model.getId()){
				model.setCreatedDate(date);
				systemProvinceMapper.insertSelective(model);
			} else{
				systemProvinceMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	@Override
	public PageModel<SystemProvince> getData(Integer pageNumber,
			Integer pageSize, SystemProvince model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		SystemProvinceExample example = new SystemProvinceExample();
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
		List<SystemProvince> systemProvinces = systemProvinceMapper.selectByExample(example);
		int total = systemProvinceMapper.countByExample(example);
		PageModel<SystemProvince> pageModel = new PageModel<>(total, systemProvinces);
		
		return pageModel;
	}
	
	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemProvince model = systemProvinceMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemProvinceMapper.updateByPrimaryKeySelective(model);
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
		String prefix = "P";
		Long maxId = systemProvinceMapper.findMaxId();
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
	public SystemProvince findByCode(String code) {
		SystemProvinceExample example = new SystemProvinceExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andCodeEqualTo(code);
		List<SystemProvince> systemProvinceList = systemProvinceMapper.selectByExample(example);
		if(null != systemProvinceList && systemProvinceList.size() > 0) {
			SystemProvince systemProvince = systemProvinceList.get(0);
			return systemProvince;
		} else {
			return null;
		}
		
	}
	
	
}
