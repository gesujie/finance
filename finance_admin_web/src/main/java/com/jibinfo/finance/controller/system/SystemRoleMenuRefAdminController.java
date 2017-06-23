package com.jibinfo.finance.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemRole;
import com.jibinfo.finance.service.system.SystemRoleMenuRefService;
import com.jibinfo.finance.service.system.SystemRoleService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/roleMenuRef")
public class SystemRoleMenuRefAdminController extends BaseController {

	private static final String CONFIG = "system/role/config";

	@Resource
	private SystemRoleMenuRefService systemRoleMenuRefService;

	@Resource
	private SystemRoleService systemRoleService;

	/**
	 * 列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/config")
	public String config(HttpServletRequest request, Long id) {
		if (null != id) {
			SystemRole role = systemRoleService.selectByPrimaryKey(id);
			request.setAttribute("role", role);
		}
		return CONFIG;
	}

	/**
	 * 子类异步请求树
	 * 
	 * @return
	 */
	@RequestMapping("/getMenuJson")
	public void getMenuJson(HttpServletResponse response, String menuId,
			String roleId) {
		ResponseVo treeJson = systemRoleMenuRefService.getSystemMenu(menuId,
				roleId);
		super.outputJSON(treeJson.getBody(), response);
	}

	/**
	 * 添加保存
	 * 
	 * @return
	 */
	@RequestMapping("/save")
	public void save(HttpServletResponse response, String roleId, String ids) {
		ResponseVo result = systemRoleMenuRefService.save(roleId, ids);
		outputJSON(result, response);
	}

}
