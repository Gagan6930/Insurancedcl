package com.policy.dao;

import java.util.List;

import com.policy.dto.Policie;

public interface PolicyDao {
	boolean addpolicy(Policie policy);

	boolean updatepolicy(Policie policy);

	boolean deleteploicy(Integer policyId);

	Policie findbyId(Integer policyid);

	List<Policie> findall();

	List<Policie> getPoliciesByCategory(Integer catogeryId);

}
