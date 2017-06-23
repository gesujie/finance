package com.jibinfo.finance.entity.car;

import java.io.Serializable;
import java.util.Date;

public class CarModel implements Serializable {
	private Long id;

	private Long sid;

	private String modelName;

	private String modelPrice;

	private String modelYear;

	private String liter;

	private String gearType;

	private String dischargeStandard;

	private String seatNumber;

	private String shortName;

	private String minGreYear;

	private String maxGerYear;

	private String pictureUrl;

	private String isDel;

	private Date createdDate;

	private Date updatedDate;

	private String bid;

	private String seriesId;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName == null ? null : modelName.trim();
	}

	public String getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(String modelPrice) {
		this.modelPrice = modelPrice == null ? null : modelPrice.trim();
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear == null ? null : modelYear.trim();
	}

	public String getLiter() {
		return liter;
	}

	public void setLiter(String liter) {
		this.liter = liter == null ? null : liter.trim();
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType == null ? null : gearType.trim();
	}

	public String getDischargeStandard() {
		return dischargeStandard;
	}

	public void setDischargeStandard(String dischargeStandard) {
		this.dischargeStandard = dischargeStandard == null ? null
				: dischargeStandard.trim();
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber == null ? null : seatNumber.trim();
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName == null ? null : shortName.trim();
	}

	public String getMinGreYear() {
		return minGreYear;
	}

	public void setMinGreYear(String minGreYear) {
		this.minGreYear = minGreYear == null ? null : minGreYear.trim();
	}

	public String getMaxGerYear() {
		return maxGerYear;
	}

	public void setMaxGerYear(String maxGerYear) {
		this.maxGerYear = maxGerYear == null ? null : maxGerYear.trim();
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel == null ? null : isDel.trim();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarModel [id=");
		builder.append(id);
		builder.append(", sid=");
		builder.append(sid);
		builder.append(", modelName=");
		builder.append(modelName);
		builder.append(", modelPrice=");
		builder.append(modelPrice);
		builder.append(", modelYear=");
		builder.append(modelYear);
		builder.append(", liter=");
		builder.append(liter);
		builder.append(", gearType=");
		builder.append(gearType);
		builder.append(", dischargeStandard=");
		builder.append(dischargeStandard);
		builder.append(", seatNumber=");
		builder.append(seatNumber);
		builder.append(", shortName=");
		builder.append(shortName);
		builder.append(", minGreYear=");
		builder.append(minGreYear);
		builder.append(", maxGerYear=");
		builder.append(maxGerYear);
		builder.append(", pictureUrl=");
		builder.append(pictureUrl);
		builder.append(", isDel=");
		builder.append(isDel);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", bid=");
		builder.append(bid);
		builder.append(", seriesId=");
		builder.append(seriesId);
		builder.append("]");
		return builder.toString();
	}

}