package com.example.forcesales.UI.Developer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.Employee.EmployeeList;
import com.example.forcesales.UI.Abstract.Person.AddPersonActivity;

public class AddEmployeeActivity extends AddPersonActivity<EmployeeList, Employee> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText("Add Employee");
    }

    @Override
    protected EmployeeList getPersonList() {
        return getIntent().getParcelableExtra(EmployeeList.PARCELABLE_STR);
    }

    @Override
    protected Employee createNewPerson() {
        return new Employee();
    }

    @Override
    protected Intent fillIntent(Intent i) {
        i.putExtra(EmployeeList.PARCELABLE_STR, (Parcelable) person_list);
        return i;
    }
}
