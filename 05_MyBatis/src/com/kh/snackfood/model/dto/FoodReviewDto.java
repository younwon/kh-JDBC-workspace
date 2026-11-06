package com.kh.snackfood.model.dto;

import java.sql.Date;

public class FoodReviewDto {
	private Long reviewNo;
	private String reviewWriter;
	private String reviewContent;
	private Long foodNo;
	private Integer rating;
	private Date createDate;
	private String deleteYn;
	
	public FoodReviewDto() { }

	public FoodReviewDto(Long reviewNo, String reviewWriter, String reviewContent, Long foodNo, Integer rating,
			Date createDate, String deleteYn) {
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.foodNo = foodNo;
		this.rating = rating;
		this.createDate = createDate;
		this.deleteYn = deleteYn;
	}

	public Long getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(Long reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Long getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(Long foodNo) {
		this.foodNo = foodNo;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "FoodReviewDto [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", reviewContent="
				+ reviewContent + ", foodNo=" + foodNo + ", rating=" + rating + ", createDate=" + createDate
				+ ", deleteYn=" + deleteYn + "]";
	}
	
	
	
	
}
