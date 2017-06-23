/**
 * Created by julin on 2017/3/27.
 * 首页的Controller
 * 规范：
 * 1:所有的管理后台(AdminWeb)的Controller都必须带上 "Admin" 字样 ,如：DemoAdminController,区别网站(Web)的Controller,DemoController
 * 2:@Controller,@RequestMapping 里的路径必须带上 "/",如：@Controller("/demo/admin"),@RequestMapping("/list")
 * 3:@Controller 里的路径禁止出现大写，正确写法：@Controller("/demo/admin"),错误写法：@Controller("/demoAdmin")
 * 4:如果是返回的JSON格式，必须加上@ResponseBody的Annotation
 * 5:所有的业务逻辑必须放在Service层，禁止在Controller出现业务代码，如果出现一律重构代码！
 * 
 */
package com.jibinfo.finance.controller.login;

import com.jibinfo.finance.constants.ModulePath;
import com.jibinfo.framework.constant.WebCookieConstant;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.security.Authorization;
import com.jibinfo.framework.service.Result;
import com.jibinfo.framework.spring.ContextHolder;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.support.utility.CookieUtility;
import com.jibinfo.framework.utils.SessionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping(ModulePath.ROOT)
public class LoginController extends BaseController {

	/**
	 * 前台登录的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loginindex")
	public String loginindex(HttpServletRequest request, HttpServletResponse response){
		String fromUrl = request.getParameter("fromUrl");
		if (null == fromUrl || fromUrl.isEmpty()) {
			fromUrl = Configuration.getProperty("system", "web_path");
		}
		request.setAttribute("fromUrl", fromUrl);

		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (Cookie c : cookies){
				if (c.getName().equals(WebCookieConstant.COOKIE_SESSION_ID)){
					cookie = c;
					break;
				}
			}
		}

		if (cookie == null){
			cookie = new Cookie(WebCookieConstant.COOKIE_SESSION_ID, UUID.randomUUID().toString());
			// 保证浏览器时间比redis短
			cookie.setMaxAge(1800 - 30);
			cookie.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			cookie.setPath(WebCookieConstant.COOKIE_PATH);
			response.addCookie(cookie);
		} else {
			SessionUtils sessionUtils = (SessionUtils) ContextHolder.getBean("sessionUtils");
			Authorization authorization = sessionUtils.sessionGet(cookie.getValue());

			if (null == authorization) {
				Cookie cookieName = new Cookie(WebCookieConstant.COOKIE_USER_NAME, null);
				cookieName.setMaxAge(0);
				Cookie cookieId = new Cookie(WebCookieConstant.COOKIE_USER_ID, null);
				cookieId.setMaxAge(0);

				cookieId.setDomain(WebCookieConstant.COOKIE_DOMAIN);
				cookieId.setPath(WebCookieConstant.COOKIE_PATH);
				cookieName.setDomain(WebCookieConstant.COOKIE_DOMAIN);
				cookieName.setPath(WebCookieConstant.COOKIE_PATH);

				response.addCookie(cookieId);
				response.addCookie(cookieName);
			}
		}

		return "loginindex";
	}

	/**
	 * 登录的接口
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpServletRequest request,  HttpServletResponse response) throws UnsupportedEncodingException {

		Result result = verifyImgValidcode(request);

		if (Result.SUCCESS.equals(result.getCode())) {
//			String user = request.getParameter("username");
			String pwd = request.getParameter("password");

			pwd = StringEscapeUtils.unescapeHtml4(pwd);//反转义密码

//			String session = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_SESSION_ID, request).getValue();

			//result = ssoUserService.login(user, pwd, session);

			if (Result.SUCCESS.equals(result.getCode())) {
				Authorization authorization = (Authorization) result.getBody();
				Cookie cookieName = new Cookie(WebCookieConstant.COOKIE_USER_NAME, URLEncoder.encode(authorization.getUsername(), "UTF-8"));
				cookieName.setDomain(WebCookieConstant.COOKIE_DOMAIN);
				cookieName.setPath(WebCookieConstant.COOKIE_PATH);
				cookieName.setMaxAge(1800 - 30);
				response.addCookie(cookieName);

				Cookie cookieId = new Cookie(WebCookieConstant.COOKIE_USER_ID, authorization.getId().toString());
				cookieId.setDomain(WebCookieConstant.COOKIE_DOMAIN);
				cookieId.setPath(WebCookieConstant.COOKIE_PATH);
				cookieId.setMaxAge(1800 - 30);
				response.addCookie(cookieId);

				//判断是否存在companyId
				if(authorization.getCompanyId() != null) {
					//设置companyId的cookie
					Cookie cookieCompanyId = new Cookie(WebCookieConstant.COOKIE_USER_COMPANY_ID, authorization.getCompanyId().toString());
					cookieCompanyId.setDomain(WebCookieConstant.COOKIE_DOMAIN);
					cookieCompanyId.setPath(WebCookieConstant.COOKIE_PATH);
					cookieCompanyId.setMaxAge(1800 - 30);
					response.addCookie(cookieCompanyId);

					result.setBody(authorization.getCompanyId());
				} else {
					// 清空body
					result.setBody(null);
				}
			} else {
				// 清空body
				result.setBody(null);
			}
		} else {
			// 清空body
			result.setBody(null);
		}
		return result;
	}

	/**
	 * 退出的接口
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		if (null != CookieUtility.getCookieByName(WebCookieConstant.COOKIE_SESSION_ID, request)) {
//			String session = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_SESSION_ID, request).getValue();
			//ssoUserService.logout(session);

			Cookie cookie = new Cookie(WebCookieConstant.COOKIE_SESSION_ID, null);
			cookie.setMaxAge(0);
			Cookie cookieName = new Cookie(WebCookieConstant.COOKIE_USER_NAME, null);
			cookieName.setMaxAge(0);
			Cookie cookieId = new Cookie(WebCookieConstant.COOKIE_USER_ID, null);
			cookieId.setMaxAge(0);

			cookie.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			cookie.setPath(WebCookieConstant.COOKIE_PATH);
			cookieId.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			cookieId.setPath(WebCookieConstant.COOKIE_PATH);
			cookieName.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			cookieName.setPath(WebCookieConstant.COOKIE_PATH);

			response.addCookie(cookieId);
			response.addCookie(cookieName);
			response.addCookie(cookie);
		}

		return "logout";
	}



	private Result verifyImgValidcode(HttpServletRequest request) {
		Result result = new Result();

//		String isImageValidatecode = Configuration.getProperty("system", "sso.is_image_validatecode", "false");
//
//		if ("true".equals(isImageValidatecode)) {
//			String userValidcode = request.getParameter("validcode");
//			String session = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_SESSION_ID, request).getValue();
//			Object obj = objectRedisTemplate.opsForValue().get(SSORedisKeyConstant.LOGIN_VALIDATE_CODE_PREFIX + session);
//
//			if (null != obj) {
//				String sysValidcode = (String) obj;
//
//				if (!sysValidcode.equalsIgnoreCase(userValidcode)) {
//					result.setCode(Result.FAILURE);
//					result.setMsg("验证码不正确");
//				}
//			}
//		}

		return result;
	}

}
