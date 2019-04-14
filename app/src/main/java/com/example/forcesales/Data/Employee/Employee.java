package com.example.forcesales.Data.Employee;
import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Application.SalesApplicationList;
import com.example.forcesales.Data.Person.Person;
import com.example.forcesales.Data.Sale.Sales;

import java.io.Serializable;
/*
 * 						Employee Menu
 */


public class Employee extends Person {
	public static final String PARCELABLE_STR = "com.example.forcesales.Data.Employee.Employee";

	private SalesApplicationList appList;

	public Employee() {
		super();
		appList = new SalesApplicationList();
	}

	public SalesApplicationList getAppList() {
		return appList;
	}
}
