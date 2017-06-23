package com.jibinfo.finance.controller.car;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.car.CarModel;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarModelService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;

@Controller
@RequestMapping(ModuleAdminPath.CAR_ADMIN + "/model")
public class CarModelAdminController extends BaseController {

	private static final String LIST = "car/model/list";

	private static final String ADD = "car/model/add";

	private static final String EDIT = "car/model/edit";

	private static final String DETAIL = "car/model/detail";

	@Resource
	private CarModelService carModelService;

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
	 * 获取汽车品牌/车系菜单树
	 * 
	 * @param response
	 */
	@RequestMapping("/getSeriesJson")
	public void getSeriesJson(HttpServletResponse response, String bid) {
		ResponseVo treeJson = carModelService.getTreeJson(bid);
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
		CarModel model = super.getRequestParam(request, CarModel.class);
		PageModel<CarModel> pageModel = carModelService.getData(pageNumber,
				pageSize, model);
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
			CarModel model = carModelService.selectByPrimaryKey(id);
			request.setAttribute("model", model);
		}
		return EDIT;
	}

	/**
	 * 添加/修改保存
	 * 
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletResponse response, CarModel model,
			String seriesId) {
		ResponseVo result = carModelService.saveOrUpdate(model, seriesId);
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
		ResponseVo result = carModelService.delete(ids);
		outputJSON(result, response);
	}

	/**
	 * 详情页面
	 * 
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Long id) {
		if (null != id) {
			CarModel model = carModelService.selectByPrimaryKey(id);
			request.setAttribute("model", model);
		}
		return DETAIL;
	}
}
