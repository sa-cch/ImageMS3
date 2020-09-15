package domain;

import java.util.Date;

public class Image {

	private Integer id;
	private String imageName;
	private String facilityName;
	private Integer areaTypesId;
	private Integer areaNamesId;
	private String photo;
	private String memo;
	private Date created;
	private String TypeName;
	private String AreaName;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public Integer getAreaTypesId() {
		return areaTypesId;
	}
	public void setAreaTypesId(Integer areaTypesId) {
		this.areaTypesId = areaTypesId;
	}
	public Integer getAreaNamesId() {
		return areaNamesId;
	}
	public void setAreaNamesId(Integer areaNamesId) {
		this.areaNamesId = areaNamesId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public String getAreaName() {
		return AreaName;
	}
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}




}
