package com.jibinfo.finance.service.car;

import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.entity.car.CarBrandExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface CarBrandService extends BaseService<CarBrandExample, CarBrand> {
	PageModel<CarBrand> getData(Integer pageNumber, Integer pageSize,
			CarBrand brand);

	ResponseVo saveOrUpdate(CarBrand brand);

	ResponseVo delete(String ids);
}
