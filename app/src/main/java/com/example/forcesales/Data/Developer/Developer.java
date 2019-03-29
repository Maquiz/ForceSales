package com.example.forcesales.Data.Developer;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.Person;

/*
 * The developer is a programmer that will have the ability to access to the
 * issue tracker and create a new employee. Developer extends from Person.
 * Refer to the Person for more information on the implementation.
 */

public class Developer extends Person implements Parcelable {
    public Developer() {
        super();
    }

    /*
     * The following code below is the Parcel implementation.
     */

    protected Developer(Parcel in) {
        super(in);

    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        @Override
        public Developer createFromParcel(Parcel source) {
            return new Developer(source);
        }

        @Override
        public Developer[] newArray(int size) {
            return new Developer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
    }

}
