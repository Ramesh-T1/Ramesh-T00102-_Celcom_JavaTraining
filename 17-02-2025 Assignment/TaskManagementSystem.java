package com.self.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tasks {
	private String name;
	private boolean completed;

	public Tasks() {
		super();
	}

	public Tasks(String name, boolean completed) {
		super();
		this.name = name;
		this.completed = completed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Tasks [name=" + name + ", completed=" + completed + "]";
	}

}

public class TaskManagementSystem {
	static List<Tasks> li = new ArrayList<>();
	static int id;

	public static void main(String[] args) {
		int i = 0;
		Scanner scr=new Scanner(System.in);
		while(true){
			System.out.println("Task Manager Menu : ");
			System.out.println("1-Add tasks \n 2-View All Tasks \n 3-searchTasks \n 4-To Mark Completed \n 5-DeleteTasks");
			int option=scr.nextInt();
			switch(option) {
			case 1:addTasks();
			       break;
			case 2:viewAllTasks();
			       break;
			case 3:searchTasks();
			       break;
			case 4:System.out.println("Enter index of task you want to update");
			       i=scr.nextInt();
			       Tasks t=li.get(i);
				   completed(t);
			       break;
			case 5:deleteTasks();
			       break;
			default:System.out.println("Please Select a valid option");
			        break;
			}
		}
	}

	public static void addTasks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a task");
		String o = sc.next();
		Tasks t = new Tasks(o, false);
		li.add(t);
	}

	public static void viewAllTasks() {
		System.out.println("All Your Tasks");
		for (Object o : li) {
			System.out.println(o);
		}
	}

	public static void completed(Tasks op) {
		if (li.contains(op))
		{
			int temp=li.indexOf(op);
			//addTasks();
			String s=op.getName();
			boolean b=!op.isCompleted();
			Tasks tn=new Tasks(op.getName(),b);
			li.remove(op);
			li.add(temp,tn);
			viewAllTasks();
		}

	}

	public static void deleteTasks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id of task you want to delete");
		id = sc.nextInt();
		viewAllTasks();
		li.remove(id);
		viewAllTasks();
	}

	public static void searchTasks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id of task you want to search");
		id = sc.nextInt();
		System.out.println(li.get(id));
	}

}
