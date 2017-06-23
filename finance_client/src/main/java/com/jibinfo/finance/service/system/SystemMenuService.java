package com.jibinfo.finance.service.system;

import java.util.List;

import com.jibinfo.finance.entity.system.SystemMenu;
import com.jibinfo.finance.entity.system.SystemMenuExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.vo.system.MenuVO;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemMenuService extends
		BaseService<SystemMenuExample, SystemMenu> {

	/**
	 * 根据用户id查询菜单权限<br>
	 * 注：最多是三级菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<MenuVO> findMenuList(Long userId);

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            当前页数
	 * @param rows
	 *            每页天数
	 * @param model
	 *            查询条件
	 * @return
	 */
	PageModel<SystemMenu> getData(Integer pageNo, Integer rows, SystemMenu model);

	ResponseVo getMenu(Integer level);

	ResponseVo saveOrUpdate(SystemMenu model);

	ResponseVo delete(String ids);

	ResponseVo getTreeJson(Long userId);

	ResponseVo getChildMenuByPid(String menuId);

}
