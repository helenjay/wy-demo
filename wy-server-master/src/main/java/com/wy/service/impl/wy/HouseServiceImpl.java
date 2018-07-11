package com.wy.service.impl.wy;

import com.wy.dao.HousesMapper;
import com.wy.model.sys.Houses;
import com.wy.service.wy.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("houseServiceImpl")
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HousesMapper houseDao;


	@Override
	public List<Houses> houseList(int pageSize, int start) {
		return houseDao.houseList(pageSize,start);
	}

	@Override
	public Integer houseSize(int pageSize, int start) {
		return houseDao.houseSize(pageSize,start);
	}

	@Override
	public void insertHouse(Houses houses) {
		houseDao.insert(houses);
	}

	@Override
	public void updateHouse(Houses houses) {
		houseDao.updateByPrimaryKey(houses);
	}

	@Override
	public void deleteHouses(Integer hid) {
		houseDao.deleteByPrimaryKey(hid);
	}
}
