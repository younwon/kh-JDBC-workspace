package com.kh.snackfood.controller;

import com.kh.snackfood.model.service.FoodService;

public class FoodController {
	private FoodService fs = new FoodService();
	
	public void selectFoodList() {
		fs.selectFoodList();
	}
}
