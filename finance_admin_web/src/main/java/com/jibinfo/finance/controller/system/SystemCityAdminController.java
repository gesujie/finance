package com.jibinfo.finance.controller.system;

import java.io.UnsupportedEncodingException;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemCity;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemCityService;
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
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/city")
public class SystemCityAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/city/list";

	private static final String ADD = "system/city/add";

	private static final String EDIT = "system/city/edit";

	@Resource
	private SystemCityService systemCityService;


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
		String code = systemCityService.findMaxCode();
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
			SystemCity model = systemCityService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){

		 SystemCity model = super.getRequestParam(request,SystemCity.class);
		if(null != model.getName()){
			System.out.println(model.getName());
			try {
				System.out.println(new String(model.getName().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		PageModel<SystemCity> pageModel = systemCityService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemCity model = super.getRequestParam(request, SystemCity.class);
		ResponseVo responseVo = systemCityService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemCityService.delete(ids);
		outputJSON(result, response);
	}


}
