package com.jibinfo.finance.service.impl.system;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.finance.entity.system.SystemDicDetailExample.Criteria;
import com.jibinfo.finance.mapper.system.SystemDicDetailMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemDicDetailService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;


@Service("systemDicDetailService")
public class SystemDicDetailServiceImpl extends AbstractBaseServiceEx<SystemDicDetailExample, SystemDicDetail> implements SystemDicDetailService {
	@Resource
	private SystemDicDetailMapper systemDicDetailMapper;

	@Override
	public BaseMapper<SystemDicDetailExample, SystemDicDetail> getMapper() {
		return systemDicDetailMapper;
	}


	@Override
	public PageModel<SystemDicDetail> getData(Integer pageNo, Integer rows, SystemDicDetail model) {
		Paginator paginator = new Paginator().getPaginator(pageNo, rows);

		SystemDicDetailExample systemDicDetailExample = new SystemDicDetailExample();
		SystemDicDetailExample.Criteria criteria = systemDicDetailExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		systemDicDetailExample.setOrderByClause("ID DESC");
		if(null != model){
			if(StringUtils.isNotEmpty(model.getName())){
				criteria.andNameLike("%"+model.getName()+"%");
			}
			if(StringUtils.isNotEmpty(model.getCode())){
				criteria.andCodeLike("%"+model.getCode()+"%");
			}
			if(null != model.getDicId()){
				criteria.andDicIdEqualTo(model.getDicId());
			}
		}
		systemDicDetailExample.setPaginator(paginator);

		List<SystemDicDetail> systemDicDetails = systemDicDetailMapper.selectByExample(systemDicDetailExample);
		int count = systemDicDetailMapper.countByExample(systemDicDetailExample);
		PageModel<SystemDicDetail> pageModel = new PageModel<SystemDicDetail>(count, systemDicDetails);
		return pageModel;
	}

	@Override
	public ResponseVo delete(String ids) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			if(StringUtils.isNotEmpty(ids)){
                String[] split = ids.split(",");
                for (String s : split) {
                    SystemDicDetail systemDicDetail = systemDicDetailMapper.selectByPrimaryKey(new Long(s));
                    if (systemDicDetail != null) {
                        systemDicDetail.setIsDel(Constants.YES_DEL);
                        systemDicDetail.setUpdatedDate(new Date());
                        systemDicDetailMapper.updateByPrimaryKeySelective(systemDicDetail);
                    }
                }
            }
		} catch (NumberFormatException e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}
		return responseVo;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemDicDetail model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		Date date = new Date();
		try {
			model.setUpdatedDate(date);
			if(null == model.getId()){
                if(!this.checkCode(model)){
                    return new ResponseVo().failureResponse("存在重复CODE!");
                }
                model.setCreatedDate(date);
                model.setIsDel(Constants.NO_DEL);
                systemDicDetailMapper.insertSelective(model);
            }
            else{
                systemDicDetailMapper.updateByPrimaryKeySelective(model);
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}
		return responseVo;
	}

	/**
	 * 校验code重复性
	 * @param model
	 * @return   ture=不存在,false=存在
	 */
	private boolean checkCode(SystemDicDetail model){
		SystemDicDetailExample example = new SystemDicDetailExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)
				.andCodeEqualTo(model.getCode());
		List<SystemDicDetail> systemDicDetails = systemDicDetailMapper.selectByExample(example);
		if(null == systemDicDetails || systemDicDetails.size() == 0)
			return true;
		return false;
	}


	@Override
	public SystemDicDetail findByCode(String code) {
		SystemDicDetailExample ex = new SystemDicDetailExample();
		ex.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andCodeEqualTo(code);
		List<SystemDicDetail> systemDicDetail = systemDicDetailMapper.selectByExample(ex);
		if(null != systemDicDetail && systemDicDetail.size() > 0) {
			return systemDicDetail.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public List<SystemDicDetail> getGatewaySourceDicDetail(Long dicId) {
		SystemDicDetailExample example = new SystemDicDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		criteria.andDicIdEqualTo(dicId);
		return systemDicDetailMapper.selectByExample(example);
	}

}
