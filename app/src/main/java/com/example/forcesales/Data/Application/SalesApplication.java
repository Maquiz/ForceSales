/**
 *  @author max_b
 */
package com.example.forcesales.Data.Application;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.Person;

//Creating a sales Application
public class SalesApplication  extends Person implements  Parcelable {

    private String companyName;
    private String phoneNumber;


    public SalesApplication(){  super();    }

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(companyName);
        dest.writeString(phoneNumber);
    }

    //creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Person createFromParcel(Parcel in){
            return new SalesApplication(in);
        }

        public SalesApplication[] newArray(int size) {
            return new SalesApplication[size];
        }
    };

    //deparcel object
    public SalesApplication(Parcel in) {
        super(in);
        companyName = in.readString();
        phoneNumber= in.readString();

    }

    public String getCompanyName(){ return companyName;}

    public String getPhoneNumber(){return  phoneNumber;}

    public void setCompanyName(String _companyName){
        companyName = _companyName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


