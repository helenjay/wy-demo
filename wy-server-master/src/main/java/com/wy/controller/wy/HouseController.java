package com.wy.controller.wy;

import com.wy.model.sys.HouseEntity;
import com.wy.model.sys.HouseholdEntity;
import com.wy.model.sys.PageResult;
import com.wy.service.wy.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房屋管理
 */
@RestController
public class HouseController {

	private Logger log = LoggerFactory.getLogger(HouseController.class);

	@Resource(name = "houseServiceImpl")
	private HouseService houseService;

	/**
	 * 根据住户姓名查询
	 * 
	 * @param householdName
	 * @return
	 */
	@GetMapping("/houseByName/")
	public List<HouseEntity> getHouseholdByName(@RequestParam("householdName") String householdName) {
		List<HouseEntity> householdList = houseService.houseList(10,0,null,householdName,null);
		return householdList;
	}

	/**
	 * 根据住户房号查询
	 *
	 * @param houseNo
	 * @return
	 */
	@GetMapping("/houseByNo/")
	public List<HouseEntity> getHouseholdByNo(@RequestParam("houseNo") String houseNo) {
		List<HouseEntity> householdList = houseService.houseList(10,0,null,null,houseNo);
		return householdList;
	}

	/**
	 * 根据房屋id查询
	 *
	 * @param householdId
	 * @return
	 */
	@GetMapping("/houseById/")
	public HouseEntity getHouseholdById(@RequestParam("householdId") String householdId) {
		List<HouseEntity> householdList = houseService.houseList(10,0,householdId,null,null);
		return (householdList != null && householdList.size() > 0 ) ? householdList.get(0) : null;
	}

	/**
	 * 获取房屋表数据
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/houses")
	public PageResult householdList(int pageSize, int page, String householdId, String householdName, String houseNo) {
		PageResult pageResult = new PageResult();
		pageResult.setData(houseService.houseList(pageSize, page * pageSize, householdId,householdName,houseNo));
		pageResult.setTotalCount(houseService.houseSize(householdId,householdName,houseNo));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建房屋信息
	 * @param houseEntity
	 * @return
	 */
	@PostMapping("/houses/house")
	public HouseEntity insertMenu(@RequestBody HouseEntity houseEntity) {
		houseService.insertHouse(houseEntity);
		log.debug("The method is ending");
		return houseEntity;
	}

	/**
	 * 修改房屋信息
	 * 
	 * @param houseEntity
	 * @param id
	 * @return
	 */
	@PutMapping("/houses/{id}")
	public HouseEntity updateMenu(@RequestBody HouseEntity houseEntity, @PathVariable int id) {
		if (houseEntity.getId() == id) {
			houseService.updateHouse(houseEntity);
		}
		log.debug("The method is ending");
		return houseEntity;
	}

	/**
	 * 删除房屋信息
	 * 
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/houses")
	public List<String> deleteMenus(@RequestBody List<String> groupId) {
		houseService.deleteHouses(groupId);
		return groupId;
	}

}
