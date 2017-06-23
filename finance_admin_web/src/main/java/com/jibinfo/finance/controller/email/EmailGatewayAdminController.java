package com.jibinfo.finance.controller.email;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.email.EmailGateway;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailGatewayService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * Created by admin on 2017/4/24.
 */
@Controller
@RequestMapping(ModuleAdminPath.EMAIL_ADMIN + "/gateway")
public class EmailGatewayAdminController extends BaseController{

//    private static final Log log = LogFactory.getLog(EmailGatewayAdminController.class);


    private static final String LIST = "email/gateway/list";

    private static final String ADD = "email/gateway/add";

    private static final String EDIT = "email/gateway/edit";

    @Resource
    private EmailGatewayService emailGatewayService;

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
        EmailGateway model = emailGatewayService.selectByPrimaryKey(id);
        request.setAttribute("model",model);
        return EDIT;

    }


    @RequestMapping("/getData")
    public void getData(HttpServletRequest request, HttpServletResponse response,Integer pageNumber,Integer pageSize){
        EmailGateway param = super.getRequestParam(request, EmailGateway.class);
        PageModel<EmailGateway> pageModel = emailGatewayService.getData(param,pageNumber,pageSize);
        super.outputJSON(pageModel, response);
    }


    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(HttpServletResponse response,HttpServletRequest request){
        EmailGateway model = super.getRequestParam(request,EmailGateway.class);
        ResponseVo responseVo = emailGatewayService.saveOrUpdate(model);
        super.outputJSON(responseVo, response);
    }


    @RequestMapping("/delete")
    public void delete(HttpServletResponse response,String ids){
        ResponseVo responseVo = emailGatewayService.delete(ids);
        super.outputJSON(responseVo, response);
    }

    @RequestMapping("/changeState")
    public void changeState(HttpServletResponse response,Long id){
        ResponseVo responseVo = emailGatewayService.changeState(id);
        super.outputJSON(responseVo, response);
    }



}
