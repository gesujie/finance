package com.jibinfo.finance.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemRole;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemRoleService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/role")
public class SystemRoleAdminController extends BaseController {
	private static final String LIST = "system/role/list";

	private static final String ADD = "system/role/add";

	private static final String EDIT = "system/role/edit";

	@Resource
	private SystemRoleService systemRoleService;

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
		SystemRole model = super.getRequestParam(request, SystemRole.class);
		PageModel<SystemRole> pageModel = systemRoleService.getData(pageNumber,
				pageSize, model);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 改变状态
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping("/changeStat")
	public void changeStat(HttpServletResponse response, Long id) {
		ResponseVo result = systemRoleService.changeStat(id);
		outputJSON(result, response);
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
			SystemRole role = systemRoleService.selectByPrimaryKey(id);
			request.setAttribute("role", role);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, SystemRole role) {
		ResponseVo result = systemRoleService.saveOrUpdate(role);
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
		ResponseVo result = systemRoleService.delete(ids);
		outputJSON(result, response);
	}
}
