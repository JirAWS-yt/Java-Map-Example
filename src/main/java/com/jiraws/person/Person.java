package com.jiraws.person;

import java.util.Date;

public class Person {

	String lastName;
	String firstName;
	
	Date birthday;
	
	public Person(String lastName, String firstName, Date birthday) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		return this.lastName + " " + this.firstName;
	}
}
