package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IFootprintDubboService;

import com.ptj.pojo.Footprint;

import com.ptj.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wh
 * @create 2018-11-25 19:37
 **/
@Service
public class FootprintServiceImpl implements IFootprintService {

    @Autowired
    IFootprintDubboService iFootprintDubboService;

    @Override
    public ServerResponse<String> addFootprint(Integer userId, Integer jobId, String jobTitle) {
        Footprint footprint = iFootprintDubboService.findFootprintByUseridAndJobid(userId, jobId);
        if (footprint != null) {
            footprint.setViewingData(new Date());
            int count = iFootprintDubboService.updateFootprint(footprint);
            if (count == 0) {
                return ServerResponse.createBySuccessMessage("更新失败");
            }
        } else {
            Footprint fp = new Footprint();
            fp.setJobId(jobId);
            fp.setUserId(userId);
            fp.setJobTitle(jobTitle);
            fp.setStatus(Constant.FOOTPRINT_HAS);
            fp.setViewingData(new Date());
            int count = iFootprintDubboService.insFootprint(fp);
            if (count == 0) {
                return ServerResponse.createBySuccessMessage("添加失败");
            }
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> delFootprint(Integer id) {
        Footprint footprint = iFootprintDubboService.findFootprintByKey(id);
        footprint.setStatus(Constant.FOOTPRINT_NOT_HAS);
        int count = iFootprintDubboService.updateFootprint(footprint);
        if (count == 0) {
            return ServerResponse.createBySuccessMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<PageInfo<Footprint>> findAllFootprint(Integer userId, int pageNum, int pageSize) {
        return iFootprintDubboService.findAllFootprint(userId,pageNum,pageSize);
    }

}
