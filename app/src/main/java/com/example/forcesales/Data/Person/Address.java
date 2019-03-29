/**
 *  @author thomas_a
 */
package com.example.forcesales.Data.Person;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Address is a class that was designed to split a normal address into serveral
 * parts. It makes it easy to do searching.
 * 
 * public:
 * 	constructor:
 * 		-> (empty)
 * 		-> (street_address,city,state,zip_code)
 * 	getters:
 * 		-> getStreetAddress
 * 		-> getCity
 * 		-> getState
 * 		-> getZipCode
 * 	setter:
 * 		-> setStreetAddress
 * 		-> setCity
 * 		-> setState
 * 		-> setZipCode
 * 	compare (will compare a specific element from one Address object to another):
 * 		-> compareStreetAddress
 * 		-> compareZipCode
 * 		-> compareCity
 * 		-> compareState
 * -> equals - Overloads Object's method. Does a case insesitive check
 * 
 *  TODO:
 *  	1. Rearrange functions location
 *  	2. Should I add code to parse the zip code into a ArrayList Integer?
 *  	3. Should I error check for null?
 */

public final class Address implements Parcelable {
	private String street_address;
	private String city;
	private String state;
	private String zip_code;

	public Address() {
		this.street_address = "";
		this.city = "";
		this.state = "";
		this.zip_code = "";
	}

	public Address(String street_address,
				   String city,
				   String state,
				   String zip_code) {
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}


	@Override // compares the values to another objects. Case sensivity is ignored.
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address value = (Address) obj;
			if (!value.street_address.equalsIgnoreCase(this.street_address))
				return false;
			else if (!value.city.equalsIgnoreCase(this.city))
				return false;
			else if (!value.state.equalsIgnoreCase(this.state))
				return false;
			else if (!value.zip_code.equalsIgnoreCase(this.zip_code))
				return false;

			return true;
		}

		return false;
	}


	public String getStreetAddress() {
		return street_address;
	}

	public void setStreetAddress(String street_address) {
		this.street_address = street_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zip_code;
	}

	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}


	public boolean compareStreetAddress(Address o) {
		return this.getStreetAddress().equalsIgnoreCase(o.getStreetAddress());
	}

	public boolean compareZipCode(Address o) {
		return this.getZipCode().equalsIgnoreCase(o.getZipCode());
	}

	public boolean compareCity(Address o) {
		return this.getCity().equalsIgnoreCase(o.getCity());
	}

	public boolean compareState(Address o) {
		return this.getState().equalsIgnoreCase(o.getState());
	}


//	private String street_address;
//	private String city;
//	private String state;
//	private String zip_code;

	//parcelable implementation methods
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(street_address);
		dest.writeString(city);
		dest.writeString(state);
		dest.writeString(zip_code);
	}
	//creator
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Address createFromParcel(Parcel in){
			return new Address(in);
		}

		public Address[] newArray(int size){
			return new Address[size];
		}
	};

	//De-parcel object
	private Address(Parcel in) {
		street_address = in.readString();
		city = in.readString();
		state = in.readString();
		zip_code = in.readString();
	}

}
