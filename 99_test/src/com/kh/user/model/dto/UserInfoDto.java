package com.kh.user.model.dto;

public class UserInfoDto {
	private int number;
	private String name;
	private String gender;
	
	public UserInfoDto() {
		super();
	}
	
	
	public UserInfoDto(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}


	public UserInfoDto(int number, String name, String gender) {
		super();
		this.number = number;
		this.name = name;
		this.gender = gender;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "UserInfoDto [number=" + number + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
	
	

}
