package com.jibinfo.finance.service.user;

import com.jibinfo.finance.entity.user.UserBlack;
import com.jibinfo.finance.entity.user.UserBlackExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface UserBlackService extends BaseService<UserBlackExample, UserBlack>{
	
	PageModel<UserBlack> getData(Integer pageNumber, Integer pageSize, UserBlack model);
	
	ResponseVo delBlack(String ids);

}
