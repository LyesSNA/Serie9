package org.LyesSNAOUI.reflection;

public class Person {

	private String lname;
	private String fname;
	@Override
	public String toString() {
		return "Person [lName=" + lname + ", fName=" + fname + ", age=" + age + "]";
	}


	private int age;
	
	
	public Person() {
		super();
	}


	public Person(String lName, String fName, int age) {
		this.lname = lName;
		this.fname = fName;
		this.age = age;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lName) {
		this.lname = lName;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fName) {
		this.fname = fName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
}
