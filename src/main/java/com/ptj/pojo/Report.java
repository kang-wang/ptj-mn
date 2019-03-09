package com.ptj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
    private Integer id;

    private Integer reportUserId;

    private Integer bereportUserId;

    private String reportContent;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date reportData;

    private Integer status;

    private String remark;

    private String result;

    public Report(Integer id, Integer reportUserId, Integer bereportUserId, String reportContent, Date reportData, Integer status, String remark, String result) {
        this.id = id;
        this.reportUserId = reportUserId;
        this.bereportUserId = bereportUserId;
        this.reportContent = reportContent;
        this.reportData = reportData;
        this.status = status;
        this.remark = remark;
        this.result = result;
    }

    public Report() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Integer reportUserId) {
        this.reportUserId = reportUserId;
    }

    public Integer getBereportUserId() {
        return bereportUserId;
    }

    public void setBereportUserId(Integer bereportUserId) {
        this.bereportUserId = bereportUserId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    public Date getReportData() {
        return reportData;
    }

    public void setReportData(Date reportData) {
        this.reportData = reportData;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}