package com.kh.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public int save(Connection conn, UserInfoDto uid) {
		int result = 0;
		String sql = """
						INSERT
						  INTO
						  	   USERINFO
						VALUES
							 (
							   SEQ_USER_NO.NEXTVAL
							 , ?
							 , ?
							 ) 
					 """;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, uid.getName());
			pstmt.setString(2, uid.getGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
