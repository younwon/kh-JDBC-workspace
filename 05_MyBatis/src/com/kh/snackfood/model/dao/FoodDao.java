package com.kh.snackfood.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.snackfood.model.dto.SnackFoodDto;

public class FoodDao {
	
	public List<SnackFoodDto> selectFoodList(SqlSession session) {
		return session.selectList("foodMapper.selectFoodList");
	}
	
	public List<SnackFoodDto> selectByCondition(SqlSession session, Map<String, String>arhuments) {
		return session.selectList("foodMapper.selectByCondition", arhuments);
	}

}
