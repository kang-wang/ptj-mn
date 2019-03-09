package com.ptj.dubbo.service;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.User;


/**
 * @author wh
 * @create 2018-11-25 19:25
 **/
public interface IUserDubboService {
    ServerResponse<User> login(String accountname, String password);

    User findUserByAccountname(String accountname);

    ServerResponse<String> addUser(User user);

    User findUserByKey(Integer id);

    int updatePassword(User user);

    int updateByKey(User user);
}
