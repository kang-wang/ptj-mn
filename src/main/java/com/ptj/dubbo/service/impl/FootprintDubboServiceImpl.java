package com.ptj.dubbo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.dao.FootprintMapper;
import com.ptj.dubbo.service.IFootprintDubboService;
import com.ptj.pojo.Footprint;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-25 19:27
 **/
@Service
public class FootprintDubboServiceImpl implements IFootprintDubboService {
    @Resource
    private FootprintMapper footprintMapper;
    @Override
    public Footprint findFootprintByUseridAndJobid(Integer userId, Integer jobId) {
        return footprintMapper.findFootprintByUseridAndJobid(userId,jobId);
    }

    @Override
    public int updateFootprint(Footprint footprint) {
        return footprintMapper.updateByPrimaryKeySelective(footprint);
    }

    @Override
    public int insFootprint(Footprint footprint) {
        return footprintMapper.insertSelective(footprint);
    }

    @Override
    public Footprint findFootprintByKey(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    @Override
    public ServerResponse<PageInfo<Footprint>> findAllFootprint(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Footprint> footprintList = footprintMapper.findAllFootprint(userId);
        PageInfo<Footprint> pageInfo = new PageInfo<>(footprintList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
