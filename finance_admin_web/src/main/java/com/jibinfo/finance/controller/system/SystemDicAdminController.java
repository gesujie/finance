package com.jibinfo.finance.controller.system;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemDic;
import com.jibinfo.finance.service.system.SystemDicService;
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
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/dic")
public class SystemDicAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/dic/list";

	private static final String ADD = "system/dic/add";

	private static final String EDIT = "system/dic/edit";

	@Resource
	private SystemDicService systemDicService;


	/**
	 * 列表页面的请求
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
//		SystemDicExample example = new SystemDicExample();
//		List<SystemDic> list = systemDicService.selectByExample(example);
		return LIST;
	}
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		String code = systemDicService.findMaxCode();
		request.setAttribute("code",code);
		return ADD;
	}

	/**
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		SystemDic model = systemDicService.selectByPrimaryKey(id);
		request.setAttribute("model",model);
		return EDIT;
	}


	@RequestMapping("/getDicJson")
	public void getDicJson(HttpServletResponse response){
		ResponseVo treeJson = systemDicService.getTreeJson();
		super.outputJSON(treeJson.getBody(),response);

	}

	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,Long id){
		ResponseVo responseVo = systemDicService.delete(id);
		super.outputJSON(responseVo,response);

	}



	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemDic model = super.getRequestParam(request, SystemDic.class);

		ResponseVo responseVo = systemDicService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}


}
