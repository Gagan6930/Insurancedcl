package com.policy.dto;

public class Purchases {
	private Integer purchase_id;
	private Integer user_id;
	private Integer policy_id;
	private String purchase_date;
	private String expiry_date;
	private String status;

	public Integer getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(Integer purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(Integer policy_id) {
		this.policy_id = policy_id;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
