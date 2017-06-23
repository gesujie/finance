package com.jibinfo.finance.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemResource;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemMenuService;
import com.jibinfo.finance.service.system.SystemResourceService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.security.AdminAuthorizationUtils;
import com.jibinfo.framework.security.Authorization;

@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/resource")
public class SystemResourceAdminController extends BaseController {
	private static final String LIST = "system/resource/list";

	private static final String ADD = "system/resource/add";

	private static final String EDIT = "system/resource/edit";

	@Resource
	private SystemResourceService systemResourceService;

	@Resource
	private SystemMenuService systemMenuService;

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
	 * 获取系统菜单树
	 * 
	 * @param response
	 */
	@RequestMapping("/getMenuJson")
	public void getMenuJson(HttpServletResponse response) {
		Authorization loadAuthorization = AdminAuthorizationUtils
				.loadAuthorization();
		logger.info("login user id is :" + loadAuthorization.getId());
		ResponseVo treeJson = systemMenuService.getTreeJson(loadAuthorization
				.getId());
		super.outputJSON(treeJson.getBody(), response);
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
		SystemResource model = super.getRequestParam(request,
				SystemResource.class);
		PageModel<SystemResource> pageModel = systemResourceService.getData(
				pageNumber, pageSize, model);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 异步请求建议是否是最后一节节点
	 * 
	 */
	@RequestMapping("/checkLastMenu")
	public void checkLastMenu(HttpServletRequest request,
			HttpServletResponse response, String menuId) {
		ResponseVo result = systemMenuService.getChildMenuByPid(menuId);
		outputJSON(result, response);
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
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
			SystemResource resource = systemResourceService
					.selectByPrimaryKey(id);
			request.setAttribute("resource", resource);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response,
			SystemResource resource, String menuId) {
		ResponseVo result = systemResourceService
				.saveOrUpdate(resource, menuId);
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
		ResponseVo result = systemResourceService.delete(ids);
		outputJSON(result, response);
	}
}
