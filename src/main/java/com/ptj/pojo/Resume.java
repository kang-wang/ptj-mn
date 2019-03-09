package com.ptj.pojo;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer gender;

    private Integer age;

    private Integer height;

    private String address;

    private String school;

    private String intention;

    private String introduction;

    private String experience;

    private String telephone;

    private Double degree;

    private String headPhoto;

    private String remark;

    public Resume(Integer id, Integer userId, String userName, Integer gender, Integer age, Integer height, String address, String school, String intention, String introduction, String experience, String telephone, Double degree, String headPhoto, String remark) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.address = address;
        this.school = school;
        this.intention = intention;
        this.introduction = introduction;
        this.experience = experience;
        this.telephone = telephone;
        this.degree = degree;
        this.headPhoto = headPhoto;
        this.remark = remark;
    }

    public Resume() {
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention == null ? null : intention.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto == null ? null : headPhoto.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}