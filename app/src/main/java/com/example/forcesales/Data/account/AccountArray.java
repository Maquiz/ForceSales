package com.example.forcesales.Data.account;

import java.util.ArrayList;
import java.util.Calendar;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

/*
 * AccountArray is a class that holds all of the accounts in a array.
 * 
 * Public:
 * 	-> (Constructor) Initializes AbstractArrayListComparsion
 * 	compare (returns a AccountArray subset based on the function called):
 * 		-> compareAccountName()
 * 		-> compareCloseDate()
 * 		-> compareOpportunityName()
 * 		-> compareFindOwner()
 * 
 * TODO:
 * 	1. Account Array could be designed with authentication in mind.
 * 	2. Consider implementing a way to find values that is Greater or Less
 * 	   than the requested calendar.
 */

@SuppressWarnings("serial")
public final class AccountArray extends AbstractArrayListComparsion<Account> {
	// Lamadas are used to avoid code repetition
	private CompareTwoObjects<Account,String> compare_account_name = (a,b) -> { return a.getAccountName().equalsIgnoreCase(b); };
	private CompareTwoObjects<Account,String> compare_oportunity_name = (a,b) -> {return a.getOpportunityName().equalsIgnoreCase(b); };
//	private CompareTwoObjects<Account,Client> compare_find_owner = (a,b) -> { return a.getOwner().contains(b); };
	private CompareTwoObjects<Account,Calendar> compare_close_date = (a,b) -> {
		return a.getCloseDate().get(Calendar.DATE) == b.get(Calendar.DATE) &&
			a.getCloseDate().get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
			a.getCloseDate().get(Calendar.YEAR) == b.get(Calendar.YEAR);
	};

	
	@Override
	// returns a new AccountArray (gets casted into ArrayList)
	protected ArrayList<Account> createEmptyArrayList() {
		return new AccountArray();
	}
	
	public AccountArray() {
		super();
	}
	
	public AccountArray compareAccountName(String value) {
		return (AccountArray) abstractContains(value, compare_account_name);
	}
	
	// public AccountArray compareCloseDateGreater(Calendar value)
	// public AccountArray compareCloseDateLess(Calendar value)
	public AccountArray compareCloseDate(Calendar value) {
		return (AccountArray) abstractContains(value, compare_close_date);
	}

	public AccountArray compareOpportunityName(String value) {
		return (AccountArray) abstractContains(value, compare_oportunity_name);
	}
	
//	public AccountArray compareFindOwner(Client value) {
//		return (AccountArray) abstractContains(value, compare_find_owner);
//	}
}
