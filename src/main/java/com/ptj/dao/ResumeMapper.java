package com.ptj.dao;

import com.ptj.pojo.Resume;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    Resume selectByUserId(@Param("userId") Integer id);
}