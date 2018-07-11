package com.wy.dao;

import com.wy.model.sys.CarEnteringRecords;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarEnteringRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarEnteringRecords record);

    int insertSelective(CarEnteringRecords record);

    CarEnteringRecords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarEnteringRecords record);

    int updateByPrimaryKey(CarEnteringRecords record);
}