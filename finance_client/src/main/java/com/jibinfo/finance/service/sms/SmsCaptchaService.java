package com.jibinfo.finance.service.sms;

import com.jibinfo.finance.entity.sms.SmsCaptcha;
import com.jibinfo.finance.entity.sms.SmsCaptchaExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.service.BaseService;

public interface SmsCaptchaService extends
		BaseService<SmsCaptchaExample, SmsCaptcha> {

	PageModel<SmsCaptcha> getData(Integer pageNumber, Integer pageSize,
			SmsCaptcha captcha);
}
