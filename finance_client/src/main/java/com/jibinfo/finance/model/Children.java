/**
 * Copyright 2017 bejson.com 
 */
package com.jibinfo.finance.model;

import java.io.Serializable;

/**
 */
public class Children implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FOLDER = "folder";

	public static final String ITEM = "item";

	private String name;

	private String type;

	private int id;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}