package com.jibinfo.finance.controller.user;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.user.User;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.user.UserService;
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
@RequestMapping(ModuleAdminPath.USER_ADMIN)
public class UserAdminController extends BaseController{
//    private static final Log log = LogFactory.getLog(UserAdminController.class);

    private static final String LIST = "user/user/list";
    
    private static final String EDIT = "user/user/setBlack";


    @Resource
    private UserService userService;


    @RequestMapping("/list")
    public String list(){
        return LIST;
    }
    
    /**
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/setBlackDia")
	public String edit(HttpServletRequest request,Long id){
		if(null != id){
			User model = userService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}


    @RequestMapping("/getData")
    @ResponseBody
    public PageModel<User> getData(HttpServletRequest request, Integer pageNumber, Integer pageSize){
        User user = super.getRequestParam(request, User.class);
        PageModel<User> pageModel = userService.getData(user,pageNumber,pageSize);
        return  pageModel;
    }



    @RequestMapping("/enableDisable")
    @ResponseBody
    public ResponseVo enableDisable(String ids){
        ResponseVo responseVo =  userService.enableDisable(ids);
        return responseVo;
    }


    @RequestMapping("/changeState")
    @ResponseBody
    public ResponseVo changeState(Long id){
        return userService.changeState(id);
    }
    
    @RequestMapping("/setBlack")
    @ResponseBody
    public ResponseVo setBlack(Long id, String remark){
        ResponseVo responseVo =  userService.setBlack(id, remark);
        return responseVo;
    }

}
