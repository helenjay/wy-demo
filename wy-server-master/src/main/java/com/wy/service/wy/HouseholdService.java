package com.wy.service.wy;

import com.wy.model.sys.HouseholdEntity;
import com.wy.model.sys.MenuEntity;

import java.util.List;

public interface HouseholdService {


	/**
	 * 获取住户列表
	 * @return
	 */
	List<HouseholdEntity> householdList(int pageSize, int start, String householdId);

	/**
	 * 获取住户列表的总量
	 * 
	 * @return
	 */
	Integer householdSize(int pageSize, int start, String householdId);

	/**
	 * 新建住户信息
	 * 
	 * @param householdEntity
	 */
	void insertHousehold(HouseholdEntity householdEntity);

	/**
	 * 修改住户信息
	 * 
	 * @param householdEntity
	 */
	void updateHousehold(HouseholdEntity householdEntity);

	/**
	 * 删除住户信息
	 * 
	 * @param hids
	 */
	void deleteHouseholds(List<String> hids);

}
