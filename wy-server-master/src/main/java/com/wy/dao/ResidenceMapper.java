package com.wy.dao;

import com.wy.model.sys.Residence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResidenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Residence record);

    int insertSelective(Residence record);

    Residence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Residence record);

    int updateByPrimaryKeyWithBLOBs(Residence record);

    int updateByPrimaryKey(Residence record);
}