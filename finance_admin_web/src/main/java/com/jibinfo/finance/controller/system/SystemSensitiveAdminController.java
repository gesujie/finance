package com.jibinfo.finance.controller.system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.system.SystemSensitive;
import com.jibinfo.finance.entity.system.SystemSensitiveExample;
import com.jibinfo.finance.exception.SensitiveException;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemSensitiveService;
import com.jibinfo.finance.utils.ExcelUtil;
import com.jibinfo.finance.utils.MessageConstants;
import com.jibinfo.finance.utils.SensitiveFileUtil;
import com.jibinfo.finance.vo.util.SystemSensitiveVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

/**
 * Created by admin on 2017/5/25.
 */
@Controller
@RequestMapping(ModuleAdminPath.SYSTEM_ADMIN + "/sensitive")
public class SystemSensitiveAdminController extends BaseController {

//	private final Log log = LogFactory.getLog(this.getClass());

	private static final String LIST = "system/sensitive/list";

	private static final String ADD = "system/sensitive/add";

	private static final String EDIT = "system/sensitive/edit";
	
	private static final String OPENIMPORT = "system/sensitive/openImport";
	
//	private static final String BATCH__SENESITIVE_IMPORT = Configuration.getProperty("system", "import.sensitive");

//    private static final String BATCH__CREDIT_GRANT_TEMPLATE = Configuration.getProperty("system", "download.template.sensitive");
    
	@Resource
	private SystemSensitiveService systemSensitiveService;



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
	public String add(HttpServletRequest request,Long id){
		return ADD;
	}
	
	/**
	 * 上传弹窗
	 * @return
	 */
	@RequestMapping("/openImport")
	public String openImport(HttpServletRequest request,Long id){
		return OPENIMPORT;
	}
	
	
	/**
	 * 修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Long id){
		if(null != id){
			SystemSensitive model = systemSensitiveService.selectByPrimaryKey(id);
			request.setAttribute("model",model);
		}
		return EDIT;
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,HttpServletRequest request, Integer pageNumber,Integer pageSize){

		SystemSensitive model = super.getRequestParam(request,SystemSensitive.class);
		PageModel<SystemSensitive> pageModel = systemSensitiveService.getData(pageNumber,pageSize,model);
		super.outputJSON(pageModel, response);
	}


	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request,HttpServletResponse response){
		SystemSensitive model = super.getRequestParam(request, SystemSensitive.class);
		ResponseVo responseVo = systemSensitiveService.saveOrUpdate(model);
		super.outputJSON(responseVo,response);

	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response,String ids){
		ResponseVo result = systemSensitiveService.delete(ids);
		outputJSON(result, response);
	}
	
	/**
     * 导入
     * @param request
     * @param response
     */
    @RequestMapping("/sensitiveLeading")
    public void sensitiveLeading(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {

        System.out.println("*********导入********");
        ResponseVo result = new ResponseVo().successResponse();

        try {
			String path = SensitiveFileUtil.getPath("/data0/nfs/import/sensitive");
			SensitiveFileUtil.forceMkdir(new File(path));
            InputStream is = file.getInputStream();
            String name = file.getOriginalFilename();
            SensitiveFileUtil.saveFileFromInputStream(file.getInputStream(),path,name);
            List<SystemSensitiveVO> list = ExcelUtil.converExcelToObject(is,0,1,SystemSensitiveVO.class);
            if(list!=null && list.size()>0){
                for (SystemSensitiveVO vo1 :list){
                    if (vo1.getWords()==null){
                        throw new SensitiveException(MessageConstants.EXCEL_DATA_INVALID);
                    } else {
                    	SystemSensitiveExample ex = new SystemSensitiveExample();
                    	ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
                    	List<SystemSensitive> systemSensitiveList = systemSensitiveService.selectByExample(ex);
                    	List<String> arrayList = new ArrayList<String>();
                    	if(null != systemSensitiveList && systemSensitiveList.size() > 0) {
                    		for(int i = 0; i< systemSensitiveList.size(); i++){
                        		arrayList.add(systemSensitiveList.get(i).getWords());
                        	}
                    	}
                    	if(!arrayList.contains(vo1.getWords())){
                    		SystemSensitive ss = new SystemSensitive();
                        	ss.setWords(vo1.getWords());
                        	ss.setRemark(vo1.getRemark());
                        	ss.setCreatedDate(new Date());
                        	ss.setUpdatedDate(new Date());
                        	systemSensitiveService.insertSelective(ss);
                    	}
                    }
                }
            }else{
                throw new SensitiveException(MessageConstants.EXCEL_DATA_EMPTY);
            }
        }catch (Exception e) {
            logger.error(e);
            result = result.failureResponse("异常");
        } 
        request.setAttribute("data",result);
        super.outputJSON(result, response);
    }
    
    /**
     * 下载模板
     * @param request
     * @param response
     */
    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("/data0/nfs/template/sensitive/template.xlsx");
            InputStream is = FileUtils.openInputStream(file);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String(("敏感词.xlsx").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }


}
