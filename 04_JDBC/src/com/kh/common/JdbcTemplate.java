package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class JdbcTemplate {
	/*
	 * JDBC과정에서 사용되는 반복적으로 작성해야하는 코드
	 * 메소드로 분리할 클래스
	 */
	
	public static Connection getConnection() {
		
		try {
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("resources/connection.properties"));
			
			System.out.println(prop.getProperty("URL"));
			
			//프로그램이 실행되고 있어도 property를 수정할수있게 된다
			//조회 요청이 오면 그때마다 외부에서 입력받기때문에
			Connection conn = DriverManager.getConnection(prop.getProperty("URL")
														 ,prop.getProperty("USERNAME")
														 ,prop.getProperty("PASSWORD"));
			
			
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
