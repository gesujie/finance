package com.jibinfo.finance.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2017/5/23.
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SurverysResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;// 生成的代金券

	private Double loanLimit;// 对应的贷款额度

}
