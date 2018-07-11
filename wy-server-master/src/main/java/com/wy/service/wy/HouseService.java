package com.wy.service.wy;

import com.wy.model.sys.Houses;

import java.util.List;

public interface HouseService {


	/**
	 * 获取住户列表
	 * @return
	 */
	List<Houses> houseList(int pageSize, int start);

	/**
	 * 获取住户列表的总量
	 *
	 * @return
	 */
	Integer houseSize(int pageSize, int start);

	/**
	 * 新建住户信息
	 * 
	 * @param houses
	 */
	void insertHouse(Houses houses);

	/**
	 * 修改住户信息
	 * 
	 * @param houses
	 */
	void updateHouse(Houses houses);

	/**
	 * 删除住户信息
	 * 
	 * @param hid
	 */
	void deleteHouses(Integer hid);

}
