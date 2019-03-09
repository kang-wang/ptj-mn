package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ptj.common.Constant;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IJobDubboService;
import com.ptj.dubbo.service.IUserDubboService;

import com.ptj.pojo.Job;
import com.ptj.pojo.JobVO;
import com.ptj.pojo.User;
import com.ptj.service.IJobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wh
 * @create 2018-11-25 19:37
 **/
@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    private IJobDubboService iJobDubboService;

    @Autowired
    private IUserDubboService iUserDubboService;

    @Override
    public ServerResponse<String> addJob(Job job) {
        User user = iUserDubboService.findUserByKey(job.getUserId());
        if (user == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        job.setIsAuthentication(user.getIsAuthentication());
        job.setReleaseDate(new Date());
        job.setStatus(Constant.DEFAULT_STATU);
        int count = iJobDubboService.addJob(job);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("发布工作失败");
        }
        return ServerResponse.createBySuccessMessage("发布工作成功");
    }

    @Override
    public ServerResponse<String> delJob(Integer id) {
        Job job = iJobDubboService.findJobByKey(id);
        if (job == null) {
            return ServerResponse.createByErrorMessage("工作不存在");
        }
        job.setStatus(Constant.REVOKET_STATU);
        int count = iJobDubboService.updateJob(job);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<String> updateJob(Job job) {
        int count = iJobDubboService.updateJob(job);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<PageInfo> findAllJobById(Integer userId, int pageNum, int pageSize) {
        return iJobDubboService.findAllJobById(userId,pageNum,pageSize);
    }

    @Override
    public ServerResponse<PageInfo> findAllJobByPosition(String longitude, String latitude, int pageNum, int pageSize) {
        return iJobDubboService.findAllJob(longitude,latitude,pageNum,pageSize);
    }

    @Override
    public ServerResponse<PageInfo> findAllJobByCondition(String jobSalaryUnit,Double minSalary, Double maxSalary, String category, String city,  Integer minWorkingDays, Integer maxWorkingDays,int pageNum, int pageSize) {
        return iJobDubboService.findAllJobByCondition(jobSalaryUnit,minSalary,maxSalary,category,city,minWorkingDays,maxWorkingDays,pageNum,pageSize);
    }

    @Override
    public ServerResponse<JobVO> findJobById(Integer id) {
        Job job = iJobDubboService.findJobByKey(id);
        if (job == null) {
            return ServerResponse.createByErrorMessage("工作不存在");
        }
        return ServerResponse.createBySuccess(jobToVo(job));
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
