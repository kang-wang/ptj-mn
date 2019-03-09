package com.ptj.service;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.User;

/**
 * @author wh
 * @create 2018-11-25 19:33
 **/
public interface IUserService {
    ServerResponse<User> login(String accountname, String password);

    ServerResponse<String> findUserByAccountname(String accountname);

    ServerResponse<String> register(String accountname, String password, String verificationCode);

    ServerResponse<String> updatePassword(Integer id, String oldPwd, String newPwd);

    ServerResponse<String> updateUser(Integer id, String remark, String role);
}
