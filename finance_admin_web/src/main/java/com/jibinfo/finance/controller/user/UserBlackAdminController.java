package com.jibinfo.finance.controller.user;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.user.UserBlack;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.user.UserBlackService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/5/18.
 */

@Controller
@RequestMapping(ModuleAdminPath.USER_ADMIN + "/black")
public class UserBlackAdminController extends BaseController{
//    private static final Log log = LogFactory.getLog(UserBlackAdminController.class);

    private static final String LIST = "user/user/blackList";
    
    @Resource
    private UserBlackService userBlackService;


    @RequestMapping("/list")
    public String list(){
        return LIST;
    }
    
    @RequestMapping("/getData")
    @ResponseBody
    public PageModel<UserBlack> getData(HttpServletRequest request, Integer pageNumber, Integer pageSize){
    	UserBlack userBlack = super.getRequestParam(request, UserBlack.class);
        PageModel<UserBlack> pageModel = userBlackService.getData(pageNumber,pageSize,userBlack);
        return  pageModel;
    }
    
    @RequestMapping("/delblack")
    @ResponseBody
    public ResponseVo delblack(String ids){
        ResponseVo responseVo =  userBlackService.delBlack(ids);
        return responseVo;
    }

}
