package com.wy.dao;

import com.wy.model.sys.Households;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseholdsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Households record);

    int insertSelective(Households record);

    Households selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Households record);

    int updateByPrimaryKey(Households record);

    /**
     * 获取住户列表
     *
     * @param pageSize
     * @param start
     * @param id 住户id
     * @return
     */
    public List<Households> householdList(@Param("pageSize") int pageSize, @Param("start") int start,
                                               @Param("id") Integer id);

    /**
     * 获取住户列表的总量
     *
     * @param pageSize 每页显示条数
     * @param start 起始页数
     * @param id 住户ID
     * @return
     */
    public Integer householdSize(@Param("pageSize") int pageSize, @Param("start") int start,@Param("id") Integer id);
}