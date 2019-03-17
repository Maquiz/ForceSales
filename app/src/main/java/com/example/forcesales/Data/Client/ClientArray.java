package com.example.forcesales.Data.Client;


import com.example.forcesales.Data.Person.PersonList;


/*
 * ClientArray is an Array that inherits from AbstractArrayListComparsion. Besides being a normal ArrayList,
 * ClientArray can also return a ClientArray based on requested comparsion.
 * 
 * public:
 * 	compare (Will return a ClientArray based on the requested function):
 * 		-> containsFirstName
 * 		-> containsLastName
 * 		-> containsEmail
 * 		-> containsAddress
 * 		-> containsAddressStreet
 * 		-> containsAddressZipCode
 * 		-> containsAddressCity
 * 		-> containsAddressState
 * 	-> (Constructor) ClientArray() - Initalizes inheritated class
 * 
 * TODO:
 * 		* See if Java has official way of supporting an abstract comparsions.
 */ 

@SuppressWarnings("serial")
public final class ClientArray extends PersonList<Client,ClientArray> {
	public ClientArray() {
		super();
	}

	@Override
	// returns a new ClientArray
	protected ClientArray createEmptyArrayList() { return new ClientArray(); }


}
