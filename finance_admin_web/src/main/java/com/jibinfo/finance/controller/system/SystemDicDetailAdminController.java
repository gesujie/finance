package com.jibinfo.finance.controller.system;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemDicDetailService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/4/7.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/dic/detail")
public class SystemDicDetailAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String ADD = "system/dic/add_detail";

	private static final String EDIT = "system/dic/edit_detail";

	@Resource
	private SystemDicDetailService systemDicDetailService;


	@RequestMapping("/add")
	public String add(HttpServletRequest request,Long dicId){
		request.setAttribute("dicId",dicId);
		return ADD;
	}

	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		SystemDicDetail systemDicDetail = systemDicDetailService.selectByPrimaryKey(id);
		request.setAttribute("model",systemDicDetail);
		return EDIT;
	}



	@RequestMapping("/getData")
	public void getData(HttpServletResponse response, HttpServletRequest request, Integer pageNumber, Integer pageSize){
		SystemDicDetail model = super.getRequestParam(request,SystemDicDetail.class);
		PageModel<SystemDicDetail> pageModel = systemDicDetailService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo responseVo = systemDicDetailService.delete(ids);
		super.outputJSON(responseVo, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response,HttpServletRequest request){
		SystemDicDetail model = super.getRequestParam(request, SystemDicDetail.class);
		ResponseVo responseVo = systemDicDetailService.saveOrUpdate(model);
		super.outputJSON(responseVo, response);
	}



}
