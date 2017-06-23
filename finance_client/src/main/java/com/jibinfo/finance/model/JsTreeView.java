package com.jibinfo.finance.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2017/4/13.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsTreeView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String text;

	private String icon;

	private JsTreeState state;

	private List<JsTreeView> children;

}
