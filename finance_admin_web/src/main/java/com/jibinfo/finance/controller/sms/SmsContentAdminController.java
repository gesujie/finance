package com.jibinfo.finance.controller.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.sms.SmsContent;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsContentService;
import com.jibinfo.framework.controller.BaseController;

@Controller
@RequestMapping(ModuleAdminPath.SMS_ADMIN + "/content")
public class SmsContentAdminController extends BaseController {
	private static final String LIST = "sms/content/list";

	@Resource
	private SmsContentService smsContentService;

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
		SmsContent content = super.getRequestParam(request, SmsContent.class);
		PageModel<SmsContent> pageModel = smsContentService.getData(pageNumber,
				pageSize, content);
		super.outputJSON(pageModel, response);
	}
}
