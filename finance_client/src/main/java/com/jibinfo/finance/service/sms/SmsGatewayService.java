package com.jibinfo.finance.service.sms;

import com.jibinfo.finance.entity.sms.SmsGateway;
import com.jibinfo.finance.entity.sms.SmsGatewayExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SmsGatewayService extends
		BaseService<SmsGatewayExample, SmsGateway> {

	PageModel<SmsGateway> getData(Integer pageNumber, Integer pageSize,
			SmsGateway gateway);

	ResponseVo saveOrUpdate(SmsGateway gateway);

	ResponseVo delete(String ids);

	ResponseVo changeOnOff(Long id);

	SmsGateway getSmsGatewayBySourceCode(String scode);
}
