/**
 *  @author thomas_a
 */
package data.client;

/**
 * Client is a class that holds information about the current person. It provides the following:
 * 		a. First name
 * 		b. Last name
 * 		c. Email
 * 		d. Address
 * 
 * TODO:
 * 		1. Add hire date?
 */

public final class Client {
	private String first_name;
	private String last_name;
	private String email;
	private Address address;
	
	// Constructor
	public Client() {
		first_name = "";
		last_name = "";
		email = "";
		address = new Address();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Client) {
			Client other2 = (Client) other;
			if (!other2.first_name.equalsIgnoreCase(this.first_name))
				return false;
			else if (!other2.last_name.equalsIgnoreCase(this.last_name))
				return false;
			else if (!other2.email.equals(this.email))
				return false;
			else if (!other2.address.equals(this.address))
				return false;
			
			return true;
		}
		
		return false;
	}
	
	// Return the first name
	public String getFirstName() {
		return first_name;
	}
	
	// Sets the first_name
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	// Returns the last_name
	public String getLastName() {
		return last_name;
	}

	// Sets the last_name
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	// Returns the email
	public String getEmail() {
		return email;
	}

	// Sets the email
	public void setEmail(String email) {
		this.email = email;
	}


	// Returns the address
	public Address getAddress() {
		return address;
	}

	// Sets the address
	public void setAddress(Address address) {
		this.address = address;
	}
}
