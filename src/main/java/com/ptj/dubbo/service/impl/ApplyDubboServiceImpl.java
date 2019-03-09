package com.ptj.dubbo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.dao.ApplyMapper;
import com.ptj.dubbo.service.IApplyDubboService;

import com.ptj.pojo.Apply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-25 19:26
 **/
@Service
public class ApplyDubboServiceImpl implements IApplyDubboService {
    @Resource
    private ApplyMapper applyMapper;
    @Override
    public Apply findApplyByTwoid(Integer jobId, Integer applyUserId) {
        return applyMapper.findApplyByTwoid(jobId,applyUserId);
    }

    @Override
    public int insApply(Apply ap) {
        return applyMapper.insertSelective(ap);
    }

    @Override
    public Apply findApplyByKey(Integer id) {
        return applyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateApply(Apply apply) {
        return applyMapper.updateByPrimaryKeySelective(apply);
    }

    @Override
    public ServerResponse<PageInfo<Apply>> findAllApply(Integer applyUserId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Apply> applyList = applyMapper.findAllApply(applyUserId);
        //System.out.println("applistSize:"+applyList.size());
        PageInfo<Apply> pageInfo = new PageInfo<>(applyList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public int delApply(Integer id) {
        return applyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ServerResponse<PageInfo<Apply>> findAllApplyByAddId(Integer addId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Apply> applyList = applyMapper.findAllApplyByAddId(addId);
        PageInfo<Apply> pageInfo = new PageInfo<>(applyList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
