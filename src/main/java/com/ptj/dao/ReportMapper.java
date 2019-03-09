package com.ptj.dao;

import com.ptj.pojo.Report;

import java.util.List;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    List<Report> findAllReport();

    List<Report> findAllReportByUserId(Integer reportUserId);
}