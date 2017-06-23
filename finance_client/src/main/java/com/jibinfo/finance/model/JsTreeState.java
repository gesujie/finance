package com.jibinfo.finance.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2017/4/17.
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsTreeState implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean opened;

	private boolean selected;

	private boolean disabled;

}
