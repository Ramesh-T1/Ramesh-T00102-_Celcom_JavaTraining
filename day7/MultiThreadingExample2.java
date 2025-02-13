package com.celcom.day7;

import java.util.Scanner;

class SavingAccount{
	private long balanceAmount;
	
	void deposit(long amount) {
		this.balanceAmount=this.balanceAmount+amount;
	}
	void withdraw(long amount) {
		this.balanceAmount=this.balanceAmount-amount;
	}
	public long getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
}
class WithDrawer extends Thread{
	SavingAccount savingAccount;
	WithDrawer(SavingAccount savingAccount){
		this.savingAccount=savingAccount;
	}
	public void run() {
		synchronized(savingAccount) {
			System.out.println("Withdrawer is waiting for depositor to deposit a money......");
			try {
				savingAccount.wait();
			}catch(InterruptedException e) {
				
			}
			System.out.println("Enter the amount to withdraw");
			long amount=new Scanner(System.in).nextLong();
			savingAccount.withdraw(amount);
			System.out.println(amount+" withdraw Successfully");
			System.out.println("Balance : "+savingAccount.getBalanceAmount());
		}
	}
}

class Depositer extends Thread{
	SavingAccount savingAccount;
	Depositer(SavingAccount savingAccount){
		this.savingAccount=savingAccount;
	}
	public void run() {
		synchronized(savingAccount) {
			System.out.println("Depositer started to deposit a money.....");
			System.out.println("Enter the amount to Deposit");
			long amount=new Scanner(System.in).nextLong();
			savingAccount.deposit(amount);
			System.out.println(amount+" Deposited Sucessfully");
			System.out.println("Balance : "+savingAccount.getBalanceAmount());
			savingAccount.notify();
		}
	}
}


public class MultiThreadingExample2 extends Thread{

	public static void main(String[] args) throws InterruptedException {
		SavingAccount savingAccount=new SavingAccount();
		WithDrawer withdraw=new WithDrawer(savingAccount);
		withdraw.start();
		Thread.sleep(2000);//This will make the current scope thread to go into sleep i.e main method
		Depositer deposit=new Depositer(savingAccount);
		deposit.start();
	}
}
