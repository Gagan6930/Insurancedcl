package com.policy.test;

import java.util.List;
import java.util.Scanner;

import com.policy.dao.UserDAO;
import com.policy.daoimpl.UserDAOImpl;
import com.policy.dto.User;

public class UserTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		UserDAO udao = new UserDAOImpl();

		// 1.registerUser
//		System.out.println("enter the full name:");
//		u.setFull_name(sc.next());
//
//		System.out.println("enter the email:");
//		u.setEmail(sc.next());
//
//		System.out.println("enter the password:");
//		u.setPassword(sc.next());
//
//		System.out.println("enter the role (ADMIN/CUSTOMER):");
//		u.setRole(sc.next());
//
//		udao.registerUser(u);
//		System.out.println("data added successfully");

		// 2.getUserById
//		System.out.println("enter the user id");
//		User u1 = udao.getUserById(sc.nextInt());
//		System.out.println(u1);

		// 3.getAllUsers
//		List<User> res = udao.getAllUsers();
//		for (User u2 : res) {
//			System.out.println(u2);
//		}

		// 4.loginUser
		System.out.println("enter mail and password");
		User u1 = udao.loginUser(sc.next(), sc.next());

		if (u1 != null) {
			System.out.println("Login Successful");
			System.out.println(u1);
		} else {
			System.out.println("Invalid Mail or Password");
		}

		// 5.updateUser
//		System.out.println("enter the user id:");
//		Integer id = sc.nextInt();
//
//		User u1 = udao.getUserById(id);
//
//		System.out.println("before update");
//		System.out.println(u1);
//
//		System.out.println("enter the field to be updated");
//		System.out.println("1.full name");
//		System.out.println("2.email");
//		System.out.println("3.password");
//		System.out.println("4.role");
//
//		Integer choice = sc.nextInt();
//		switch (choice) {
//
//		case 1:
//			System.out.println("enter the name to be updated");
//			u1.setFull_name(sc.next());
//			break;
//
//		case 2:
//			System.out.println("enter the email to be updated");
//			u1.setEmail(sc.next());
//			break;
//
//		case 3:
//			System.out.println("enter the password to be updated");
//			u1.setPassword(sc.next());
//			break;
//
//		case 4:
//			System.out.println("enter the role to be updated");
//			u1.setRole(sc.next());
//			break;
//
//		default:
//			System.out.println("invalid choice");
//			return;
//		}
//
//		udao.updateUser(u1);
//
//		User u5 = udao.getUserById(id);
//
//		System.out.println("data modified");
//		System.out.println("after update");
//		System.out.println(u5);

		// 6.deleteUser
//		System.out.println("enter the id to delete");
//		udao.deleteUser(sc.nextInt());
	}
}
