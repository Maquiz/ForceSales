package com.example.forcesales.Data.Tasks;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.Person.Person;

import java.io.Serializable;
import java.util.ArrayList;


/* Tasks extends from AbstractTask<AbstractTask>. Refer to AbstractTask
 * for details on the functions inherited.
 */

public class Task extends AbstractTask<Client> {
    public Task(String name, String description, Client who, Calendar due) {
        super(name,description,who,due);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    protected Task(Parcel in) {
        super(in);
    }
}