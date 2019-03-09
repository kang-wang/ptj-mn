package com.ptj.dao;

import com.ptj.pojo.Authentication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthenticationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authentication record);

    int insertSelective(Authentication record);

    Authentication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authentication record);

    int updateByPrimaryKey(Authentication record);

    Authentication findByIdAndType(@Param("userId") Integer userId, @Param("authenticationType") Integer authenticationType);

    List<Authentication> findAll();

    List<Authentication> findAllByUserId(Integer userId);
}