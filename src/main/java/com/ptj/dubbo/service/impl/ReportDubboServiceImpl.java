package com.ptj.dubbo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dao.ReportMapper;
import com.ptj.dao.UserMapper;
import com.ptj.dubbo.service.IReportDubboService;

import com.ptj.pojo.Report;
import com.ptj.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-25 19:28
 **/
@Service
public class ReportDubboServiceImpl implements IReportDubboService {
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public ServerResponse<String> addReport(Report report) {
        int count = reportMapper.insert(report);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> updateReport(Report report) {
        int count = reportMapper.updateByPrimaryKeySelective(report);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public Report findReportByKey(Integer id) {
        return reportMapper.selectByPrimaryKey(id);
    }

    @Override
    public ServerResponse<String> handleReport(Integer id, Integer resultNum, String resultText) {
        if (!(resultNum == Constant.PROCESSEDT_TRUE_STATU || resultNum == Constant.PROCESSEDT_FALSE_STATU)) {
            return ServerResponse.createByErrorMessage("处理错误");
        }
        Report report = findReportByKey(id);
        if (report == null) {
            return ServerResponse.createByErrorMessage("此举报不存在");
        }
        report.setStatus(resultNum);
        report.setResult(resultText);
        int count = reportMapper.updateByPrimaryKeySelective(report);
        if (count == 0) {
            try {
                throw new Exception("更新失败");
            } catch (Exception e) {
                System.out.println("回滚数据库，处理举报失败");
                return ServerResponse.createByErrorMessage("处理失败");
            }
        }
        if (resultNum == Constant.PROCESSEDT_TRUE_STATU) {
            User user = userMapper.selectByPrimaryKey(report.getBereportUserId());
            user.setStatus(Constant.ACCOUNT_EXCEPTION);
            count = userMapper.updateByPrimaryKeySelective(user);
            if (count == 0) {
                try {
                    throw new Exception("更新失败");
                } catch (Exception e) {
                    System.out.println("回滚数据库，处理举报失败");
                    return ServerResponse.createByErrorMessage("处理失败");
                }
            }
        }
        return ServerResponse.createBySuccessMessage("处理成功");
    }

    @Override
    public ServerResponse<PageInfo> findAllReport(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Report> reportList = reportMapper.findAllReport();
        PageInfo pageInfo = new PageInfo(reportList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<PageInfo> findAllReportByUserId(Integer reportUserId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Report> reportList = reportMapper.findAllReportByUserId(reportUserId);
        PageInfo pageInfo = new PageInfo(reportList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
