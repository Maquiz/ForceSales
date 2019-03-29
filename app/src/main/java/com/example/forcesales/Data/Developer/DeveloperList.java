package com.example.forcesales.Data.Developer;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.PersonList;

/*
 * DeveloperList, which extends from PersonList<Developer,DeveloperList>, is a list that holds
 * a group of developers. Refer to PersonList for information on the selected classes
 */

public class DeveloperList extends PersonList<Developer,DeveloperList> implements Parcelable {
    public DeveloperList() {
        super();
    }

    @Override
    protected DeveloperList createEmptyArrayList() {
        return new DeveloperList();
    }

    /*
     * This section contains Parcel specific code.
     */

    protected DeveloperList(Parcel in) {
        in.readList(this, DeveloperList.class.getClassLoader());
    }

    public static final Creator<DeveloperList> CREATOR = new Creator<DeveloperList>() {
        @Override
        public DeveloperList createFromParcel(Parcel in) {
            return new DeveloperList(in);
        }

        @Override
        public DeveloperList[] newArray(int size) {
            return new DeveloperList[size];
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
