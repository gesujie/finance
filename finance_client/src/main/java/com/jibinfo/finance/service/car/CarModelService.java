package com.jibinfo.finance.service.car;

import java.util.List;

import com.jibinfo.finance.entity.car.CarModel;
import com.jibinfo.finance.entity.car.CarModelExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface CarModelService extends BaseService<CarModelExample, CarModel> {
	ResponseVo getTreeJson(String bid);

	PageModel<CarModel> getData(Integer pageNumber, Integer pageSize,
			CarModel model);

	ResponseVo saveOrUpdate(CarModel model, String seriesId);

	ResponseVo delete(String ids);

	List<Long> getSidByBid(Long bid);
}
