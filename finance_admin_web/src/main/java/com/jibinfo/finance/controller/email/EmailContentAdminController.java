package com.jibinfo.finance.controller.email;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.email.EmailContent;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailContentService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/4/24.
 */
@Controller
@RequestMapping(ModuleAdminPath.EMAIL_ADMIN + "/content")
public class EmailContentAdminController extends BaseController{

//    private static final Log log = LogFactory.getLog(EmailContentAdminController.class);


    private static final String LIST = "email/content/list";

    private static final String ADD = "email/content/add";

    private static final String EDIT = "email/content/edit";

    @Resource
    private EmailContentService emailContentService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        return LIST;

    }


    @RequestMapping("/add")
    public String add(){

        return ADD;

    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Long id){

        return EDIT;

    }

    @RequestMapping("/getData")
    public void getData(HttpServletRequest request, HttpServletResponse response,Integer pageNumber,Integer pageSize){
        EmailContent param = super.getRequestParam(request, EmailContent.class);
        PageModel<EmailContent> pageModel = emailContentService.getData(param,pageNumber,pageSize);
        super.outputJSON(pageModel, response);
    }


    @RequestMapping("/delete")
    public void delete(HttpServletResponse response,String ids){
        ResponseVo responseVo = emailContentService.delete(ids);
        super.outputJSON(responseVo, response);
    }

}
