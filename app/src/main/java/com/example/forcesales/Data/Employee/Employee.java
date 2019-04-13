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
	private SalesApplicationList appList;
	public static final String PARCELABLE_STR = "com.example.forcesales.Data.Employee.Employee";

	public Employee() {
		super();
		appList = new SalesApplicationList();
	}

	public SalesApplicationList getAppList() {
		return appList;
	}
}
