package com.wy.controller.wy;

import com.wy.model.sys.Households;
import com.wy.model.sys.PageResult;
import com.wy.service.wy.HouseholdService;
import com.wy.utils.BaseResponseInfo;
import com.wy.utils.ConstantData;
import com.wy.utils.HTTPStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Households> getHouseholdByName(@RequestParam("householdName") String householdName) {
		List<Households> householdList = householdService.householdList(10,0,null);
		return householdList;
	}

	/**
	 * 根据住户房号查询
	 *
	 * @param houseNo
	 * @return
	 */
	@GetMapping("/householdByNo/")
	public List<Households> getHouseholdByNo(@RequestParam("houseNo") String houseNo) {
		List<Households> householdList = householdService.householdList(10,0,null);
		return householdList;
	}

	/**
	 * 根据住户id查询
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/householdById/")
	public Households getHouseholdById(@RequestParam("householdId") Integer id) {
		List<Households> householdList = householdService.householdList(10,0,id);
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
		pageResult.setData(householdService.householdList(pageSize, page * pageSize, null));
		pageResult.setTotalCount(householdService.householdSize(pageSize, page * pageSize, null));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建住户信息
	 * @param householdEntity
	 * @return
	 */
	@PostMapping("/households/household")
	public Households insertMenu(@RequestBody Households householdEntity) {
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
	public Households updateHousehold(@RequestBody Households householdEntity, @PathVariable int id) {
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
	public Integer deleteMenus(@RequestBody Integer groupId) {
		householdService.deleteHouseholds(groupId);
		return groupId;
	}

	@ResponseBody
	@GetMapping("/test1")
	public String save() {
		return "hello world!";
	}

	@ResponseBody
	@PostMapping("/save_household")
	public BaseResponseInfo saveHousehold(@RequestBody Households householdEntity) {
		BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			householdEntity.setCreater("admin");
			householdEntity.setCreateTime(new Date());

			//设置房号名称
			String houseNo = householdEntity.getHouseNo();
			if(!StringUtils.isEmpty(houseNo)) {
				String[] houseArray = houseNo.split("-");
				if(houseArray.length !=3){
					householdEntity.setHouseholdName(houseNo);
				}else{
					householdEntity.setHouseholdName(houseArray[0]+"栋"+houseArray[1]+"单元"+houseArray[2]);
					householdEntity.setBuildingCode(houseArray[0]+"-"+houseArray[1]);
				}
			}

			householdEntity.setStatus("1");
			householdService.insertHousehold(householdEntity);
			baseResponseInfo.code = HTTPStatus.OK;
			data.put("message", ConstantData.MSG_SUCCESS_INFO);
		} catch (Exception ex){
			ex.printStackTrace();
			baseResponseInfo.code = HTTPStatus.INTERNAL_SERVER_ERROR;
		}
		baseResponseInfo.data = data;
		return baseResponseInfo;
	}


	@ResponseBody
	@GetMapping("/get_household_list")
	public BaseResponseInfo getHouseholdList(@RequestParam("pageSize") int pageSize, @RequestParam("start")int start, @RequestParam(value = "id",required = false)Integer id) {
		BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			data.put("households", householdService.householdList(pageSize, (start -1)* pageSize, id));
			data.put("count", householdService.householdSize(pageSize, (start -1) * pageSize, id));
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
