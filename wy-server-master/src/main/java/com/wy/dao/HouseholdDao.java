package com.wy.dao;

import com.wy.model.sys.HouseholdEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseholdDao {


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
	public List<HouseholdEntity> householdList(@Param("pageSize") int pageSize, @Param("start") int start,
										   @Param("householdId") String householdId);

	/**
	 * 获取住户列表的总量
	 *
	 * @param pageSize 每页显示条数
	 * @param start 起始页数
	 * @param householdId 住户ID
	 * @return
	 */
	public Integer householdSize(@Param("pageSize") int pageSize, @Param("start") int start,@Param("householdId") String householdId);

	/**
	 * 新建住户信息
	 * 
	 * @param householdEntity
	 */
	public void insertHousehold(@Param("householdEntity") HouseholdEntity householdEntity);

	/**
	 * 修改住户信息
	 * 
	 * @param householdEntity
	 */
	public void updateHousehold(@Param("householdEntity") HouseholdEntity householdEntity);

	/**
	 * 删除住户信息
	 *
	 * @param hids
	 */
	public void deleteHousehold(@Param("hids") List<String> hids);

}
