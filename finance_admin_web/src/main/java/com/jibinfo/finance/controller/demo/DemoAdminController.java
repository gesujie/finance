package com.jibinfo.finance.controller.demo;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.demo.Demo;
import com.jibinfo.finance.entity.email.EmailTemplate;
import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.model.SurverysResult;
import com.jibinfo.finance.service.demo.DemoService;
import com.jibinfo.finance.service.email.EmailTemplateService;
import com.jibinfo.finance.service.email.MessageService;
import com.jibinfo.finance.service.sms.SmsTemplateService;
import com.jibinfo.finance.service.surveys.SurverysDataService;
import com.jibinfo.finance.vo.email.EmailVO;
import com.jibinfo.finance.vo.sms.SmsVO;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping(ModuleAdminPath.DEMO_ADMIN)
public class DemoAdminController extends BaseController{

	@Resource
	private DemoService demoService;

	@Resource
	private SurverysDataService surverysDataService;

	@Resource
	private MessageService messageService;

	@Resource
	private EmailTemplateService emailTemplateService;

	@Resource
	private SmsTemplateService smsTemplateService;

	@RequestMapping("/sr")
	@ResponseBody
	public SurverysResult sr(){
		SurverysResult surverysResult = surverysDataService.getSurverysResult("");
		return surverysResult;
	}
	
	@RequestMapping("/jsonData")
	@ResponseBody
	public Demo jsonData(HttpServletResponse response){
		Demo demo = demoService.getDemo();
		return demo;
	}

	@RequestMapping("/save")
	@ResponseBody
	public void save(Long id,String name,HttpServletResponse response){
		ResponseVo  result = demoService.save(id,name);
		super.outputJSON(result, response);
	}


	@RequestMapping("/email")
	public void email(){
		EmailTemplate template = emailTemplateService.getTemplateByCode("ET_20170526155121");
		EmailVO email = new EmailVO();
		email.setSubject("测试"+System.currentTimeMillis());
		email.setMessage(template.getContent());
		email.setTemplate(template.getCode());
		Map<String, String> params = new HashMap<>();
		params.put("name",System.currentTimeMillis()+"");
		params.put("sign","[签名字样]");
		email.setParams(params);
		messageService.sendEmail(email,"sujie.ge@jibinfo.com.cn");
	}


	@RequestMapping("/sms")
	public void sms(HttpServletResponse response){

		SmsTemplate template = smsTemplateService.selectByPrimaryKey(3L);

		SmsVO smsVO = new SmsVO();

		//设置发送参数
		Map<String, String> params = new HashMap<>();
		params.put("a","100A-");
		params.put("b","100B-");
		params.put("c","100C-");
		params.put("d","100D-");
		smsVO.setParams(params);

		//设置短信网关渠道
		smsVO.setSourceCode("ALI");
		//设置发送模板
		smsVO.setTemplate(template.getCode());
		//设置发送类型
		smsVO.setType(template.getType());

		messageService.sendSms(smsVO,"15850755123","18252061896");

	}


}
