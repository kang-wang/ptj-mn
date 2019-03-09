package com.ptj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Footprint implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer jobId;

    private String jobTitle;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date viewingData;

    private Integer status;

    private String remark;

    public Footprint(Integer id, Integer userId, Integer jobId, String jobTitle, Date viewingData, Integer status, String remark) {
        this.id = id;
        this.userId = userId;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.viewingData = viewingData;
        this.status = status;
        this.remark = remark;
    }

    public Footprint() {
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

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public Date getViewingData() {
        return viewingData;
    }

    public void setViewingData(Date viewingData) {
        this.viewingData = viewingData;
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