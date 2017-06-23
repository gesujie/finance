package com.jibinfo.finance.vo.car;

import java.io.Serializable;
import java.util.List;

import com.jibinfo.finance.entity.car.CarLoanRate;
import com.jibinfo.finance.entity.system.SystemDicDetail;

public class CarLoanRateVO extends CarLoanRate  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	List<SystemDicDetail> SystemDicDetail;

	
	public List<SystemDicDetail> getSystemDicDetail() {
		return SystemDicDetail;
	}

	public void setSystemDicDetail(List<SystemDicDetail> systemDicDetail) {
		SystemDicDetail = systemDicDetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CarLoanRateVo [name=" + name + "]";
	}
	
	

}
