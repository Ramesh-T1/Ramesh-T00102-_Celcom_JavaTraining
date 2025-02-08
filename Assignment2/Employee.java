package com.Assignment2;

public class Employee {
	String name,jobtitle;
	double salary,totalsalary;
	
	public Employee(String name, String jobtitle, double salary) {
		super();
		this.name = name;
		this.jobtitle = jobtitle;
		this.salary = salary;
	}
	public void calculateSalary(double hra,double bonus,double tax) {
		totalsalary=salary+hra+bonus-tax;
	}
	public void updateSalary(double salary) {
		this.salary=salary;
		//this.calculateSalary(salary, salary, salary);
	}
	public void display() {
		System.out.println("Salary ="+totalsalary);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e=new Employee("Ramesh","Java Devloper",80000);
		e.calculateSalary(4500,15000,3000);
		System.out.println("Initial Salary : ");
		e.display();
		e.updateSalary(100000);
		e.calculateSalary(4500,15000,3000);
		System.out.println("Updated Salary : ");
		e.display();

	}

}
