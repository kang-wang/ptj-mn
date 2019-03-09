package com.ptj.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ptj.common.ServerResponse;
import com.ptj.dubbo.service.IResumeDubboService;
import com.ptj.pojo.Resume;
import com.ptj.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wh
 * @create 2018-11-25 19:38
 **/
@Service
public class ResumeServiceImpl implements IResumeService {
    @Autowired
    private IResumeDubboService iResumeDubboService;

    @Override
    public ServerResponse<String> updateResume(Resume resume) {
        int count = iResumeDubboService.updateResumeByKey(resume);
        if (count == 0){
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<Resume> findResumeByUserId(Integer id) {
        Resume resume = iResumeDubboService.findResumeByUserId(id);
        if (resume ==null){
            return ServerResponse.createByErrorMessage("没有此用户");
        }
        return ServerResponse.createBySuccess(resume);

    }
}
