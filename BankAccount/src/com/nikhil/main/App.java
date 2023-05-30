package com.nikhil.main;

import java.util.Scanner;

import com.nikhil.banking.Bank;
import com.nikhil.banking.UserAccount;

public class App {
	public static void main(String[] args) {

		System.out.println("please enter the name of the user: ");
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
		UserAccount user1 = new UserAccount(userName);
		Bank bank = new Bank(user1);

		extracted(bank);

		System.out.println("closing the application");
		scan.close();

	}

	private static void extracted(Bank bank) {
		boolean IsanotherTransaction = false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("What do you want to do today? enter " + "1:check Balance; " + "2:deposit Money; "
					+ "3:withdraw Money");
			int choice = scan.nextInt();
			if (choice == 1) {
				bank.checkAmount();
			} else if (choice == 2) {
				bank.addMoney();

			} else if (choice == 3) {
				bank.withDrayMoney();
			} else {
				System.out.println("You have entered an invalid choice");
			}

			System.out.println("do you have another transaction? [y/n]");
			String again = scan.next();

			if (again.equalsIgnoreCase("y")) {
				IsanotherTransaction = true;
			} else {
				IsanotherTransaction = false;
			}

		} while (IsanotherTransaction);

		scan.close();
	}
}
