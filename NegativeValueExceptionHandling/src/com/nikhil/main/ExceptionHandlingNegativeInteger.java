package com.nikhil.main;

import java.util.Scanner;

public class ExceptionHandlingNegativeInteger {
	public static void main(String[] args) {
		System.out.println("Please provide an integer value to estimate if it is a negitive number");
		Scanner scan = new Scanner(System.in);

		try {

			Integer value = Integer.parseInt(scan.nextLine());
			if (value >= 0) {
				System.out.println("Value is a positive integer " + value);
			} else {
				throw new IllegalArgumentException("This is a negative number");
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Catch for the exception created "+ e.getClass().getName() +" "+ e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error was caught "+ e.getClass().getName() + " "+ e.getMessage());
		} finally {
			scan.close();
		}

	}
}
