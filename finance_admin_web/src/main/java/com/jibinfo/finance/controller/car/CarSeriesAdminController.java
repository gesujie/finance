package com.jibinfo.finance.controller.car;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.car.CarSeries;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarSeriesService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.CAR_ADMIN + "/series")
public class CarSeriesAdminController extends BaseController {
	
	private static final String LIST = "car/series/list";

	private static final String ADD = "car/series/add";

	private static final String EDIT = "car/series/edit";

	@Resource
	private CarSeriesService carSeriesService;

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
	 * 获取汽车品牌菜单树
	 * 
	 * @param response
	 */
	@RequestMapping("/getBrandJson")
	public void getBrandJson(HttpServletResponse response) {
		ResponseVo treeJson = carSeriesService.getTreeJson();
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
		CarSeries series = super.getRequestParam(request, CarSeries.class);
		PageModel<CarSeries> pageModel = carSeriesService.getData(pageNumber,
				pageSize, series);
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
			CarSeries series = carSeriesService.selectByPrimaryKey(id);
			request.setAttribute("series", series);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, CarSeries series,
			String bid) {
		ResponseVo result = carSeriesService.saveOrUpdate(series, bid);
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
		ResponseVo result = carSeriesService.delete(ids);
		outputJSON(result, response);
	}
}
