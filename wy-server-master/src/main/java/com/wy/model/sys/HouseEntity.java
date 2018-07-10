package com.wy.model.sys;

/**
 * 房屋表
 */
public class HouseEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 楼栋id
	 */
	private int buildId;
	/**
	 * 房屋编码
	 */
	private String houseCode;
	/**
	 * 房号名称
	 */
	private String houseName;
	/**
	 * 房屋等级:高层，小高层，多层，独栋，联排
	 */
	private String houseLevel;
	/**
	 * 房屋面积
	 */
	private String houseArea;
	/**
	 * 户型
	 */
	private String houseType;
	/**
	 * 朝向
	 */
	private String face;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseLevel() {
		return houseLevel;
	}

	public void setHouseLevel(String houseLevel) {
		this.houseLevel = houseLevel;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}
}
