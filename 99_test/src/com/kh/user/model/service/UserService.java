package com.kh.user.model.service;

import com.kh.user.model.dao.UserDao;
import com.kh.user.model.dto.UserInfoDto;

public class UserService {
	
	public int save(UserInfoDto uid) {
		return new UserDao().save(uid);
	}

}
