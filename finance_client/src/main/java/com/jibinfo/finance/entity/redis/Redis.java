package com.jibinfo.finance.entity.redis;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Redis implements Serializable {
	private static final long serialVersionUID = 1L;

	private String key;

	private String value;
}
