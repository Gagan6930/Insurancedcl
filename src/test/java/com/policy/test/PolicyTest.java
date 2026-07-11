package com.policy.test;

import java.util.List;
import java.util.Scanner;

import com.policy.dao.PolicyDao;
import com.policy.daoimpl.PolicyDaoImpl;
import com.policy.dto.Policie;

public class PolicyTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Policie p = new Policie();
		PolicyDao pdao = new PolicyDaoImpl();

		// 1.addpolicy
		System.out.println("enter the category id:");
		p.setCategory_id(sc.nextInt());

		System.out.println("enter the policy name:");
		p.setPolicy_name(sc.next());

		System.out.println("enter the premium amount:");
		p.setPremium_amount(sc.nextDouble());

		System.out.println("enter the coverage amount:");
		p.setCoveage_amount(sc.nextDouble());

		System.out.println("enter the duration in months:");
		p.setDuration_months(sc.nextInt());

		System.out.println("enter the description:");
		p.setDescription(sc.next());

		System.out.println("enter the status (ACTIVE/INACTIVE):");
		p.setStatus(sc.next());

		pdao.addpolicy(p);
		System.out.println("data added successfully");

		// 2.findbyId
//		System.out.println("enter the policy id");
//		Policie p1 = pdao.findbyId(sc.nextInt());
//		System.out.println(p1);

		// 3.findall
//		List<Policie> res = pdao.findall();
//		for (Policie p2 : res) {
//			System.out.println(p2);
//		}

		// 4.getPoliciesByCategory
//		System.out.println("enter the category id");
//		List<Policie> res = pdao.getPoliciesByCategory(sc.nextInt());
//		for (Policie p2 : res) {
//			System.out.println(p2);
//		}

		// 5.updatepolicy
//		System.out.println("enter the policy id:");
//		Integer id = sc.nextInt();
//
//		Policie p1 = pdao.findbyId(id);
//
//		System.out.println("before update");
//		System.out.println(p1);
//
//		System.out.println("enter the field to be updated");
//		System.out.println("1.policy name");
//		System.out.println("2.premium amount");
//		System.out.println("3.coverage amount");
//		System.out.println("4.duration months");
//		System.out.println("5.description");
//		System.out.println("6.status");
//
//		Integer choice = sc.nextInt();
//		switch (choice) {
//
//		case 1:
//			System.out.println("enter the policy name to be updated");
//			p1.setPolicy_name(sc.next());
//			break;
//
//		case 2:
//			System.out.println("enter the premium amount to be updated");
//			p1.setPremium_amount(sc.nextDouble());
//			break;
//
//		case 3:
//			System.out.println("enter the coverage amount to be updated");
//			p1.setCoveage_amount(sc.nextDouble());
//			break;
//
//		case 4:
//			System.out.println("enter the duration months to be updated");
//			p1.setDuration_months(sc.nextInt());
//			break;
//
//		case 5:
//			System.out.println("enter the description to be updated");
//			p1.setDescription(sc.next());
//			break;
//
//		case 6:
//			System.out.println("enter the status to be updated");
//			p1.setStatus(sc.next());
//			break;
//
//		default:
//			System.out.println("invalid choice");
//			return;
//		}
//
//		pdao.updatepolicy(p1);
//
//		Policie p5 = pdao.findbyId(id);
//
//		System.out.println("data modified");
//		System.out.println("after update");
//		System.out.println(p5);

		// 6.deleteploicy
//		System.out.println("enter the id to delete");
//		pdao.deleteploicy(sc.nextInt());
	}
}
