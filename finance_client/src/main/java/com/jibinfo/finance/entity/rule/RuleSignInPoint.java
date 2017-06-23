package com.jibinfo.finance.entity.rule;

import java.io.Serializable;
import java.math.BigDecimal;

public class RuleSignInPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean dayReward;

	private boolean contReward;

	private int continueDays;

	private boolean cumuReward;

	private int cumulateDays;

	private BigDecimal dayPoint;

	private BigDecimal contPoint;

	private BigDecimal cumuPoint;

	private BigDecimal rewardPoint;

	public RuleSignInPoint() {
		super();
	}

	public RuleSignInPoint(boolean dayReward, boolean contReward,
			int continueDays, boolean cumuReward, int cumulateDays,
			BigDecimal dayPoint, BigDecimal contPoint, BigDecimal cumuPoint,
			BigDecimal rewardPoint) {
		super();
		this.dayReward = dayReward;
		this.contReward = contReward;
		this.continueDays = continueDays;
		this.cumuReward = cumuReward;
		this.cumulateDays = cumulateDays;
		this.dayPoint = dayPoint;
		this.contPoint = contPoint;
		this.cumuPoint = cumuPoint;
		this.rewardPoint = rewardPoint;
	}

	public boolean isDayReward() {
		return dayReward;
	}

	public void setDayReward(boolean dayReward) {
		this.dayReward = dayReward;
	}

	public boolean isContReward() {
		return contReward;
	}

	public void setContReward(boolean contReward) {
		this.contReward = contReward;
	}

	public int getContinueDays() {
		return continueDays;
	}

	public void setContinueDays(int continueDays) {
		this.continueDays = continueDays;
	}

	public boolean isCumuReward() {
		return cumuReward;
	}

	public void setCumuReward(boolean cumuReward) {
		this.cumuReward = cumuReward;
	}

	public int getCumulateDays() {
		return cumulateDays;
	}

	public void setCumulateDays(int cumulateDays) {
		this.cumulateDays = cumulateDays;
	}

	public BigDecimal getDayPoint() {
		return dayPoint;
	}

	public void setDayPoint(BigDecimal dayPoint) {
		this.dayPoint = dayPoint;
	}

	public BigDecimal getContPoint() {
		return contPoint;
	}

	public void setContPoint(BigDecimal contPoint) {
		this.contPoint = contPoint;
	}

	public BigDecimal getCumuPoint() {
		return cumuPoint;
	}

	public void setCumuPoint(BigDecimal cumuPoint) {
		this.cumuPoint = cumuPoint;
	}

	public BigDecimal getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(BigDecimal rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RuleSignInPoint [dayReward=");
		builder.append(dayReward);
		builder.append(", contReward=");
		builder.append(contReward);
		builder.append(", continueDays=");
		builder.append(continueDays);
		builder.append(", cumuReward=");
		builder.append(cumuReward);
		builder.append(", cumulateDays=");
		builder.append(cumulateDays);
		builder.append(", dayPoint=");
		builder.append(dayPoint);
		builder.append(", contPoint=");
		builder.append(contPoint);
		builder.append(", cumuPoint=");
		builder.append(cumuPoint);
		builder.append(", rewardPoint=");
		builder.append(rewardPoint);
		builder.append("]");
		return builder.toString();
	}

}
