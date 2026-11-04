package com.kh.user.controller;

import com.kh.user.model.dto.UserInfoDto;
import com.kh.user.model.service.UserService;

public class UserController {
	UserService us = new UserService();
	
	public int save(String name, String gender) {
		UserInfoDto uid = new UserInfoDto(name, gender);
		return us.save(uid);
	}
}
