package junit.data.account;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.account.Account;
import data.account.AccountArray;
import data.client.Address;
import data.client.Client;

class TestAccountArray {
	private static AccountArray account_array;
	
	static private String string_value[][] = {
			{"Sarah's Account","The explorer clubs"},
			{"James's Account","Burning Star"},
			{"James's Account","The Men's Club"},
			{"Matthew Account","The explorer clubs"},
	};
	
	static private Calendar calendar_value[][] = {
			{ Calendar.getInstance() },
			{ Calendar.getInstance() },
			{ Calendar.getInstance() },
			{ Calendar.getInstance() },
	};

	static private int date_value[][] = {
			{2013, 2, 3},
			{2014, 4, 4},
			{2015, 5, 5},
			{2013, 2, 3},
	};
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		account_array = new AccountArray();
		

		
		for (int i=0; i<4; i++) {
			calendar_value[i][0].set(date_value[i][0], date_value[i][1], date_value[i][2]);
		}
		
		for (int i=0; i<4; i++) {
			addDataToAccountArray(i,account_array);
		}
	}
	
	static void addDataToAccountArray(int index, AccountArray account_array) {
		Account account = new Account();
		account.setAccountName(string_value[index][0]);
		account.setOpportunityName(string_value[index][1]);
		account.setCloseDate(calendar_value[index][0]);
//		account.getOwner().add(client_value[i][0]);
		account_array.add(account);
	}
	
	@Test
	void testCompareOpportunityName() {
		AccountArray actual = account_array.compareOpportunityName("The explorer clubs");
		AccountArray expected = new AccountArray();
		addDataToAccountArray(0,expected);
		addDataToAccountArray(3,expected);
		
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testCompareAccountName() {
		AccountArray actual = account_array.compareAccountName("James's Account");
		AccountArray expected = new AccountArray();
		addDataToAccountArray(1,expected);
		addDataToAccountArray(2,expected);
		
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testCompareCloseDate() {
		Calendar new_calender = Calendar.getInstance();
		new_calender.set(Calendar.DATE, 3);
		new_calender.set(Calendar.MONTH, 2);
		new_calender.set(Calendar.YEAR, 2013);
		AccountArray actual = account_array.compareCloseDate(new_calender);
		AccountArray expected = new AccountArray();
		addDataToAccountArray(0,expected);
		addDataToAccountArray(3,expected);
		
		Assertions.assertEquals(expected, actual);
	}
}
