package com.example.forcesales.Data.IssueTracker;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Developer.Developer;
import com.example.forcesales.Data.Tasks.AbstractTask;

import java.util.Calendar;

public class IssueTracker extends AbstractTask<Developer> implements Parcelable {
    public static final String PARCELABLE_STR = "com.example.forcesales.Data.IssueTracke.IssueTracker";
    public enum LABLE {
        NONE,
        WONTFIX,
        DUPLICATE,
        QUESTION
    }

    private LABLE label;

    public IssueTracker(String name, String description, Developer who, Calendar due) {
        super(name, description, who, due);
        this.label = LABLE.NONE;
    }

    public LABLE getLabel() {
        return this.label;
    }

    public void setLabel(LABLE label) {
        this.label = label;
    }

    //
    // Parcel Functions
    //

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        dest.writeInt(label.ordinal());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public IssueTracker createFromParcel(Parcel in) {
            return new IssueTracker(in);
        }

        public IssueTracker[] newArray(int size) {
            return new IssueTracker[size];
        }
    };

    protected IssueTracker(Parcel in) {
        super(in);
        label = LABLE.values()[in.readInt()];
    }
}
