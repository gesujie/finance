package com.jibinfo.finance.controller.index;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.dto.SpaceStatusDTO;
import com.jibinfo.finance.entity.system.SystemAdminUser;
import com.jibinfo.finance.service.system.SystemAdminUserService;
import com.jibinfo.finance.service.system.SystemMenuService;
import com.jibinfo.finance.utils.DiskSpaceDetailUtils;
import com.jibinfo.finance.vo.system.MenuVO;
import com.jibinfo.framework.constant.AdminCookieConstant;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.security.AdminAuthorizationUtils;
import com.jibinfo.framework.security.Authorization;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.support.utility.CookieUtility;


@Controller
@RequestMapping(ModuleAdminPath.INDEX)
public class IndexAdminController extends BaseController{
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private static final String INDEX = "index/index";
	
	private static final String LOGIN = "index/login";
	
	private static final String CONSOLE = "index/console";

	private static final String PROFILE = "index/profile";

	private static final String RESET_PWD = "index/reset_pwd";


	@Resource
	private SystemAdminUserService systemAdminUserService;
	
	@Resource
	private SystemMenuService systemMenuService;
	
	private static final String LOGIN_URL = Configuration.getProperty("manager_path");
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		Authorization loadAuthorization = AdminAuthorizationUtils.loadAuthorization();
		log.info("login user id is :" + loadAuthorization.getId());
		//加载菜单信息
		List<MenuVO> menuList = systemMenuService.findMenuList(loadAuthorization.getId());
		request.setAttribute("menuList", menuList);
		//System.out.println(menuList);
		return INDEX;
	}
	
	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("/admin/loginindex")
	public String loginindex(HttpServletRequest request,HttpServletResponse response){
		String fromUrl = Configuration.getProperty("system", "manager_path");
		request.setAttribute("fromUrl", fromUrl);
		Cookie cookie = null;
 		Cookie[] cookies = request.getCookies();
 		if (cookies != null){
 			for (Cookie c : cookies){
 				if (c.getName().equals(AdminCookieConstant.COOKIE_SESSION_ID)){
 					cookie = c;
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
		
		return LOGIN;
	}
	

	/**
	 * 登陆
	 * @param request
	 * @param response
	 */
	@RequestMapping("/admin/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String session = CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_SESSION_ID, request).getValue();
		ResponseVo result = systemAdminUserService.login(userName,password,session);
		try {
			if (ResponseVo.SUCCESS.equals(result.getCode())) {
				Authorization authorization = (Authorization) result.getBody();
				String name = null != authorization ? authorization.getUsername() : "";
				Cookie cookieName = new Cookie(AdminCookieConstant.COOKIE_USER_NAME, URLEncoder.encode(name, "UTF-8"));
				cookieName.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
				cookieName.setPath(AdminCookieConstant.COOKIE_PATH);
				cookieName.setMaxAge(1800 - 30);
				response.addCookie(cookieName);
				
				String value = null != authorization ? authorization.getId().toString() : "";
				Cookie cookieId = new Cookie(AdminCookieConstant.COOKIE_USER_ID, value);
				cookieId.setDomain(AdminCookieConstant.COOKIE_DOMAIN);
				cookieId.setPath(AdminCookieConstant.COOKIE_PATH);
				cookieId.setMaxAge(1800 - 30);
				response.addCookie(cookieId);
				//记录用户最后登录时间，登录IP
				if(authorization != null && authorization.getId() != null && authorization.getId()> 0 ){
					SystemAdminUser adminUser = new SystemAdminUser();
					adminUser.setId(authorization.getId());
					adminUser.setLastLoginDate(new Date());
					String ip = super.getRemoteAddress(request);
					if (ip == null ) {
						ip = "unknow";
					}
					adminUser.setLastLoginIp(ip);
					systemAdminUserService.updateByPrimaryKeySelective(adminUser);
				}
				result = result.successResponse();
				result.setBody(LOGIN_URL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = result.failureResponse("登陆异常!");
		}
		super.outputJSON(result, response);
	}
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/admin/logout")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (null != CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_SESSION_ID, request)) {
			String session = CookieUtility.getCookieByName(AdminCookieConstant.COOKIE_SESSION_ID, request).getValue();
			systemAdminUserService.logout(session);
			Cookie cookie = new Cookie(AdminCookieConstant.COOKIE_SESSION_ID, null);
			cookie.setMaxAge(0);
			Cookie cookieName = new Cookie(AdminCookieConstant.COOKIE_USER_NAME, null);
			cookieName.setMaxAge(0);
			Cookie cookieId = new Cookie(AdminCookieConstant.COOKIE_USER_ID, null);
			cookieId.setMaxAge(0);
			response.addCookie(cookieId);
			response.addCookie(cookieName);
			response.addCookie(cookie);
		}
		String url = Configuration.getProperty("system", "admin.login.url");
		response.sendRedirect(url);
		
	}
	
	
	/**
	 * 跳转控制台
	 * @return
	 */
	@RequestMapping("/admin/console")
	public String console(){
		return CONSOLE;
	}



	/**
	 * 个人信息
	 * @return
	 */
	@RequestMapping("/admin/profile")
	public String profile(HttpServletRequest request){
		Authorization authorization = AdminAuthorizationUtils.loadAuthorization();
		Long id = authorization.getId();
		SystemAdminUser systemAdminUser = systemAdminUserService.selectByPrimaryKey(id);
		request.setAttribute("profile",systemAdminUser);
		return PROFILE;
	}

	/**
	 * 重置密码
	 * @return
	 */
	@RequestMapping("/admin/resetPwd")
	public String resetPwd(){
		return RESET_PWD;
	}


	@RequestMapping("/admin/getSpace")
	public void getSpace(HttpServletResponse response){
		List<SpaceStatusDTO> spaceStatusDTOS = DiskSpaceDetailUtils.percentSpace();
		super.outputJSON(spaceStatusDTOS, response);

	}



}
