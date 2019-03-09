package com.ptj.dubbo.service.impl;

import com.ptj.dao.CategoryMapper;
import com.ptj.dubbo.service.ICategoryDubboService;

import com.ptj.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-28 12:53
 **/
@Service
public class CategoryDubboServiceImpl implements ICategoryDubboService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public Category findCategoryByName(String category) {
        return categoryMapper.findCategoryByName(category);
    }

    @Override
    public int addCategory(Category c1) {
        return categoryMapper.insert(c1);
    }

    @Override
    public int delCategory(String category) {
        return categoryMapper.delByName(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
