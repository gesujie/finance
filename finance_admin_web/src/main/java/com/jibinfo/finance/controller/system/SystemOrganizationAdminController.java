package com.jibinfo.finance.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.framework.controller.BaseController;

/**
 * Created by admin on 2017/4/27.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN+"/organization")
public class SystemOrganizationAdminController extends BaseController{
    private static final String LIST = "system/organization/list";

    private static final String ADD = "system/organization/add";

	// private static final String EDIT = "system/organization/edit";





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
    public String add(HttpServletRequest request, Long id){
        return ADD;
    }



}
