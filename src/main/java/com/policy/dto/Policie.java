package com.policy.dto;

public class Policie {
	private Integer policy_id;
	private Integer category_id;
	private String policy_name;
	private Double premium_amount;
	private Double coveage_amount;
	private Integer duration_months;
	private String description;
	private String status;

	public Integer getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(Integer policy_id) {
		this.policy_id = policy_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public Double getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(Double premium_amount) {
		this.premium_amount = premium_amount;
	}

	public Double getCoveage_amount() {
		return coveage_amount;
	}

	public void setCoveage_amount(Double coveage_amount) {
		this.coveage_amount = coveage_amount;
	}

	public Integer getDuration_months() {
		return duration_months;
	}

	public void setDuration_months(Integer duration_months) {
		this.duration_months = duration_months;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
