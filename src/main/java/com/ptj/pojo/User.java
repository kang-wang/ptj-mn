package com.ptj.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String accountname;

    private String password;

    private String role;

    private Integer isAuthentication;

    private Integer status;

    private String remark;

    public User(Integer id, String accountname, String password, String role, Integer isAuthentication, Integer status, String remark) {
        this.id = id;
        this.accountname = accountname;
        this.password = password;
        this.role = role;
        this.isAuthentication = isAuthentication;
        this.status = status;
        this.remark = remark;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
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