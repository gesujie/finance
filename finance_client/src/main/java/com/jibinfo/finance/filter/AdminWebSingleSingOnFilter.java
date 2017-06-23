package com.jibinfo.finance.filter;

import com.jibinfo.framework.constant.AdminCookieConstant;
import com.jibinfo.framework.security.Authorization;
import com.jibinfo.framework.spring.ContextHolder;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.support.utility.CookieUtility;
import com.jibinfo.framework.utils.SessionUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;

public class AdminWebSingleSingOnFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestUri = request.getRequestURI();
		String requestUrl = request.getRequestURL().toString();
		requestUrl = Configuration.getProperty("system", "manager_path");
		String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        Cookie cookie = null;
 		Cookie[] cookies = request.getCookies();
 		if (cookies != null){
 			for (Cookie c : cookies){
 				if (c.getName().equals(AdminCookieConstant.COOKIE_SESSION_ID)){
 					cookie = c;
 					break;
 				}
 			}
 		}
 		if (cookie == null){
 			cookie = new Cookie(AdminCookieConstant.COOKIE_SESSION_ID, UUID.randomUUID().toString());
 			// 保证浏览器时间比redis短
 			cookie.setMaxAge(1800 - 30); 
 			cookie.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
 			cookie.setPath(AdminCookieConstant.COOKIE_PATH);
 			response.addCookie(cookie);
 		}
         
		if (whiteList(url) || url.contains("/login")) {
			filterChain.doFilter(request, response);
			return;
		}
		String paraSession = request.getParameter(AdminCookieConstant.PARAMETER_SESSION_KEY);
		String session = (null != paraSession && !paraSession.isEmpty()) ? paraSession : cookie.getValue();
		SessionUtils sessionUtils = (SessionUtils)ContextHolder.getBean("sessionUtils");
		Authorization authorization = (Authorization)sessionUtils.sessionGet(session);
		cookie.setMaxAge(1800 - 30);
		cookie.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
		cookie.setPath(AdminCookieConstant.COOKIE_PATH);
		response.addCookie(cookie);
		refreshCookie(request, response);
		if (null == authorization) {
			request.setAttribute("fromUrl", requestUrl);
			String loginUrl =  Configuration.getProperty("system", "admin.login.url") + "?fromUrl=" + requestUrl;
			
			Cookie cookieName = new Cookie(AdminCookieConstant.COOKIE_USER_NAME, null);
			cookieName.setMaxAge(0);
			Cookie cookieUserId = new Cookie(AdminCookieConstant.COOKIE_USER_ID, null);
			cookieUserId.setMaxAge(0);
			response.addCookie(cookieUserId);
			response.addCookie(cookieName);			
			response.sendRedirect(loginUrl);
			return;
		} else {
			request.setAttribute(AdminCookieConstant.AUTHORIZATION_KEY, authorization);
		}

		filterChain.doFilter(request, response);
	}
	
	private boolean whiteList(String url){
		String patternStr =  Configuration.getProperty("system", "admin.web.server.exclude.url.pattern");
		if (null != patternStr) {
			Pattern pattern = Pattern.compile(patternStr);
			if (null != pattern && pattern.matcher(url).find()) {
				return true;
			}
		}
		return false;
	}
	
	private void refreshCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie sessionCookie = CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_SESSION_ID, request);
		Cookie userIdCookie = CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_USER_ID, request);
		Cookie userNameCookie = CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_USER_NAME, request);
		
		if (null != sessionCookie) {
			sessionCookie.setMaxAge(1800 - 30);
			sessionCookie.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
			sessionCookie.setPath(AdminCookieConstant.COOKIE_PATH);
			response.addCookie(sessionCookie);
		}
		if (null != userIdCookie) {
			userIdCookie.setMaxAge(1800 - 30);
			userIdCookie.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
			userIdCookie.setPath(AdminCookieConstant.COOKIE_PATH);
			response.addCookie(userIdCookie);
		}

		if (null != userNameCookie) {
			userNameCookie.setMaxAge(1800 - 30);
			userNameCookie.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
			userNameCookie.setPath(AdminCookieConstant.COOKIE_PATH);
			response.addCookie(userNameCookie);
		}
	}

}
