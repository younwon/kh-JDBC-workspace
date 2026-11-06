package com.kh.snackfood.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SnackFoodDto {
	private Long foodNo;
	private String foodName;
	private Integer price;
	private String category;
	private List<FoodReviewDto> reviews = new ArrayList<FoodReviewDto>();
	
	
	public SnackFoodDto() { }
	public SnackFoodDto(Long foodNo, String foodName, Integer price, String category) {
		super();
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.price = price;
		this.category = category;
	}

	public Long getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(Long foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public List<FoodReviewDto> getReviews() {
		return reviews;
	}
	public void setReviews(List<FoodReviewDto> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "SnackFoodDto [foodNo=" + foodNo + ", foodName=" + foodName + ", price=" + price + ", category="
				+ category + "]";
	}
	
	
	
	
}
