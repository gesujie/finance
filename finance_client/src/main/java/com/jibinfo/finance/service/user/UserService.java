package com.jibinfo.finance.service.user;

import com.jibinfo.finance.entity.user.User;
import com.jibinfo.finance.entity.user.UserExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface UserService extends BaseService<UserExample, User> {

	PageModel<User> getData(User user, Integer pageNumber, Integer pageSize);

	ResponseVo enableDisable(String ids);

	ResponseVo changeState(Long id);
	
	ResponseVo setBlack(Long id, String remark);

	/**
	 * 查询用户的报表数据信息
	 * @return
	 */
	ResponseVo findByChart();
}
