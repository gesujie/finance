package com.jibinfo.finance.controller.quartz;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.enums.QuartzEnum;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.quartz.QuartzService;
import com.jibinfo.finance.utils.QuartzUtils;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by admin on 2017/4/26.
 */
@Controller
@RequestMapping(ModuleAdminPath.QUARTZ_ADMIN + "/")
public class QuartzAdminController extends BaseController {
//    private static final Log log = LogFactory.getLog(QuartzAdminController.class);

    private static final String LIST = "quartz/quartz/list";

    private static final String ADD = "quartz/quartz/add";

    private static final String EDIT = "quartz/quartz/edit";



    @Resource
    private QuartzService quartzService;



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
    public String add(){
        return ADD;
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Long id){
        Quartz model = quartzService.selectByPrimaryKey(id);
        request.setAttribute("model",model);
        return EDIT;
    }


    @RequestMapping("/getData")
    public void getData(HttpServletResponse response, HttpServletRequest request, Integer pageNumber, Integer pageSize){

        Quartz model = super.getRequestParam(request,Quartz.class);
        PageModel<Quartz> pageModel = quartzService.getData(pageNumber,pageSize,model);
        super.outputJSON(pageModel, response);
    }




    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(HttpServletResponse response, HttpServletRequest request){
        Quartz quartz = super.getRequestParam(request, Quartz.class);
        ResponseVo responseVo = quartzService.saveOrUpdate(quartz);
        super.outputJSON(responseVo, response);
    }


    @RequestMapping("/delete")
    public void delete(HttpServletResponse response, String ids){
        ResponseVo responseVo = quartzService.delete(ids);
        super.outputJSON(responseVo, response);
    }


    @RequestMapping("/start")
    public void start(HttpServletResponse response, Long id) throws Exception{
        Quartz quartz = quartzService.selectByPrimaryKey(id);
        ResponseVo responseVo = new ResponseVo().successResponse();
        try {
            quartz.setStatus(QuartzEnum.NONE.getStatus());
            quartz.setUpdatedDate(new Date());

            Scheduler scheduler = QuartzUtils.getScheduler(quartz.getFullClassName(), quartz.getJobName(), quartz.getGroupName(), quartz.getTriggerName(), quartz.getCron());
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }
        if(responseVo.getCode().equals(ResponseVo.SUCCESS)){
            quartzService.updateByPrimaryKeySelective(quartz);
        }
        super.outputJSON(responseVo, response);
    }

    @RequestMapping("/pauseOrResumeJob")
    public void pauseOrResumeJob(HttpServletResponse response, Long id) throws Exception{
        Quartz quartz = quartzService.selectByPrimaryKey(id);
        ResponseVo responseVo = new ResponseVo().successResponse();
        try {
            Scheduler scheduler = QuartzUtils.getScheduler();
            quartz.setUpdatedDate(new Date());
            if(quartz.getStatus().equals(QuartzEnum.NORMAL.getStatus())){
                quartz.setStatus(QuartzEnum.PAUSED.getStatus());
                //停止触发器
                scheduler.pauseTrigger(TriggerKey.triggerKey(quartz.getTriggerName(),quartz.getGroupName()));
                //停止任务
                scheduler.pauseJob(JobKey.jobKey(quartz.getJobName(),quartz.getGroupName()));

            }
            else{
                quartz.setStatus(QuartzEnum.NORMAL.getStatus());
                //恢复触发器
                scheduler.resumeTrigger(TriggerKey.triggerKey(quartz.getTriggerName(),quartz.getGroupName()));
                //恢复任务
                scheduler.resumeJob(JobKey.jobKey(quartz.getJobName(),quartz.getGroupName()));

            }

        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }
        if(responseVo.getCode().equals(ResponseVo.SUCCESS)){
            quartzService.updateByPrimaryKeySelective(quartz);
        }
        super.outputJSON(responseVo, response);
    }




    @RequestMapping("/pauseOrResumeTrigger")
    public void pauseOrResumeTrigger(HttpServletResponse response, Long id) throws Exception{
        Quartz quartz = quartzService.selectByPrimaryKey(id);
        ResponseVo responseVo = new ResponseVo().successResponse();
        try {
            Scheduler scheduler = QuartzUtils.getScheduler();
            quartz.setUpdatedDate(new Date());
            quartz.setStatus(QuartzEnum.END.getStatus());
            //停止触发器
            scheduler.resumeTrigger(TriggerKey.triggerKey(quartz.getTriggerName(),quartz.getTriggerName()));
            //移除触发器
            scheduler.unscheduleJob(TriggerKey.triggerKey(quartz.getTriggerName(),quartz.getTriggerName()));
            //删除任务
            scheduler.deleteJob(JobKey.jobKey(quartz.getJobName(),quartz.getGroupName()));

        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }
        if(responseVo.getCode().equals(ResponseVo.SUCCESS)){
            quartzService.updateByPrimaryKeySelective(quartz);
        }
        super.outputJSON(responseVo, response);
    }



}
