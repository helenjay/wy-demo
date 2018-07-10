package com.wy.controller.wy;

import com.wy.model.sys.HouseholdEntity;
import com.wy.model.sys.PageResult;
import com.wy.service.wy.HouseholdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 住户管理
 */
@RestController
public class HouseholdController {

	private Logger log = LoggerFactory.getLogger(HouseholdController.class);

	@Resource(name = "householdServiceImpl")
	private HouseholdService householdService;

	/**
	 * 根据住户姓名查询
	 *
	 * @param householdName
	 * @return
	 */
	@GetMapping("/householdByName/")
	public List<HouseholdEntity> getHouseholdByName(@RequestParam("householdName") String householdName) {
		List<HouseholdEntity> householdList = householdService.householdList(10,0,null);
		return householdList;
	}

	/**
	 * 根据住户房号查询
	 *
	 * @param houseNo
	 * @return
	 */
	@GetMapping("/householdByNo/")
	public List<HouseholdEntity> getHouseholdByNo(@RequestParam("houseNo") String houseNo) {
		List<HouseholdEntity> householdList = householdService.householdList(10,0,null);
		return householdList;
	}

	/**
	 * 根据住户id查询
	 *
	 * @param householdId
	 * @return
	 */
	@GetMapping("/householdById/")
	public HouseholdEntity getHouseholdById(@RequestParam("householdId") String householdId) {
		List<HouseholdEntity> householdList = householdService.householdList(10,0,householdId);
		return (householdList != null && householdList.size() > 0 ) ? householdList.get(0) : null;
	}

	/**
	 * 获取住户表数据
	 *
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/households")
	public PageResult householdList(int pageSize, int page, String householdId) {
		PageResult pageResult = new PageResult();
		pageResult.setData(householdService.householdList(pageSize, page * pageSize, householdId));
		pageResult.setTotalCount(householdService.householdSize(pageSize, page * pageSize, householdId));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建住户信息
	 * @param householdEntity
	 * @return
	 */
	@PostMapping("/households/household")
	public HouseholdEntity insertMenu(@RequestBody HouseholdEntity householdEntity) {
		householdService.insertHousehold(householdEntity);
		log.debug("The method is ending");
		return householdEntity;
	}

	/**
	 * 修改住户信息
	 *
	 * @param householdEntity
	 * @param id
	 * @return
	 */
	@PutMapping("/households/{id}")
	public HouseholdEntity updateHousehold(@RequestBody HouseholdEntity householdEntity, @PathVariable int id) {
		if (householdEntity.getId() == id) {
			householdService.updateHousehold(householdEntity);
		}
		log.debug("The method is ending");
		return householdEntity;
	}

	/**
	 * 删除住户信息
	 *
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/households")
	public List<String> deleteMenus(@RequestBody List<String> groupId) {
		householdService.deleteHouseholds(groupId);
		return groupId;
	}

}
