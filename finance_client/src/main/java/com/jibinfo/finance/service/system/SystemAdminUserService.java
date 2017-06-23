package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemAdminUser;
import com.jibinfo.finance.entity.system.SystemAdminUserExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemAdminUserService extends BaseService<SystemAdminUserExample, SystemAdminUser> {

	ResponseVo login(String userName, String password,String session);
	
	void logout(String session);


	PageModel<SystemAdminUser> getData(Integer pageNumber, Integer pageSize, SystemAdminUser model);

	ResponseVo saveOrUpdate(SystemAdminUser model);

	ResponseVo delete(String ids);

    ResponseVo changeState(Long id);

    ResponseVo getUserInfo(Long id);

	ResponseVo resetPwd(String ids);

    ResponseVo updatePwd(Long id,String oldPwd,String newPwd);
}
