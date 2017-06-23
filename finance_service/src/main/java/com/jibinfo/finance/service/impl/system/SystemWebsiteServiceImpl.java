package com.jibinfo.finance.service.impl.system;

import com.jibinfo.finance.entity.system.SystemWebsite;
import com.jibinfo.finance.entity.system.SystemWebsiteExample;
import com.jibinfo.finance.mapper.system.SystemWebsiteMapper;
import com.jibinfo.finance.service.system.SystemWebsiteService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("systemWebsiteService")
public class SystemWebsiteServiceImpl extends
		AbstractBaseServiceEx<SystemWebsiteExample, SystemWebsite> implements
		SystemWebsiteService {

	@Resource
	private SystemWebsiteMapper systemWebsiteMapper;

	@Override
	public BaseMapper<SystemWebsiteExample, SystemWebsite> getMapper() {
		return systemWebsiteMapper;
	}


	@Override
	public ResponseVo saveOrUpdate(SystemWebsite model){
		ResponseVo result = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null != model.getId()){
				systemWebsiteMapper.updateByPrimaryKeySelective(model);
            }
            else{
				model.setIsDel(Constants.NO_DEL);
				model.setCreatedDate(date);
                systemWebsiteMapper.insertSelective(model);
            }
			result.setBody(model);
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseVo().failureResponse();
		}
		return result;
	}

	@Override
	public SystemWebsite findOne() {
		SystemWebsiteExample example = new SystemWebsiteExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		List<SystemWebsite> systemWebsites = systemWebsiteMapper.selectByExample(example);
		if(null != systemWebsites && systemWebsites.size() > 0)
			return systemWebsites.get(0);
		return null;
	}

}
