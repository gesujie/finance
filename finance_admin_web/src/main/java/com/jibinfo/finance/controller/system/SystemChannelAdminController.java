package com.jibinfo.finance.controller.system;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemChannel;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemChannelService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * Created by admin on 2017/5/27.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/channel")
public class SystemChannelAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/channel/list";

	private static final String ADD = "system/channel/add";

	private static final String EDIT = "system/channel/edit";

	@Resource
	private SystemChannelService systemChannelService;


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
			SystemChannel model = systemChannelService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){
		SystemChannel model = super.getRequestParam(request,SystemChannel.class);
		PageModel<SystemChannel> pageModel = systemChannelService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemChannel model = super.getRequestParam(request, SystemChannel.class);
		ResponseVo responseVo = systemChannelService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemChannelService.delete(ids);
		outputJSON(result, response);
	}


}
