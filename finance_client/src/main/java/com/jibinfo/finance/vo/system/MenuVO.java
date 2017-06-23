package com.jibinfo.finance.vo.system;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单的VO
 * @author admin
 *
 */
public class MenuVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	
	private Long pid;
	
	
	private String name;
	
	
	private String baseUrl;
	
	
	private String moduleUrl;
	
	
	private Integer level;
	
	
	private String classIcon;
	
	
	private List<MenuVO> childMenu;
	
	private boolean hasChildren;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBaseUrl() {
		return baseUrl;
	}


	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}


	public String getModuleUrl() {
		return moduleUrl;
	}


	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	public String getClassIcon() {
		return classIcon;
	}


	public void setClassIcon(String classIcon) {
		this.classIcon = classIcon;
	}


	public List<MenuVO> getChildMenu() {
		return childMenu;
	}


	public void setChildMenu(List<MenuVO> childMenu) {
		this.childMenu = childMenu;
	}

	

	public boolean isHasChildren() {
		return childMenu == null || childMenu.size() == 0 ? false : true;
	}


	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}


	public MenuVO() {
		super();
	}


	@Override
	public String toString() {
		return "MenuVO [id=" + id + ", pid=" + pid + ", name=" + name
				+ ", baseUrl=" + baseUrl + ", moduleUrl=" + moduleUrl
				+ ", level=" + level + ", classIcon=" + classIcon
				+ ", childMenu=" + childMenu + ", hasChildren=" + hasChildren
				+ "]";
	}


	
	

}
