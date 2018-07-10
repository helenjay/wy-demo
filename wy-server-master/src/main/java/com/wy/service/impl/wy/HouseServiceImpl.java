package com.wy.service.impl.wy;

import com.wy.dao.HouseDao;
import com.wy.model.sys.HouseEntity;
import com.wy.service.wy.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("houseServiceImpl")
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;


	@Override
	public List<HouseEntity> houseList(int pageSize, int start, String houseId, String houseName, String houseNo) {
		return houseDao.houseList(pageSize,start,houseId,houseName,houseNo);
	}

	@Override
	public Integer houseSize(String houseId, String houseName, String houseNo) {
		return houseDao.householdSize(houseId,houseName,houseNo);
	}

	@Override
	public void insertHouse(HouseEntity HouseEntity) {
		houseDao.insertHouse(HouseEntity);
	}

	@Override
	public void updateHouse(HouseEntity HouseEntity) {
		houseDao.updateHouse(HouseEntity);
	}

	@Override
	public void deleteHouses(List<String> hids) {
		houseDao.deleteHouse(hids);
	}
}
