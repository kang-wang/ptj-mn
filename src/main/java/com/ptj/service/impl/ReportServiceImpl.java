package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IReportDubboService;
import com.ptj.pojo.Report;
import com.ptj.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wh
 * @create 2018-11-25 19:38
 **/
@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private IReportDubboService iReportDubboService;

    @Override
    public ServerResponse<String> addReport(Integer reportUserId, Integer bereportUserId, String reportContent) {
        Report report = new Report();
        report.setReportUserId(reportUserId);
        report.setBereportUserId(bereportUserId);
        report.setReportContent(reportContent);
        report.setStatus(Constant.DEFAULT_STATU);
        report.setReportData(new Date());
        return iReportDubboService.addReport(report);
    }

    @Override
    public ServerResponse<String> delReport(Integer id) {
        Report report = iReportDubboService.findReportByKey(id);
        if (report == null) {
            return ServerResponse.createByErrorMessage("没有此举报信息");
        }
        report.setStatus(Constant.REVOKET_STATU);
        return iReportDubboService.updateReport(report);
    }

    @Override
    public ServerResponse<String> handleReport(Integer id, Integer resultNum, String resultText) {
        return iReportDubboService.handleReport(id, resultNum, resultText);
    }

    @Override
    public ServerResponse<String> updateReport(Integer id, String updateText) {
        Report report = iReportDubboService.findReportByKey(id);
        if (report == null) {
            return ServerResponse.createByErrorMessage("没有此举报信息");
        }
        report.setReportContent(updateText);
        return iReportDubboService.updateReport(report);
    }

    @Override
    public ServerResponse<PageInfo> findAllReport(int pageNum, int pageSize) {
        return iReportDubboService.findAllReport(pageNum,pageSize);
    }

    @Override
    public ServerResponse<PageInfo> findAllReportByUserId(Integer reportUserId, int pageNum, int pageSize) {
        return iReportDubboService.findAllReportByUserId(reportUserId,pageNum,pageSize);
    }

}
