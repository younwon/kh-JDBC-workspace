package com.kh.user.model.service;

import java.sql.Connection;

import com.kh.common.JdbcTemplate;
import com.kh.user.model.dao.UserDao;
import com.kh.user.model.dto.UserInfoDto;

public class UserService {
	
	public int save(UserInfoDto uid) {
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new UserDao().save(conn, uid);
		
		JdbcTemplate.close(conn);
		
		return result;
	}

}
