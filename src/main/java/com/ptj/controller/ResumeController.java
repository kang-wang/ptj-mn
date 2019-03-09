package com.ptj.controller;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Resume;
import com.ptj.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @create 2018-11-25 19:33
 **/
@Controller
@RequestMapping("/resume/")
public class ResumeController {
    @Autowired
    private IResumeService iResumeService;

    /**
     * 更新简历
     * @param resume
     * @return
     */
    @RequestMapping("updateResume.do")
    @ResponseBody
    public ServerResponse<String> updateResume(Resume resume){
        return iResumeService.updateResume(resume);
    }

    /**
     * 根据用户id查找简历
     * @param id
     * @return
     */
    @RequestMapping("findResumeByUserId.do")
    @ResponseBody
    public ServerResponse<Resume> findResumeByUserId(Integer id){
        return iResumeService.findResumeByUserId(id);
    }
}
