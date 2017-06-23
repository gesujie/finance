package com.jibinfo.finance.service.sms;

import com.jibinfo.finance.entity.sms.SmsContent;
import com.jibinfo.finance.entity.sms.SmsContentExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.service.BaseService;

public interface SmsContentService extends
		BaseService<SmsContentExample, SmsContent> {
	PageModel<SmsContent> getData(Integer pageNumber, Integer pageSize,
			SmsContent content);



	/**
	 *
	 * 保存发送内容
	 * @param gid     网关id
	 * @param template 模板CODE
	 * @param type	  短信/验证码
	 * @param params  参数json
	 * @param status  结果状态
	 * @param code    结果code
	 * @param msg     结果msg
	 * @param mobile  手机号
	 */
	void saveSmsContent(Long gid, String template, String type, String params, String status, String code, String msg,String... mobiles);
}
