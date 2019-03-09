package com.ptj.controller;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Category;

import com.ptj.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wh
 * @create 2018-11-28 12:51
 **/
@Controller
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 添加新的分类
     * @param category
     * @return
     */
    @RequestMapping("addCategory.do")
    @ResponseBody
    public ServerResponse<String> addCategory(String category){
        return iCategoryService.addCategory(category);
    }

    /**
     * 删除此分类
     * @param category
     * @return
     */
    @RequestMapping("delCategory.do")
    @ResponseBody
    public ServerResponse<String> delCategory(String category){
        return iCategoryService.delCategory(category);
    }

    /**
     * 查找所有的分类
     * @return
     */
    @RequestMapping("findAllCategory.do")
    @ResponseBody
    public ServerResponse<List<Category>> findAllCategory(){
        return iCategoryService.findAllCategory();
    }
}
