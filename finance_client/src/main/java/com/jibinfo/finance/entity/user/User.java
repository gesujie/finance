package com.jibinfo.finance.entity.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;

    private String mobile;

    private String wxOpenId;

    private String email;

    private String userName;

    private String password;

    private String cardNo;

    private String status;

    private String nickName;

    private String mobileValidated;

    private String emailValidated;

    private String wxIsFollowed;

    private String avatar;

    private String qrsceneId;

    private Date createdDate;

    private Date updatedDate;

    private String isDel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getMobileValidated() {
        return mobileValidated;
    }

    public void setMobileValidated(String mobileValidated) {
        this.mobileValidated = mobileValidated == null ? null : mobileValidated.trim();
    }

    public String getEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(String emailValidated) {
        this.emailValidated = emailValidated == null ? null : emailValidated.trim();
    }

    public String getWxIsFollowed() {
        return wxIsFollowed;
    }

    public void setWxIsFollowed(String wxIsFollowed) {
        this.wxIsFollowed = wxIsFollowed == null ? null : wxIsFollowed.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getQrsceneId() {
        return qrsceneId;
    }

    public void setQrsceneId(String qrsceneId) {
        this.qrsceneId = qrsceneId == null ? null : qrsceneId.trim();
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append(", wxOpenId=").append(wxOpenId);
        sb.append(", email=").append(email);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", status=").append(status);
        sb.append(", nickName=").append(nickName);
        sb.append(", mobileValidated=").append(mobileValidated);
        sb.append(", emailValidated=").append(emailValidated);
        sb.append(", wxIsFollowed=").append(wxIsFollowed);
        sb.append(", avatar=").append(avatar);
        sb.append(", qrsceneId=").append(qrsceneId);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}