package data.client;

import java.util.ArrayList;

/*
 * ClientArray is an Array that inherits from java.util.ArrayList. Besides using
 * the same functionality as ArrayList, it will also have some function to find
 * a match based on the function used. 
 * 
 * TODO:
 * 		* Verify with group if it is okay to implement a client list this way. Code
 * 		might be removed.
 * 		* If group members are okay with idea, see if Java has official way of supporting
 * 		abstractComparsions.
 */ 

public final class ClientArray extends ArrayList<Client> {
	// To avoid being repetitious I am using lambda expressions for the following functions
	private CompareTwoObjects<Client,String> compareFirstName = (v,s) -> { return v.getFirstName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareLastName = (v,s) -> { return v.getLastName().equalsIgnoreCase(s); };
	private CompareTwoObjects<Client,String> compareEmail = (v,s) -> { return v.getEmail().equals(s); };
	private CompareTwoObjects<Client,Address> compareAddress = (v,s) -> { return v.getAddress().equals(s); };

	// This is a template class, designed to return an ArrayList of Clients if the requested comparison does match
	private <V> ArrayList<Client> abstractContains(V v, CompareTwoObjects<Client,V> comparsion) {
		ArrayList<Client> result = new ArrayList<>();
		
		for(Client i: this) {
			if (i.getAddress().equals(v)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	// Constructor
	public ClientArray() {
		super();
	}
	
	// Find a list of clients that have the same first name.
	public ArrayList<Client> containsFirstName(String v) {
		return abstractContains(v, compareFirstName);
	}
	
	// Find a list of clients that have the same list name.
	public ArrayList<Client> containsLastName(String v) {
		return abstractContains(v, compareLastName);
	}
	
	// Find a list of clients that have the same email.
	public ArrayList<Client> containsEmail(String v) {
		return abstractContains(v, compareEmail);
	}
	
	// Find a list of clients that have the same address.
	public ArrayList<Client> containsAddress(Address v) {
		return abstractContains(v, compareAddress);
	}
}
