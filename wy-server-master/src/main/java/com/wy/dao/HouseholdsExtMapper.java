package com.wy.dao;

import com.wy.model.sys.HouseholdsExt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseholdsExtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseholdsExt record);

    int insertSelective(HouseholdsExt record);

    HouseholdsExt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseholdsExt record);

    int updateByPrimaryKey(HouseholdsExt record);
}