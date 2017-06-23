package com.jibinfo.finance.controller.system;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemMenu;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemMenuService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * 菜单后台管理Controller
 * @author admin
 *
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/menu")
public class SystemMenuAdminController extends BaseController{
	
//	private static final Log log = LogFactory.getLog(SystemMenuAdminController.class);
	
	private static final String LIST = "system/menu/list";
	
	private static final String ADD = "system/menu/add";
	
	private static final String EDIT = "system/menu/edit";
	
	
	@Resource
	private SystemMenuService systemMenuService;
	
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
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		if(null != id){
			SystemMenu model = systemMenuService.selectByPrimaryKey(id);
			request.setAttribute("model", model);
			if(model.getLevel() != 1){
				ResponseVo result = systemMenuService.getMenu(model.getLevel() - 1);
				request.setAttribute("menuList", result.getBody());
			}
		}
		return EDIT;
	}
	
	
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){
		
		SystemMenu menu = super.getRequestParam(request,SystemMenu.class);
		PageModel<SystemMenu> pageModel = systemMenuService.getData(pageNumber,pageSize,menu);
		super.outputJSON(pageModel, response);
	}
	
	
	/**
	 * 保存修改操作
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response,SystemMenu model){
		ResponseVo result = systemMenuService.saveOrUpdate(model);
		outputJSON(result, response);
		
	}
	
	/**
	 * 
	 * @param response
	 * @param level
	 */
	@RequestMapping("/getMenu")
	public void getMenu(HttpServletResponse response,Integer level){
		ResponseVo result = systemMenuService.getMenu(level);
		outputJSON(result, response);
	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemMenuService.delete(ids);
		outputJSON(result, response);
	}

}
