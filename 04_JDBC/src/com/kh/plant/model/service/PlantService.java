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
		
		validateHousePlant(hpd);
		
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
		
		validateHousePlant(hpd);
		validatePlantNo(hpd.getNumber());
		
		SqlSession session = getSqlSession();
		
		int result = new PlantDao().edit(session, hpd);
		
		session.close();
		
		return result;
	}
	
	public int remove(int plantNo) {
		
		validatePlantNo(plantNo);
		
		SqlSession session = getSqlSession();
		
		int result = new PlantDao().remove(session, plantNo);
		
		session.close();
		
		return result;
	}
	
	public HousePlantDto oneRead(int plantNo) {
		validatePlantNo(plantNo);
		
		SqlSession session = getSqlSession();
		
		HousePlantDto hpd = new PlantDao().oneRead(session, plantNo);
		
		session.close();
		
		return hpd;
		
	}
	
	public List<HousePlantDto> search(String keyword) {
		List<String> badKeywords = List.of("바보", "멍청이", "똥개", "해삼");
		
		if (badKeywords.contains(keyword)) {
			throw new RuntimeException(keyword + "은(는) 부적절한 검색어입니다");
		}
		
		SqlSession session = getSqlSession();
		
		List<HousePlantDto> plants = new PlantDao().search(session, keyword);
		
		session.close();
		
		return plants;
	}
	
	
	
	private void validatePlantNo(int plantNo) {
		if (plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다");
		}
	}
	
	private void validateHousePlant(HousePlantDto hpd) {
		checkNull(hpd);
		checkPlantName(hpd);
		checkPlantType(hpd);
	}
	
	private void checkNull(HousePlantDto hpd) {
		if (hpd == null) {
			throw new RuntimeException("잠시 후 다시 시도해주세요");
		}
	}
	
	private void checkPlantName(HousePlantDto hpd) {
		//trim() : 문자열에 공백 날리기 : 자바6
		//itrim().isEmpty() => isBlank() : 자바11부터
		if(hpd == null || hpd.getName().isBlank() || hpd.getName().length() > 40) {
			throw new RuntimeException("잘못된 입력입니다");
		}
	}
	
	private void checkPlantType(HousePlantDto hpd) {
		if (hpd.getType().isBlank() || hpd.getType().length() > 6) {
			throw new RuntimeException("유효하지 않은 타입 값입니다");
		}
	}
}
