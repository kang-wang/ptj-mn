package com.ptj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Job implements java.io.Serializable {
    private Integer id;

    private Integer userId;

    private String jobTitle;

    private String jobDescribe;

    private String jobCategory;

    private Double jobSalary;

    private String jobSalaryUnit;

    private Integer jobCount;

    private String workingHours;

    private String workingDays;

    private String contact;

    private String telephone;

    private Integer isAuthentication;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date releaseDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//接受前台的时间格式 传到后台的格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//作用：后台的时间 格式化 发送到前台
    private Date closingDate;

    private String issuePlace;

    private Integer status;

    private String remark;

    public Job(Integer id, Integer userId, String jobTitle, String jobDescribe, String jobCategory, Double jobSalary, String jobSalaryUnit, Integer jobCount, String workingHours, String workingDays, String contact, String telephone, Integer isAuthentication, Date releaseDate, Date closingDate, String issuePlace, Integer status, String remark) {
        this.id = id;
        this.userId = userId;
        this.jobTitle = jobTitle;
        this.jobDescribe = jobDescribe;
        this.jobCategory = jobCategory;
        this.jobSalary = jobSalary;
        this.jobSalaryUnit = jobSalaryUnit;
        this.jobCount = jobCount;
        this.workingHours = workingHours;
        this.workingDays = workingDays;
        this.contact = contact;
        this.telephone = telephone;
        this.isAuthentication = isAuthentication;
        this.releaseDate = releaseDate;
        this.closingDate = closingDate;
        this.issuePlace = issuePlace;
        this.status = status;
        this.remark = remark;
    }

    public Job() {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe == null ? null : jobDescribe.trim();
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory == null ? null : jobCategory.trim();
    }

    public Double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(Double jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobSalaryUnit() {
        return jobSalaryUnit;
    }

    public void setJobSalaryUnit(String jobSalaryUnit) {
        this.jobSalaryUnit = jobSalaryUnit == null ? null : jobSalaryUnit.trim();
    }

    public Integer getJobCount() {
        return jobCount;
    }

    public void setJobCount(Integer jobCount) {
        this.jobCount = jobCount;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours == null ? null : workingHours.trim();
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays == null ? null : workingDays.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace == null ? null : issuePlace.trim();
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