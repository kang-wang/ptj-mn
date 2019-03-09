package com.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;
import com.ptj.pojo.Job;
import com.ptj.pojo.JobVO;

import com.ptj.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author wh
 * @create 2018-11-25 19:32
 **/
@Controller
@RequestMapping("/job/")
public class JobController {

    @Autowired
    private IJobService iJobService;

    /**
     * 根据id查找工作
     * @param id
     * @return
     */
    @RequestMapping("findJobById.do")
    @ResponseBody
    public ServerResponse<JobVO> findJobById(Integer id){
        return iJobService.findJobById(id);
    }

    /**
     * 添加新的职位
     * @param job
     * @return
     */
    @RequestMapping("addJob.do")
    @ResponseBody
    public ServerResponse<String> addJob(Job job, String cDate, String longitude, String latitude, String city){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            job.setClosingDate(df.parse(cDate));
        } catch (ParseException e) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        System.out.println(city);
        job.setRemark(longitude+","+latitude+","+city);
        return iJobService.addJob(job);
    }

    /**
     * 撤销职位
     * @param id
     * @return
     */
    @RequestMapping("delJob.do")
    @ResponseBody
    public ServerResponse<String> delJob(Integer id){
        return iJobService.delJob(id);
    }

    /**
     * 更新职位信息
     * @param job
     * @return
     */
    @RequestMapping("updateJob.do")
    @ResponseBody
    public ServerResponse<String> updateJob(Job job, String cDate, String longitude, String latitude, String city){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            job.setClosingDate(df.parse(cDate));
        } catch (ParseException e) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if (!"".equals(longitude) &&!"".equals(latitude)&&"".equals(city)){
            job.setRemark(longitude+","+latitude+","+city);
        }
        return iJobService.updateJob(job);
    }

    /**
     * 分页查询个人发布的职位
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllJobById.do")
    @ResponseBody
    public ServerResponse<PageInfo> findAllJobById(Integer userId,
                                               @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        System.out.println(pageNum+" "+pageSize);
        return iJobService.findAllJobById(userId,pageNum,pageSize);
    }

    /**
     * 分页查询附近的职位
     * @param longitude
     * @param latitude
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllJobByPosition.do")
    @ResponseBody
    public ServerResponse<PageInfo> findAllJobByPosition(String longitude,String latitude,
                                                   @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return iJobService.findAllJobByPosition(longitude,latitude,pageNum,pageSize);
    }

    /**
     * 条件查询
     * @param minSalary
     * @param maxSalary
     * @param category
     * @param city
     * @param minWorkingDays
     * @param maxWorkingDays
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllJobByCondition.do")
    @ResponseBody
    public ServerResponse<PageInfo> findAllJobByCondition(String jobSalaryUnit,Double minSalary,Double maxSalary,String category,String city,
                                                         Integer minWorkingDays,Integer maxWorkingDays,
                                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                         @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        System.out.println(minSalary+" "+maxSalary+" "+category+" "+city+" "+minWorkingDays+" "+maxWorkingDays);
        return iJobService.findAllJobByCondition(jobSalaryUnit,minSalary,maxSalary,category,city,minWorkingDays,maxWorkingDays,pageNum,pageSize);
    }
}
