package com.ptj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Authentication implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer authenticationType;

    private String photoOne;

    private String photoTwo;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date authenticationData;

    private String result;

    private Integer status;

    private String remark;

    public Authentication(Integer id, Integer userId, String userName, Integer authenticationType, String photoOne, String photoTwo, Date authenticationData, String result, Integer status, String remark) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.authenticationType = authenticationType;
        this.photoOne = photoOne;
        this.photoTwo = photoTwo;
        this.authenticationData = authenticationData;
        this.result = result;
        this.status = status;
        this.remark = remark;
    }

    public Authentication() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(Integer authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne == null ? null : photoOne.trim();
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo == null ? null : photoTwo.trim();
    }

    public Date getAuthenticationData() {
        return authenticationData;
    }

    public void setAuthenticationData(Date authenticationData) {
        this.authenticationData = authenticationData;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}