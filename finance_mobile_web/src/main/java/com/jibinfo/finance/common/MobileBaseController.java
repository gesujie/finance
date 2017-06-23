/**
 * 坚卓电商
 * com.jibinfo.m.common
 * MobileBaseController.java
 * 
 * 2015-10-9-下午1:39:29
 *  2015南京坚卓软件科技有限公司-版权所有
 * 
 */
package com.jibinfo.finance.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.support.utility.Configuration;

/**
 * 
 * MobileBaseController
 * 
 * licc
 * licc
 * 2015-10-9-下午1:39:29
 * 
 * @version 1.0.0
 * 
 */
public class MobileBaseController extends BaseController {

	@ExceptionHandler({ Throwable.class })
	public void exception(Throwable throwable, HttpServletResponse response) throws IOException {
		logger.error(throwable.getMessage(), throwable);
		response.sendRedirect(Configuration.getProperty("urlPath", "mobile_path") + "/50x");
	}
	
	@ExceptionHandler({NoHandlerFoundException.class})
	public void error_404(Throwable throwable, HttpServletResponse response) throws IOException {
		//logger.error(throwable.getMessage(), throwable);
		response.sendRedirect(Configuration.getProperty("urlPath", "mobile_path") + "/404");
	}
}
