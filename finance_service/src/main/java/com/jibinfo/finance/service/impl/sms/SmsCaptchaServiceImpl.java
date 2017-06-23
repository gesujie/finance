package com.jibinfo.finance.service.impl.sms;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.sms.SmsCaptcha;
import com.jibinfo.finance.entity.sms.SmsCaptchaExample;
import com.jibinfo.finance.entity.sms.SmsCaptchaExample.Criteria;
import com.jibinfo.finance.mapper.sms.SmsCaptchaMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsCaptchaService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("smsCaptchaService")
public class SmsCaptchaServiceImpl extends
		AbstractBaseServiceEx<SmsCaptchaExample, SmsCaptcha> implements
		SmsCaptchaService {
	@Resource
	private SmsCaptchaMapper smsCaptchaMapper;
	
	@Override
	public BaseMapper<SmsCaptchaExample, SmsCaptcha> getMapper() {
		return smsCaptchaMapper;
	}

	@Override
	public PageModel<SmsCaptcha> getData(Integer pageNumber, Integer pageSize,
			SmsCaptcha captcha) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SmsCaptchaExample example = new SmsCaptchaExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");
		
		example.setPaginator(paginator);

		if (null != captcha) {
			if (StringUtils.isNotEmpty(captcha.getMobile())) {
				criteria.andMobileLike("%" + captcha.getMobile() + "%");
			}

			if (null != captcha.getStatus()
					&& !StringUtils.equalsIgnoreCase("-1", captcha.getStatus())) {
				criteria.andStatusEqualTo(captcha.getStatus());
			}
		}

		List<SmsCaptcha> captchas = smsCaptchaMapper.selectByExample(example);
		int total  = smsCaptchaMapper.countByExample(example);
		PageModel<SmsCaptcha> pageModel = new PageModel<>(total, captchas);
		return pageModel;
	}
}
