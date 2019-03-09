package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IApplyDubboService;
import com.ptj.dubbo.service.IJobDubboService;

import com.ptj.pojo.Apply;

import com.ptj.service.IApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wh
 * @create 2018-11-25 19:37
 **/
@Service
public class ApplyServiceImpl implements IApplyService {
    @Autowired
    private IApplyDubboService iApplyDubboService;
    @Autowired
    private IJobDubboService iJobDubboService;

    @Override
    public ServerResponse<String> addApply(Integer jobId, Integer applyUserId, String applyInformation) {
       // System.out.println(jobId+" "+applyUserId);


        Apply apply = iApplyDubboService.findApplyByTwoid(jobId, applyUserId);


       // System.out.println("apply:"+apply);
        if (apply != null) {
            return ServerResponse.createByErrorMessage("您已经申请过该职位了");
        }
        Apply ap = new Apply();
        ap.setJobId(jobId);
        ap.setApplyUserId(applyUserId);
        ap.setApplyInformation(applyInformation);
        ap.setApplyData(new Date());
        ap.setHandleStatus(Constant.DEFAULT_STATU);
        ap.setRemark(iJobDubboService.findJobByKey(jobId).getJobTitle());
        ap.setHandleStatus(Constant.DEFAULT_STATU);
        int count = iApplyDubboService.insApply(ap);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("申请失败");
        }
        return ServerResponse.createBySuccessMessage("申请成功");
    }

    @Override
    public ServerResponse<String> delApply(Integer id) {
        Apply apply = iApplyDubboService.findApplyByKey(id);
        if (apply == null) {
            return ServerResponse.createByErrorMessage("该职位不存在");
        }
        apply.setHandleStatus(Constant.REVOKET_STATU);
        int count = iApplyDubboService.delApply(id);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("撤消失败");
        }
        return ServerResponse.createBySuccessMessage("撤销成功");
    }

    @Override
    public ServerResponse<String> handleApply(Integer id, Integer resultStatu) {
        Apply apply = iApplyDubboService.findApplyByKey(id);
        if (apply == null) {
            return ServerResponse.createByErrorMessage("该职位不存在");
        }
        if (resultStatu == Constant.PROCESSEDT_TRUE_STATU){
            apply.setHandleStatus(Constant.PROCESSEDT_TRUE_STATU);
        }else if (resultStatu == Constant.PROCESSEDT_FALSE_STATU){
            apply.setHandleStatus(Constant.PROCESSEDT_FALSE_STATU);
        }else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        apply.setHandleData(new Date());
        int count = iApplyDubboService.updateApply(apply);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("处理失败");
        }
        return ServerResponse.createBySuccessMessage("处理成功");
    }

    @Override
    public ServerResponse<PageInfo<Apply>> findAllApply(Integer applyUserId, int pageNum, int pageSize) {
        return iApplyDubboService.findAllApply(applyUserId,pageNum,pageSize);
    }

    @Override
    public ServerResponse<PageInfo<Apply>> findAllApplyByAddId(Integer addId, int pageNum, int pageSize) {
        return iApplyDubboService.findAllApplyByAddId(addId,pageNum,pageSize);
    }

}
