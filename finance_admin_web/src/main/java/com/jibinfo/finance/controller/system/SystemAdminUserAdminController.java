package com.jibinfo.finance.controller.system;


import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemAdminUser;
import com.jibinfo.finance.entity.system.SystemUserRoleRef;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemAdminUserService;
import com.jibinfo.finance.service.system.SystemUserRoleRefService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.security.AdminAuthorizationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户后台管理Controller
 * @author admin
 *
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/user")
public class SystemAdminUserAdminController extends BaseController{
	
//	private static final Log log = LogFactory.getLog(SystemAdminUserAdminController.class);
	
	private static final String LIST = "system/user/list";
	
	private static final String ADD = "system/user/add";
	
	private static final String EDIT = "system/user/edit";

	private static final String CONFIG_ROLE = "system/user/config_role";


	@Resource
	private SystemAdminUserService systemAdminUserService;

	@Resource
	private SystemUserRoleRefService systemUserRoleRefService;
	
	/**
	 * 列表页面的请求
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return LIST;
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Long id){
		return ADD;
	}



	/**
	 * 设置角色
	 * @return
	 */
	@RequestMapping("/configRole")
	public String configRole(HttpServletRequest request,Long id){
		SystemUserRoleRef byUserId = systemUserRoleRefService.findByUserId(id);
		if(null != byUserId){
			request.setAttribute("roleId",byUserId.getRoleId());
		}
		request.setAttribute("userId",id);
		return CONFIG_ROLE;
	}
	/**
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		if(null != id){
			SystemAdminUser model = systemAdminUserService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){

		SystemAdminUser model = super.getRequestParam(request,SystemAdminUser.class);
		PageModel<SystemAdminUser> pageModel = systemAdminUserService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}
	
	
	/**
	 * 保存修改操作
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response,SystemAdminUser model){
		ResponseVo result = systemAdminUserService.saveOrUpdate(model);
		outputJSON(result, response);
		
	}
	/**
	 * 保存修改用户角色操作
	 * @return
	 */
	@RequestMapping("/saveOrUpdateRole")
	public void saveOrUpdateRole(HttpServletResponse response,SystemUserRoleRef model){
		ResponseVo result = systemUserRoleRefService.saveOrUpdate(model);
		outputJSON(result, response);

	}

	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemAdminUserService.delete(ids);
		outputJSON(result, response);
	}
	


	@RequestMapping("/changeState")
	public void changeState(HttpServletResponse response,Long id){
		ResponseVo result = systemAdminUserService.changeState(id);
		outputJSON(result, response);
	}

	@RequestMapping("/getUserInfo")
	public void getUserInfo(HttpServletResponse response,Long id){
		ResponseVo result = systemAdminUserService.getUserInfo(id);
		outputJSON(result, response);
	}

	/**
	 * 重置密码,还原成默认密码
	 * @param response
	 * @param ids
	 */

	@RequestMapping("/resetPwd")
	public void resetPwd(HttpServletResponse response,String ids){
		ResponseVo result = systemAdminUserService.resetPwd(ids);
		outputJSON(result, response);
	}


	/**
	 * 修改密码,设置成自己输入的密码
	 * @param response
	 */
	@RequestMapping("/updatePwd")
	public void updatePwd(HttpServletResponse response,String oldPwd,String newPwd){
		Long id = AdminAuthorizationUtils.loadAuthorization().getId();
		ResponseVo result = systemAdminUserService.updatePwd(id,oldPwd,newPwd);
		outputJSON(result, response);
	}

}
