package com.ptj.service;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Resume;

/**
 * @author wh
 * @create 2018-11-25 19:35
 **/
public interface IResumeService {
    ServerResponse<String> updateResume(Resume resume);

    ServerResponse<Resume> findResumeByUserId(Integer id);
}
