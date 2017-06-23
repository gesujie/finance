package com.jibinfo.finance.service.impl.system;


import com.jibinfo.finance.entity.system.SystemDic;
import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.finance.entity.system.SystemDicExample;
import com.jibinfo.finance.mapper.system.SystemDicDetailMapper;
import com.jibinfo.finance.mapper.system.SystemDicMapper;
import com.jibinfo.finance.model.JsTreeState;
import com.jibinfo.finance.model.JsTreeView;
import com.jibinfo.finance.service.system.SystemDicService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("systemDicService")
public class SystemDicServiceImpl extends AbstractBaseServiceEx<SystemDicExample, SystemDic> implements SystemDicService {
	

	@Resource
	private SystemDicMapper systemDicMapper;

	@Resource
	private SystemDicDetailMapper systemDicDetailMapper;

	@Override
	public BaseMapper<SystemDicExample, SystemDic> getMapper() {
		return systemDicMapper;
	}


	@Override
	public ResponseVo getTreeJson() {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			SystemDicExample example = new SystemDicExample();
			example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
			List<SystemDic> list = systemDicMapper.selectByExample(example);
			List<JsTreeView> jtvList = new ArrayList<>();
			JsTreeView jsTreeView = new JsTreeView();
			jsTreeView.setId("-1");
			jsTreeView.setText("字典树形");
			jsTreeView.setState(new JsTreeState(true,false,false));
			List<JsTreeView> children = new ArrayList<>();

			jtvList.add(new JsTreeView());
			if(null != list && list.size() > 0){
				for (SystemDic child : list) {
					JsTreeView jtvc = new JsTreeView();
					jtvc.setId(child.getId()+"");
					jtvc.setState(new JsTreeState(false,false,false));
					jtvc.setText(child.getName().length() > 20 ? child.getName().substring(0,20)+"..." : child.getName());
					children.add(jtvc);
				}
			}
			jsTreeView.setChildren(children);
			responseVo.setBody(jsTreeView);
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}

		return responseVo;
	}

	@Override
	public ResponseVo delete(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			SystemDic systemDic = systemDicMapper.selectByPrimaryKey(id);
			if (systemDic != null) {
                systemDic.setIsDel(Constants.YES_DEL);
                systemDic.setUpdatedDate(new Date());
                systemDicMapper.updateByPrimaryKeySelective(systemDic);


				SystemDicDetailExample sddExample = new SystemDicDetailExample();
				sddExample.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andDicIdEqualTo(id);
				SystemDicDetail systemDicDetail = new SystemDicDetail();
				systemDicDetail.setUpdatedDate(new Date());
				systemDicDetail.setIsDel(Constants.YES_DEL);
				systemDicDetailMapper.updateByExampleSelective(systemDicDetail,sddExample);

			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}


		return responseVo;
	}

	@Override
	public String findMaxCode() {
		String prefix = "D";
		Long maxId = systemDicMapper.findMaxId();
		if(null == maxId){
			maxId = 0L;

		}
		String maxIdStr = maxId.toString();
		if(maxIdStr.length() >= 6){
			prefix = prefix + maxIdStr;
		}
		else{
			int len = 6 - maxIdStr.length();
			for (int i = 0 ; i < len ; i++){
				maxIdStr = "0"+maxIdStr;
			}
			prefix = prefix + maxIdStr;
		}
		return prefix;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemDic model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		Date date = new Date();
		try {
			model.setUpdatedDate(date);
			if(null == model.getId()){
                model.setCreatedDate(date);
                model.setIsDel(Constants.NO_DEL);
                systemDicMapper.insertSelective(model);
            }
            else{
                systemDicMapper.updateByPrimaryKeySelective(model);
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}


		return responseVo;
	}
}
