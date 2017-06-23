package com.jibinfo.finance.service.car;

import java.util.List;

import com.jibinfo.finance.entity.car.CarLoanRate;
import com.jibinfo.finance.entity.car.CarLoanRateExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.vo.car.CarLoanRateVO;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface CarLoanRateService extends
		BaseService<CarLoanRateExample, CarLoanRate> {
	ResponseVo getTreeJson(String provinceId);

	PageModel<CarLoanRateVO> getData(Integer pageNumber, Integer pageSize,
			CarLoanRate rate);

	ResponseVo delete(String ids);

	ResponseVo saveOrUpdate(CarLoanRate loanRate);

	List<CarLoanRate> findByPid(Long pid);

}
