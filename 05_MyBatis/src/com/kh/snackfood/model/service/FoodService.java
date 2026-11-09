package com.kh.snackfood.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.snackfood.model.dao.FoodDao;
import com.kh.snackfood.model.dto.SnackFoodDto;

public class FoodService {
	private FoodDao fd = new FoodDao();
	
	public List<SnackFoodDto> selectFoodList() {
		SqlSession session = Template.getSqlSession();
		List<SnackFoodDto> foods = fd.selectFoodList(session);
		session.close();
		return foods;
		
	}
	
	public List<SnackFoodDto> selectByCondition(Map<String, String> aguments) {
		SqlSession session = Template.getSqlSession();
		List<SnackFoodDto> foods = fd.selectByCondition(session, aguments);
		session.close();
		return foods;
	}
}
