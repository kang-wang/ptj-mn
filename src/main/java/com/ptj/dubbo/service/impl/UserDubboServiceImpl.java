package com.ptj.dubbo.service.impl;

import com.ptj.common.ServerResponse;
import com.ptj.dao.ResumeMapper;
import com.ptj.dao.UserMapper;
import com.ptj.dubbo.service.IUserDubboService;

import com.ptj.pojo.Resume;
import com.ptj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wh
 * @create 2018-11-25 19:28
 **/
@Service
public class UserDubboServiceImpl implements IUserDubboService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public ServerResponse<User> login(String accountname, String password) {
        User user = userMapper.findUserByNameAndPw(accountname, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("登录失败，用户账号或者密码错误");
        }
        if (user.getStatus() == 1) {
            return ServerResponse.createByErrorMessage("此账号存在异常！");
        }
        user.setPassword("");
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public User findUserByAccountname(String accountname) {
        return userMapper.findUserByAccountname(accountname);
    }

    @Override
    public ServerResponse<String> addUser(User user) {
        int count = 0;
        try {
            System.out.println("user:"+user);
            count += userMapper.insert(user);
            System.out.println("count ="+count);
            User userByNameAndPw = userMapper.findUserByNameAndPw(user.getAccountname(), user.getPassword());
            System.out.println("查出来的user"+userByNameAndPw);
            Resume resume = new Resume();
            resume.setUserId(userByNameAndPw.getId());
            count += resumeMapper.insertSelective(resume);
        }catch (Exception e){
            System.out.println("注册有问题！");
            e.printStackTrace();
        }

        if (count == 2 ) {
            return ServerResponse.createBySuccessMessage("注册成功");
        }else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("回滚！");
                e.printStackTrace();
            }
        }
        return ServerResponse.createByErrorMessage("回滚");

    }

    @Override
    public User findUserByKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateByKey(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
