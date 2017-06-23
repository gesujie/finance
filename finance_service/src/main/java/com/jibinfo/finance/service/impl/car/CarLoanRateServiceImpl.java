package com.jibinfo.finance.service.impl.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.car.CarLoanRate;
import com.jibinfo.finance.entity.car.CarLoanRateExample;
import com.jibinfo.finance.entity.car.CarLoanRateExample.Criteria;
import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.entity.system.SystemProvinceExample;
import com.jibinfo.finance.mapper.car.CarLoanRateMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeViewDiy;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.car.CarLoanRateService;
import com.jibinfo.finance.service.system.SystemDicDetailService;
import com.jibinfo.finance.service.system.SystemProvinceService;
import com.jibinfo.finance.vo.car.CarLoanRateVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("carLoanRateService")
public class CarLoanRateServiceImpl extends
		AbstractBaseServiceEx<CarLoanRateExample, CarLoanRate> implements
		CarLoanRateService {
	@Resource
	private CarLoanRateMapper carLoanRateMapper;

	@Resource
	private SystemProvinceService systemProvinceService;
	
	@Resource
	private SystemDicDetailService systemDicDetailService;

	@Override
	public BaseMapper<CarLoanRateExample, CarLoanRate> getMapper() {
		return carLoanRateMapper;
	}

	@Override
	public ResponseVo getTreeJson(String provinceId) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		List<JsTreeViewDiy> jtvList = new ArrayList<>();

		// 获取省份
		this.getProvinceTree(jtvList);

		responseVo.setBody(jtvList);

		return responseVo;
	}

	@Override
	public PageModel<CarLoanRateVO> getData(Integer pageNumber, Integer pageSize,
			CarLoanRate rate) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		CarLoanRateExample example = new CarLoanRateExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");
		
		if (rate != null) {
			if(!StringUtils.isEmpty(rate.getPname())){
				criteria.andPnameLike("%"+rate.getPname()+"%");
			}
		}
		example.setPaginator(paginator);
		
		SystemDicDetailExample dicex = new SystemDicDetailExample();
		dicex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(20L);
		List<SystemDicDetail> systemDicDetailList = systemDicDetailService.selectByExample(dicex);
		
		List<CarLoanRate> carLoanRates = carLoanRateMapper.selectByExample(example);
		List<CarLoanRateVO> reList = new ArrayList<CarLoanRateVO>();
		if(null != carLoanRates && carLoanRates.size() > 0) {
			for(CarLoanRate carLoanRate : carLoanRates){
				CarLoanRateVO vo = new CarLoanRateVO();
				SystemDicDetailExample ex = new SystemDicDetailExample();
				ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andCodeEqualTo(carLoanRate.getCode());
				List<SystemDicDetail> systemDicDetails = systemDicDetailService.selectByExample(ex);
				if(null != systemDicDetails && systemDicDetails.size() > 0) {
					BeanUtils.copyProperties(carLoanRate, vo);
					vo.setName(systemDicDetails.get(0).getName());
					vo.setSystemDicDetail(systemDicDetailList);
				}
				reList.add(vo);
			}
		}
		
		int total = carLoanRateMapper.countByExample(example);
		PageModel<CarLoanRateVO> pageModel = new PageModel<>(total, reList);
		return pageModel;
	}


	/**
	 * 获取省份
	 */
	private void getProvinceTree(List<JsTreeViewDiy> jtvList) {
		SystemProvinceExample example = new SystemProvinceExample();
		SystemProvinceExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);

		List<SystemProvince> provinceList = systemProvinceService
				.selectByExample(example);
		if (null != provinceList && !provinceList.isEmpty()) {
			for (SystemProvince province : provinceList) {
				JsTreeViewDiy jsTreeViewDiy = new JsTreeViewDiy("p_"
						+ province.getId(), province.getName(), "",
						new JsTreeState(false, false, false), true);
				jtvList.add(jsTreeViewDiy);
			}
		}
	}

	@Override
	public ResponseVo saveOrUpdate(CarLoanRate loanRate) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = loanRate.getId();
		if (null == id) {// 添加
			loanRate.setCreatedDate(new Date());
			loanRate.setUpdatedDate(new Date());
			loanRate.setIsDel(Constants.NO_DEL);
			carLoanRateMapper.insertSelective(loanRate);
		}

		if (null != id) {// 修改
			loanRate.setUpdatedDate(new Date());
			carLoanRateMapper.updateByPrimaryKeySelective(loanRate);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				CarLoanRate loanRate = carLoanRateMapper.selectByPrimaryKey(new Long(id));
				loanRate.setUpdatedDate(new Date());
				loanRate.setIsDel(Constants.YES_DEL);
				carLoanRateMapper.updateByPrimaryKeySelective(loanRate);
			}
		}
		return result;
	}

	@Override
	public List<CarLoanRate> findByPid(Long pid) {
		CarLoanRateExample example = new CarLoanRateExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andPidEqualTo(pid);
		List<CarLoanRate> list = carLoanRateMapper.selectByExample(example);
		return list;
	}


}
