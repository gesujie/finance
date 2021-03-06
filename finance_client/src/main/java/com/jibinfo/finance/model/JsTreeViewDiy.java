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
public class JsTreeViewDiy implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String text;

	private String icon;

	private JsTreeState state;

	private boolean children;
}
