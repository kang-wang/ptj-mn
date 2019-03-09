package com.ptj.dubbo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.dao.AuthenticationMapper;
import com.ptj.dubbo.service.IAuthenticationDubboService;
import com.ptj.pojo.Authentication;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-25 19:26
 **/
@Service
public class AuthenticationDubboServiceImpl implements IAuthenticationDubboService {
    @Resource
    private AuthenticationMapper authenticationMapper;
    @Override
    public int addAuthentication(Authentication authentication) {
        return authenticationMapper.insert(authentication);
    }

    @Override
    public Authentication findByIdAndType(Integer userId, Integer authenticationType) {
        return authenticationMapper.findByIdAndType(userId,authenticationType);
    }

    @Override
    public int delAuthentication(Integer id) {
        return authenticationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Authentication findByKey(Integer id) {
        return authenticationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateAuthentication(Authentication authentication) {
        return authenticationMapper.updateByPrimaryKeySelective(authentication);
    }

    @Override
    public ServerResponse<PageInfo<Authentication>> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Authentication> authenticationList = authenticationMapper.findAll();
        PageInfo<Authentication> pageInfo = new PageInfo<>(authenticationList);
        return  ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<PageInfo<Authentication>> findAllByUserId(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Authentication> authenticationList = authenticationMapper.findAllByUserId(userId);
        PageInfo<Authentication> pageInfo = new PageInfo<>(authenticationList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
