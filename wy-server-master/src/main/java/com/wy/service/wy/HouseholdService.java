package com.wy.service.wy;

import com.wy.model.sys.Households;

import java.util.List;

public interface HouseholdService {


	/**
	 * 获取住户列表
	 * @return
	 */
	List<Households> householdList(int pageSize, int start, Integer id);

	/**
	 * 获取住户列表的总量
	 * 
	 * @return
	 */
	Integer householdSize(int pageSize, int start, Integer id);

	/**
	 * 新建住户信息
	 * 
	 * @param householdEntity
	 */
	void insertHousehold(Households householdEntity);

	/**
	 * 修改住户信息
	 * 
	 * @param householdEntity
	 */
	void updateHousehold(Households householdEntity);

	/**
	 * 删除住户信息
	 * 
	 * @param hid
	 */
	void deleteHouseholds(Integer hid);

}
