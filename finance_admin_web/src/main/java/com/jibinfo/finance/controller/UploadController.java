
package com.jibinfo.finance.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.support.utility.Md5Utility;


/**
 * @author admin
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
	private static final Log logger = LogFactory.getLog(UploadController.class);

	private static final String ROOT_PATH = Configuration.getProperty("system", "upload.avatar.image");

    private static final String AVATAR_PATH = "/avatar";

	private static final String LOGO_PATH = "/logo";
	
	private static final String CAR_PATH = "/car";

	private static final String DATA_MATERIALS_PATH = "/data/materials";

	/**
	 * 默认生成图片层次数
	 */
	// private static final int DEFALUT_FOLDER_DEEP = 4;

	/**
	 * 每层的字符数
	 */
	// private static final int DEFAULT_CHAR_COUNT = 2;

    @RequestMapping("/uploadAvatar")
	public void upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse resp) {
		ResponseVo responseVo = this.uploadFile(file, AVATAR_PATH);
		super.outputJSON(responseVo,resp);
	}

	@RequestMapping("/uploadLogo")
	public void uploadLogo(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse resp) {
		ResponseVo responseVo = this.uploadFile(file, LOGO_PATH);
		super.outputJSON(responseVo, resp);
	}

	@RequestMapping("/uploadCar")
	public void uploadBrand(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse resp) {
		ResponseVo responseVo = this.uploadFile(file, CAR_PATH);
		super.outputJSON(responseVo, resp);
	}



	@RequestMapping("/uploadMaterials")
	public void uploadMaterials(@RequestParam("file") MultipartFile file,
							HttpServletRequest request, HttpServletResponse resp) {
		ResponseVo responseVo = this.uploadFile(file, DATA_MATERIALS_PATH);
		super.outputJSON(responseVo, resp);
	}
	/**
	 * 上传图片
	 */
	private ResponseVo uploadFile(MultipartFile file, String uploadPath) {
		String newPath = null;
		try {
			Integer index = file.getOriginalFilename().lastIndexOf(".");
			String extension = file.getOriginalFilename().substring(index);
			String md5 = Md5Utility.getMD5String(file.getBytes());
			String fileName = md5 + extension;
			// 相对路径
			String relativePath = uploadPath + "/" + fileName;
			// 文件夹路径
			String path = ROOT_PATH + uploadPath;
			// 全路径
			String fullPath = path + "/" + fileName;
			checkPath(path);
			File newFile = new File(fullPath);
			file.transferTo(newFile);
			newPath = relativePath;
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		ResponseVo responseVo = new ResponseVo();
		responseVo.setBody(newPath);
		return responseVo;
	}

	/**
	 * 根据md5的名称生成目录结构
	 * 
	 * @param md5 文件大小生成的md5
	 * @return
	 * @exception
	 * @author Nick.Tan
	 * @version 1.0.0
	 */
	// private String generateFolderPath(String md5) {
	//
	// StringBuilder result = new StringBuilder();
	// String tmp;
	// for (int i = 0; i < DEFALUT_FOLDER_DEEP; i++) {
	// // 截取
	// tmp = md5.substring(i * DEFAULT_CHAR_COUNT, (i + 1)
	// * DEFAULT_CHAR_COUNT);
	// result.append(tmp).append(File.separator);
	// }
	// return result.toString();
	// }

	// private String formatPath(String path) {
	// return path.replace("\\", "/");
	// }
	
	private void checkPath(String path) throws IOException{
		File file = new File(path);
		
		if (!file.exists()) {
			FileUtils.forceMkdir(file);
		}
	}
	
	/**
	 * @author Show_Ge
	 * @date 2016-4-21下午1:13:40
	 * @desr
	 * 拼接 like 语句    %param%
	 */
	protected String like(String param){
		return "%"+param+"%";
	}
	
	/**
	 * @author Show_Ge
	 * @date 2016-4-21下午1:13:40
	 * @desr
	 * 拼接 like 语句    %param
	 */
	protected String likeLeft(String param){
		return "%"+param;
	}
	
	/**
	 * @author Show_Ge
	 * @date 2016-4-21下午1:13:40
	 * @desr
	 * 拼接 like 语句    param%
	 */
	protected String likeRight(String param){
		return param+"%";
	}
}
