package data.client;

import java.util.ArrayList;

import util.CompareTwoObjects;

/*
 * ClientArray is an Array that inherits from java.util.ArrayList. Besides using
 * the same functionality as ArrayList, it will also have some function to find
 * a match based on the function used. 
 * 
 * 
 * 
 * TODO:
 * 		* Verify with group if it is okay to implement a client list this way.
 * 		  Code might be removed (I think they are cool with it).
 * 		* See if Java has official way of supporting an abstract comparsions.
 * 		* For the address, should I also provide the ability to check for State,
 * 		  Zip Code, and City? 
 */ 

@SuppressWarnings("serial")
public final class ClientArray extends ArrayList<Client> {
	// To avoid being repetitious I am using lambda expressions for the following functions
	private CompareTwoObjects<Client,String> compareFirstName = (v,s) -> { return v.getFirstName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareLastName = (v,s) -> { return v.getLastName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareEmail = (v,s) -> { return v.getEmail().equals(s); };
	private CompareTwoObjects<Client,Address> compareAddress = (v,s) -> { return v.getAddress().equals(s); };
	
	private CompareTwoObjects<Client,Address> compareAddressStreet = (v,s) -> { return v.getAddress().compareStreetAddress(s); };
	private CompareTwoObjects<Client,Address> compareAddressZipCode = (v,s) -> { return v.getAddress().compareZipCode(s); };
	private CompareTwoObjects<Client,Address> compareAddressCity = (v,s) -> { return v.getAddress().compareCity(s); };
	private CompareTwoObjects<Client,Address> compareAddressState = (v,s) -> { return v.getAddress().compareState(s); };
	
	
	private <V> ClientArray abstractContains(V v, CompareTwoObjects<Client,V> comparsion) {
		ClientArray result = new ClientArray();
		
		for(Client i: this) {
			if (comparsion.compare(i, v))
				result.add(i);
		}
		
		return result;
	}
	
	
	// Constructor
	public ClientArray() {
		super();
	}
	
	// Find a list of clients that have the same first name.
	public ClientArray containsFirstName(String v) {
		return abstractContains(v, compareFirstName);
	}
	
	// Find a list of clients that have the same list name.
	public ClientArray containsLastName(String v) {
		return abstractContains(v, compareLastName);
	}
	
	// Find a list of clients that have the same email.
	public ClientArray containsEmail(String v) {
		return abstractContains(v, compareEmail);
	}
	
	// Find a list of clients that have the same address.
	public ClientArray containsAddress(Address v) {
		return abstractContains(v, compareAddress);
	}
	
	// Find a list of clients that have the same address.
	public ClientArray containsAddressStreet(Address v) {
		return abstractContains(v, compareAddressStreet);
	}
	
	// Find a list of clients that have the same address.
	public ClientArray containsAddressZipCode(Address v) {
		return abstractContains(v, compareAddressZipCode);
	}
	
	// Find a list of clients that have the same address.
	public ClientArray containsAddressCity(Address v) {
		return abstractContains(v, compareAddressCity);
	}
	
	// Find a list of clients that have the same address.
	public ClientArray containsAddressState(Address v) {
		return abstractContains(v, compareAddressState);
	}
}
