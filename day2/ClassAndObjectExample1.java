package com.celcom.day2;

class Employee{
	//Variable declaration
	int eid;
	String ename;
	double esalary;
	//Constructor
	/*Employee(int id,String name,double salary){
		eid=id;
		ename=name;
		esalary=salary;
	}*/
	Employee(int eid,String ename,double esalary){
		this.eid=eid;
		this.ename=ename;
		this.esalary=esalary;
	}
	//Method
	void display() {
		System.out.println("Employee Id : "+eid);
		System.out.println("Employee Name : "+ename);
		System.out.println("Employee Salary : "+esalary);
	}
}

public class ClassAndObjectExample1 {

	public static void main(String[] args) {
		Employee valan=new Employee(101,"Valan",2000);
		valan.display();
		Employee h=new Employee(102,"Harish",3000);
		h.display();

	}

}
