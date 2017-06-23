package com.jibinfo.finance.controller.surveys;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.dto.SurverysDataDTO;
import com.jibinfo.finance.entity.surveys.SurverysData;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.surveys.SurverysDataService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */
@Controller
@RequestMapping(ModuleAdminPath.SURVEYS_ADMIN + "/data")
public class SurveysDataAdminController extends BaseController{

//    private static final Log log = LogFactory.getLog(SurveysDataAdminController.class);


    private static final String LIST = "surveys/data/list";

    private static final String ADD = "surveys/data/add";

    private static final String EDIT = "surveys/data/edit";

    @Resource
    private SurverysDataService surverysDataService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        request.setAttribute("dataList",surverysDataService.getDataType());
        return LIST;

    }


    @RequestMapping("/add")
    public String add(){

        return ADD;

    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Long id){
        SurverysData model = surverysDataService.selectByPrimaryKey(id);
        request.setAttribute("model",model);
        request.setAttribute("dataList",surverysDataService.getDataType());
        return EDIT;

    }

    @RequestMapping("/getData")
    @ResponseBody
    public PageModel<SurverysDataDTO> getData(HttpServletRequest request, Integer pageNumber, Integer pageSize){
        SurverysData surverysData = super.getRequestParam(request, SurverysData.class);
        return surverysDataService.getData(pageNumber,pageSize,surverysData);

    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseVo saveOrUpdate(HttpServletRequest request){
        SurverysData requestParam = super.getRequestParam(request, SurverysData.class);
        return surverysDataService.saveOrUpdate(requestParam);
    }



    @RequestMapping("/getDataType")
    @ResponseBody
    public List<SurverysData> getDataType(){
        return surverysDataService.getDataType();
    }



}
