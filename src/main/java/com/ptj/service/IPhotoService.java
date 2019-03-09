package com.ptj.service;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Photo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wh
 * @create 2018-11-28 13:10
 **/
public interface IPhotoService {
    ServerResponse<Photo> uploadPhoto(MultipartFile uploadFile);
}
