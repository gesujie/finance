package com.jibinfo.finance.controller.car;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarBrandService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.CAR_ADMIN + "/brand")
public class CarBrandAdminController extends BaseController {

	private static final String LIST = "car/brand/list";

	private static final String ADD = "car/brand/add";

	private static final String EDIT = "car/brand/edit";

	@Resource
	private CarBrandService carBrandService;

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
	 * 分页列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public void getData(HttpServletResponse response,
			HttpServletRequest request, Integer pageNumber, Integer pageSize) {
		CarBrand brand = super.getRequestParam(request, CarBrand.class);
		PageModel<CarBrand> pageModel = carBrandService.getData(pageNumber,
				pageSize, brand);
		super.outputJSON(pageModel, response);
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
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
			CarBrand brand = carBrandService.selectByPrimaryKey(id);
			request.setAttribute("brand", brand);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, CarBrand brand) {
		ResponseVo result = carBrandService.saveOrUpdate(brand);
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
		ResponseVo result = carBrandService.delete(ids);
		outputJSON(result, response);
	}
}
