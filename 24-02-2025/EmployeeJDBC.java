package com.celcom.day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Employee {
	int eid;
	String name;
	int age;
	String dept;
	double salary;
	String email;

	public Employee() {
		super();
	}

	public Employee(int eid, String name, int age, String dept, double salary, String email) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.salary = salary;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", dept=" + dept + ", salary=" + salary
				+ ", email=" + email + "]";
	}
}

/*class CK {
	static int count = 1;

	public CK() {
		super();
	}

	public int getCount() {
		return count;
	}

	public int setCKey() {
		return count++;
	}

}*/

public class EmployeeJDBC {
	int id, age, n, i = 1, eid, ck;
	String name, dept, email, o;
	double sal, es;
	static Connection con;
	 Map<Integer, Employee> m = new TreeMap<>();
	//Map<CK, Employee> m = new TreeMap<>();
	Scanner sc1 = new Scanner(System.in);

	// Add Employee
	public void addEmployee() {
		System.out.println("Enter how many employees you want to enter");
		n = sc1.nextInt();
		while (i <= n) {
			System.out.println("Enter Emploayee Id :");
			id = sc1.nextInt();
			System.out.println("Enter Emploayee Name :");
			name = sc1.next();
			System.out.println("Enter Emploayee age :");
			age = sc1.nextInt();
			System.out.println("Enter Emploayee Dept :");
			dept = sc1.next();
			System.out.println("Enter Emploayee Salary :");
			sal = sc1.nextDouble();
			System.out.println("Enter Emploayee Email :");
			email = sc1.next();
			Employee e = new Employee(id, name, age, dept, sal, email);
			//CK c=new CK();
			//ck=c.setCKey();
			m.put(i, e);
			//m.put(ck, e);
			//System.out.println("Value of CK = "+ck);
			System.out.println("Value of I = "+i);
			String query2 = "insert into employee_master (eid,name,age,dept,salary,email) values (?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(query2);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, dept);
				pstmt.setDouble(5, sal);
				pstmt.setString(6, email);
				pstmt.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			i++;
		}
		if (n == 0) {
			System.out.println("You aborted.....");
			System.exit(0);
		}

	}

	// Show employee
	private void showEmployee() {
		System.out.println("Entire list of Employee");
		for (Map.Entry<Integer, Employee> x : m.entrySet()) {
			System.out.println("Printing using key and then getValue");
			System.out.println("Employee " + x.getKey());
			System.out.println(x.getValue());
			System.out.println("Complete list in key value form");
			System.out.println(x.getKey() + " " + x.getValue());
			System.out.println("Complete list in object form");
			System.out.println(x);
		}
		System.out.println("Employee whose age is more than 20");
		for (Map.Entry<Integer, Employee> x : m.entrySet()) {
			if (x.getValue().getAge() >= 20) {
				System.out.println("Employee " + x.getKey());
				System.out.println(x.getValue());
			}
		}
		// SQL Show
		System.out.println("SQL show Employee output");
		String query4 = "Select * from employee_master";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query4);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
						+ rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Employee
	private void updateEmployee() {
		System.out.println("Enter employee id");
		eid = sc1.nextInt();
		for (Map.Entry<Integer, Employee> x : m.entrySet()) {
			if (x.getValue().getEid() == eid) {
				System.out.println("Enter Salary to be updated");
				es = sc1.nextDouble();
				x.getValue().setSalary(es);
				System.out.println("Salary updated sucessfully");
			}
		}
		// SQL update
		String query3 = "update employee_master set salary=? where eid=?";
		try {
			PreparedStatement st = con.prepareStatement(query3);
			st.setDouble(1, es);
			st.setInt(2, eid);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Remove Employee
	public void removeEmployee() {
		System.out.println("Enter employee id you want to delete");
		eid = sc1.nextInt();
		for (Map.Entry<Integer, Employee> x : m.entrySet()) {
			if (x.getValue().getEid() == eid) {
				m.remove(x);
				System.out.println("Employee " + x.getValue().getEid() + " Deleted Sucessfully");
			}
		}
		// SQL remove
		String query4 = "delete from employee_master where eid=?";
		try {
			PreparedStatement st = con.prepareStatement(query4);
			st.setInt(1, eid);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Exit
	public void exit() {
		System.out.println("Do you really want to exit Yes or No");
		o = sc1.next();
		switch (o) {
		case "Yes":
			System.out.println("You exited");
			System.exit(1);
			break;
		case "No":
			System.out.println("You can continue");
			break;
		}
	}

	static {
		String url = "jdbc:mysql://localhost:3306/practice_ramesh";
		String userName = "root";
		String password = "root@123";
		try {
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection is Sucessful");
			try {
				String query1 = "create table employee_master(eid int,name varchar(20),age int,dept varchar(20),salary double,email varchar(50))";
				Statement st = con.createStatement();
				st.executeUpdate(query1);
				System.out.println("Table Employee_Master created sucessfully");
			} catch (Exception e) {
				System.out.println("Table already created");
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println("Connection Unsucessful");
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		EmployeeJDBC ej = new EmployeeJDBC();
		Scanner sc = new Scanner(System.in);
		int op;
		while (true) {
			System.out.println(
					"1-Enter Employee Details\n2-Update Employee Details\n3-Remove Employee\n4-See Employee details\n5-Exit");
			op = sc.nextInt();
			switch (op) {
			case 1:
				ej.addEmployee();
				break;
			case 2:
				ej.updateEmployee();
				break;
			case 3:
				ej.removeEmployee();
				break;
			case 4:
				ej.showEmployee();
				break;
			case 5:
				ej.exit();
				break;
			default:
				System.out.println("Please select a valid option");
				break;
			}
		}
	}
}
