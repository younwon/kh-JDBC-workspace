package com.kh.plant.model.service;

import java.util.List;

import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		return new PlantDao().save(hpd);
	}
	
	public List<HousePlantDto> read() {
		return new PlantDao().read();
	}
	
	public int edit(HousePlantDto hpd) {
		return new PlantDao().edit(hpd);
	}
	
	public int remove(int plantNo) {
		
		if (plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다");
		}
		
		return new PlantDao().remove(plantNo);
	}
	
	public HousePlantDto oneRead(int plantNo) {
		
		return new PlantDao().oneRead(plantNo);
	}
	
	public List<HousePlantDto> search(String keyword) {
		return new PlantDao().search(keyword);
	}
}
