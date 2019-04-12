package com.example.forcesales.Data.IssueTracker;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Tasks.AbstractTaskList;

public class IssueTrackerList extends AbstractTaskList<IssueTracker,IssueTrackerList> implements Parcelable {
    public static final String PARCELABLE_STR = "com.example.forcesales.Data.IssueTracker.IssueTrackerList";

    public IssueTrackerList() {
        super();
    }

    protected IssueTrackerList(Parcel in) {
        in.readList(this, IssueTracker.class.getClassLoader());
    }

    public static final Creator<IssueTrackerList> CREATOR = new Creator<IssueTrackerList>() {
        @Override
        public IssueTrackerList createFromParcel(Parcel in) {
            return new IssueTrackerList(in);
        }

        @Override
        public IssueTrackerList[] newArray(int size) {
            return new IssueTrackerList[size];
        }
    };

    @Override
    protected IssueTrackerList createEmptyArrayList() {
        return new IssueTrackerList();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this);
    }
}
