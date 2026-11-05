package com.kh.plant.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.plant.model.dto.HousePlantDto;

/*
 * DAO
 * DB에 직접 접근해서 SQL문들 실행 후 결과 받아오는 메소들을 선언
 * 
 * 하나의 메소드는 하나의 SQL문
 * ------------------------------------------------------
 * PreparedStatement : SQL문을 미리 전달하는 개념
 * 					   미완성된 SQL문을 미리 전달한 뒤 실행하기 전
 * 					   실제 값을 Bind해서 실행함(Binding)
 * 					   전달 시 SQL문에 사용자가 입력한 값이 들어갈 수 있도록 공간확보를 해놓음 ==> ? (placeholder)
 * 
 * - 차이점
 * 1) Statement => 완성된 SQL문 / PreparedStatement => 미완성된 SQL문
 * 2) conn.createStatement() / conn.prepareStatement(SQL문) <--미리 SQL문을 인자로 전달하는게 핵심!!
 * 3) stmt.executeXXX(SQL문) / pstmt.executeXXX()
 * 
 * ?에 실제 값을 Binding 해준 뒤 실행한다
 * setString(홀더순번, 넣을 값) => '값' (양옆에 홑따옴표를 감싼 상태로 알아서 Bind)
 * setInt(홀더순번, 값) => 값 (알아서 잘들어 감)
 * 
 * PreparedStatement가 Statement보다 좋은점
 * 1. 구문분석 및 컴파일 최적화에 유리
 * Statement는 매 번 SQL문을 파싱하고 실행하는데
 * PreparedStatement는 SQL쿼리를 최최 1회만 파싱하고 실행계획을 캐싱(메모리에 올림)
 * 재사용적인 측면에서 효율적
 * 
 * 2. DB서버에 대한 트래픽 감소
 * 쿼리자체는 한 번만 전송하고 이후에는 바인딩할 값만 보내기 때문에
 * 동일 쿼리를 반복 실행할 때, 인기많은 애플리케이션일 때 더욱더 효율적임
 * DB의 작업 -> 실행 게획 세울 때 리소스를 많이 잡아먹음
 * 
 * 3. PreparedStatement는 SQL인젝션 방지 => 보안적인 측면이 좋음
 */
public class PlantDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save(Connection conn, HousePlantDto hpd) {
		int result = 0;
		String sql = """
						INSERT
						  INTO
						  	   HOUSEPLANT
						VALUES
							   (
							   SEQ_PLANT_NO.NEXTVAL
							 , ?
							 , ?
							   )
					 """;
		
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
		String sql = """
						SELECT
							   PLANT_NO
							 , PLANT_NAME
							 , PLANT_TYPE
						  FROM
						 	   HOUSEPLANT
						 ORDER
							BY
							   PLANT_NO DESC
					 """;
		
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
		
		String sql = """
						UPDATE
							   HOUSEPLANT
						   SET
						   	   PLANT_NAME = ?
						   	 , PLANT_TYPE = ?
						 WHERE
						 	   PLANT_NO = ?
					 """;
		
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
		String sql = """
						DELETE
						  FROM
						  	   HOUSEPLANT
						 WHERE
						 	   PLANT_NO = ?
					 """;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, plantNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}



