package com.wy.model.sys;

import java.util.Date;

public class Buildings {
    private Integer id;

    private Integer projectId;

    private String villageCode;

    private String buildingCode;

    private String buildingName;

    private Integer floorTotal;

    private Integer houseTotal;

    private Short coordType;

    private String note;

    private Double lon;

    private Double lat;

    private Date rowTime;

    private Date mrowTime;

    private String architecturalAge;

    private String propertyRights;

    private String buildingLevel;

    private String hasLeft;

    private String image1;

    private Integer ext1;

    private Integer ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    private String ext6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode == null ? null : villageCode.trim();
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getFloorTotal() {
        return floorTotal;
    }

    public void setFloorTotal(Integer floorTotal) {
        this.floorTotal = floorTotal;
    }

    public Integer getHouseTotal() {
        return houseTotal;
    }

    public void setHouseTotal(Integer houseTotal) {
        this.houseTotal = houseTotal;
    }

    public Short getCoordType() {
        return coordType;
    }

    public void setCoordType(Short coordType) {
        this.coordType = coordType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Date getRowTime() {
        return rowTime;
    }

    public void setRowTime(Date rowTime) {
        this.rowTime = rowTime;
    }

    public Date getMrowTime() {
        return mrowTime;
    }

    public void setMrowTime(Date mrowTime) {
        this.mrowTime = mrowTime;
    }

    public String getArchitecturalAge() {
        return architecturalAge;
    }

    public void setArchitecturalAge(String architecturalAge) {
        this.architecturalAge = architecturalAge == null ? null : architecturalAge.trim();
    }

    public String getPropertyRights() {
        return propertyRights;
    }

    public void setPropertyRights(String propertyRights) {
        this.propertyRights = propertyRights == null ? null : propertyRights.trim();
    }

    public String getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(String buildingLevel) {
        this.buildingLevel = buildingLevel == null ? null : buildingLevel.trim();
    }

    public String getHasLeft() {
        return hasLeft;
    }

    public void setHasLeft(String hasLeft) {
        this.hasLeft = hasLeft == null ? null : hasLeft.trim();
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public Integer getExt2() {
        return ext2;
    }

    public void setExt2(Integer ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6 == null ? null : ext6.trim();
    }
}