package com.jibinfo.finance.service.impl.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.user.User;
import com.jibinfo.finance.entity.user.UserBlack;
import com.jibinfo.finance.entity.user.UserBlackExample;
import com.jibinfo.finance.entity.user.UserBlackExample.Criteria;
import com.jibinfo.finance.mapper.user.UserBlackMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.user.UserBlackService;
import com.jibinfo.finance.service.user.UserService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

@Service("userBlackService")
public class UserBlackServiceImpl extends AbstractBaseServiceEx<UserBlackExample, UserBlack> implements UserBlackService{

	@Resource
	private UserBlackMapper userBlackMapper;
	
	@Override
	public BaseMapper<UserBlackExample, UserBlack> getMapper() {
		return userBlackMapper;
	}
	
	@Resource
	private UserService userService;
	
	@Override
	public PageModel<UserBlack> getData(Integer pageNumber, Integer pageSize,
			UserBlack model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		UserBlackExample example = new UserBlackExample();
		Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		if(null != model && model.getUserId() != null) {
			if(StringUtils.isNotEmpty(model.getUserId().toString())){
				criteria.andUserIdEqualTo(model.getUserId());
			}
		}
		example.setPaginator(paginator);
		example.setOrderByClause("ID DESC");
		List<UserBlack> list = userBlackMapper.selectByExample(example);
		int count = userBlackMapper.countByExample(example);
		PageModel<UserBlack> pageModel = new PageModel<UserBlack>(count,list);
		return pageModel;
	}

	@Override
	public ResponseVo delBlack(String ids) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			if(StringUtils.isNotEmpty(ids)){
                String[] strings = ids.split(",");
                for (String string : strings) {
					this.updateDel(new Long(string));
					UserBlack userBlack = userBlackMapper.selectByPrimaryKey(new Long(string));
					Long userId = userBlack.getUserId();
					this.updateStatus(userId);
					
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}


		return responseVo;
	}
	
	/**
	 * 修改isdel
	 * @param id
	 */
	private void updateDel(Long id){
		UserBlack userBlack = userBlackMapper.selectByPrimaryKey(id);
		userBlack.setUpdatedDate(new Date());
		if(Constants.NO_DEL.equals(userBlack.getIsDel())){
			userBlack.setIsDel(Constants.YES_DEL);
		}
		userBlackMapper.updateByPrimaryKeySelective(userBlack);
	}
	
	/**
	 * 修改状态
	 * @param id
	 */
	private void updateStatus(Long id){
		User user = userService.selectByPrimaryKey(id);
		user.setUpdatedDate(new Date());
		if(Constants.ENABLE.equals(user.getStatus())){
			user.setStatus(Constants.DISABLE);
		}
		else{
			user.setStatus(Constants.ENABLE);
		}
		userService.updateByPrimaryKeySelective(user);
	}

	

}
