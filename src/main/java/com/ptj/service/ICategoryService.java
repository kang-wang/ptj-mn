package com.ptj.service;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Category;


import java.util.List;

/**
 * @author wh
 * @create 2018-11-28 12:51
 **/
public interface ICategoryService {
    ServerResponse<String> addCategory(String category);

    ServerResponse<String> delCategory(String category);

    ServerResponse<List<Category>> findAllCategory();
}
