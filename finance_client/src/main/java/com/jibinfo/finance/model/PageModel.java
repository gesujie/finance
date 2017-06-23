package com.jibinfo.finance.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer total;

	private List<T> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageModel() {
	}

	public PageModel(Integer total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

}
