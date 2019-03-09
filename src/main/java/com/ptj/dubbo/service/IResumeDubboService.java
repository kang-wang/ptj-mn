package com.ptj.dubbo.service;

import com.ptj.pojo.Resume;

/**
 * @author wh
 * @create 2018-11-25 19:25
 **/
public interface IResumeDubboService {
    int updateResumeByKey(Resume resume);

    Resume findResumeByUserId(Integer id);
}
