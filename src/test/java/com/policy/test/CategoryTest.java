package com.policy.test;

import java.util.List;
import java.util.Scanner;

import com.policy.dao.Policy_CategorieDAO;
import com.policy.daoimpl.Policy_CategorieDAOImpl;
import com.policy.dto.Policy_Categorie;

public class CategoryTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Policy_Categorie c = new Policy_Categorie();
		Policy_CategorieDAO cdao = new Policy_CategorieDAOImpl();
//
//		// 1.addCategory
//		System.out.println("enter the category name:");
//		c.setCategory_name(sc.next());
//
//		System.out.println("enter the description:");
//		c.setDescription(sc.next());
//
//		cdao.addCategory(c);
//		System.out.println("data added successfully");

		// 2.getCategoryById
//		System.out.println("enter the category id");
//		Policy_Categorie c1 = cdao.getCategoryById(sc.nextInt());
//		System.out.println(c1);

		// 3.getAllCategories
//		List<Policy_Categorie> res = cdao.getAllCategories();
//		for (Policy_Categorie c2 : res) {
//			System.out.println(c2);
//		}

		// 4.updateCategory
//		System.out.println("enter the category id:");
//		Integer id = sc.nextInt();
//
//		Policy_Categorie c1 = cdao.getCategoryById(id);
//
//		System.out.println("before update");
//		System.out.println(c1);
//
//		System.out.println("enter the field to be updated");
//		System.out.println("1.category name");
//		System.out.println("2.description");
//
//		Integer choice = sc.nextInt();
//		switch (choice) {
//
//		case 1:
//			System.out.println("enter the category name to be updated");
//			c1.setCategory_name(sc.next());
//			break;
//
//		case 2:
//			System.out.println("enter the description to be updated");
//			c1.setDescription(sc.next());
//			break;
//
//		default:
//			System.out.println("invalid choice");
//			return;
//		}
//
//		cdao.updateCategory(c1);
//
//		Policy_Categorie c5 = cdao.getCategoryById(id);
//
//		System.out.println("data modified");
//		System.out.println("after update");
//		System.out.println(c5);

		// 5.deleteCategory
//		System.out.println("enter the id to delete");
//		cdao.deleteCategory(sc.nextInt());
	}
}
