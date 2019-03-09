package com.ptj.pojo;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;

    private String category;

    public Category(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}