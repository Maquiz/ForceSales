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
 * TODO:
 * 		* See if Java has official way of supporting an abstract comparsions.
 */ 

@SuppressWarnings("serial")
public final class ClientList extends PersonList<Client, ClientList>  {
	public ClientList() {
		super();
	}

	@Override
	// returns a new ClientList
	protected ClientList createEmptyArrayList() { return new ClientList(); }







}
