package com.jibinfo.finance.service.impl.system;

import com.jibinfo.finance.entity.system.SystemStaticPage;
import com.jibinfo.finance.entity.system.SystemStaticPageExample;
import com.jibinfo.finance.mapper.system.SystemStaticPageMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemStaticPageService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("systemStaticPageService")
public class SystemStaticPageServiceImpl extends
		AbstractBaseServiceEx<SystemStaticPageExample, SystemStaticPage> implements
		SystemStaticPageService {

	@Resource
	private SystemStaticPageMapper systemStaticPageMapper;

	@Override
	public BaseMapper<SystemStaticPageExample, SystemStaticPage> getMapper() {
		return systemStaticPageMapper;
	}


	@Override
	public PageModel<SystemStaticPage> getData(Integer pageNumber, Integer pageSize,SystemStaticPage model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);

		SystemStaticPageExample systemStaticPageExample = new SystemStaticPageExample();
		SystemStaticPageExample.Criteria criteria = systemStaticPageExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		systemStaticPageExample.setOrderByClause("ID DESC");
		if (model != null) {
			if(StringUtils.isNotEmpty(model.getName())){
				criteria.andNameLike("%"+model.getName()+"%");
			}
			if(null != model.getCreatedDate()){
				criteria.andCreatedDateGreaterThanOrEqualTo(model.getCreatedDate());
			}
			if(null != model.getUpdatedDate()){
				criteria.andCreatedDateLessThanOrEqualTo(model.getUpdatedDate());
			}
		}

		systemStaticPageExample.setPaginator(paginator);

		List<SystemStaticPage> systemStaticPages = systemStaticPageMapper.selectByExample(systemStaticPageExample);
		int count = systemStaticPageMapper.countByExample(systemStaticPageExample);

		PageModel<SystemStaticPage> pageModel = new PageModel<>(count, systemStaticPages);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemStaticPage model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		Date date = new Date();
		model.setUpdatedDate(date);
		try {
			if(null != model.getId()){
				systemStaticPageMapper.updateByPrimaryKeySelective(model);
            }
            else{
				model.setIsDel(Constants.NO_DEL);
				model.setCreatedDate(date);
                systemStaticPageMapper.insertSelective(model);
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}

		return responseVo;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		if(StringUtils.isNotEmpty(ids)){
			String[] strings = ids.split(",");
			for (String string : strings) {
				SystemStaticPage systemStaticPage = systemStaticPageMapper.selectByPrimaryKey(new Long(string));
				systemStaticPage.setIsDel(Constants.YES_DEL);
				systemStaticPageMapper.updateByPrimaryKeySelective(systemStaticPage);
			}
		}
		return responseVo;
	}
}
