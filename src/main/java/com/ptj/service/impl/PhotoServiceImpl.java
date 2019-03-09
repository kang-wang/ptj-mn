package com.ptj.service.impl;

import com.ptj.common.ServerResponse;
import com.ptj.pojo.Photo;
import com.ptj.service.IPhotoService;
import com.ptj.util.FtpUtil;
import com.ptj.util.IDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wh
 * @create 2018-11-28 13:10
 **/
@Service
public class PhotoServiceImpl implements IPhotoService {
    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basepath}")
    private String basePath;
    @Value("${ftpclient.filepath}")
    private String filePath;

    @Override
    public ServerResponse<Photo> uploadPhoto(MultipartFile file) {
        String genImageName = IDUtils.genImageName()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        boolean result = false;
        try {
            result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, genImageName, file.getInputStream());
        } catch (IOException e) {
            System.out.println("文件上传错误");
            e.printStackTrace();
        }
        if (result){
            Photo p = new Photo("http://"+ host+"/"+genImageName);
            return ServerResponse.createBySuccess("图片上传成功",p);
        }
        return ServerResponse.createByErrorMessage("图片上传失败");
    }
}
