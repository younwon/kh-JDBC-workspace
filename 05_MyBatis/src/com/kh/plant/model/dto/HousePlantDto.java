package com.kh.plant.model.dto;

public class HousePlantDto {
	private int number;
	private String type;
	private String name;
	
	public HousePlantDto() {}
	public HousePlantDto(String type, String name) {
		this.type = type;
		this.name = name;
	}
	public HousePlantDto(int number, String type, String name) {
		super();
		this.number = number;
		this.type = type;
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	
	@Override
	public String toString() {
		return "HousePlantDto [number=" + number + ", type=" + type + ", name=" + name + "]";
	}
	
	
}
