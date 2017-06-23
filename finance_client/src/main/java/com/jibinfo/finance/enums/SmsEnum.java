package com.jibinfo.finance.enums;

/**
 * Created by admin on 2017/4/26.
 */
public enum SmsEnum {


    CLOSE("CLOSE","未设置短信网关"),//
    SUCCESS("SUCCESS","短信发送成功"),//
    EXCEPTION("EXCEPTION","短信发送异常"),
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


    SmsEnum(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }



}
