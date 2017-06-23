package com.jibinfo.finance.utils;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jibinfo.framework.constant.AdminCookieConstant;
import com.jibinfo.framework.security.Authorization;
import com.jibinfo.framework.support.utility.WebUtility;

public class ActionContext {
	private static ApplicationContext applicationContext = null;
	private static ServletContext servletContext = null;

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getRequestAttr(String key, Class<T> clazz) {
		return (T) getRequest().getAttribute(key);
	}

	public static void setRequestAttr(String key, Object value) {
		if (null == value) {
			getRequest().removeAttribute(key);
		} else {
			getRequest().setAttribute(key, value);
		}
	}

	public static HttpSession getSession(boolean create) {
		return getRequest().getSession(create);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSessionAttr(String key) {
		HttpSession session = getSession(false);
		return (T) (null == session ? null : session.getAttribute(key));
	}

	public static void setSessionAttr(String key, Object value) {
		HttpSession session = getSession(true);
		if (null == value) {
			session.removeAttribute(key);
		} else {
			session.setAttribute(key, value);
		}
	}

	@SuppressWarnings("unchecked")
	public static Authorization getAuthorization() {
		Map<String, String> cookie = WebUtility.getCookies(getRequest());
		if (StringUtils.isBlank(cookie
				.get(AdminCookieConstant.COOKIE_SESSION_ID))) {
			HttpServletRequest request = getRequest();
			if (null != request.getAttribute("cas_authentication_key")) {
				return (Authorization) request
						.getAttribute("cas_authentication_key");
			}
			return null;
		}
		Authorization authorization = new Authorization();
		authorization.setId(Long.valueOf(cookie
				.get(AdminCookieConstant.COOKIE_USER_ID)));
		authorization.setUsername(cookie
				.get(AdminCookieConstant.COOKIE_USER_NAME));
		authorization.setSession(cookie
				.get(AdminCookieConstant.COOKIE_SESSION_ID));
		return authorization;
	}

	public static ServletContext getServletContext() {
		if (null != servletContext) {
			return servletContext;
		}
		return servletContext = getSession(true).getServletContext();
	}

	public static ApplicationContext getApplicationContext() {
		if (null != applicationContext) {
			return applicationContext;
		}
		return applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}
}
