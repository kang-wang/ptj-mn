package com.ptj.dao;

import com.ptj.pojo.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    Apply findApplyByTwoid(@Param("jobId") Integer jobId, @Param("applyUserId") Integer applyUserId);

    List<Apply> findAllApply(Integer applyUserId);

    List<Apply> findAllApplyByAddId(Integer addId);
}