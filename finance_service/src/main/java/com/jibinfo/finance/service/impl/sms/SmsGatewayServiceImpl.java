package com.jibinfo.finance.service.impl.sms;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.sms.SmsGateway;
import com.jibinfo.finance.entity.sms.SmsGatewayExample;
import com.jibinfo.finance.entity.sms.SmsGatewayExample.Criteria;
import com.jibinfo.finance.mapper.sms.SmsGatewayMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsGatewayService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("smsGatewayService")
public class SmsGatewayServiceImpl extends
		AbstractBaseServiceEx<SmsGatewayExample, SmsGateway> implements
		SmsGatewayService {
	private static final String ONOFF_VALID = "0";

	private static final String ONOFF_INVALID = "1";

	@Resource
	private SmsGatewayMapper smsGatewayMapper;

	@Override
	public BaseMapper<SmsGatewayExample, SmsGateway> getMapper() {
		return smsGatewayMapper;
	}

	@Override
	public PageModel<SmsGateway> getData(Integer pageNumber, Integer pageSize,
			SmsGateway gateway) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SmsGatewayExample example = new SmsGatewayExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != gateway) {
			if (StringUtils.isNotEmpty(gateway.getAppKey())) {
				criteria.andAppKeyLike("%" + gateway.getAppKey() + "%");
			}

			if (StringUtils.isNotEmpty(gateway.getRequestUrl())) {
				criteria.andRequestUrlLike("%" + gateway.getRequestUrl() + "%");
			}

			if (null != gateway.getOnOff()
					&& !StringUtils.equalsIgnoreCase("-1", gateway.getOnOff())) {
				criteria.andOnOffEqualTo(gateway.getOnOff());
			}
		}

		List<SmsGateway> gateways = smsGatewayMapper.selectByExample(example);
		int total = smsGatewayMapper.countByExample(example);
		PageModel<SmsGateway> pageModel = new PageModel<>(total, gateways);
		return pageModel;
	}

	@Override
	public ResponseVo changeOnOff(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		SmsGateway gateway = smsGatewayMapper.selectByPrimaryKey(id);
		String onOff = gateway.getOnOff();
		if (ONOFF_VALID.equals(onOff)) {
			gateway.setOnOff(ONOFF_INVALID);
		}
		if (ONOFF_INVALID.equals(onOff)) {
			gateway.setOnOff(ONOFF_VALID);
		}

		smsGatewayMapper.updateByPrimaryKeySelective(gateway);

		return responseVo;
	}

	@Override
	public ResponseVo saveOrUpdate(SmsGateway gateway) {
		ResponseVo result = new ResponseVo().successResponse();
		Long id = gateway.getId();
		if (null == id) {// 添加
			gateway.setCreatedDate(new Date());
			gateway.setUpdatedDate(new Date());
			gateway.setIsDel(Constants.NO_DEL);
			smsGatewayMapper.insertSelective(gateway);
		}

		if (null != id) {// 修改
			gateway.setUpdatedDate(new Date());
			smsGatewayMapper.updateByPrimaryKeySelective(gateway);
		}
		return result;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] idArr = StringUtils.split(ids, ",");
		if (null != idArr && idArr.length > 0) {
			for (String id : idArr) {
				SmsGateway gateway = smsGatewayMapper
						.selectByPrimaryKey(new Long(id));
				gateway.setUpdatedDate(new Date());
				gateway.setIsDel(Constants.YES_DEL);
				smsGatewayMapper.updateByPrimaryKeySelective(gateway);
			}
		}
		return result;
	}

	@Override
	public SmsGateway getSmsGatewayBySourceCode(String scode) {
		SmsGatewayExample example = new SmsGatewayExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andSourceCodeEqualTo(scode);
		List<SmsGateway> smsGateways = smsGatewayMapper
				.selectByExample(example);
		if (smsGateways.size() > 0)
			return smsGateways.get(0);
		return null;
	}
}
