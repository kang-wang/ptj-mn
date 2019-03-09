package com.ptj.dubbo.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Apply;


/**
 * @author wh
 * @create 2018-11-25 19:22
 **/
public interface IApplyDubboService {
    Apply findApplyByTwoid(Integer jobId, Integer applyUserId);

    int insApply(Apply ap);

    Apply findApplyByKey(Integer id);

    int updateApply(Apply apply);

    ServerResponse<PageInfo<Apply>> findAllApply(Integer applyUserId, int pageNum, int pageSize);

    int delApply(Integer id);

    ServerResponse<PageInfo<Apply>> findAllApplyByAddId(Integer addId, int pageNum, int pageSize);
}
