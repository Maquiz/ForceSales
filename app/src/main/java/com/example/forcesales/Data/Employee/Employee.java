package com.example.forcesales.Data.Employee;
import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Application.SalesApplicationList;
import com.example.forcesales.Data.Person.Person;
import com.example.forcesales.Data.Sale.Sales;

import java.io.Serializable;
/*
 * 						Employee Menu
 */


public class Employee extends Person implements Serializable {
	private SalesApplicationList appList;

	public Employee(String name) {
		this.name = name;
		appList = new SalesApplicationList();
	}

	private String name;

	public SalesApplicationList getAppList(){ return appList;}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
