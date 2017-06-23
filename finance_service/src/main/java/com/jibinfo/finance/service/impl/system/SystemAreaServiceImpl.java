package com.jibinfo.finance.service.impl.system;

import java.util.Date;
import java.util.List;

import com.jibinfo.finance.entity.system.SystemArea;
import com.jibinfo.finance.entity.system.SystemAreaExample;
import com.jibinfo.finance.entity.system.SystemAreaExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemAreaMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemAreaService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service("systemAreaService")
public class SystemAreaServiceImpl extends AbstractBaseServiceEx<SystemAreaExample, SystemArea> implements SystemAreaService {

	@Resource
	private SystemAreaMapper systemAreaMapper;

	@Override
	public BaseMapper<SystemAreaExample, SystemArea> getMapper() {
		return systemAreaMapper;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemArea model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null == model.getId()){
				model.setCreatedDate(date);
				systemAreaMapper.insertSelective(model);
			} else{
				systemAreaMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	@Override
	public PageModel<SystemArea> getData(Integer pageNumber,
			Integer pageSize, SystemArea model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		SystemAreaExample example = new SystemAreaExample();
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
		List<SystemArea> systemAreas = systemAreaMapper.selectByExample(example);
		int total = systemAreaMapper.countByExample(example);
		PageModel<SystemArea> pageModel = new PageModel<>(total, systemAreas);
		
		return pageModel;
	}
	
	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemArea model = systemAreaMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemAreaMapper.updateByPrimaryKeySelective(model);
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
		String prefix = "A";
		Long maxId = systemAreaMapper.findMaxId();
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

	
}
