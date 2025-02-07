package com.celcom.day3;

public class JavaBean1 {
	private int id, salary;
	private String name;

	public JavaBean1() {

	}

	public JavaBean1(int id, int salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		JavaBean1 j1=new JavaBean1(1,19000,"Ramesh");
		System.out.println(j1.getName());
		System.out.println(j1.getSalary());
		j1.setSalary(700000);
		System.out.println(j1.getSalary());

	}

}
