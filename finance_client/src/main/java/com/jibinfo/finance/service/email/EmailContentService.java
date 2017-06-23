package com.jibinfo.finance.service.email;

import com.jibinfo.finance.entity.email.EmailContent;
import com.jibinfo.finance.entity.email.EmailContentExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.vo.email.EmailVO;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

/**
 * Created by admin on 2017/4/24.
 */
public interface EmailContentService extends BaseService<EmailContentExample, EmailContent> {

    /**
     * 保存发送的内容
     * @param eid
     * @param emailVO
     * @param type
     * @param code
     * @param msg
     * @param receivers
     */
    void saveEmailContent(Long eid, EmailVO emailVO, int type,String code,String msg,String... receivers);


    PageModel<EmailContent> getData(EmailContent param, Integer pageNumber, Integer pageSize);

    ResponseVo delete(String ids);
}
