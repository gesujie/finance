package com.jibinfo.finance.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/4/13.
 */
public class Additionalparameters implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Children> children;

	public void setChildren(List<Children> children) {
		this.children = children;
	}

	public List<Children> getChildren() {
		return children;
	}

}
