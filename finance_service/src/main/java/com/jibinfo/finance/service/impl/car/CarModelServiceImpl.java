package com.jibinfo.finance.service.impl.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.entity.car.CarBrandExample;
import com.jibinfo.finance.entity.car.CarModel;
import com.jibinfo.finance.entity.car.CarModelExample;
import com.jibinfo.finance.entity.car.CarModelExample.Criteria;
import com.jibinfo.finance.entity.car.CarSeries;
import com.jibinfo.finance.entity.car.CarSeriesExample;
import com.jibinfo.finance.mapper.car.CarBrandMapper;
import com.jibinfo.finance.mapper.car.CarModelMapper;
import com.jibinfo.finance.mapper.car.CarSeriesMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeViewDiy;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarModelService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("carModelService")
public class CarModelServiceImpl extends
		AbstractBaseServiceEx<CarModelExample, CarModel> implements
		CarModelService {
	@Resource
	private CarModelMapper carModelMapper;

	@Resource
	private CarBrandMapper carBrandMapper;

	@Resource
	private CarSeriesMapper carSeriesMapper;

	@Override
	public BaseMapper<CarModelExample, CarModel> getMapper() {
		return carModelMapper;
	}

	@Override
	public ResponseVo getTreeJson(String bid) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		List<JsTreeViewDiy> jtvList = new ArrayList<>();

		if (StringUtils.isEmpty(bid)) {
			// 获取品牌树
			this.getbrandTree(jtvList);
		} else {
			// 获取车型树
			this.getSeriesTree(bid, jtvList);
		}

		responseVo.setBody(jtvList);

		return responseVo;
	}

	@Override
	public PageModel<CarModel> getData(Integer pageNumber, Integer pageSize,
			CarModel model) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		CarModelExample example = new CarModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != model) {
			String bid = model.getBid();
			String sid = model.getSeriesId();

			if (null != bid && null == sid) {
				Long brandId = Long.valueOf(bid.substring(2));
				List<Long> sids = this.getSidByBid(brandId);
				if (!(null != sids && !sids.isEmpty())) {
					sids.add(0L);
				}
				criteria.andSidIn(sids);
			}

			if (null != sid) {
				Long seriesId = Long.valueOf(sid.substring(2));
				criteria.andSidEqualTo(seriesId);
			}

			if (StringUtils.isNotEmpty(model.getModelName())) {
				criteria.andModelNameLike("%" + model.getModelName() + "%");
			}
		}

		List<CarModel> carModels = carModelMapper.selectByExample(example);
		int total = carModelMapper.countByExample(example);
		PageModel<CarModel> pageModel = new PageModel<>(total, carModels);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(CarModel model, String seriesId) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = model.getId();
		if (null == id) {// 添加
			Long sid = Long.valueOf(seriesId.substring(2));
			model.setSid(sid);
			model.setCreatedDate(new Date());
			model.setUpdatedDate(new Date());
			model.setIsDel(Constants.NO_DEL);
			carModelMapper.insertSelective(model);
		}

		if (null != id) {// 修改
			model.setUpdatedDate(new Date());
			carModelMapper.updateByPrimaryKeySelective(model);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				CarModel model = carModelMapper
						.selectByPrimaryKey(new Long(id));
				model.setUpdatedDate(new Date());
				model.setIsDel(Constants.YES_DEL);
				carModelMapper.updateByPrimaryKeySelective(model);
			}
		}
		return result;
	}

	/**
	 * 获取品牌树
	 */
	private void getbrandTree(List<JsTreeViewDiy> jtvList) {
		CarBrandExample example = new CarBrandExample();
		CarBrandExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		List<CarBrand> brandList = carBrandMapper.selectByExample(example);
		if (null != brandList && !brandList.isEmpty()) {
			for (CarBrand carBrand : brandList) {
				JsTreeViewDiy jsTreeViewDiy = new JsTreeViewDiy("b_"
						+ carBrand.getId(), carBrand.getBrandName(), "",
						new JsTreeState(false, false, false), true);
				jtvList.add(jsTreeViewDiy);
			}
		}
	}

	/**
	 * 获取车系树
	 */
	private void getSeriesTree(String bid, List<JsTreeViewDiy> jtvList) {
		Long brandId = Long.valueOf(bid.substring(2));// 获取汽车品牌
		CarSeriesExample example = new CarSeriesExample();
		CarSeriesExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andBidEqualTo(brandId);
		List<CarSeries> seriesList = carSeriesMapper.selectByExample(example);
		if (null != seriesList && !seriesList.isEmpty()) {
			for (CarSeries carSeries : seriesList) {
				JsTreeViewDiy jsTreeViewDiy = new JsTreeViewDiy("s_"
						+ carSeries.getId(), carSeries.getSeriesName(), "",
						new JsTreeState(false, false, false), false);
				jtvList.add(jsTreeViewDiy);
			}
		}
	}

	@Override
	public List<Long> getSidByBid(Long bid) {
		List<Long> sids = new ArrayList<>();
		CarSeriesExample example = new CarSeriesExample();
		CarSeriesExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andBidEqualTo(bid);
		List<CarSeries> list = carSeriesMapper.selectByExample(example);
		if (null != list && !list.isEmpty()) {
			for (CarSeries carSeries : list) {
				sids.add(carSeries.getId());
			}
		}
		return sids;
	}
}
