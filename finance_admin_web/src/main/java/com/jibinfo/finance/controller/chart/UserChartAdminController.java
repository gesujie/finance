package com.jibinfo.finance.controller.chart;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.service.user.UserService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/5/18.
 */

@Controller
@RequestMapping(ModuleAdminPath.CHART_ADMIN+"/user")
public class UserChartAdminController extends BaseController{



    @Resource
    private UserService userService;


    @RequestMapping("/regsiter")
    public void regsiter(HttpServletResponse response){
        ResponseVo charts = userService.findByChart();
        super.outputJSON(charts,response);
    }
    

}
