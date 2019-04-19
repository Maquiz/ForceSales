package com.example.forcesales.Data.Application;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Account.Account;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

import java.io.Serializable;
import java.util.Calendar;


public final class SalesApplicationList extends AbstractArrayListComparsion<SalesApplication, com.example.forcesales.Data.Application.SalesApplicationList> implements Parcelable {
    // Lamadas are used to avoid code repetition
    private CompareTwoObjects<Account,String> compare_account_name = (a, b) -> a.getAccountName().equalsIgnoreCase(b);
    private CompareTwoObjects<Account,String> compare_oportunity_name = (a,b) -> a.getOpportunityName().equalsIgnoreCase(b);
    //	private CompareTwoObjects<Account,Client> compare_find_owner = (a,b) -> { return a.getOwner().contains(b); };
    private CompareTwoObjects<Account, Calendar> compare_close_date =
            (a,b) -> a.getCloseDate().get(Calendar.DATE) == b.get(Calendar.DATE) &&
                    a.getCloseDate().get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                    a.getCloseDate().get(Calendar.YEAR) == b.get(Calendar.YEAR);

    public SalesApplicationList() {
        super();
    }

    protected SalesApplicationList(Parcel in) {
        in.readList(this, SalesApplication.class.getClassLoader());
    }

    public static final Creator<SalesApplicationList> CREATOR = new Creator<SalesApplicationList>() {
        @Override
        public SalesApplicationList createFromParcel(Parcel in) {
            return new SalesApplicationList(in);
        }

        @Override
        public SalesApplicationList[] newArray(int size) {
            return new SalesApplicationList[size];
        }
    };

    @Override
    protected SalesApplicationList createEmptyArrayList() {
        return new SalesApplicationList();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { dest.writeList(this); }
}

