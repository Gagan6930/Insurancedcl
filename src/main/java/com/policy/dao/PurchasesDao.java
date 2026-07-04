package com.policy.dao;

import java.util.List;

import com.policy.dto.Purchase;

public interface PurchasesDao {
	boolean purchasePolicy(Purchase purchase);

	Purchase findpurchasebyId(Integer purchaseId);

	List<Purchase> findpurchaseByUser(Integer UserId);

	List<Purchase> findAll();

	boolean Updatepurchase(Integer purchaseId, String status);

	boolean deletepurchase(Integer purchaseId);
}
