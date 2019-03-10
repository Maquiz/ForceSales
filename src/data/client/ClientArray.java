package data.client;

import java.util.ArrayList;

import util.AbstractArrayListComparsion;
import util.CompareTwoObjects;

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
public final class ClientArray extends AbstractArrayListComparsion<Client> {
	// To avoid being repetitious I am using lambda expressions for the following functions
	private CompareTwoObjects<Client,String> compareFirstName = (v,s) -> { return v.getFirstName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareLastName = (v,s) -> { return v.getLastName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareEmail = (v,s) -> { return v.getEmail().equals(s); };
	private CompareTwoObjects<Client,Address> compareAddress = (v,s) -> { return v.getAddress().equals(s); };
	
	private CompareTwoObjects<Client,Address> compareAddressStreet = (v,s) -> { return v.getAddress().compareStreetAddress(s); };
	private CompareTwoObjects<Client,Address> compareAddressZipCode = (v,s) -> { return v.getAddress().compareZipCode(s); };
	private CompareTwoObjects<Client,Address> compareAddressCity = (v,s) -> { return v.getAddress().compareCity(s); };
	private CompareTwoObjects<Client,Address> compareAddressState = (v,s) -> { return v.getAddress().compareState(s); };
	
	
	@Override
	// returns a new ClientArray (gets casted into ArrayList)
	protected ArrayList<Client> createEmptyArrayList() {
		return new ClientArray();
	}
	
	public ClientArray() {
		super();
	}
	
	public ClientArray containsFirstName(String v) {
		return (ClientArray) abstractContains(v, compareFirstName);
	}
	
	public ClientArray containsLastName(String v) {
		return (ClientArray) abstractContains(v, compareLastName);
	}
	
	public ClientArray containsEmail(String v) {
		return (ClientArray) abstractContains(v, compareEmail);
	}
	
	public ClientArray containsAddress(Address v) {
		return (ClientArray) abstractContains(v, compareAddress);
	}
	
	public ClientArray containsAddressStreet(Address v) {
		return (ClientArray) abstractContains(v, compareAddressStreet);
	}
	
	public ClientArray containsAddressZipCode(Address v) {
		return (ClientArray) abstractContains(v, compareAddressZipCode);
	}
	
	public ClientArray containsAddressCity(Address v) {
		return (ClientArray) abstractContains(v, compareAddressCity);
	}
	
	public ClientArray containsAddressState(Address v) {
		return (ClientArray) abstractContains(v, compareAddressState);
	}
}
