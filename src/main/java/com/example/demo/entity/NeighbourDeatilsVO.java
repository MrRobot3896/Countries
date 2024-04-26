package com.example.demo.entity;

public class NeighbourDeatilsVO {
	
	
	private String name;
	private Boolean commonLanguage;
	private Boolean commonside;
	private Double distance;
	private String parentCountryName;
	
	public NeighbourDeatilsVO(String name, Boolean commonLanguage, Boolean commonside, Double distance,
			String parentCountryName) {
		this.name = name;
		this.commonLanguage = commonLanguage;
		this.commonside = commonside;
		this.distance = distance;
		this.parentCountryName = parentCountryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getCommonLanguage() {
		return commonLanguage;
	}
	public void setCommonLanguage(Boolean commonLanguage) {
		this.commonLanguage = commonLanguage;
	}
	public Boolean getCommonside() {
		return commonside;
	}
	public void setCommonside(Boolean commonside) {
		this.commonside = commonside;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getParentCountryName() {
		return parentCountryName;
	}
	public void setParentCountryName(String parentCountryName) {
		this.parentCountryName = parentCountryName;
	}
	
	

}
