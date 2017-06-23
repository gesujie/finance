package com.jibinfo.finance.controller.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.sms.SmsCaptcha;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsCaptchaService;
import com.jibinfo.framework.controller.BaseController;

@Controller
@RequestMapping(ModuleAdminPath.SMS_ADMIN + "/captcha")
public class SmsCaptchaAdminController extends BaseController {
	private static final String LIST = "sms/captcha/list";
	
	@Resource
	private SmsCaptchaService smsCaptchaService;

	/**
	 * 列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String list() {
		return LIST;
	}

	/**
	 * 分页列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,
			HttpServletRequest request, Integer pageNumber, Integer pageSize) {
		SmsCaptcha captcha = super.getRequestParam(request, SmsCaptcha.class);
		PageModel<SmsCaptcha> pageModel = smsCaptchaService.getData(pageNumber,
				pageSize, captcha);
		super.outputJSON(pageModel, response);
	}
}
