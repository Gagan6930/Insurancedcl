package com.policy.test;

import java.util.List;
import java.util.Scanner;

import com.policy.dao.PurchasesDao;
import com.policy.daoimpl.PurchasesDaoImpl;
import com.policy.dto.Purchase;

public class PurchaseTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Purchase pu = new Purchase();
		PurchasesDao pudao = new PurchasesDaoImpl();

		// 1.purchasePolicy
		System.out.println("enter the user id:");
		pu.setUser_id(sc.nextInt());

		System.out.println("enter the policy id:");
		pu.setPolicy_id(sc.nextInt());

		System.out.println("enter the purchase date (yyyy-mm-dd):");
		pu.setPurchase_date(sc.next());

		System.out.println("enter the expiry date (yyyy-mm-dd):");
		pu.setExpiry_date(sc.next());

		System.out.println("enter the status (ACTIVE/EXPIRED/CANCELLED):");
		pu.setStatus(sc.next());

		pudao.purchasePolicy(pu);
		System.out.println("data added successfully");

		// 2.findpurchasebyId
//		System.out.println("enter the purchase id");
//		Purchase p1 = pudao.findpurchasebyId(sc.nextInt());
//		System.out.println(p1);

		// 3.findpurchaseByUser
//		System.out.println("enter the user id");
//		List<Purchase> res = pudao.findpurchaseByUser(sc.nextInt());
//		for (Purchase p2 : res) {
//			System.out.println(p2);
//		}

		// 4.findAll
//		List<Purchase> res = pudao.findAll();
//		for (Purchase p2 : res) {
//			System.out.println(p2);
//		}

		// 5.Updatepurchase
//		System.out.println("enter the purchase id:");
//		Integer id = sc.nextInt();
//
//		System.out.println("enter the new status (ACTIVE/EXPIRED/CANCELLED):");
//		String status = sc.next();
//
//		pudao.Updatepurchase(id, status);
//
//		Purchase p5 = pudao.findpurchasebyId(id);
//
//		System.out.println("data modified");
//		System.out.println("after update");
//		System.out.println(p5);

		// 6.deletepurchase
//		System.out.println("enter the id to delete");
//		pudao.deletepurchase(sc.nextInt());
	}
}
