package com.example.forcesales.Data.Employee;
import com.example.forcesales.Data.Person.Person;
/*
 * 						Fake Employee Class (for testing purposes)
 */


public class Employee extends Person {
	public Employee() {
		super();
	}
	
	private String name;

	public Employee(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
