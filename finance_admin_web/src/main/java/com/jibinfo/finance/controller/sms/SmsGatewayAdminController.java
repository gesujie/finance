package com.jibinfo.finance.controller.sms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.sms.SmsGateway;
import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsGatewayService;
import com.jibinfo.finance.service.system.SystemDicDetailService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.SMS_ADMIN + "/gateway")
public class SmsGatewayAdminController extends BaseController {

	private static final String LIST = "sms/gateway/list";

	private static final String ADD = "sms/gateway/add";

	private static final String EDIT = "sms/gateway/edit";

	private static final String DETAIL = "sms/gateway/detail";

	private static final Long DIC_ID = 22L;

	@Resource
	private SmsGatewayService smsGatewayService;
	
	@Resource
	private SystemDicDetailService systemDicDetailService;

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
		SmsGateway gateway = super.getRequestParam(request, SmsGateway.class);
		PageModel<SmsGateway> pageModel = smsGatewayService.getData(pageNumber,
				pageSize, gateway);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 改变状态
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping("/changeOnOff")
	public void changeOnOff(HttpServletResponse response, Long id) {
		ResponseVo result = smsGatewayService.changeOnOff(id);
		outputJSON(result, response);
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		List<SystemDicDetail> dicDetail = systemDicDetailService
				.getGatewaySourceDicDetail(DIC_ID);
		if (null != dicDetail) {
			request.setAttribute("dicDetail", dicDetail);
		}
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
			SmsGateway gateway = smsGatewayService.selectByPrimaryKey(id);
			request.setAttribute("gateway", gateway);
		}

		List<SystemDicDetail> dicDetail = systemDicDetailService
				.getGatewaySourceDicDetail(DIC_ID);
		if (null != dicDetail) {
			request.setAttribute("dicDetail", dicDetail);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, SmsGateway gateway) {
		ResponseVo result = smsGatewayService.saveOrUpdate(gateway);
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
		ResponseVo result = smsGatewayService.delete(ids);
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
			SmsGateway gateway = smsGatewayService.selectByPrimaryKey(id);
			request.setAttribute("gateway", gateway);
		}
		return DETAIL;
	}
}
