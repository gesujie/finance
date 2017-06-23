package com.jibinfo.finance.service.car;

import com.jibinfo.finance.entity.car.CarSeries;
import com.jibinfo.finance.entity.car.CarSeriesExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface CarSeriesService extends
		BaseService<CarSeriesExample, CarSeries> {
	ResponseVo getTreeJson();

	PageModel<CarSeries> getData(Integer pageNumber, Integer pageSize,
			CarSeries series);

	ResponseVo saveOrUpdate(CarSeries series, String bid);

	ResponseVo delete(String ids);
}
