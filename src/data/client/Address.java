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
 */

final class Address {
	private String street_address;
	private String city;
	private String state;
	private String zip_code;
	
	
	public String getStreetAddress() {
		return street_address;
	}
	
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
}
