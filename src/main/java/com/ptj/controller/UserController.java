package com.ptj.controller;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.User;
import com.ptj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author wh
 * @create 2018-11-25 19:31
 **/
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 根据账号名查询用户是否存在
     *
     * @param accountname
     * @return
     */
    @RequestMapping("findUserByAccountname.do")
    @ResponseBody
    public ServerResponse<String> findUserByAccountname(String accountname) {
        return iUserService.findUserByAccountname(accountname);
    }

    /**
     * 登录
     *
     * @param session
     * @param accountname
     * @param password
     * @return
     */
    @RequestMapping("login.do")
    @ResponseBody
    public ServerResponse<User> login(HttpSession session, String accountname, String password) {
        ServerResponse<User> serverResponseUser = iUserService.login(accountname, password);
        if (serverResponseUser.isSuccess()) {
            session.setAttribute("user", serverResponseUser.getData());
        }
        return serverResponseUser;
    }

    /**
     * 注册
     *
     * @param accountname
     * @param password
     * @return
     */
    @RequestMapping("register.do")
    @ResponseBody
    public ServerResponse<String> register(String accountname, String password, String verificationCode) {
        return iUserService.register(accountname, password, verificationCode);
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping("updatePassword.do")
    @ResponseBody
    public ServerResponse<String> updatePassword(Integer id, String oldPwd, String newPwd) {
        return iUserService.updatePassword(id, oldPwd, newPwd);
    }

    /**
     * 修改昵称和头像
     * @return
     */
    @RequestMapping("updateUser.do")
    @ResponseBody
    public ServerResponse<String> updateUser(Integer id,String remark,String role){
        return iUserService.updateUser(id,remark,role);
    }
}
