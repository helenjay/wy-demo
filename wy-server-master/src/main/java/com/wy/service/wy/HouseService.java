package com.wy.service.wy;

import com.wy.model.sys.HouseEntity;
import com.wy.model.sys.HouseholdEntity;

import java.util.List;

public interface HouseService {


	/**
	 * 获取住户列表
	 * @return
	 */
	List<HouseEntity> houseList(int pageSize, int start, String houseId, String houseName, String houseNo);

	/**
	 * 获取住户列表的总量
	 *
	 * @return
	 */
	Integer houseSize(String houseId, String houseName, String houseNo);

	/**
	 * 新建住户信息
	 * 
	 * @param houseEntity
	 */
	void insertHouse(HouseEntity houseEntity);

	/**
	 * 修改住户信息
	 * 
	 * @param houseEntity
	 */
	void updateHouse(HouseEntity houseEntity);

	/**
	 * 删除住户信息
	 * 
	 * @param hids
	 */
	void deleteHouses(List<String> hids);

}
