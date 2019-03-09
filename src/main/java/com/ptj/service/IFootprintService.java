package com.ptj.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Footprint;

/**
 * @author wh
 * @create 2018-11-25 19:34
 **/
public interface IFootprintService {
    ServerResponse<String> addFootprint(Integer userId, Integer jobId, String jobTitle);

    ServerResponse<String> delFootprint(Integer id);

    ServerResponse<PageInfo<Footprint>> findAllFootprint(Integer userId, int pageNum, int pageSize);
}
