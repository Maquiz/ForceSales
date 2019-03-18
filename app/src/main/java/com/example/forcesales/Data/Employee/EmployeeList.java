package com.example.forcesales.Data.Employee;

import com.example.forcesales.Data.Person.PersonList;

public class EmployeeList extends PersonList<Employee,EmployeeList> {
    public EmployeeList() {
        super();
    }

    @Override
    protected EmployeeList createEmptyArrayList() {
        return new EmployeeList();
    }
}
