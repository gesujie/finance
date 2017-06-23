package com.jibinfo.finance.service.impl.sms;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jibinfo.finance.entity.sms.SmsContent;
import com.jibinfo.finance.entity.sms.SmsContentExample;
import com.jibinfo.finance.entity.sms.SmsContentExample.Criteria;
import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.entity.sms.SmsTemplateExample;
import com.jibinfo.finance.mapper.sms.SmsContentMapper;
import com.jibinfo.finance.mapper.sms.SmsTemplateMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.sms.SmsContentService;
import com.jibinfo.finance.vo.sms.SmsVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("smsContentService")
public class SmsContentServiceImpl extends
		AbstractBaseServiceEx<SmsContentExample, SmsContent> implements
		SmsContentService {
	private static final Integer INTI_AGAIN_COUNTS = 0;

	@Resource
	private SmsContentMapper smsContentMapper;

	@Resource
	private SmsTemplateMapper smsTemplateMapper;

	@Override
	public BaseMapper<SmsContentExample, SmsContent> getMapper() {
		return smsContentMapper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<SmsContent> getData(Integer pageNumber, Integer pageSize,
			SmsContent content) {
		Paginator paginator = new Paginator()
				.getPaginator(pageNumber, pageSize);

		SmsContentExample example = new SmsContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		example.setPaginator(paginator);

		if (null != content) {
			if (null != content.getType()
					&& !StringUtils.equalsIgnoreCase("-1", content.getType())) {
				criteria.andTypeEqualTo(content.getType());
			}

			if (StringUtils.isNotEmpty(content.getContent())) {
				criteria.andContentLike("%" + content.getContent() + "%");
			}

			if (StringUtils.isNotEmpty(content.getMobile())) {
				criteria.andMobileLike("%" + content.getMobile() + "%");
			}

			if (null != content.getStatus()
					&& !StringUtils.equalsIgnoreCase("-1", content.getStatus())) {
				criteria.andStatusEqualTo(content.getStatus());
			}

			if (StringUtils.isNotEmpty(content.getResultCode())) {
				criteria.andResultCodeLike("%" + content.getResultCode() + "%");
			}
		}

		List<SmsContent> contents = smsContentMapper.selectByExample(example);
		if (null != contents && !contents.isEmpty()) {
			for (SmsContent smsContent : contents) {
				String ct = "";
				// 获取模板内容
				SmsTemplate template = this.getSmsTemplate(smsContent
						.getTcode());
				if (null != template) {
					// 将短信内容的json格式转为为map替换短信模板的占位符
					Map<String, String> map = (Map<String, String>) JSON
							.parse(smsContent.getContent());
					ct = SmsVO.composeMessage(template.getContent(), map);
				}
				smsContent.setContent(ct);
			}
		}

		int total = smsContentMapper.countByExample(example);
		PageModel<SmsContent> pageModel = new PageModel<>(total, contents);
		return pageModel;
	}

	@Override
	public void saveSmsContent(Long gid, String template, String type,
			String params, String status, String code, String msg,
			String... mobiles) {
		String mobile = StringUtils.join(mobiles, ",");
		SmsContent content = new SmsContent();
		Date date = new Date();
		content.setGid(gid);
		content.setTcode(template);
		content.setMobile(mobile);
		content.setUpdatedDate(date);
		content.setCreatedDate(date);
		content.setType(type);
		content.setContent(params);
		content.setStatus(status);
		content.setResultCode(code);
		content.setResultMsg(msg);
		content.setAgainCounts(INTI_AGAIN_COUNTS);
		content.setIsDel(Constants.NO_DEL);
		smsContentMapper.insertSelective(content);

	}

	/**
	 * 根据code获取短信模板
	 */
	private SmsTemplate getSmsTemplate(String code) {
		SmsTemplateExample ex = new SmsTemplateExample();
		SmsTemplateExample.Criteria cta = ex.createCriteria();
		cta.andIsDelEqualTo(Constants.NO_DEL);
		cta.andCodeEqualTo(code);
		List<SmsTemplate> list = smsTemplateMapper.selectByExample(ex);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
