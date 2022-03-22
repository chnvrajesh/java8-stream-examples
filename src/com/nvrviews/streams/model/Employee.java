package com.nvrviews.streams.model;

public class Employee {

	private String firstName;
	
	private String lastName;
	
	private String department;
	
	private int employeeId;
	
	private double salary;
	
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(String firstName, String lastName, String department, int employeeId, double salary, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.employeeId = employeeId;
		this.salary = salary;
		this.age = age;
	}
	
	
	
}
