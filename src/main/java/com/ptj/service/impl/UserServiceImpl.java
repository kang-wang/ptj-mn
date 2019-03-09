package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IUserDubboService;
import com.ptj.pojo.User;

import com.ptj.redis.JedisDao;
import com.ptj.service.IUserService;
import com.ptj.util.AliMsgUtil;
import com.ptj.util.NameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wh
 * @create 2018-11-25 19:36
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDubboService iUserDubboService;
    @Resource
    private JedisDao jedisDao;

    /**
     * 登录
     * @param accountname
     * @param password
     * @return
     */
    @Override
    public ServerResponse<User> login(String accountname, String password) {
        return iUserDubboService.login(accountname, password);
    }

    /**
     * 判断次账号是否存在，如果不存在发送短信
     * @param accountname
     * @return
     */
    @Override
    public ServerResponse<String> findUserByAccountname(String accountname) {
        User user = iUserDubboService.findUserByAccountname(accountname);
        if (user != null) {
            return ServerResponse.createByErrorMessage("账号已经存在");
        }
        String randomVcode = AliMsgUtil.createRandomVcode();

        SendSmsResponse sms = null;
        try {
            //发短信
            sms = AliMsgUtil.sendSms(randomVcode, accountname);
            //存入redis
            jedisDao.setHasTime(accountname, randomVcode, 100000L);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if (!"OK".equals(sms.getCode())) {
            return ServerResponse.createByErrorMessage("短信发送失败！失败原因：" + sms.getMessage());
        }
        return ServerResponse.createBySuccessMessage("账号不存在,短信已经发送");
    }

    /**
     * 注册
     * @param accountname
     * @param password
     * @param verificationCode
     * @return
     */
    @Override
    public ServerResponse<String> register(String accountname, String password, String verificationCode) {
        User u = iUserDubboService.findUserByAccountname(accountname);
        if (u != null) {
            return ServerResponse.createByErrorMessage("注册失败，账号已经拥有");
        }
        //从redis中取出
        String s = jedisDao.get(accountname);
        if (s == null) {
            return ServerResponse.createByErrorMessage("注册失败，验证码失效");
        }
        if (!s.equals(verificationCode)) {
            return ServerResponse.createByErrorMessage("验证码不正确");
        }
        User user = new User();
        user.setAccountname(accountname);
        user.setPassword(password);
        user.setIsAuthentication(Constant.NO_AUTHENTICATION);
        user.setRole(NameUtil.telToName(accountname));
        user.setStatus(Constant.ACCOUNT_NUMBER_IS_NORMAL);
        user.setRemark(Constant.DEFAULT_PIC);
        return iUserDubboService.addUser(user);
    }

    /**
     * 修改密码
     * @param id
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @Override
    public ServerResponse<String> updatePassword(Integer id, String oldPwd, String newPwd) {
        User user = iUserDubboService.findUserByKey(id);
        if (!user.getPassword().equals(oldPwd)) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        user.setPassword(newPwd);
        int count = iUserDubboService.updatePassword(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    @Override
    public ServerResponse<String> updateUser(Integer id, String remark, String role) {
        User user = iUserDubboService.findUserByKey(id);
        if (user ==null) {
            return ServerResponse.createByErrorMessage("此用户不存在");
        }
        user.setRemark(remark);
        user.setRole(role);
        int count = iUserDubboService.updatePassword(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

}
