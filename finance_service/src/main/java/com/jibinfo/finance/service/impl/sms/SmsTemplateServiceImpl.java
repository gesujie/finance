package com.jibinfo.finance.service.impl.sms;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.entity.sms.SmsTemplateExample;
import com.jibinfo.finance.entity.sms.SmsTemplateExample.Criteria;
import com.jibinfo.finance.mapper.sms.SmsTemplateMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsTemplateService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("smsTemplateService")
public class SmsTemplateServiceImpl extends
		AbstractBaseServiceEx<SmsTemplateExample, SmsTemplate> implements
		SmsTemplateService {

	@Resource
	private SmsTemplateMapper smsTemplateMapper;

	@Override
	public BaseMapper<SmsTemplateExample, SmsTemplate> getMapper() {
		return smsTemplateMapper;
	}

	@Override
	public PageModel<SmsTemplate> getData(Integer pageNumber, Integer pageSize,
			SmsTemplate template) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SmsTemplateExample example = new SmsTemplateExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != template) {
			if (null != template.getType()
					&& !StringUtils.equalsIgnoreCase("-1", template.getType())) {
				criteria.andTypeEqualTo(template.getType());
			}

			if (StringUtils.isNotEmpty(template.getCode())) {
				criteria.andCodeLike("%" + template.getCode() + "%");
			}

			if (StringUtils.isNotEmpty(template.getName())) {
				criteria.andNameLike("%" + template.getName() + "%");
			}
		}

		List<SmsTemplate> templates = smsTemplateMapper
				.selectByExample(example);
		int total = smsTemplateMapper.countByExample(example);
		PageModel<SmsTemplate> pageModel = new PageModel<>(total, templates);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(SmsTemplate template) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = template.getId();
		if (null == id) {// 添加
			template.setCreatedDate(new Date());
			template.setUpdatedDate(new Date());
			template.setIsDel(Constants.NO_DEL);
			smsTemplateMapper.insertSelective(template);
		}

		if (null != id) {// 修改
			template.setUpdatedDate(new Date());
			smsTemplateMapper.updateByPrimaryKeySelective(template);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				SmsTemplate template = smsTemplateMapper
						.selectByPrimaryKey(new Long(id));
				template.setUpdatedDate(new Date());
				template.setIsDel(Constants.YES_DEL);
				smsTemplateMapper.updateByPrimaryKeySelective(template);
			}
		}
		return result;
	}
}
