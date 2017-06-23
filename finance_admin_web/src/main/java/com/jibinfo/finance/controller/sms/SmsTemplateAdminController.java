package com.jibinfo.finance.controller.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsTemplateService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.SMS_ADMIN + "/template")
public class SmsTemplateAdminController extends BaseController {

	private static final String LIST = "sms/template/list";

	private static final String ADD = "sms/template/add";

	private static final String EDIT = "sms/template/edit";

	private static final String DETAIL = "sms/template/detail";

	@Resource
	private SmsTemplateService smsTemplateService;

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
		SmsTemplate template = super
				.getRequestParam(request, SmsTemplate.class);
		PageModel<SmsTemplate> pageModel = smsTemplateService.getData(
				pageNumber, pageSize, template);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		return ADD;
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Long id) {
		if (null != id) {
			SmsTemplate template = smsTemplateService.selectByPrimaryKey(id);
			request.setAttribute("template", template);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, SmsTemplate template) {
		ResponseVo result = smsTemplateService.saveOrUpdate(template);
		outputJSON(result, response);
	}

	/**
	 * 删除/批量删除
	 * 
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response, String ids) {
		ResponseVo result = smsTemplateService.delete(ids);
		outputJSON(result, response);
	}

	/**
	 * 详情页面
	 * 
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Long id) {
		if (null != id) {
			SmsTemplate template = smsTemplateService.selectByPrimaryKey(id);
			request.setAttribute("template", template);
		}
		return DETAIL;
	}
}
