package com.Assignment2;

import java.util.ArrayList;

class Account{
	String accounttype,address,name;
	long accountnumber,balance;
	
	public Account() {
		super();
	}
	public Account(String accounttype, String address, String name, long accountnumber, long balance) {
		super();
		this.accounttype = accounttype;
		this.address = address;
		this.name = name;
		this.accountnumber = accountnumber;
		this.balance = balance;
	}
	public void addAccount(String accounttype, String address, String name, long accountnumber, long balance) {
		this.accounttype = accounttype;
		this.address = address;
		this.name = name;
		this.accountnumber = accountnumber;
		this.balance = balance;
	}
	public long deposit(long depositamount) {
		return balance=balance+depositamount;
	}
	public long withdraw(long withdrawalamount) {
		return balance=balance-withdrawalamount;
	}
	void show() {
		System.out.println("Account Holder Name : "+name+" ,Account Type : "+accounttype+" ,Address : "+address+" ,Account Number : "
				+accountnumber+" ,Balance : "+balance);
	}
}

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Account> a=new ArrayList();
		Account ac1=new Account("Savings","Mount Poonamalle","Ramesh",33445566,30000);
		Account ac2=new Account("Current","AnnaNaar","Rajesh",22889911,50000);
		a.add(ac1);
		a.add(ac2);
		Account a3=new Account();
		a3.addAccount("Current","Tambram","Santosh",90903344,50000);
		a.add(a3);
		Account a4=new Account();
		a4.addAccount("Savings","Avadi","Diwakar",55773322,54000);
		a.add(a4);
		System.out.println("Initial Account Details :");
		a4.show();
		a4.withdraw(4000);
		System.out.println("After withdraw :");
		a4.show();
		Account a5=new Account();
		a5.addAccount("Savings","Avadi","Preet",99880044,45000);
		a.add(a5);
		System.out.println("Initial Account Details :");
		a5.show();
		a5.deposit(5000);
		System.out.println("After Deposit :");
		a5.show();
		a.remove(a3);
		a.remove(ac2);
		System.out.println("Total no.of account and their details with bank");
		for(Account x:a)
		{
			x.show();
		}
	}

}
