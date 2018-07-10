package com.wy.model.sys;

/**
 * 住户表
 */
public class HouseholdEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 房屋id
	 */
	private int houseId;
	/**
	 * 住户姓名
	 */
	private String householdName;
	/**
	 * 住户性别
	 */
	private String sex;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 身份类型1:业主,2家属
	 */
	private String identityType;
	/**
	 * 工作单位
	 */
	private String company;
	/**
	 * 工作部门
	 */
	private String department;
	/**
	 * 证件类型
	 */
	private String cardType;
	/**
	 * 证件号码
	 */
	private String cardNo;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 修改时间
	 */
	private String modifyTime;
	/**
	 * 认证状态
	 */
	private String authStatus;
	/**
	 * 身份证正面照片
	 */
	private String idCardImage1;
	/**
	 * 身份证反面照片
	 */
	private String idCardImage2;
	/**
	 * 当前照片
	 */
	private String currentImage;
	/**
	 * 户籍地址
	 */
	private String address;
	/**
	 * 数据状态,有效,无效
	 */
	private String status;

	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;

	private String houseNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getIdCardImage1() {
		return idCardImage1;
	}

	public void setIdCardImage1(String idCardImage1) {
		this.idCardImage1 = idCardImage1;
	}

	public String getIdCardImage2() {
		return idCardImage2;
	}

	public void setIdCardImage2(String idCardImage2) {
		this.idCardImage2 = idCardImage2;
	}

	public String getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(String currentImage) {
		this.currentImage = currentImage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHouseholdName() {
		return householdName;
	}

	public void setHouseholdName(String householdName) {
		this.householdName = householdName;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
}
