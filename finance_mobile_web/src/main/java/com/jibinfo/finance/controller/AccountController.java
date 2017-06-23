package com.jibinfo.finance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jibinfo.finance.common.MobileBaseController;


@Controller
@RequestMapping({"/account"})
public class AccountController extends MobileBaseController {
	
	public AccountController() {
		super();
	}
	
	/**
	 * 贷金券小测试的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/loanTest")
	public String loanTestAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "loan/loan_test";
	}
	
	/**
	 * 贷款申请的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/loanApply")
	public String loanApply(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "loan/loanApply";
	}

	/**
	 * 贷款申请的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/laws")
	public String laws(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "static/laws";
	}
	
	/**
	 * 贷款申请的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/aboutUs")
	public String aboutUs(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "static/about";
	}
	
	/**
	 * 零利率品牌的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/carActivity")
	public String carActivity(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/zero_interest_rate";
	}
	
	/**
	 * 子品牌的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/carActivity/{brands}")
	public String carActivityBrands(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/subBrands";
	}
	
	/**
	 * 子品牌详情（活动详情）的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/carActivity/{brands}/{subBrands}")
	public String activityDescr(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/subBrandsDescr";
	}
	
	/**
	 * 品牌的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/activity")
	public String activity(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/activity";
	}
	
	/**
	 * 贷款计算器的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/calc")
	public String calc(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/calculator";
	}
	
	/**
	 * 账号管理的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/manage")
	public String manage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/account_management";
	}
	
	/**
	 * 修改手机号的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateMobile")
	public String updateMobile(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/update_mobile";
	}
	
	/**
	 * 修改密码的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/update_password";
	}
	
	/**
	 * 个人中心的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/memberCenter")
	public String memberCenter(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/member_center";
	}
	
	/**
	 * 我的贷款的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/contractDatailsInfo")
	public String contractDatailsInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "loan/my_loan_second";
	}
	
	/**
	 * 定位功能调研的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/distest")
	public String distest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "distributor/text";
	}
	
	/**
	 * 搜索的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/search";
	}
	
	/**
	 * 经销商预约页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/appointment")
	public String appointment(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/appointment";
	}
	
	/**
	 * 贷款指南的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/help")
	public String help(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "static/help";
	}
	
	/**
	 * 经销商详情的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/{disId}/{brandId}")
	public String description(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "distributor/description";
	}
	
	/**
	 * 更多评论的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/moreComments")
	public String disComments(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "distributor/disComments";
	}
	
	/**
	 * 根据经纬度显示标注的页面结构（第二步）
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/showMarker")
	public String showMarker(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("LONGITUDE", "118.739979");
		model.put("LATITUDE", "32.027908");
		model.put("company", "南京公用发展股份有限公司");
		model.put("address", "南京市通江路16号");
		return "distributor/showMarker";
	}
	
	/**
	 * 更多活动算月供的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/moreCarActivities/{brandId}/{subBrandId}/{code}")
	public String moreCarActivities(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "car/carActivityCalc";
	}
	
	/**
	 * 修改登录密码的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/modifyPassword";
	}
	
	/**
	 * 咨询留言码的页面结构
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/myMessages")
	public String myMessages(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "account/myMessages";
	}
	
	
	
}
