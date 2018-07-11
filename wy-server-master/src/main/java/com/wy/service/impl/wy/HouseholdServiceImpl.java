package com.wy.service.impl.wy;

import com.wy.dao.HouseholdsMapper;
import com.wy.model.sys.Households;
import com.wy.service.wy.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("householdServiceImpl")
public class HouseholdServiceImpl implements HouseholdService {

	@Autowired
	private HouseholdsMapper householdDao;


	@Override
	public List<Households> householdList(int pageSize, int start, Integer id) {
		return householdDao.householdList(pageSize,start,id);
	}

	@Override
	public Integer householdSize(int pageSize, int start, Integer id) {
		return householdDao.householdSize(pageSize,start,id);
	}

	@Transactional
	@Override
	public void insertHousehold(Households householdEntity) {
		householdDao.insert(householdEntity);
	}

	@Override
	public void updateHousehold(Households householdEntity) {
		householdDao.updateByPrimaryKey(householdEntity);
	}

	@Override
	public void deleteHouseholds(Integer hid) {
		householdDao.deleteByPrimaryKey(hid);
	}
}
