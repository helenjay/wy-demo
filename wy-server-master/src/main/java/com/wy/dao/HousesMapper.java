package com.wy.dao;

import com.wy.model.sys.Households;
import com.wy.model.sys.Houses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HousesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Houses record);

    int insertSelective(Houses record);

    Houses selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Houses record);

    int updateByPrimaryKey(Houses record);

    /**
     * 获取房屋列表
     *
     * @param pageSize
     * @param start
     * @param id 住户id
     * @return
     */
    public List<Houses> houseList(@Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * 获取房屋列表的总量
     *
     * @param pageSize 每页显示条数
     * @param start 起始页数
     * @param id 住户ID
     * @return
     */
    public Integer houseSize(@Param("pageSize") int pageSize, @Param("start") int start);
}