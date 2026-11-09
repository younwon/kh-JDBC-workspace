package com.kh.snackfood.controller;

import java.util.List;
import java.util.Map;

import com.kh.snackfood.model.dto.SnackFoodDto;
import com.kh.snackfood.model.service.FoodService;

public class FoodController {
	private FoodService fs = new FoodService();
	
	public List<SnackFoodDto> selectFoodList() {
		return fs.selectFoodList();
	}
	
	public List<SnackFoodDto> selectByCondition(Map<String, String> arguments) {
		return fs.selectByCondition(arguments);
	}
}
