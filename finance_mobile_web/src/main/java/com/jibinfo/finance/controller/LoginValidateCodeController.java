/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */

package com.jibinfo.finance.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jibinfo.finance.common.ValidateCode;


@Controller
@Scope("prototype")
@RequestMapping("/codeImages")
public class LoginValidateCodeController {

	@RequestMapping("/codeimages")
	public void codeimages(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ValidateCode vCode = new ValidateCode(120, 40, 4, 50);
		//String session = CookieUtility.getCookieByName(YYConstant.COOKIE_SESSION_ID, request).getValue();
		//userobjectRedisTemplate.opsForValue().set(UserRedisKeyConstant.REGISTER_VALIDATE_CODE_PREFIX + session, vCode.getCode(), 15, TimeUnit.MINUTES);

		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		vCode.write(response.getOutputStream());
	}

	/**
	 * 验证码登录的的图形验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/dynamicLogin")
	public void dynamicLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ValidateCode vCode = new ValidateCode(120, 40, 4, 50);
		//String session = CookieUtility.getCookieByName(YYConstant.COOKIE_SESSION_ID, request).getValue();
		//objectRedisTemplate.opsForValue().set(SSORedisKeyConstant.LOGIN_VALIDATE_CODE_PREFIX + session, vCode.getCode(), 15, TimeUnit.MINUTES);

		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		vCode.write(response.getOutputStream());
	}

	
	
	@RequestMapping("/admin/codeimages")
	public void adminCodeimages(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// ValidateCode vCode = new ValidateCode(120, 40, 4, 50);
		//String session = CookieUtility.getCookieByName(AdminYYConstant.COOKIE_SESSION_ID, request).getValue();
		//objectRedisTemplate.opsForValue().set(SSORedisKeyConstant.LOGIN_VALIDATE_CODE_PREFIX + session, vCode.getCode(), 15, TimeUnit.MINUTES);

	}
}
