package com.example.Bank;

public class Bank {

	private double balance;
	
	public Bank() {
		balance =0.00;
	}
	
	public void deposit(double amt) {
		
		if(amt>0) {
			balance+=amt;
		}
	}
	public void withdraw(double amt) {
		if(amt>0 && amt<=balance) {
			balance-=amt;
		}
	}
	public double showbalance() {
		return balance;
	}
}
