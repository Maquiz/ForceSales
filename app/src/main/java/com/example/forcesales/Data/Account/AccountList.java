package com.example.forcesales.Data.Account;

import java.util.Calendar;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

/*
 * AccountList is a class that holds all of the accounts in a array.
 * 
 * Public:
 * 	-> (Constructor) Initializes AbstractArrayListComparsion
 * 	compare (returns a AccountList subset based on the function called):
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


public final class AccountList extends AbstractArrayListComparsion<Account, AccountList> {
	// Lamadas are used to avoid code repetition
	private CompareTwoObjects<Account,String> compare_account_name = (a,b) -> a.getAccountName().equalsIgnoreCase(b);
	private CompareTwoObjects<Account,String> compare_oportunity_name = (a,b) -> a.getOpportunityName().equalsIgnoreCase(b);
//	private CompareTwoObjects<Account,Client> compare_find_owner = (a,b) -> { return a.getOwner().contains(b); };
	private CompareTwoObjects<Account,Calendar> compare_close_date =
		(a,b) -> a.getCloseDate().get(Calendar.DATE) == b.get(Calendar.DATE) &&
		a.getCloseDate().get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
		a.getCloseDate().get(Calendar.YEAR) == b.get(Calendar.YEAR);

	
	public AccountList() {
		super();
	}

	@Override
	// returns a new AccountList (gets casted into ArrayList)
	protected AccountList createEmptyArrayList() {
		return new AccountList();
	}

	public AccountList compareAccountName(String value) {
		return abstractContains(value, compare_account_name);
	}
	
	// public AccountList compareCloseDateGreater(Calendar value)
	// public AccountList compareCloseDateLess(Calendar value)
	public AccountList compareCloseDate(Calendar value) {
		return abstractContains(value, compare_close_date);
	}

	public AccountList compareOpportunityName(String value) {
		return abstractContains(value, compare_oportunity_name);
	}
	
//	public AccountList compareFindOwner(Client value) {
//		return (AccountList) abstractContains(value, compare_find_owner);
//	}
}
