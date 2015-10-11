package com.jar.domain;

public class Customer {

	private String id;
	private String name;
	private String charger;
	private String type;
	private String cellphone;
	private String level;
	private String introduction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
