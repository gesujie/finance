package com.jibinfo.finance.enums;

/**
 * Created by admin on 2017/4/26.
 */
public enum QuartzEnum {

    /**
     * NONE = 未知  ,
     * NORMAL = 正常无任务，用这个判断Job是否在运行 ,
     * PAUSED = 暂停状态 ,
     * COMPLETE =完成那一刻，不过一般不用这个判断Job状态 ,
     * ERROR =错误 ,
     * BLOCKED=运行
     * @return
     */
    INIT("INIT","未加进任务列表"),//自定义状态判断列表是否已经添加到任务列表中
    END("END","移除任务列表"),//同上，判断任务列表是否从任务列表中移除
    NONE("NONE","未知"),
    NORMAL("NORMAL","正常无任务"),
    PAUSED("PAUSED","暂停状态"),
    COMPLETE("COMPLETE","完成"),
    ERROR("ERROR","错误"),
    BLOCKED("BLOCKED","运行");


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


    QuartzEnum(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }



}
