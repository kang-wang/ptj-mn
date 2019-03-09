package com.ptj.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;

/**
 * @author wh
 * @create 2018-11-25 19:35
 **/
public interface IReportService {
    ServerResponse<String> addReport(Integer reportUserId, Integer bereportUserId, String reportContent);

    ServerResponse<String> delReport(Integer id);

    ServerResponse<String> handleReport(Integer id, Integer resultNum, String resultText);

    ServerResponse<String> updateReport(Integer id, String updateText);

    ServerResponse<PageInfo> findAllReport(int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllReportByUserId(Integer reportUserId, int pageNum, int pageSize);
}
