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
 */

public final class Client {
	private String first_name;
	private String last_name;
	private String email;
	private Address address;
	
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
