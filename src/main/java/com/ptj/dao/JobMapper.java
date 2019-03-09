package com.ptj.dao;

import com.ptj.pojo.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);

    List<Job> findAllJobById(Integer userId);

    List<Job> findAllJob();

    List<Job> findAllJobByCondition(@Param("jobSalaryUnit") String jobSalaryUnit, @Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary, @Param("category") String category,
                                    @Param("city") String city, @Param("minWorkingDays") Integer minWorkingDays, @Param("maxWorkingDays") Integer maxWorkingDays);
}