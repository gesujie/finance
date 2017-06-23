package com.jibinfo.finance.service.impl.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.entity.car.CarBrandExample;
import com.jibinfo.finance.entity.car.CarSeries;
import com.jibinfo.finance.entity.car.CarSeriesExample;
import com.jibinfo.finance.entity.car.CarSeriesExample.Criteria;
import com.jibinfo.finance.mapper.car.CarBrandMapper;
import com.jibinfo.finance.mapper.car.CarSeriesMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeView;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarSeriesService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("carSeriesService")
public class CarSeriesServiceImpl extends
		AbstractBaseServiceEx<CarSeriesExample, CarSeries> implements
		CarSeriesService {
	private static final Log logger = LogFactory
			.getLog(CarSeriesServiceImpl.class);

	@Resource
	private CarSeriesMapper carSeriesMapper;

	@Resource
	private CarBrandMapper carBrandMapper;

	@Override
	public BaseMapper<CarSeriesExample, CarSeries> getMapper() {
		return carSeriesMapper;
	}

	@Override
	public ResponseVo getTreeJson() {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			CarBrandExample example = new CarBrandExample();
			CarBrandExample.Criteria criteria = example.createCriteria();
			criteria.andIsDelEqualTo(Constants.NO_DEL);
			List<CarBrand> list = carBrandMapper.selectByExample(example);

			List<JsTreeView> jtvList = new ArrayList<>();
			JsTreeView jsTreeView = new JsTreeView();
			jsTreeView.setId("-1");
			jsTreeView.setText("汽车品牌");
			jsTreeView.setState(new JsTreeState(true, false, false));
			jtvList.add(new JsTreeView());

			List<JsTreeView> children = new ArrayList<>();
			if (null != list && !list.isEmpty()) {
				for (CarBrand brand : list) {
					JsTreeView jtvc = new JsTreeView();
					jtvc.setId(brand.getId() + "");
					jtvc.setState(new JsTreeState(false, false, false));
					jtvc.setText(brand.getBrandName());
					children.add(jtvc);
				}
			}

			jsTreeView.setChildren(children);
			responseVo.setBody(jsTreeView);
		} catch (Exception e) {
			logger.error(e.getMessage().toString());
			responseVo = new ResponseVo().failureResponse();
		}
		return responseVo;
	}

	@Override
	public PageModel<CarSeries> getData(Integer pageNumber, Integer pageSize,
			CarSeries series) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		CarSeriesExample example = new CarSeriesExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != series) {
			Long bid = series.getBid();
			if (null != bid) {
				criteria.andBidEqualTo(bid);
			}
			if (StringUtils.isNotEmpty(series.getSeriesName())) {
				criteria.andSeriesNameLike("%" + series.getSeriesName() + "%");
			}
			if (StringUtils.isNotEmpty(series.getMakerType())) {
				criteria.andMakerTypeLike("%" + series.getMakerType() + "%");
			}
		}

		List<CarSeries> carSeries = carSeriesMapper.selectByExample(example);
		int total = carSeriesMapper.countByExample(example);
		PageModel<CarSeries> pageModel = new PageModel<>(total, carSeries);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(CarSeries series, String bid) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = series.getId();
		if (null == id) {// 添加
			series.setBid(Long.valueOf(bid));
			series.setCreatedDate(new Date());
			series.setUpdatedDate(new Date());
			series.setIsDel(Constants.NO_DEL);
			carSeriesMapper.insertSelective(series);
		}

		if (null != id) {// 修改
			series.setUpdatedDate(new Date());
			carSeriesMapper.updateByPrimaryKeySelective(series);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				CarSeries series = carSeriesMapper
						.selectByPrimaryKey(new Long(id));
				series.setUpdatedDate(new Date());
				series.setIsDel(Constants.YES_DEL);
				carSeriesMapper.updateByPrimaryKeySelective(series);
			}
		}
		return result;
	}
}
