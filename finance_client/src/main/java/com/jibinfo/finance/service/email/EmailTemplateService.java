package com.jibinfo.finance.service.email;

import com.jibinfo.finance.entity.email.EmailTemplate;
import com.jibinfo.finance.entity.email.EmailTemplateExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

/**
 * Created by admin on 2017/4/24.
 */
public interface EmailTemplateService extends BaseService<EmailTemplateExample, EmailTemplate> {


    PageModel<EmailTemplate> getData(EmailTemplate param, Integer pageNumber, Integer pageSize);

    ResponseVo saveOrUpdate(EmailTemplate model);

    ResponseVo delete(String ids);

    EmailTemplate getTemplateByCode(String code);
}
