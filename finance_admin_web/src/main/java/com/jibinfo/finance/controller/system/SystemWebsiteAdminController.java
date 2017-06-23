package com.jibinfo.finance.controller.system;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemWebsite;
import com.jibinfo.finance.service.system.SystemWebsiteService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/website")
public class SystemWebsiteAdminController extends BaseController {

	private static final String INDEX = "system/website/index";

	@Resource
	private SystemWebsiteService systemWebsiteService;

	@RequestMapping("/index")
	public String index(HttpServletResponse response, HttpServletRequest request){
		SystemWebsite website = systemWebsiteService.findOne();
		if(null != website)
			request.setAttribute("model",website);
		return INDEX;
	}



	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, HttpServletRequest request){
		SystemWebsite model = super.getRequestParam(request, SystemWebsite.class);
		ResponseVo responseVo = systemWebsiteService.saveOrUpdate(model);
		super.outputJSON(responseVo, response);
	}




}
