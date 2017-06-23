package com.jibinfo.finance.controller.quartz;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.quartz.QuartzLogs;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.quartz.QuartzLogsService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/4/26.
 */
@Controller
@RequestMapping(ModuleAdminPath.QUARTZ_ADMIN + "/logs")
public class QuartzLogsAdminController extends BaseController {
//    private static final Log log = LogFactory.getLog(QuartzLogsAdminController.class);

    private static final String LIST = "quartz/logs/list";



    @Resource
    private QuartzLogsService quartzLogsService;



    /**
     * 列表页面的请求
     * @return
     */
    @RequestMapping("/list")
    public String list(){
        return LIST;
    }

    @RequestMapping("/getData")
    public void getData(HttpServletResponse response, HttpServletRequest request, Integer pageNumber, Integer pageSize){

        QuartzLogs model = super.getRequestParam(request,QuartzLogs.class);
        PageModel<QuartzLogs> pageModel = quartzLogsService.getData(pageNumber,pageSize,model);
        super.outputJSON(pageModel, response);
    }




    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(HttpServletResponse response, HttpServletRequest request){
        QuartzLogs quartz = super.getRequestParam(request, QuartzLogs.class);
        ResponseVo responseVo = quartzLogsService.saveOrUpdate(quartz);
        super.outputJSON(responseVo, response);
    }



}
