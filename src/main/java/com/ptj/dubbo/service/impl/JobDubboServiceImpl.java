package com.ptj.dubbo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.dao.JobMapper;
import com.ptj.dubbo.service.IJobDubboService;

import com.ptj.pojo.Job;
import com.ptj.pojo.JobVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @create 2018-11-25 19:27
 **/
@Service
public class JobDubboServiceImpl implements IJobDubboService {
    @Resource
    private JobMapper jobMapper;

    @Override
    public int addJob(Job job) {
        return jobMapper.insertSelective(job);
    }

    @Override
    public Job findJobByKey(Integer id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateJob(Job job) {
        return jobMapper.updateByPrimaryKeySelective(job);
    }

    @Override
    public ServerResponse<PageInfo> findAllJobById(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Job> jobList = jobMapper.findAllJobById(userId);
        List<JobVO> jobVOList = new ArrayList<>();
        for (Job j : jobList) {
            jobVOList.add(jobToVo(j));
        }
        PageInfo pageInfo1 = new PageInfo<>(jobList);
        pageInfo1.setList(jobVOList);
        return ServerResponse.createBySuccess(pageInfo1);
    }

    @Override
    public ServerResponse<PageInfo> findAllJob(String longitude, String latitude, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Job> jobList = jobMapper.findAllJob();
        // System.out.println("jobsize:"+jobList.size());
        List<JobVO> jobVOList = new ArrayList<>();
        // System.out.println("longitude:"+longitude+"   latitude:"+latitude+" "+jobList.size() );
        for (Job j : jobList) {
            String[] strs = j.getRemark().split(",");
            Double maxLo = Double.valueOf(longitude) + 0.2d;
            Double minLo = Double.valueOf(longitude) - 0.2d;
            Double maxLa = Double.valueOf(latitude) + 0.2d;
            Double minLa = Double.valueOf(latitude) - 0.2d;
            Double lo = Double.valueOf(strs[0]);
            Double la = Double.valueOf(strs[1]);
            // System.out.println("maxLo:"+maxLo+" minLo:"+minLo+" maxLa:"+maxLa+" minLa:"+minLa);
            // System.out.println("lo:"+lo+" la:"+la);
            boolean b1 = (lo >= minLo) && (lo <= maxLo);
            boolean b2 = (la >= minLa) && (la <= maxLa);
            // System.out.println("b1:"+b1+" b2:"+b2);
            if (b1 && b2) {
                jobVOList.add(jobToVo(j));
            }
        }
        // System.out.println("jobVOListSize:"+jobVOList.size());
        PageInfo pageInfo = new PageInfo<>(jobList);
        pageInfo.setList(jobVOList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<PageInfo> findAllJobByCondition(String jobSalaryUnit, Double minSalary, Double maxSalary, String category, String city, Integer minWorkingDays, Integer maxWorkingDays, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Job> jobList = jobMapper.findAllJobByCondition(jobSalaryUnit, minSalary, maxSalary, category, city, minWorkingDays, maxWorkingDays);
        List<JobVO> jobVOList = new ArrayList<>();
        for (Job j : jobList) {
            jobVOList.add(jobToVo(j));
        }
        PageInfo pageInfo = new PageInfo<>(jobList);
        pageInfo.setList(jobVOList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    private JobVO jobToVo(Job job) {
        JobVO jv = new JobVO();
        jv.setId(job.getId());
        jv.setUserId(job.getUserId());
        jv.setJobTitle(job.getJobTitle());
        jv.setJobDescribe(job.getJobDescribe());
        jv.setJobCategory(job.getJobCategory());
        jv.setJobSalary(job.getJobSalary());
        jv.setJobSalaryUnit(job.getJobSalaryUnit());
        jv.setJobCount(job.getJobCount());
        jv.setWorkingHours(job.getWorkingHours());
        jv.setWorkingDays(job.getWorkingDays());
        jv.setContact(job.getContact());
        jv.setTelephone(job.getTelephone());
        jv.setIsAuthentication(job.getIsAuthentication());
        jv.setReleaseDate(job.getReleaseDate());
        jv.setClosingDate(job.getClosingDate());
        jv.setIssuePlace(job.getIssuePlace());
        jv.setStatus(job.getStatus());
        if (job.getRemark() != null) {
            String[] strs = job.getRemark().split(",");
            jv.setLongitude(strs[0]);
            jv.setLatitude(strs[1]);
            jv.setCity(strs[2]);
        }
        return jv;
    }
}
