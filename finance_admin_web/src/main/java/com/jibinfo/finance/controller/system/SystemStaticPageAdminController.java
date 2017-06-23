package com.jibinfo.finance.controller.system;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemStaticPage;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemStaticPageService;
import com.jibinfo.finance.utils.DateUtils;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.twitter.IdWorkerUtils;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/static/page")
public class SystemStaticPageAdminController extends BaseController {

	private static final String LIST = "system/staticPage/list";

	private static final String ADD = "system/staticPage/add";

	private static final String EDIT = "system/staticPage/edit";

    private static final String VIEW = "system/staticPage/view";

	@Resource
	private SystemStaticPageService systemStaticPageService;



	@RequestMapping("/list")
	public String list(){

		return LIST;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request){
        SystemStaticPage model = new SystemStaticPage();
	    model.setKeyCode("K"+ IdWorkerUtils.getId());
        request.setAttribute("model",model);
		return ADD;
	}

	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
        SystemStaticPage model = systemStaticPageService.selectByPrimaryKey(id);
        request.setAttribute("model",model);
        return EDIT;
	}


	@RequestMapping("/getData")
	public void getData(HttpServletResponse response, HttpServletRequest request, Integer pageNumber, Integer pageSize){
		SystemStaticPage model = super.getRequestParam(request, SystemStaticPage.class);
        String datetimeStart = request.getParameter("datetimeStart");
        String datetimeEnd = request.getParameter("datetimeEnd");
        if(StringUtils.isNotEmpty(datetimeStart)){
            String strDateFirst = DateUtils.getStrDateFirst(datetimeStart);
            model.setCreatedDate(DateUtils.strToDate(strDateFirst));
        }
        if(StringUtils.isNotEmpty(datetimeEnd)) {
            String strDateLast = DateUtils.getStrDateLast(datetimeEnd);
            model.setUpdatedDate(DateUtils.strToDate(strDateLast));
        }
		PageModel<SystemStaticPage> pageModel = systemStaticPageService.getData(pageNumber,pageSize,model);

		super.outputJSON(pageModel, response);
	}

	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, HttpServletRequest request){
		SystemStaticPage model = super.getRequestParam(request, SystemStaticPage.class);

		ResponseVo responseVo = systemStaticPageService.saveOrUpdate(model);
		super.outputJSON(responseVo, response);
	}

    @RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
        ResponseVo responseVo = systemStaticPageService.delete(ids);
        super.outputJSON(responseVo, response);
    }


    @RequestMapping("/view/{id}")
    public String view(HttpServletRequest request,@PathVariable Long id){
        SystemStaticPage model = systemStaticPageService.selectByPrimaryKey(id);
        request.setAttribute("model",model);
        return VIEW;
    }

}
