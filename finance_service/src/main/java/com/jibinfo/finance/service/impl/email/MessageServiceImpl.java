package com.jibinfo.finance.service.impl.email;

import com.alibaba.fastjson.JSONObject;
import com.jibinfo.finance.entity.email.EmailGateway;
import com.jibinfo.finance.entity.sms.SmsGateway;
import com.jibinfo.finance.enums.EmailEnum;
import com.jibinfo.finance.enums.SmsEnum;
import com.jibinfo.finance.service.email.EmailContentService;
import com.jibinfo.finance.service.email.EmailGatewayService;
import com.jibinfo.finance.service.email.MessageService;
import com.jibinfo.finance.service.sms.SmsContentService;
import com.jibinfo.finance.service.sms.SmsGatewayService;
import com.jibinfo.finance.vo.email.EmailVO;
import com.jibinfo.finance.vo.sms.SmsVO;
import com.jibinfo.framework.utils.StringUtils;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.BizResult;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/26.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

//    private static final Log log = LogFactory.getLog(MessageServiceImpl.class);



    @Resource
    private EmailGatewayService emailGatewayService;

    @Resource
    private EmailContentService emailContentService;

    @Resource
    private SmsGatewayService smsGatewayService;

    @Resource
    private SmsContentService smsContentService;

    @Override
    public void sendEmail(EmailVO emailVO,String... receivers) {
        EmailGateway emailGateway = emailGatewayService.getEmailGateway();
        if(null == emailGateway){
//          emailContentService.saveEmailContent(emailGateway.getId(),emailVO, 2, EmailEnum.CLOSE.getStatus(),EmailEnum.CLOSE.getStatusName(),receivers);
        	emailContentService.saveEmailContent(0L,emailVO, 2, EmailEnum.CLOSE.getStatus(),EmailEnum.CLOSE.getStatusName(),receivers);
        	return;
        }
        // 发送email
        HtmlEmail email = new HtmlEmail();
        List<String> successReceiver = new ArrayList<>();
        for (String receiver : receivers) {
            try {
                // 这里是SMTP发送服务器的名字：
                email.setHostName(emailGateway.getEmailHost());
                // 字符编码集的设置
                email.setCharset(EmailVO.ENCODEING);
                // 收件人的邮箱
                email.addTo(receiver);
                // 发送人的邮箱
                email.setFrom(emailGateway.getSender());
                // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
                email.setAuthentication(emailGateway.getEmailUserName(), emailGateway.getEmailPassword());
                // 要发送的邮件主题
                email.setSubject(emailVO.getSubject());
                // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
                email.setMsg(EmailVO.composeMessage(emailVO.getMessage(),emailVO.getParams()));
                // 发送
                email.send();
                successReceiver.add(receiver);
            } catch (EmailException e) {
                e.printStackTrace();
                emailContentService.saveEmailContent(emailGateway.getId(),emailVO, 1,EmailEnum.EXCEPTION.getStatus(),EmailEnum.EXCEPTION.getStatusName(),receiver);

            }

        }
        String[] array = new String[successReceiver.size()];
        emailContentService.saveEmailContent(emailGateway.getId(),emailVO, 0,EmailEnum.SUCCESS.getStatus(),EmailEnum.SUCCESS.getStatusName(),successReceiver.toArray(array));

    }

    /**
     * 暂时只支持阿里大鱼的短信网关
     * @param smsVO
     * @param mobiles
     */
    @Override
    public void sendSms(SmsVO smsVO, String... mobiles) {
        SmsGateway smsGateway = smsGatewayService.getSmsGatewayBySourceCode(smsVO.getSourceCode());
        String content = JSONObject.toJSONString(smsVO.getParams());
        if(null == smsGateway){
            smsContentService.saveSmsContent(-1L,smsVO.getTemplate(), smsVO.getType(),
                    content,"2", SmsEnum.CLOSE.getStatus(),SmsEnum.CLOSE.getStatusName(),mobiles);
            return;
        }
        String mobile = StringUtils.join(mobiles, ",");
        try {
            TaobaoClient client = new DefaultTaobaoClient(smsGateway.getRequestUrl(), smsGateway.getAppKey(), smsGateway.getAppSecret());
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setExtend("");
            req.setSmsType(smsGateway.getType());
            req.setSmsParamString(content);
            req.setSmsFreeSignName(smsGateway.getSignName());
            req.setRecNum(mobile);
            req.setSmsTemplateCode(smsVO.getTemplate());
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            BizResult result = rsp.getResult();
            String errCode = rsp.getErrorCode();
            Boolean success = result.getSuccess();
            String msg = result.getMsg();
            String status = "1";
            if(success){
                status = "0";
                errCode = SmsEnum.SUCCESS.getStatus();
                msg = SmsEnum.SUCCESS.getStatusName();
            }

            smsContentService.saveSmsContent(smsGateway.getId(),smsVO.getTemplate(),
                    smsVO.getType(), content,status, errCode,msg,mobile);
        } catch (Exception e) {
            e.printStackTrace();
            smsContentService.saveSmsContent(smsGateway.getId(),smsVO.getTemplate(),
                    smsVO.getType(), content,"1", SmsEnum.EXCEPTION.getStatus(),SmsEnum.EXCEPTION.getStatusName(),mobile);
        }


    }









}
