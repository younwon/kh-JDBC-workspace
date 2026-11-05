package com.kh.plant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {
	private Properties prop = new Properties();
	
	public PlantDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save(Connection conn, HousePlantDto hpd) {
		int result = 0;
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("save"));
		
		String sql = prop.getProperty("save");
		
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, hpd.getType());
			pstmt.setString(2, hpd.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<HousePlantDto> read(Connection conn) {
		List<HousePlantDto> plants = new ArrayList<HousePlantDto>();
		
		//메소드를 호출할 때 마다 XML파일로부터 Properties객체로 입력받는 코드를 작성해야함
		//기본생성자에 만들어놓고 service에서 객체를 생성할때 실행되도록 하자
		
		String sql = prop.getProperty("read");
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery()) {
			
			while (rset.next()) {
				plants.add(new HousePlantDto(rset.getInt("PLANT_NO")
											,rset.getString("PLANT_TYPE")
											,rset.getString("PLANT_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plants;
	}
	
	public int edit(Connection conn, HousePlantDto hpd) {
		int result = 0;
		
		String sql = prop.getProperty("edit");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, hpd.getName());
			pstmt.setString(2, hpd.getType());
			pstmt.setInt(3, hpd.getNumber());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int remove(Connection conn, int plantNo) {
		int result = 0;
		String sql = prop.getProperty("remove");
				
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, plantNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}



