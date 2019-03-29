/**
 *  @author thomas_a
 */
package com.example.forcesales.Data.Client;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.Person;

/**
 * Client is an extention of the Person class
 */

public final class Client extends Person implements Parcelable {
	public Client() {
		super();
	}

	@Override
	public int describeContents(){
		return 0;
	}

	@Override
	public void writeToParcel(Parcel in, int flags) {
		super.writeToParcel(in, flags);
	}

	public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>(){
		public Client createFromParcel(Parcel in) {
			return new Client(in);
		}

		public Client[] newArray(int size){
			return new Client[size];
		}
	};

	private Client(Parcel in){
		super(in);
	}
}
