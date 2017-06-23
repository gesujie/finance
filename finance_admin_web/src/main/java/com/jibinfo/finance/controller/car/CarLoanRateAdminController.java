package com.jibinfo.finance.controller.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.car.CarLoanRate;
import com.jibinfo.finance.entity.car.CarLoanRateExample;
import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.entity.system.SystemProvinceExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarLoanRateService;
import com.jibinfo.finance.service.system.SystemDicDetailService;
import com.jibinfo.finance.service.system.SystemProvinceService;
import com.jibinfo.finance.vo.car.CarLoanRateVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.CAR_ADMIN + "/loan/rate")
public class CarLoanRateAdminController extends BaseController {
	private static final String LIST = "car/loanRate/list";

	private static final String ADD = "car/loanRate/add";

	private static final String EDIT = "car/loanRate/edit";
	
	private static final String CALC = "car/loanRate/calc";

	@Resource
	private CarLoanRateService carLoanRateService;
	
	@Resource
	private SystemDicDetailService systemDicDetailService;
	
	@Resource
	private SystemProvinceService systemProvinceService;

	/**
	 * 列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String list() {
		return LIST;
	}

	/**
	 * 获取省/市树
	 * 
	 * @param response
	 */
	@RequestMapping("/getCityJson")
	public void getCityJson(HttpServletResponse response, String provinceId) {
		ResponseVo treeJson = carLoanRateService.getTreeJson(provinceId);
		super.outputJSON(treeJson.getBody(), response);
	}

	/**
	 * 分页列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,
			HttpServletRequest request, Integer pageNumber, Integer pageSize) {
		
		CarLoanRate rate = super.getRequestParam(request, CarLoanRate.class);
		PageModel<CarLoanRateVO> pageModel = carLoanRateService.getData(
				pageNumber, pageSize, rate);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		SystemDicDetailExample dicex = new SystemDicDetailExample();
		dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L);
		List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
		request.setAttribute("systemDicDetailList", systemDicDetailList);
		SystemProvinceExample ex = new SystemProvinceExample();
		ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		List<SystemProvince> provinceList = systemProvinceService.selectByExample(ex);
		request.setAttribute("provinceList", provinceList);
		return ADD;
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Long id) {
		if (null != id) {
			CarLoanRate loanRate = carLoanRateService.selectByPrimaryKey(id);
			request.setAttribute("loanRate", loanRate);
			List<CarLoanRate> carLoanRateList = carLoanRateService.findByPid(loanRate.getPid());
			List<String> idList = new ArrayList<String>();
			if(null != carLoanRateList && carLoanRateList.size() > 0) {
				for(int i=0; i<carLoanRateList.size(); i++) {
					String codes = carLoanRateList.get(i).getCode();
					idList.add(codes);
				}
			}
			//省份信息
			SystemProvinceExample ex = new SystemProvinceExample();
			ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
			List<SystemProvince> provinceList = systemProvinceService.selectByExample(ex);
			request.setAttribute("provinceList", provinceList);
			
			SystemDicDetailExample dicex = new SystemDicDetailExample();
			dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L).andCodeIn(idList);
			List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
			request.setAttribute("systemDicDetailList", systemDicDetailList);
			
		}
		return EDIT;
	}
	
	/**
	 * 修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/calc")
	public String calc(HttpServletRequest request, Long id) {
		if (null != id) {
			CarLoanRate loanRate = carLoanRateService.selectByPrimaryKey(id);
			request.setAttribute("loanRate", loanRate);
			SystemDicDetailExample dicex = new SystemDicDetailExample();
			dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L);
			List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
			request.setAttribute("systemDicDetailList", systemDicDetailList);
			SystemProvinceExample ex = new SystemProvinceExample();
			ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
			List<SystemProvince> provinceList = systemProvinceService.selectByExample(ex);
			request.setAttribute("provinceList", provinceList);
		}
		return CALC;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response,CarLoanRate loanRate) {
//		String code = loanRate.getCode();
		Long pid = loanRate.getPid();
		SystemProvince systemProvince = systemProvinceService.selectByPrimaryKey(pid);
		loanRate.setPname(systemProvince.getName());
//		SystemDicDetail systemDicDetail = systemDicDetailService.findByCode(code);
		ResponseVo result = carLoanRateService.saveOrUpdate(loanRate);
		outputJSON(result, response);
	}

	/**
	 * 删除/批量删除
	 * 
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response, String ids) {
		ResponseVo result = carLoanRateService.delete(ids);
		outputJSON(result, response);
	}
	
	/**
	 * 计算
	 * 
	 * @return
	 */
	@RequestMapping("/calcAjax")
	public void calcAjax(HttpServletResponse response,HttpServletRequest request, CarLoanRate loanRate, String price) {
		String code = loanRate.getCode();
		Long pid = loanRate.getPid();
		CarLoanRateExample ex = new CarLoanRateExample();
		ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andCodeEqualTo(code).andPidEqualTo(pid);
		List<CarLoanRate> carLoanRateList = carLoanRateService.selectByExample(ex);
		CarLoanRate carLoan = null;
		String num = "12";
		if(null != carLoanRateList && carLoanRateList.size() > 0){
			 carLoan = carLoanRateList.get(0);
		}
		SystemDicDetailExample dicex = new SystemDicDetailExample();
		dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L).andCodeEqualTo(code);
		List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
		if(null != systemDicDetailList && systemDicDetailList.size() > 0){
			num = systemDicDetailList.get(0).getValue();
		}

		String rate = null != carLoan ? carLoan.getRate() : "";
		BigDecimal radix = new BigDecimal("1");
		BigDecimal yearRate = new BigDecimal(rate).multiply(new BigDecimal("0.01"));
		BigDecimal mouthRate = yearRate.divide(new BigDecimal("12"), 4, BigDecimal.ROUND_HALF_UP);
		BigDecimal radixnew = mouthRate.add(radix);
		double part = Math.pow(radixnew.doubleValue(),Integer.valueOf(num));
		ResponseVo result = new ResponseVo();
		Map<String, Object> amountData = new HashMap<>();
		if(price.equals("")){
			result.setCode(ResponseVo.FAILURE);
			result.setMsg("请输入贷款金额");
		} else {
			BigDecimal dividend = new BigDecimal(price).multiply(new BigDecimal(part)).multiply(mouthRate);
			BigDecimal divisor = new BigDecimal(part).subtract(radix);
			BigDecimal amount = dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
			amountData.put("amount",amount);
			amountData.put("num",num);
			result.setCode(ResponseVo.SUCCESS);
		}
		amountData.put("num",num);
		result.setBody(amountData);
		super.outputJSON(result, response);
	}
	
	/**
	 * 修改里面切换省份
	 * 
	 * @return
	 */
	@RequestMapping("/changePro")
	public void changePro(HttpServletResponse response,HttpServletRequest request) {
		ResponseVo result = new ResponseVo();
		Map<String, Object> list = new HashMap<>();// 生成签名的数据
		String id = request.getParameter("provinceId");
		List<CarLoanRate> carLoanRateList = carLoanRateService.findByPid(Long.valueOf(id));
		List<String> idList = new ArrayList<String>();
		if(null != carLoanRateList && carLoanRateList.size() > 0) {
			for(int i=0; i<carLoanRateList.size(); i++) {
				String codes = carLoanRateList.get(i).getCode();
				idList.add(codes);
			}
			SystemDicDetailExample dicex = new SystemDicDetailExample();
			dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L).andCodeIn(idList);
			List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
			request.setAttribute("systemDicDetailList", systemDicDetailList);
			list.put("systemDicDetailList", systemDicDetailList);
			result.setBody(list);
			result.setCode(ResponseVo.SUCCESS);
		} else {
			result.setCode(ResponseVo.FAILURE);
		}
		
		outputJSON(result, response);
	}
	
	/**
	 * 计算里面切换贷款方案
	 * 
	 * @return
	 */
	@RequestMapping("/changeLoanType")
	public void changeLoanType(HttpServletResponse response,HttpServletRequest request) {
		ResponseVo result = new ResponseVo();
		Map<String, Object> list = new HashMap<>();
		String id = request.getParameter("provinceId");
		String loanCode = request.getParameter("loanCode");
		CarLoanRateExample dicex = new CarLoanRateExample();
		dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andPidEqualTo(Long.valueOf(id)).andCodeEqualTo(loanCode);
		List<CarLoanRate> carLoanRateList = carLoanRateService.selectByExample(dicex);
		list.put("carLoanRateList", carLoanRateList);
		result.setBody(list);
		outputJSON(result, response);
	}
}
