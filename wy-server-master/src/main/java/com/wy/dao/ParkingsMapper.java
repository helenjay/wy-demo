package com.wy.dao;

import com.wy.model.sys.Parkings;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkingsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkings record);

    int insertSelective(Parkings record);

    Parkings selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkings record);

    int updateByPrimaryKey(Parkings record);
}