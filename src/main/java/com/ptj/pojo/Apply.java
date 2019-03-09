package com.ptj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Apply implements Serializable {
    private Integer id;

    private Integer jobId;

    private Integer applyUserId;

    private String applyInformation;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date applyData;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date handleData;

    private Integer handleStatus;

    private String remark;

    public Apply(Integer id, Integer jobId, Integer applyUserId, String applyInformation, Date applyData, Date handleData, Integer handleStatus, String remark) {
        this.id = id;
        this.jobId = jobId;
        this.applyUserId = applyUserId;
        this.applyInformation = applyInformation;
        this.applyData = applyData;
        this.handleData = handleData;
        this.handleStatus = handleStatus;
        this.remark = remark;
    }

    public Apply() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyInformation() {
        return applyInformation;
    }

    public void setApplyInformation(String applyInformation) {
        this.applyInformation = applyInformation == null ? null : applyInformation.trim();
    }

    public Date getApplyData() {
        return applyData;
    }

    public void setApplyData(Date applyData) {
        this.applyData = applyData;
    }

    public Date getHandleData() {
        return handleData;
    }

    public void setHandleData(Date handleData) {
        this.handleData = handleData;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}