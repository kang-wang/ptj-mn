package com.ptj.dao;

import com.ptj.pojo.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    Footprint findFootprintByUseridAndJobid(@Param("userId") Integer userId, @Param("jobId") Integer jobId);

    List<Footprint> findAllFootprint(Integer userId);
}