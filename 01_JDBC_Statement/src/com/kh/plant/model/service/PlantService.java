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
}
