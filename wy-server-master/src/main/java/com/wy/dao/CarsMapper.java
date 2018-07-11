package com.wy.dao;

import com.wy.model.sys.Cars;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cars record);

    int insertSelective(Cars record);

    Cars selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cars record);

    int updateByPrimaryKey(Cars record);
}