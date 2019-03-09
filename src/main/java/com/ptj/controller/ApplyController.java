package com.ptj.controller;

import com.github.pagehelper.PageInfo;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Apply;
import com.ptj.service.IApplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wh
 * @create 2018-11-25 19:32
 **/
@Controller
@RequestMapping("/apply/")
public class ApplyController {

    @Resource
    private IApplyService iApplyService;

    /**
     * 添加新的申请
     *
     * @param jobId 用户id
     * @param applyUserId 申请用户id
     * @param applyInformation
     * @return
     */
    @RequestMapping("addApply.do")
    @ResponseBody
    public ServerResponse<String> addApply(Integer jobId, Integer applyUserId, String applyInformation) {
        return iApplyService.addApply(jobId, applyUserId, applyInformation);
    }

    /**
     * 用户撤销申请
     *
     * @param id
     * @return
     */
    @RequestMapping("delApply.do")
    @ResponseBody
    public ServerResponse<String> delApply(Integer id) {
        return iApplyService.delApply(id);
    }

    /**
     * 发布方处理申请
     *
     * @param id
     * @param resultStatu
     * @return
     */
    @RequestMapping("handleApply.do")
    @ResponseBody
    public ServerResponse<String> handleApply(Integer id, Integer resultStatu) {
        return iApplyService.handleApply(id, resultStatu);
    }

    /**
     * 分页查询个人所有申请
     *
     * @param applyUserId
     * @return
     */
    @RequestMapping("findAllApply.do")
    @ResponseBody
    public ServerResponse<PageInfo<Apply>> findAllApply(Integer applyUserId,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return iApplyService.findAllApply(applyUserId, pageNum, pageSize);
    }

    /**
     * 分页查询个人发布
     *
     * @param addId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllApplyByAddId.do")
    @ResponseBody
    public ServerResponse<PageInfo<Apply>> findAllApplyByAddId(Integer addId,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return iApplyService.findAllApplyByAddId(addId, pageNum, pageSize);
    }
}
