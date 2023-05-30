package com.nikhil.banking;

import java.util.Scanner;

public class Bank {
//	private static String name;
//	private List<String> users;
//	private Map<String, Integer> bankUserData;
	private UserAccount user;
	public Bank(UserAccount user) {
		this.user = user;
	}

	private boolean isUserLogedIn() {
		try (Scanner scan = new Scanner(System.in)) {
			for (int i = 0; i < 3; i++) {
				System.out.println("please confirm the username ");
				String enteredUsername = scan.nextLine();
				System.out.println("please enter the password ");
				String enteredPassword = scan.nextLine();
				if (enteredUsername.equals(user.getUserName()) && enteredPassword.equals(user.getPassword())) {
					return true;
				} else {
					System.out.println("incorrect password, try again");
				}
			}
			System.out.println("Out of attempts");
			scan.close();
		}
		return false;

	}

	public void addMoney() {
		if (isUserLogedIn()) {
			System.out.println("Enter the amount you want to add ");
			Scanner scan = new Scanner(System.in);
			Integer amount = Integer.parseInt(scan.nextLine());
			user.userAddMoney(amount);
			System.out.println("Amount added successfully");
			scan.close();
		}

	}

	public void withDrayMoney() {
		if (isUserLogedIn()) {
			System.out.println("Enter the amount you want to withdraw ");
			Scanner scan = new Scanner(System.in);
			Integer amount = Integer.parseInt(scan.nextLine());
			user.userWithdrawMoney(amount);
			System.out.println("Amount withdrawn successfully");
			scan.close();
		}

	}

	public void checkAmount() {
		if (isUserLogedIn()) {
			System.out.println("The current amount is " + user.getCurrentAmount());
		}
	}
}
