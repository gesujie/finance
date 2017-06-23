package com.jibinfo.finance.service.impl.car;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.entity.car.CarBrandExample;
import com.jibinfo.finance.entity.car.CarBrandExample.Criteria;
import com.jibinfo.finance.mapper.car.CarBrandMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarBrandService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("carBrandService")
public class CarBrandServiceImpl extends
		AbstractBaseServiceEx<CarBrandExample, CarBrand>
		implements CarBrandService {
	@Resource
	private CarBrandMapper carBrandMapper;

	@Override
	public BaseMapper<CarBrandExample, CarBrand> getMapper() {
		return carBrandMapper;
	}

	@Override
	public PageModel<CarBrand> getData(Integer pageNumber, Integer pageSize,
			CarBrand brand) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		CarBrandExample example = new CarBrandExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		if (null != brand) {
			if (StringUtils.isNotEmpty(brand.getBrandName())) {
				criteria.andBrandNameLike("%" + brand.getBrandName() + "%");
			}
			if (StringUtils.isNotEmpty(brand.getInitials())) {
				criteria.andInitialsEqualTo(brand.getInitials());
			}
			if (StringUtils.isNotEmpty(brand.getType())
					&& !StringUtils.equalsIgnoreCase("-1", brand.getType())) {
				criteria.andTypeEqualTo(brand.getType());
			}
		}

		example.setPaginator(paginator);

		List<CarBrand> brands = carBrandMapper.selectByExample(example);
		int total = carBrandMapper.countByExample(example);
		PageModel<CarBrand> pageModel = new PageModel<>(total, brands);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(CarBrand brand) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = brand.getId();
		if (null == id) {// 添加
			brand.setCreatedDate(new Date());
			brand.setUpdatedDate(new Date());
			brand.setIsDel(Constants.NO_DEL);
			carBrandMapper.insertSelective(brand);
		}

		if (null != id) {// 修改
			brand.setUpdatedDate(new Date());
			carBrandMapper.updateByPrimaryKeySelective(brand);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				CarBrand brand = carBrandMapper
						.selectByPrimaryKey(new Long(id));
				brand.setUpdatedDate(new Date());
				brand.setIsDel(Constants.YES_DEL);
				carBrandMapper.updateByPrimaryKeySelective(brand);
			}
		}
		return result;
	}

}
