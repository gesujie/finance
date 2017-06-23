package com.jibinfo.finance.entity.surveys;

import java.io.Serializable;
import java.util.Date;

public class SurverysData implements Serializable {
    private Long id;

    private Long parOptionId;

    private String code;

    private Integer score;

    private String url;

    private String dataType;

    private String optiondesc;

    private String optionname;

    private Integer optionno;

    private Integer orderno;

    private String sitemcode;

    private String action;

    private String isDel;

    private Date createdDate;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParOptionId() {
        return parOptionId;
    }

    public void setParOptionId(Long parOptionId) {
        this.parOptionId = parOptionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getOptiondesc() {
        return optiondesc;
    }

    public void setOptiondesc(String optiondesc) {
        this.optiondesc = optiondesc == null ? null : optiondesc.trim();
    }

    public String getOptionname() {
        return optionname;
    }

    public void setOptionname(String optionname) {
        this.optionname = optionname == null ? null : optionname.trim();
    }

    public Integer getOptionno() {
        return optionno;
    }

    public void setOptionno(Integer optionno) {
        this.optionno = optionno;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getSitemcode() {
        return sitemcode;
    }

    public void setSitemcode(String sitemcode) {
        this.sitemcode = sitemcode == null ? null : sitemcode.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parOptionId=").append(parOptionId);
        sb.append(", code=").append(code);
        sb.append(", score=").append(score);
        sb.append(", url=").append(url);
        sb.append(", dataType=").append(dataType);
        sb.append(", optiondesc=").append(optiondesc);
        sb.append(", optionname=").append(optionname);
        sb.append(", optionno=").append(optionno);
        sb.append(", orderno=").append(orderno);
        sb.append(", sitemcode=").append(sitemcode);
        sb.append(", action=").append(action);
        sb.append(", isDel=").append(isDel);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}