/**
 *  @author thomas_a
 */
package data.client;

/**
 * Address is a class that splits the address into multiple components:
 * 		a. The street address
 * 		b. The city
 * 		c. The state
 * 		d. The zip code
 * 
 *  TODO:
 *  	1. Should I add code to parse the zip code into a ArrayList Integer?
 *  	2. If someone wanted to do a more elaborate search on the Address, should
 *  		I add the functionality here or in the ClientArray function?
 */

public final class Address {
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
	
	// Returns the street address
	public String getStreetAddress() {
		return street_address;
	}
	
	// Assigns the street address
	public void setStreetAddress(String street_address) {
		this.street_address = street_address;
	}

	//	Returns the city
	public String getCity() {
		return city;
	}

	//	Assigns the city
	public void setCity(String city) {
		this.city = city;
	}

	//	Returns the state
	public String getState() {
		return state;
	}

	//	Assigns the state
	public void setState(String state) {
		this.state = state;
	}

	//	Returns the zip code
	public String getZipCode() {
		return zip_code;
	}

	//	Assigns the zip code
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
	

}
