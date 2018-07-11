package com.wy.dao;

import com.wy.model.sys.Buildings;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuildingsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Buildings record);

    int insertSelective(Buildings record);

    Buildings selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buildings record);

    int updateByPrimaryKey(Buildings record);
}