package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.ICategoryDubboService;
import com.ptj.pojo.Category;

import com.ptj.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wh
 * @create 2018-11-28 12:52
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDubboService iCategoryDubboService;
    @Override
    public ServerResponse<String> addCategory(String category) {
        Category c  = iCategoryDubboService.findCategoryByName(category);
        if (c !=null){
            return ServerResponse.createByErrorMessage("此分类已经存在");
        }
        Category c1 = new Category();
        c1.setCategory(category);
        int count = iCategoryDubboService.addCategory(c1);
        if (count == 0 ){
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> delCategory(String category) {
        int count = iCategoryDubboService.delCategory(category);
        if (count == 0 ){
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<List<Category>> findAllCategory() {
        List<Category> categoryList = iCategoryDubboService.findAllCategory();
        return ServerResponse.createBySuccess(categoryList);
    }

}
