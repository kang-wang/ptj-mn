package com.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @create 2018-11-25 19:33
 **/
@Controller
@RequestMapping("/report/")
public class ReportController {
    @Autowired
    private IReportService iReportService;

    /**
     * 添加举报
     *
     * @param reportUserId
     * @param bereportUserId
     * @param reportContent
     * @return
     */
    @RequestMapping("addReport.do")
    @ResponseBody
    public ServerResponse<String> addReport(Integer reportUserId, Integer bereportUserId, String reportContent) {
        return iReportService.addReport(reportUserId, bereportUserId, reportContent);
    }

    /**
     * 修改举报信息
     *
     * @param id
     * @param updateText
     * @return
     */
    @RequestMapping("updateReport.do")
    @ResponseBody
    public ServerResponse<String> updateReport(Integer id, String updateText) {
        return iReportService.updateReport(id, updateText);
    }

    /**
     * 用户撤销举报
     *
     * @param id
     * @return
     */
    @RequestMapping("delReport.do")
    @ResponseBody
    public ServerResponse<String> delReport(Integer id) {
        return iReportService.delReport(id);
    }

    /**
     * 分页查询自己提交的举报
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllReportByUserId.do")
    @ResponseBody
    public ServerResponse<PageInfo> findAllReportByUserId(Integer  reportUserId,
                                                  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        return iReportService.findAllReportByUserId(reportUserId,pageNum,pageSize);
    }

    /**
     * 分页查询所有的举报信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllReport.do")
    @ResponseBody
    public ServerResponse<PageInfo> findAllReport(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        return iReportService.findAllReport(pageNum,pageSize);
    }

    /**
     * 管理员处理举报
     *
     * @param id
     * @return
     */
    @RequestMapping("handleReport.do")
    @ResponseBody
    public ServerResponse<String> handleReport(Integer id, Integer resultNum, String resultText) {
        return iReportService.handleReport(id, resultNum, resultText);
    }

}
