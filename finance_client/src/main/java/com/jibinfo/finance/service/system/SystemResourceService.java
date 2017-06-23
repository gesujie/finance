package com.jibinfo.finance.service.system;

import java.util.List;

import com.jibinfo.finance.entity.system.SystemResource;
import com.jibinfo.finance.entity.system.SystemResourceExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemResourceService extends
		BaseService<SystemResourceExample, SystemResource> {
	PageModel<SystemResource> getData(Integer pageNumber, Integer pageSize,
			SystemResource model);

	ResponseVo saveOrUpdate(SystemResource resource, String menuId);

	ResponseVo delete(String ids);

	List<Long> getChildMenuIdByPid(Long menuId);
}
