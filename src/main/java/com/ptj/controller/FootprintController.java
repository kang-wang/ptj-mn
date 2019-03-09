package com.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Footprint;
import com.ptj.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @create 2018-11-25 19:32
 **/
@Controller
@RequestMapping("/footprint/")
public class FootprintController {

    @Autowired
    private IFootprintService iFootprintService;

    /**
     * 添加新的足迹记录
     *
     * @param userId
     * @param jobId
     * @param jobTitle
     * @return
     */
    @RequestMapping("addFootprint.do")
    @ResponseBody
    public ServerResponse<String> addFootprint(Integer userId, Integer jobId, String jobTitle) {
        return iFootprintService.addFootprint(userId, jobId, jobTitle);
    }

    /**
     * 删除足迹
     *
     * @param id
     * @return
     */
    @RequestMapping("delFootprint.do")
    @ResponseBody
    public ServerResponse<String> delFootprint(Integer id) {
        return iFootprintService.delFootprint(id);
    }

    /**
     * 分页查询足迹
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllFootprint.do")
    @ResponseBody
    public ServerResponse<PageInfo<Footprint>> findAllFootprint(Integer userId,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return iFootprintService.findAllFootprint(userId, pageNum, pageSize);
    }
}
