package com.jibinfo.finance.service.email;


import com.jibinfo.finance.entity.email.EmailGateway;
import com.jibinfo.finance.entity.email.EmailGatewayExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;


/**
 * Created by admin on 2017/4/24.
 */
public interface EmailGatewayService extends BaseService<EmailGatewayExample, EmailGateway> {


    PageModel<EmailGateway> getData(EmailGateway param, Integer pageNumber, Integer pageSize);

    ResponseVo saveOrUpdate(EmailGateway model);

    ResponseVo changeState(Long id);

    ResponseVo delete(String ids);

    EmailGateway getEmailGateway();
}
