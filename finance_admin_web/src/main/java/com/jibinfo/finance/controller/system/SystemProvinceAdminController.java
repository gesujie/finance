package com.jibinfo.finance.controller.system;


import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemProvinceService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/4/7.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/provice")
public class SystemProvinceAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/province/list";

	private static final String ADD = "system/province/add";

	private static final String EDIT = "system/province/edit";

	@Resource
	private SystemProvinceService systemProvinceService;


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
		String code = systemProvinceService.findMaxCode();
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
			SystemProvince model = systemProvinceService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){

		SystemProvince model = super.getRequestParam(request,SystemProvince.class);
		PageModel<SystemProvince> pageModel = systemProvinceService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemProvince model = super.getRequestParam(request, SystemProvince.class);
		ResponseVo responseVo = systemProvinceService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemProvinceService.delete(ids);
		outputJSON(result, response);
	}


}
