package com.jibinfo.finance.filter;

import com.jibinfo.framework.constant.WebCookieConstant;
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

public class WebSingleSingOnFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestUri = request.getRequestURI();
		String requestUrl = request.getRequestURL().toString();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		requestUrl = requestUrl.replace(contextPath, "");

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
 		}

		if (whiteList(url) || url.contains("/login") || url.endsWith("/favicon.ico")) {
			filterChain.doFilter(request, response);
			return;
		}

		String paraSession = request.getParameter(WebCookieConstant.PARAMETER_SESSION_KEY);
		String session = (null != paraSession && !paraSession.isEmpty()) ? paraSession : cookie.getValue();
		SessionUtils sessionUtils = (SessionUtils)ContextHolder.getBean("sessionUtils");
		Authorization authorization = (Authorization)sessionUtils.sessionGet(session);

		Cookie userIdCookie = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_USER_ID, request);


		if (null == authorization || (null != userIdCookie && !authorization.getId().toString().equals(userIdCookie.getValue()))) {
			request.setAttribute("fromUrl", requestUrl);
			String loginUrl = Configuration.getProperty("system", "web.login.url") + "?fromUrl=" + requestUrl;
			response.sendRedirect(loginUrl);
			return;
		} else {
			request.setAttribute(WebCookieConstant.AUTHORIZATION_KEY, authorization);
		}

		filterChain.doFilter(request, response);
	}
	
	private boolean whiteList(String url){
		String patternStr =  Configuration.getProperty("system", "web.server.exclude.url.pattern");
		if (null != patternStr) {
			Pattern pattern = Pattern.compile(patternStr);
			if (null != pattern && pattern.matcher(url).find()) {
				return true;
			}
		}
		return false;
	}
	
	private void refreshCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie sessionCookie = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_SESSION_ID, request);
		Cookie userIdCookie = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_USER_ID, request);
		Cookie userNameCookie = CookieUtility.getCookieByName(WebCookieConstant.COOKIE_USER_NAME, request);
		
		if (null != sessionCookie) {
			sessionCookie.setMaxAge(1800 - 30);
			sessionCookie.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			sessionCookie.setPath(WebCookieConstant.COOKIE_PATH);
			response.addCookie(sessionCookie);
		}
		if (null != userIdCookie) {
			userIdCookie.setMaxAge(1800 - 30);
			userIdCookie.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			userIdCookie.setPath(WebCookieConstant.COOKIE_PATH);
			response.addCookie(userIdCookie);
		}

		if (null != userNameCookie) {
			userNameCookie.setMaxAge(1800 - 30);
			userNameCookie.setDomain(WebCookieConstant.COOKIE_DOMAIN);
			userNameCookie.setPath(WebCookieConstant.COOKIE_PATH);
			response.addCookie(userNameCookie);
		}
	}

}
