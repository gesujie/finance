package com.jibinfo.finance.service.impl.system;

import java.util.Date;
import java.util.List;

import com.jibinfo.finance.entity.system.SystemChannel;
import com.jibinfo.finance.entity.system.SystemChannelExample;
import com.jibinfo.finance.entity.system.SystemChannelExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemChannelMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemChannelService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service("systemChannelService")
public class SystemChannelServiceImpl extends AbstractBaseServiceEx<SystemChannelExample, SystemChannel> implements SystemChannelService {

	@Resource
	private SystemChannelMapper systemChannelMapper;

	@Override
	public BaseMapper<SystemChannelExample, SystemChannel> getMapper() {
		return systemChannelMapper;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemChannel model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null == model.getId()){
				model.setCreatedDate(date);
				systemChannelMapper.insertSelective(model);
			} else{
				systemChannelMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	@Override
	public PageModel<SystemChannel> getData(Integer pageNumber,
			Integer pageSize, SystemChannel model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		SystemChannelExample example = new SystemChannelExample();
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
		}

		example.setPaginator(paginator);
		List<SystemChannel> systemChannelList = systemChannelMapper.selectByExample(example);
		int total = systemChannelMapper.countByExample(example);
		PageModel<SystemChannel> pageModel = new PageModel<>(total, systemChannelList);
		
		return pageModel;
	}
	
	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemChannel model = systemChannelMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemChannelMapper.updateByPrimaryKeySelective(model);
				}
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}
}
