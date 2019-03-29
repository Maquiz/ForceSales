package com.example.forcesales.Data.Employee;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.PersonList;

public class EmployeeList extends PersonList<Employee,EmployeeList> implements Parcelable {
    public EmployeeList() {
        super();
    }

    @Override
    protected EmployeeList createEmptyArrayList() {
        return new EmployeeList();
    }

    /*

     */

    protected EmployeeList(Parcel in) {
        in.readList(this, EmployeeList.class.getClassLoader());
    }

    public static final Creator<EmployeeList> CREATOR = new Creator<EmployeeList>() {
        @Override
        public EmployeeList createFromParcel(Parcel in) {
            return new EmployeeList(in);
        }

        @Override
        public EmployeeList[] newArray(int size) {
            return new EmployeeList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this);
    }
}
