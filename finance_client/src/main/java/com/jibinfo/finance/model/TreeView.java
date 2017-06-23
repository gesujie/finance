package com.jibinfo.finance.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by admin on 2017/4/13.
 */
public class TreeView implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FOLDER = "folder";

	public static final String ITEM = "item";

	private String name;
	private String type;
	private int id;

	@JsonProperty("additionalParameters")
	private Additionalparameters additionalParameters;

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

	public Additionalparameters getAdditionalParameters() {
		return additionalParameters;
	}

	public void setAdditionalParameters(
			Additionalparameters additionalParameters) {
		this.additionalParameters = additionalParameters;
	}
}
