package com.ptj.dubbo.service;

import com.ptj.pojo.Category;

import java.util.List;

/**
 * @author wh
 * @create 2018-11-28 12:53
 **/
public interface ICategoryDubboService {
    Category findCategoryByName(String category);

    int addCategory(Category c1);

    int delCategory(String category);

    List<Category> findAllCategory();
}
