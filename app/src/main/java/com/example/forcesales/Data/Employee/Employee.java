package com.example.forcesales.Data.Employee;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Application.SalesApplicationList;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.Data.Person.Person;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.TaskList;

import java.io.Serializable;
/*
 * 						Employee Menu
 */


public class Employee extends Person implements Parcelable {
	private SalesApplicationList appList;
	private SalesApplicationList approvedApps;
	private SalesApplicationList deniedApps;
	public static final String PARCELABLE_STR = "com.example.forcesales.Data.Employee.Employee";

	private IssueTrackerList issue_tracker;

	public Employee() {
		super();
		appList = new SalesApplicationList();
		approvedApps = new SalesApplicationList();
		deniedApps = new SalesApplicationList();
		issue_tracker = new IssueTrackerList();
	}

	protected Employee(Parcel in){
		super();
		appList = in.readParcelable(SalesApplicationList.class.getClassLoader());
		approvedApps = 	in.readParcelable(SalesApplicationList.class.getClassLoader());
		deniedApps = in.readParcelable(SalesApplicationList.class.getClassLoader());
		issue_tracker = in.readParcelable(TaskList.class.getClassLoader());
	}
	public static final Creator<Employee> CREATOR = new Creator<Employee>() {
		@Override
		public Employee createFromParcel(Parcel in) {
			return new Employee(in);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};


	public SalesApplicationList getAppList() {
		return appList;
	}

	public IssueTrackerList getIssueTracker() {
		return this.issue_tracker;
	}

	public void setAppList (SalesApplicationList l){
		appList = l;
	}

	public SalesApplicationList getDeniedList() {
		return deniedApps;
	}

	public void setDeniedList (SalesApplicationList l){
		deniedApps = l;
	}

	public SalesApplicationList getApprovedList() {
		return approvedApps;
	}

	public void setApprovedList (SalesApplicationList l){
		approvedApps = l;
	}

	public void setIssueTracker(IssueTrackerList issue_tracker) {
		this.issue_tracker = issue_tracker;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(issue_tracker, flags);
	}
}
