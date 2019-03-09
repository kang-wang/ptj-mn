package com.ptj.dubbo.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Job;


/**
 * @author wh
 * @create 2018-11-25 19:24
 **/
public interface IJobDubboService {
    int addJob(Job job);

    Job findJobByKey(Integer id);

    int updateJob(Job job);

    ServerResponse<PageInfo> findAllJobById(Integer userId, int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllJob(String longitude, String latitude, int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllJobByCondition(String jobSalaryUnit, Double minSalary, Double maxSalary, String category, String city, Integer minWorkingDays, Integer maxWorkingDays, int pageNum, int pageSize);
}
