package com.ptj.controller;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Photo;

import com.ptj.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wh
 * @create 2018-11-28 12:47
 **/
@Controller
@RequestMapping("/pic/")
public class PhotoController {
    @Autowired
    private IPhotoService iPhotoService;

    /**
     * 图片上传
     *
     * @param uploadFile
     * @return
     */
    @RequestMapping("uploadPhoto.do")
    @ResponseBody
    public ServerResponse<Photo> uploadPhoto(MultipartFile uploadFile) {
        if (uploadFile.getSize() == 0) {
            System.out.println("1111111");
            return ServerResponse.createByErrorMessage("文件不能为空");
        }
        return iPhotoService.uploadPhoto(uploadFile);
    }
}
