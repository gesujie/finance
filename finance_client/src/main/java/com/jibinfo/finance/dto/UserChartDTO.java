package com.jibinfo.finance.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2017/6/20.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserChartDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String date;

    private int count;
}
