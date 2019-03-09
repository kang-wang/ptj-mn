package com.ptj.dao;

import com.ptj.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByNameAndPw(@Param("accountname") String accountname, @Param("password") String password);

    User findUserByAccountname(String accountname);
}