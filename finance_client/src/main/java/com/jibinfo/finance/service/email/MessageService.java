package com.jibinfo.finance.service.email;

import com.jibinfo.finance.vo.email.EmailVO;
import com.jibinfo.finance.vo.sms.SmsVO;

/**
 * Created by admin on 2017/4/24.
 */
public interface MessageService{

    /**
     * 发送邮件内容
     * @param email       发送邮件的内容
     * @param receivers   接收者集合
     */
    void sendEmail(EmailVO email,String... receivers);



    void sendSms(SmsVO smsVO, String... mobiles);

}
