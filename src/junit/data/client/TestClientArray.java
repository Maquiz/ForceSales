package junit.data.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.client.Address;
import data.client.Client;
import data.client.ClientArray;

/*
 * It is just a bunch of test cases for ClientArray:
 * 
 * private:
 * 	string_value, address_value -> Holds premade values to test various cases.
 * 
 * public:
 * 	helperGenerateClientArray -> Generates the ClientArray data.
 * 	testContainsAddress -> Does a search for any one who contain the exact (case ignored) address.
 * 	testContainsEmail -> Return a list of people who have the same email.
 * 	testContainsFirstName -> Does a case insensitive search of the first person's name.
 * 	testContainsLastName -> Does a case insensitive search of the last person's name.
 * 	testContainsAddressCity -> Does a case insensitive search of the addresses's city.
 * 	testContainsAddressState -> Does a case insensitive search of the addresses's state.
 * 	testContainsAddressStreet -> Does a case insensitive search of the addresses's street.
 * 	testContainsAddressZipCode -> Does a case insensitive search of the addresses's zip code.
 */

class TestClientArray {
	static private ClientArray client_array;
	
	static private String string_value[][] = {
			{"Sarah","Palin","spalin@example.com"},
			{"SARAH","Hendricks","shendricks@example.com"},
			{"James","MADISON","bros@examples.com"},
			{"John","Madison","bros@examples.com"},
			{"Jay","Hammons","JayMHammons@jourrapide.com"},
			{"George","Hogan","GeorgeAHogan@teleworm.us"},
	};
	
	
	static private Address address_value[] = {
			new Address("2333 Glen Falls Road","Newtown","PA","18940"),
			new Address("779 Brannon Street","Los Angeles","CA","90057"),
			new Address("3229 Libby Street","Los Angeles","CA","90025"),
			new Address("816 Upland Avenue","Lima","OH","45801"),
			new Address("779 Brannon Street","Los Angeles","CA","90057"),
			new Address("3229 Libby Street","Los Angeles","CA","90025"),
	};
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		client_array = new ClientArray();
		
		for (int i = 0; i < string_value.length; i++) {
			String data_person[] = string_value[i];
			
			Client new_person = new Client();
			new_person.setFirstName(data_person[0]);
			new_person.setLastName(data_person[1]);
			new_person.setEmail(data_person[2]);
			new_person.setAddress(address_value[i]);
			
			client_array.add(new_person);
		}
	}
	
	static public void helperGenerateClientArray(ClientArray in, int ArrayOfInts[]) {		
		for (int i: ArrayOfInts) {
			Client new_person = new Client();
			String data_person[] = string_value[i];
			
			new_person.setFirstName(data_person[0]);
			new_person.setLastName(data_person[1]);
			new_person.setEmail(data_person[2]);
			new_person.setAddress(address_value[i]);
			
			in.add(new_person);
		}
	}
	
	
	@Test
	void testContainsAddress() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {2,5};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		ClientArray actual = client_array.containsAddress(new Address("3229 Libby Street","Los Angeles","CA","90025"));
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	@Test
	void testContainsEmail() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {2,3};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		ClientArray actual = client_array.containsEmail("bros@examples.com");
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	
	@Test
	void testContainsFirstName() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {0,1};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		ClientArray actual = client_array.containsFirstName("Sarah");		
		Assertions.assertIterableEquals(expected, actual);
	}

	
	@Test
	void testContainsLastName() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {2,3};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		ClientArray actual = client_array.containsLastName("Madison");
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	@Test
	void testContainsAddressCity() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {1,2,4,5};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		Address address = new Address();
		address.setCity("Los Angeles");
		ClientArray actual = client_array.containsAddressCity(address);
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	@Test
	void testContainsAddressState() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {1,2,4,5};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		Address address = new Address();
		address.setState("CA");
		ClientArray actual = client_array.containsAddressState(address);
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	@Test
	void testContainsAddressStreet() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {1,4};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		Address address = new Address();
		address.setStreetAddress("779 Brannon Street");
		ClientArray actual = client_array.containsAddressStreet(address);
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	@Test
	void testContainsAddressZipCode() {
		ClientArray expected = new ClientArray();
		int ArrayOfInts[] = {3};
		helperGenerateClientArray(expected,ArrayOfInts);
		
		Address address = new Address();
		address.setZipCode("45801");
		ClientArray actual = client_array.containsAddressZipCode(address);
		Assertions.assertIterableEquals(expected, actual);
	}
}
