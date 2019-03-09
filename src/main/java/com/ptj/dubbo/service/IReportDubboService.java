package com.ptj.dubbo.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Report;


/**
 * @author wh
 * @create 2018-11-25 19:25
 **/
public interface IReportDubboService {
    ServerResponse<String> addReport(Report report);

    ServerResponse<String> updateReport(Report report);

    Report findReportByKey(Integer id);

    ServerResponse<String> handleReport(Integer id, Integer resultNum, String resultText);

    ServerResponse<PageInfo> findAllReport(int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllReportByUserId(Integer reportUserId, int pageNum, int pageSize);
}
