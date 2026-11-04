package com.kh.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.user.model.dto.UserInfoDto;

public class UserDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int save(UserInfoDto uid) {
		int result = 0;
		
		String sql = "INSERT "
					+"  INTO "
					+		 "USERINFO "
					+"VALUES "
					+		 "("
					+		 "SEQ_USER_NO.NEXTVAL"
					+		", '" + uid.getName() + "'"
					+		", '" + uid.getGender() + "'"
					+		 ")";

		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stat = conn.createStatement()) {
			
			result = stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
