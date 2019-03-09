package com.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.ptj.common.ServerResponse;

import com.ptj.pojo.Authentication;

import com.ptj.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @create 2018-11-25 19:32
 **/
@Controller
@RequestMapping("/authentication/")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService iAuthenticationService;

    /**
     * 提交认证申请
     * @param authentication
     * @return
     */
    @RequestMapping("addAuthentication.do")
    @ResponseBody
    public ServerResponse<String> addAuthentication(Authentication authentication){
        return iAuthenticationService.addAuthentication(authentication);
    }

    /**
     * 删除认证
     * @param id
     * @return
     */
    @RequestMapping("delAuthentication.do")
    @ResponseBody
    public ServerResponse<String> delAuthentication(Integer id){
        return iAuthenticationService.delAuthentication(id);
    }

    /**
     * 分页查询用户的认证申请
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllAuthenticationByUserId.do")
    @ResponseBody
    public ServerResponse<PageInfo<Authentication>> findAllAuthenticationByUserId(Integer userId,
                                                                                  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                                                  @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return iAuthenticationService.findAllAuthenticationByUserId(userId,pageNum,pageSize);
    }

    /**
     * 分页查询所有未处理的认证（管理员）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllAuthentication.do")
    @ResponseBody
    public ServerResponse<PageInfo<Authentication>> findAllAuthentication(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                                          @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return iAuthenticationService.findAllAuthentication(pageNum,pageSize);
    }

    /**
     * 处理认证(管理员)
     * @param userId
     * @param authenticationType
     * @param result
     * @param status
     * @return
     */
    @RequestMapping("handleAuthentication.do")
    @ResponseBody
    public ServerResponse<String> handleAuthentication(Integer id,Integer userId,Integer authenticationType,String result,Integer status){
        return iAuthenticationService.handleAuthentication(id,userId,authenticationType,result,status);
    }


}
