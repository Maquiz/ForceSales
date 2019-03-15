package junit.data.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.client.Client;
import data.client.Address;

/*
 * I know that the assignment doesn't want us to create junits
 * for only getters and setters, but I want to make sure that
 * Client work before using ClientArray
*/

class TestClient {
	static private Client client;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		client = new Client();
	}
	
	@Test
	void testFirstName() {
		client.setFirstName("Sarah");
		Assertions.assertEquals("Sarah", client.getFirstName());
	}

	@Test
	void testLastName() {
		client.setLastName("Palin");
		Assertions.assertEquals("Palin", client.getLastName());
	}
	
	@Test
	void testEmail() {
		client.setEmail("sarah.palin@politics.org");
		Assertions.assertEquals("sarah.palin@politics.org", client.getEmail());
	}
	
	/*
	 * If any value contained in the Address are 'null', they will be ignored
	 */
	@Test
	void testAddress() {
		Address new_address = new Address();
		new_address.setState("CA");
		client.setAddress(new_address);
		
		Address compare_address = new Address();
		compare_address.setState("CA");
		
		Assertions.assertEquals(compare_address, client.getAddress());
	}
	
	@Test
	void testEqualComparsion() {
		Client a = new Client();
		Client b = new Client();
		Client a2 = new Client();
		
		a.setFirstName("a");
		a.setLastName("a");
		a.setEmail("a");
		a.setAddress(new Address());
		
		b.setFirstName("b");
		b.setLastName("b");
		b.setEmail("b");
		b.setAddress(new Address());
		
		a2.setFirstName("a");
		a2.setLastName("a");
		a2.setEmail("a");
		a2.setAddress(new Address());
		
		Assertions.assertNotEquals(a, b);
		Assertions.assertEquals(a, a2);
	}
}
