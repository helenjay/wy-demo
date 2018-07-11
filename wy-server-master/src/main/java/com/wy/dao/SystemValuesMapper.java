package com.wy.dao;

import com.wy.model.sys.SystemValues;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemValuesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemValues record);

    int insertSelective(SystemValues record);

    SystemValues selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemValues record);

    int updateByPrimaryKey(SystemValues record);
}