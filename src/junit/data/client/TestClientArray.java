package junit.data.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.client.Address;
import data.client.Client;
import data.client.ClientArray;

class TestClientArray {
	static private ClientArray client_array;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		client_array = new ClientArray();
		
		String value[][] = {
				{"Sarah","Palin","spalin@example.com"},
				{"SARAH","Hendricks","shendricks@example.com"},
				{"James","MADISON","bros@examples.com"},
				{"John","Madison","bros@examples.com"},
				{"Jay","Hammons","JayMHammons@jourrapide.com"},
				{"George","Hogan","GeorgeAHogan@teleworm.us"},
		};
		
		Address value2[] = {
				new Address("2333 Glen Falls Road","Newtown","PA","18940"),
				new Address("779 Brannon Street","Los Angeles","CA","90057"),
				new Address("3229 Libby Street","Los Angeles","CA","90025"),
				new Address("816 Upland Avenue","Lima","OH","45801"),
				new Address("779 Brannon Street","Los Angeles","CA","90057"),
				new Address("3229 Libby Street","Los Angeles","CA","90025"),
		};
		
		
		for (int i = 0; i < value.length; i++) {
			String data_person[] = value[i];
			
			Client new_person = new Client();
			new_person.setFirstName(data_person[0]);
			new_person.setLastName(data_person[1]);
			new_person.setEmail(data_person[2]);
			new_person.setAddress(value2[i]);
			
			client_array.add(new_person);
		}
	}
	
	/*
	 * 	testContainsAddress() will do a search for any one who contain the same address.
	 */
	@Test
	void testContainsAddress() {
		ArrayList<Address> actual = new ArrayList<>();
		for (Client i: client_array.containsAddress(new Address("3229 Libby Street","Los Angeles","CA","90025")))
			actual.add(i.getAddress());
		
		ArrayList<Address> expected = new ArrayList<>();
		expected.add(new Address("3229 Libby Street","Los Angeles","CA","90025"));
		expected.add(new Address("3229 Libby Street","Los Angeles","CA","90025"));
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	/*
	 * 	containsEmail() will return a list of people who have the same email.
	 */
	@Test
	void testContainsEmail() {
		ArrayList<String> actual = new ArrayList<>();
		for (Client i: client_array.containsEmail("bros@examples.com"))
			actual.add(i.getEmail());
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("bros@examples.com");
		expected.add("bros@examples.com");
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	/*
	 * 	containsFirstName() will do a case insensitive search of the first person's
	 * 	name. Therefore Sarah and SARAH will be considered the same thing.
	 */
	@Test
	void testContainsFirstName() {		
		ArrayList<String> actual = new ArrayList<>();
		for (Client i: client_array.containsFirstName("Sarah"))
			actual.add(i.getFirstName());
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Sarah");
		expected.add("SARAH");
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	
	/*
	 *	containsLastName() will do a case insensitive search of the last person's
	 *	name.
	 */
	@Test
	void testContainsLastName() {
		ArrayList<String> actual = new ArrayList<>();
		for (Client i: client_array.containsLastName("Madison"))
			actual.add(i.getLastName());
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("MADISON");
		expected.add("Madison");
		
		Assertions.assertIterableEquals(expected, actual);
	}
}
