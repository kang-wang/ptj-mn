package com.ptj.dubbo.service.impl;

import com.ptj.dao.ResumeMapper;
import com.ptj.dubbo.service.IResumeDubboService;

import com.ptj.pojo.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wh
 * @create 2018-11-25 19:28
 **/
@Service
public class ResumeDubboServiceImpl implements IResumeDubboService {
    @Resource
    private ResumeMapper resumeMapper;
    @Override
    public int updateResumeByKey(Resume resume) {
        return resumeMapper.updateByPrimaryKeySelective(resume);
    }

    @Override
    public Resume findResumeByUserId(Integer id) {
        return resumeMapper.selectByUserId(id);
    }
}
