package com.wy.dao;

import com.wy.model.sys.HouseEntity;
import com.wy.model.sys.HouseholdEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseDao {


	/**
	 * 获取住户列表
	 *
	 * @param pageSize
	 * @param start
	 * @param householdId 住户id
	 * @param householdName 住户名字
	 * @param houseNo 住户房号
	 * @return
	 */
	public List<HouseEntity> houseList(@Param("pageSize") int pageSize, @Param("start") int start,
                                               @Param("householdId") String householdId, @Param("householdName") String householdName, @Param("houseNo") String houseNo);

	/**
	 * 获取住户列表的总量
	 *
	 * @param householdId 住户id
	 * @param householdName 住户名字
	 * @param householdNo 住户房号
	 * @return
	 */
	public Integer householdSize(@Param("householdId") String householdId, @Param("householdName") String householdName, @Param("householdNo") String householdNo);

	/**
	 * 新建住户信息
	 * 
	 * @param houseEntity
	 */
	public void insertHouse(@Param("houseEntity") HouseEntity houseEntity);

	/**
	 * 修改住户信息
	 * 
	 * @param houseEntity
	 */
	public void updateHouse(@Param("houseEntity") HouseEntity houseEntity);

	/**
	 * 删除住户信息
	 *
	 * @param hids
	 */
	public void deleteHouse(@Param("hids") List<String> hids);

}
