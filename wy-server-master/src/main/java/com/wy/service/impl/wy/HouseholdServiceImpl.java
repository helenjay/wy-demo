package com.wy.service.impl.wy;

import com.wy.dao.HouseholdDao;
import com.wy.dao.MenuDao;
import com.wy.dao.RoleDao;
import com.wy.model.sys.HouseholdEntity;
import com.wy.model.sys.MenuEntity;
import com.wy.service.sys.MenuService;
import com.wy.service.wy.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("householdServiceImpl")
public class HouseholdServiceImpl implements HouseholdService {

	@Autowired
	private HouseholdDao householdDao;


	@Override
	public List<HouseholdEntity> householdList(int pageSize, int start, String householdId) {
		return householdDao.householdList(pageSize,start,householdId);
	}

	@Override
	public Integer householdSize(int pageSize, int start, String householdId) {
		return householdDao.householdSize(pageSize,start,householdId);
	}

	@Override
	public void insertHousehold(HouseholdEntity householdEntity) {
		householdDao.insertHousehold(householdEntity);
	}

	@Override
	public void updateHousehold(HouseholdEntity householdEntity) {
		householdDao.updateHousehold(householdEntity);
	}

	@Override
	public void deleteHouseholds(List<String> hids) {
		householdDao.deleteHousehold(hids);
	}
}
