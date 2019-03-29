package com.example.forcesales.Data.Client;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.PersonList;

import java.io.Serializable;


/*
 * ClientList is an Array that inherits from AbstractArrayListComparsion. Besides being a normal ArrayList,
 * ClientList can also return a ClientList based on requested comparsion.
 * 
 * public:
 * 	compare (Will return a ClientList based on the requested function):
 * 		-> containsFirstName
 * 		-> containsLastName
 * 		-> containsEmail
 * 		-> containsAddress
 * 		-> containsAddressStreet
 * 		-> containsAddressZipCode
 * 		-> containsAddressCity
 * 		-> containsAddressState
 * 	-> (Constructor) ClientList() - Initalizes inheritated class
 *
 */ 

public final class ClientList extends PersonList<Client, ClientList>  implements Parcelable {
	public ClientList() {
		super();
	}

	@Override
	// returns a new ClientList
	protected ClientList createEmptyArrayList() { return new ClientList(); }



	protected ClientList(Parcel in) {
		in.readList(this, ClientList.class.getClassLoader());
	}

	public static final Creator<ClientList> CREATOR = new Creator<ClientList>() {
		@Override
		public ClientList createFromParcel(Parcel in) {
			return new ClientList(in);
		}

		@Override
		public ClientList[] newArray(int size) {
			return new ClientList[size];
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
