package org.LyesSNAOUI.reflection;

public class Employee extends Person{

	int salary;
	
	public Employee(String lName, String fName, int age, int salary) {
		super();
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee() {
	}
	
}
