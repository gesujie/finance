package com.jibinfo.finance.enums;

/**
 * Created by admin on 2017/4/26.
 */
public enum EmailEnum {


    CLOSE("CLOSE","未设置邮件网关"),//
    SUCCESS("SUCCESS","邮件发送成功"),//
    EXCEPTION("EXCEPTION","邮件发送异常"),
    ;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String status;

    private String statusName;


    EmailEnum(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }



}
