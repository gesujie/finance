package com.jibinfo.finance.service.sms;

import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.entity.sms.SmsTemplateExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SmsTemplateService extends
		BaseService<SmsTemplateExample, SmsTemplate> {

	PageModel<SmsTemplate> getData(Integer pageNumber, Integer pageSize,
			SmsTemplate template);

	ResponseVo saveOrUpdate(SmsTemplate template);

	ResponseVo delete(String ids);
}
