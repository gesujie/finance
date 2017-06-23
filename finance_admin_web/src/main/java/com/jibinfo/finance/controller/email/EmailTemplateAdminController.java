package com.jibinfo.finance.controller.email;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.email.EmailTemplate;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailTemplateService;
import com.jibinfo.finance.utils.DateUtils;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * Created by admin on 2017/4/24.
 */
@Controller
@RequestMapping(ModuleAdminPath.EMAIL_ADMIN + "/template")
public class EmailTemplateAdminController extends BaseController{

//    private static final Log log = LogFactory.getLog(EmailTemplateAdminController.class);


    private static final String LIST = "email/template/list";

    private static final String ADD = "email/template/add";

    private static final String EDIT = "email/template/edit";

    @Resource
    private EmailTemplateService emailTemplateService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        return LIST;

    }


    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String code = "ET_"+ DateUtils.dateToStr(new Date(),"yyyyMMddHHmmss");
        request.setAttribute("code",code);
        return ADD;

    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Long id){
        EmailTemplate template = emailTemplateService.selectByPrimaryKey(id);
        request.setAttribute("model",template);
        return EDIT;

    }

    @RequestMapping("/getData")
    public void getData(HttpServletRequest request, HttpServletResponse response,Integer pageNumber,Integer pageSize){
        EmailTemplate param = super.getRequestParam(request, EmailTemplate.class);
        PageModel<EmailTemplate> pageModel = emailTemplateService.getData(param,pageNumber,pageSize);

        super.outputJSON(pageModel, response);

    }


    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
        EmailTemplate model = super.getRequestParam(request, EmailTemplate.class);
        ResponseVo responseVo = emailTemplateService.saveOrUpdate(model);
        super.outputJSON(responseVo, response);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletResponse response,String ids){
        ResponseVo responseVo = emailTemplateService.delete(ids);
        super.outputJSON(responseVo, response);
    }



}
