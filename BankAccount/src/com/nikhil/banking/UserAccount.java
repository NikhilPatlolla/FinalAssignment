package com.nikhil.banking;

public class UserAccount {
	public String userName;
	public String password;
	private Integer currentAmount = 100;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

	public UserAccount(String userName) {
		this.userName = userName;
		this.password = "userPassword" + this.userName;
	}

	public Integer getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Integer currentAmount) {
		this.currentAmount = currentAmount;
	}

	public int userAddMoney(int amount) {
		if (amount < 0) {
			System.out.println("enter a valid amount");
		}
		currentAmount += amount;
		System.out.println();
		return currentAmount;
	}

	public int userWithdrawMoney(int amount) {
		if (currentAmount < 0) {
			System.out.println("Insufficient balance, please add money to withdraw");
			return currentAmount;
		}
		currentAmount -= amount;
		return currentAmount;
	}

}
