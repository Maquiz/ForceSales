package junit.data.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.account.Account;
import data.client.Address;
import data.client.Client;
import data.client.ClientArray;

class TestAccount {
	static private Account account;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		account = new Account();
	}

	@Test
	void testAccountName() {
		account.setAccountName("MyAccountName");
		Assertions.assertEquals("MyAccountName", account.getAccountName());
	}
	
	@Test
	void testOpportunityName() {
		account.setOpportunityName("MyOpportunityName");
		Assertions.assertEquals("MyOpportunityName", account.getOpportunityName());
	}
	
	@Test
	void testClient() {
		account.setClients(new ClientArray());
		Client e = new Client();
		e.setFirstName("first_name");
		e.setLastName("last_name");
		e.setEmail("email");
		e.setAddress(new Address());
		account.getClients().add(e);
		
		ClientArray e2 = new ClientArray();
		e = new Client();
		e.setFirstName("first_name");
		e.setLastName("last_name");
		e.setEmail("email");
		e.setAddress(new Address());
		e2.add(e);
		
		Assertions.assertEquals(e2, account.getClients());
	}
	
	@Test
	void testCloseDate() {
		// TODO: Implement Later.
	}
}
