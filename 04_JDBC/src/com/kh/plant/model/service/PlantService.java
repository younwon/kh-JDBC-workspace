package com.kh.plant.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.JdbcTemplate;
import static com.kh.common.Template.getSqlSession;
import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		
		SqlSession session = getSqlSession();
		
		int result = new PlantDao().save(session, hpd);
		
		session.close();
		
		return result;
	}
	
	public List<HousePlantDto> read() {
		
		SqlSession session = getSqlSession();
		
		List<HousePlantDto> plants = new PlantDao().read(session);
		
		session.close();
		
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
