package com.example.forcesales.Data.Management;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.Employee.EmployeeList;
import com.example.forcesales.Data.Tasks.TaskList;

/*
 * Management holds a bunch of lists for the ForceSale application.
 * methods:
 *      developer_list - (DeveloperList)
 *      employee_list - (EmployeeList)
 *      issue_tracker - (TaskList)
 */

public class Management implements Parcelable {
    private DeveloperList developer_list;
    private EmployeeList employee_list;
    private TaskList issue_tracker;

    public Management() {
        developer_list = new DeveloperList();
        employee_list = new EmployeeList();
        issue_tracker = new TaskList();
    }

    protected Management(Parcel in) {
        developer_list = in.readParcelable(DeveloperList.class.getClassLoader());
        employee_list = in.readParcelable(EmployeeList.class.getClassLoader());
        issue_tracker = in.readParcelable(TaskList.class.getClassLoader());
    }

    public static final Creator<Management> CREATOR = new Creator<Management>() {
        @Override
        public Management createFromParcel(Parcel in) {
            return new Management(in);
        }

        @Override
        public Management[] newArray(int size) {
            return new Management[size];
        }
    };

    public DeveloperList getDeveloperList() {
        return this.developer_list;
    }

    public EmployeeList getEmployeeList() {
        return  this.employee_list;
    }

    public TaskList getIssueTracker() {
        return this.issue_tracker;
    }

    public void setDeveloperList(DeveloperList in) {
        this.developer_list = in;
    }

    public void setEmployeeList(EmployeeList in) {
        this.employee_list = in;
    }

    public void setIssueTracker(TaskList issue_tracker) {
        this.issue_tracker = issue_tracker;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(developer_list, flags);
        dest.writeParcelable(employee_list, flags);
        dest.writeParcelable(issue_tracker, flags);
    }
}
