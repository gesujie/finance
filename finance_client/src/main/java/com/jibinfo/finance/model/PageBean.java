package com.jibinfo.finance.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int curPage; // 当前页

	private int pageCount; // 总页数

	private int rowsCount; // 总行数

	private int pageSize = 20; // 每页多少行

	public PageBean(int rows) {
		this.setRowsCount(rows);
		if (this.rowsCount % this.pageSize == 0) {
			this.pageCount = this.rowsCount / this.pageSize;
		} else if (rows < this.pageSize) {
			this.pageCount = 1;
		} else {
			this.pageCount = this.rowsCount / this.pageSize + 1;
		}
	}
}
