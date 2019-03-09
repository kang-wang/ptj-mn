package com.ptj.dubbo.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Footprint;


/**
 * @author wh
 * @create 2018-11-25 19:24
 **/
public interface IFootprintDubboService {
    Footprint findFootprintByUseridAndJobid(Integer userId, Integer jobId);

    int updateFootprint(Footprint footprint);

    int insFootprint(Footprint footprint);

    Footprint findFootprintByKey(Integer id);

    ServerResponse<PageInfo<Footprint>> findAllFootprint(Integer userId, int pageNum, int pageSize);
}
