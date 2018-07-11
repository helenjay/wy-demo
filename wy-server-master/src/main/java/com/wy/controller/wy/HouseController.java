package com.wy.controller.wy;

import com.wy.model.sys.Households;
import com.wy.model.sys.Houses;
import com.wy.model.sys.PageResult;
import com.wy.service.wy.HouseService;
import com.wy.utils.BaseResponseInfo;
import com.wy.utils.ConstantData;
import com.wy.utils.HTTPStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房屋管理
 */
@RestController
public class HouseController {

	private Logger log = LoggerFactory.getLogger(HouseController.class);

	@Resource(name = "houseServiceImpl")
	private HouseService houseService;

//	/**
//	 * 根据住户姓名查询
//	 *
//	 * @param householdName
//	 * @return
//	 */
//	@GetMapping("/houseByName/")
//	public List<Houses> getHouseholdByName(@RequestParam("householdName") String householdName) {
//		List<Houses> householdList = houseService.houseList(10,0,null,householdName,null);
//		return householdList;
//	}
//
//	/**
//	 * 根据住户房号查询
//	 *
//	 * @param houseNo
//	 * @return
//	 */
//	@GetMapping("/houseByNo/")
//	public List<Houses> getHouseholdByNo(@RequestParam("houseNo") String houseNo) {
//		List<Houses> householdList = houseService.houseList(10,0,null,null,houseNo);
//		return householdList;
//	}

	/**
	 * 根据房屋id查询
	 *
	 * @param householdId
	 * @return
	 */
//	@GetMapping("/houseById/")
//	public Houses getHouseholdById(@RequestParam("householdId") String householdId) {
//		List<Houses> householdList = houseService.houseList(10,0,householdId,null,null);
//		return (householdList != null && householdList.size() > 0 ) ? householdList.get(0) : null;
//	}

	/**
	 * 获取房屋表数据
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 */
//	@GetMapping("/houses")
//	public PageResult householdList(int pageSize, int page, String householdId, String householdName, String houseNo) {
//		PageResult pageResult = new PageResult();
//		pageResult.setData(houseService.houseList(pageSize, page * pageSize, householdId,householdName,houseNo));
//		pageResult.setTotalCount(houseService.houseSize(householdId,householdName,houseNo));
//		log.debug("The method is ending");
//		return pageResult;
//	}

	/**
	 * 新建房屋信息
	 * @param houseEntity
	 * @return
	 */
	@PostMapping("/houses/house")
	public Houses insertMenu(@RequestBody Houses houseEntity) {
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
	public Houses updateMenu(@RequestBody Houses houseEntity, @PathVariable int id) {
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
	public Integer deleteMenus(@RequestBody Integer groupId) {
		houseService.deleteHouses(groupId);
		return groupId;
	}

	/**
	 * 添加房屋信息（无登录验证）
	 * @param houseEntity
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save_house")
	public BaseResponseInfo saveHouse(@RequestBody Houses houseEntity) {
		BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			houseService.insertHouse(houseEntity);
			baseResponseInfo.code = HTTPStatus.OK;
			data.put("message", ConstantData.MSG_SUCCESS_INFO);
		} catch (Exception ex){
			ex.printStackTrace();
			baseResponseInfo.code = HTTPStatus.INTERNAL_SERVER_ERROR;
		}
		baseResponseInfo.data = data;
		return baseResponseInfo;
	}


	/**
	 * 查询房屋信息（无验证）
	 * @param pageSize
	 * @param start
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("/get_house_list")
	public BaseResponseInfo getHouseholdList(@RequestParam("pageSize") int pageSize, @RequestParam("start")int start) {
		BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			data.put("houses", houseService.houseList(pageSize, (start -1)* pageSize));
			data.put("count", houseService.houseSize(pageSize, (start -1) * pageSize));
			baseResponseInfo.code = HTTPStatus.OK;
			data.put("message", ConstantData.MSG_SUCCESS_INFO);
		}catch(Exception ex){
			ex.printStackTrace();
			baseResponseInfo.code = HTTPStatus.INTERNAL_SERVER_ERROR;
		}
		baseResponseInfo.data = data;
		return baseResponseInfo;
	}
}
