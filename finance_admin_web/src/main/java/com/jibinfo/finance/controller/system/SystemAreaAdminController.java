package com.jibinfo.finance.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemArea;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemAreaService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * Created by admin on 2017/4/7.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/area")
public class SystemAreaAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/area/list";

	private static final String ADD = "system/area/add";

	private static final String EDIT = "system/area/edit";

	@Resource
	private SystemAreaService systemAreaService;


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
		String code = systemAreaService.findMaxCode();
		request.setAttribute("code",code);
		return ADD;
	}
	
	/**
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		if(null != id){
			SystemArea model = systemAreaService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){

		SystemArea model = super.getRequestParam(request,SystemArea.class);
		PageModel<SystemArea> pageModel = systemAreaService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemArea model = super.getRequestParam(request, SystemArea.class);
		ResponseVo responseVo = systemAreaService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemAreaService.delete(ids);
		outputJSON(result, response);
	}


}
