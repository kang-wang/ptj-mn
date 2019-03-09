package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IAuthenticationDubboService;
import com.ptj.dubbo.service.IUserDubboService;
import com.ptj.pojo.Authentication;
import com.ptj.pojo.User;
import com.ptj.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wh
 * @create 2018-11-25 19:37
 **/
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Autowired
    private IAuthenticationDubboService iAuthenticationDubboService;
    @Autowired
    private IUserDubboService iUserDubboService;

    @Override
    public ServerResponse<String> addAuthentication(Authentication authentication) {
        Authentication a = iAuthenticationDubboService.findByIdAndType(authentication.getUserId(), authentication.getAuthenticationType());
        if (a != null) {
            return ServerResponse.createByErrorMessage("已经提交过该类型申请");
        }
        authentication.setStatus(Constant.DEFAULT_STATU);
        authentication.setAuthenticationData(new Date());
        int count = iAuthenticationDubboService.addAuthentication(authentication);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("提交失败");
        }
        return ServerResponse.createBySuccessMessage("提交成功");
    }

    @Override
    public ServerResponse<String> delAuthentication(Integer id) {
        int count = iAuthenticationDubboService.delAuthentication(id);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<String> handleAuthentication(Integer id, Integer userId, Integer authenticationType, String result, Integer status) {
        User user = iUserDubboService.findUserByKey(userId);
        Authentication authentication = iAuthenticationDubboService.findByKey(id);
        authentication.setResult(result);
        authentication.setStatus(status);
        if (status ==Constant.PROCESSEDT_TRUE_STATU){
            if (user.getIsAuthentication()==Constant.NO_AUTHENTICATION && authenticationType==Constant.DEFAULT_STATU){
                user.setIsAuthentication(Constant.STUDENT_AUTHENTICATION);
            }else if (user.getIsAuthentication()==Constant.NO_AUTHENTICATION && authenticationType==Constant.REVOKET_STATU){
                user.setIsAuthentication(Constant.REAL_NAME_AUTHENTICATION);
            }else if (user.getIsAuthentication()==Constant.STUDENT_AUTHENTICATION && authenticationType==Constant.REVOKET_STATU){
                user.setIsAuthentication(Constant.NAME_AND_STUDENT_AUTHENTICATION);
            }else if (user.getIsAuthentication()==Constant.REAL_NAME_AUTHENTICATION && authenticationType==Constant.DEFAULT_STATU){
                user.setIsAuthentication(Constant.NAME_AND_STUDENT_AUTHENTICATION);
            }
        }
        iUserDubboService.updateByKey(user);
        iAuthenticationDubboService.updateAuthentication(authentication);
        return ServerResponse.createBySuccessMessage("修改成功");

    }

    @Override
    public ServerResponse<PageInfo<Authentication>> findAllAuthentication(int pageNum, int pageSize) {
        return iAuthenticationDubboService.findAll(pageNum,pageSize);
    }

    @Override
    public ServerResponse<PageInfo<Authentication>> findAllAuthenticationByUserId(Integer userId, int pageNum, int pageSize) {
        return iAuthenticationDubboService.findAllByUserId(userId,pageNum,pageSize);
    }

}
