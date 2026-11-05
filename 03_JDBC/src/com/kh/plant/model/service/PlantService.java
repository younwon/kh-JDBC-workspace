package com.kh.plant.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JdbcTemplate;
import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	/*
	 * 비즈니스 로직 작성(의사결정코드) -> 데이터 가공, 중복체크, 연산처리, 암호화..
	 * 트랜잭션 관리, 여러 DAO호출, 예외 처리 및 예외 발생, 보안 및 권한 검사
	 * 
	 */
	
	public int save(HousePlantDto hpd) {
		Connection conn = JdbcTemplate.getConnection();
		int result = new PlantDao().save(conn, hpd);
		// 사용이 끝난 Connection 티입의 객체를 반납
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	public List<HousePlantDto> read() {
		// 커넥션 객체 받아오기
		Connection conn = JdbcTemplate.getConnection();
		// 컨트롤러로부터 잔달받은 인자값과 커넥션 타입의 객체를 DAO로 전달
		List<HousePlantDto> plants = new PlantDao().read(conn);
		JdbcTemplate.close(conn);
		
		return plants;
	}
	
	
	public int edit(HousePlantDto hpd) {
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new PlantDao().edit(conn, hpd);
		
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	public int remove(int plantNo) {
		
		if (plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다");
		}
		
		Connection conn = JdbcTemplate.getConnection();
		int result = new PlantDao().remove(conn, plantNo);
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	public HousePlantDto oneRead(int plantNo) {
		
		return new PlantDao().oneRead(plantNo);
	}
	
	public List<HousePlantDto> search(String keyword) {
		return new PlantDao().search(keyword);
	}
}
