package com.ptj.dubbo.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Authentication;


/**
 * @author wh
 * @create 2018-11-25 19:22
 **/
public interface IAuthenticationDubboService {
    int addAuthentication(Authentication authentication);

    Authentication findByIdAndType(Integer userId, Integer authenticationType);

    int delAuthentication(Integer id);

    Authentication findByKey(Integer id);

    int updateAuthentication(Authentication authentication);

    ServerResponse<PageInfo<Authentication>> findAll(int pageNum, int pageSize);

    ServerResponse<PageInfo<Authentication>> findAllByUserId(Integer userId, int pageNum, int pageSize);
}
