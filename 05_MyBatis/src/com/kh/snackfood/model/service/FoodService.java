package com.kh.snackfood.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.snackfood.model.dao.FoodDao;

public class FoodService {
	private FoodDao fd = new FoodDao();
	
	public void selectFoodList() {
		SqlSession session = Template.getSqlSession();
	}
}
