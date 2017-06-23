package com.jibinfo.finance.service.impl.system;

import java.util.Date;
import java.util.List;

import com.jibinfo.finance.entity.system.SystemSensitive;
import com.jibinfo.finance.entity.system.SystemSensitiveExample;
import com.jibinfo.finance.entity.system.SystemSensitiveExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemSensitiveMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemSensitiveService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service("systemSensitiveService")
public class SystemSensitiveServiceImpl extends AbstractBaseServiceEx<SystemSensitiveExample, SystemSensitive> implements SystemSensitiveService {

	@Resource
	private SystemSensitiveMapper systemSensitiveMapper;

	@Override
	public BaseMapper<SystemSensitiveExample, SystemSensitive> getMapper() {
		return systemSensitiveMapper;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemSensitive model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(null == model.getId()){
				model.setCreatedDate(date);
				systemSensitiveMapper.insertSelective(model);
			} else{
				systemSensitiveMapper.updateByPrimaryKeySelective(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	@Override
	public PageModel<SystemSensitive> getData(Integer pageNumber,
			Integer pageSize, SystemSensitive model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		SystemSensitiveExample example = new SystemSensitiveExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");
		
		if (model != null) {
			if(!StringUtils.isEmpty(model.getWords())){
				criteria.andWordsLike("%"+model.getWords()+"%");
			}
			if(!StringUtils.isEmpty(model.getRemark())){
				criteria.andRemarkLike("%"+model.getRemark()+"%");
			}
		}

		example.setPaginator(paginator);
		List<SystemSensitive> SystemSensitiveList = systemSensitiveMapper.selectByExample(example);
		int total = systemSensitiveMapper.countByExample(example);
		PageModel<SystemSensitive> pageModel = new PageModel<>(total, SystemSensitiveList);
		
		return pageModel;
	}
	
	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemSensitive model = systemSensitiveMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemSensitiveMapper.updateByPrimaryKeySelective(model);
				}
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}
}
