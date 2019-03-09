package com.ptj.service;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Job;
import com.ptj.pojo.JobVO;


/**
 * @author wh
 * @create 2018-11-25 19:34
 **/
public interface IJobService {
    ServerResponse<String> addJob(Job job);

    ServerResponse<String> delJob(Integer id);

    ServerResponse<String> updateJob(Job job);

    ServerResponse<PageInfo> findAllJobById(Integer userId, int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllJobByPosition(String longitude, String latitude, int pageNum, int pageSize);

    ServerResponse<PageInfo> findAllJobByCondition(String jobSalaryUnit, Double minSalary, Double maxSalary, String category, String city, Integer minWorkingDays, Integer maxWorkingDays, int pageNum, int pageSize);

    ServerResponse<JobVO> findJobById(Integer id);
}
