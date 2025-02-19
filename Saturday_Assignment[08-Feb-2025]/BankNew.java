package com.Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AccountNew {
	String name, accounttype, address;
	long accountnumber, balance;

	public AccountNew() {
		super();
	}

	public AccountNew(String name, String accounttype, String address, long accountnumber, long balance) {
		super();
		this.name = name;
		this.accounttype = accounttype;
		this.address = address;
		this.accountnumber = accountnumber;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public String getAddress() {
		return address;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public long getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "AccountNew [name=" + name + ", accounttype=" + accounttype + ", address=" + address + ", accountnumber="
				+ accountnumber + ", balance=" + balance + "]";
	}
}

public class BankNew {
	static List<AccountNew> bank = new ArrayList<>();
	static String accounttype, address, name;
	static long accountnumber, balance;
	static AccountNew ac;

	public static void addAccount() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Add your Account details");
		System.out.println("Enter your Name");
		name = scn.next();
		System.out.println("Enter Account type Savings or Current");
		accounttype = scn.next();
		System.out.println("Enter Bank Addres");
		address = scn.next();
		System.out.println("Enter Account Number");
		accountnumber = scn.nextLong();
		System.out.println("Enter Account Balance");
		balance = scn.nextLong();
		ac = new AccountNew(name, accounttype, address, accountnumber, balance);
		bank.add(ac);
		//System.out.println("Account Created" + bank);
	}

	public static void display(long accno) {
		if(bank.isEmpty()) {
			System.out.println("Please Enter correct account number");
		}
		for (AccountNew acx : bank) {
			if (acx.getAccountnumber() == accno) {
				System.out.println("Account Holder Name : " + name + " ,Account Type : " + accounttype + " ,Address : "
						+ address + " ,Account Number : " + accountnumber + " ,Balance : " + balance);
			} else {
				System.out.println("Please Enter Correct Account number");
			}
		}
	}

	public static void deposit(long accno, long amount) {
		System.out.println("Depositing.....");
		for (AccountNew acx : bank) {
			if (acx.getAccountnumber() == accno) {
				balance += amount;
			}
		}
	}

	public static void withdraw(long accno, long amount) {
		System.out.println("Withdrwaing.....");
		for (AccountNew acx : bank) {
			if (acx.getAccountnumber() == accno) {
				balance -= amount;
			}
		}

	}

	public static void delete(long accno) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you really want to delete your account 1-Yes or 2-No");
		int s = sc.nextInt();
		switch (s) {
		case 1:
			for (AccountNew acx : bank) {
				if (acx.getAccountnumber() == accno) {
					bank.remove(acx);
					System.out.println("Account removed successfully");
					break;
				}
			}
			break;
		case 2:
			System.out.println("You aborted Deletion of your account");
			break;
		default:System.out.println("Please Select valid option");
		        break;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		long accno, amount;
		while (true) {
			System.out.println(
					"Select your option \n1-Create Account\n2-View Account Details\n3-Deposit\n4-Withdraw\n5-DeleteAccount\n6-Exit ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				addAccount();
				break;
			case 2:
				System.out.println("Enter your Account number");
				accno = sc.nextLong();
				display(accno);
				break;
			case 3:
				System.out.println("Enter your Account number");
				accno = sc.nextLong();
				System.out.println("Enter amount you want to deposit");
				amount = sc.nextLong();
				deposit(accno, amount);
				System.out.println("After depositing amount ="+amount);
				display(accno);
				break;
			case 4:
				System.out.println("Enter your Account number");
				accno = sc.nextLong();
				System.out.println("Enter amount you want to withdraw");
				amount = sc.nextLong();
				withdraw(accno, amount);
				System.out.println("After Withdrawing amount = "+amount);
				display(accno);
				break;
			case 5:
				System.out.println("Enter your Account number");
				accno = sc.nextLong();
				delete(accno);
				break;
			case 6:System.out.println("You are exiting please wait");
			       System.exit(0);
			       break;
			default:System.out.println("No option selected");
			        break;
			}
		}

	}

}
