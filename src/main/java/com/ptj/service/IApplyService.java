package com.ptj.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Apply;

/**
 * @author wh
 * @create 2018-11-25 19:34
 **/
public interface IApplyService {
    ServerResponse<String> addApply(Integer jobId, Integer applyUserId, String applyInformation);

    ServerResponse<String> delApply(Integer id);

    ServerResponse<String> handleApply(Integer id, Integer resultStatu);

    ServerResponse<PageInfo<Apply>> findAllApply(Integer applyUserId, int pageNum, int pageSize);

    ServerResponse<PageInfo<Apply>> findAllApplyByAddId(Integer addId, int pageNum, int pageSize);
}
