package com.ptj.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Authentication;


/**
 * @author wh
 * @create 2018-11-25 19:34
 **/
public interface IAuthenticationService {
    ServerResponse<String> addAuthentication(Authentication authentication);

    ServerResponse<String> delAuthentication(Integer id);

    ServerResponse<String> handleAuthentication(Integer id, Integer userId, Integer authenticationType, String result, Integer status);

    ServerResponse<PageInfo<Authentication>> findAllAuthentication(int pageNum, int pageSize);

    ServerResponse<PageInfo<Authentication>> findAllAuthenticationByUserId(Integer userId, int pageNum, int pageSize);
}
