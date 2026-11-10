package com.kh.subs.model.dto;

public class SubscriptionDto {
	private Long subNo;
	private String subName;
	private Integer monthlyFee;
	private Integer paymentDay;
	private String category;
	
	public SubscriptionDto() {
		super();
	}

	public SubscriptionDto(String subName, Integer monthlyFee, Integer paymentDay, String category) {
		super();
		this.subName = subName;
		this.monthlyFee = monthlyFee;
		this.paymentDay = paymentDay;
		this.category = category;
	}

	public SubscriptionDto(Long subNo, String subName, Integer monthlyFee, Integer paymentDay, String category) {
		super();
		this.subNo = subNo;
		this.subName = subName;
		this.monthlyFee = monthlyFee;
		this.paymentDay = paymentDay;
		this.category = category;
	}

	public Long getSubNo() {
		return subNo;
	}

	public void setSubNo(Long subNo) {
		this.subNo = subNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Integer getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(Integer monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public Integer getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(Integer paymentDay) {
		this.paymentDay = paymentDay;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubscriptionDto [subNo=" + subNo + ", subName=" + subName + ", monthlyFee=" + monthlyFee
				+ ", paymentDay=" + paymentDay + ", category=" + category + "]";
	}
	
	
	

}
