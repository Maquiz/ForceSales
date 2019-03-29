package com.example.forcesales.Data.Application;

import com.example.forcesales.Data.Account.Account;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

import java.io.Serializable;
import java.util.Calendar;


public final class SalesApplicationList extends AbstractArrayListComparsion<SalesApplication, com.example.forcesales.Data.Application.SalesApplicationList> implements Serializable{
    // Lamadas are used to avoid code repetition
    private CompareTwoObjects<Account,String> compare_account_name = (a, b) -> a.getAccountName().equalsIgnoreCase(b);
    private CompareTwoObjects<Account,String> compare_oportunity_name = (a,b) -> a.getOpportunityName().equalsIgnoreCase(b);
    //	private CompareTwoObjects<Account,Client> compare_find_owner = (a,b) -> { return a.getOwner().contains(b); };
    private CompareTwoObjects<Account, Calendar> compare_close_date =
            (a,b) -> a.getCloseDate().get(Calendar.DATE) == b.get(Calendar.DATE) &&
                    a.getCloseDate().get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                    a.getCloseDate().get(Calendar.YEAR) == b.get(Calendar.YEAR);

    public SalesApplicationList() {
        super();
    }

    @Override
    protected SalesApplicationList createEmptyArrayList() {
        return new SalesApplicationList();
    }
}




/*

public final class AccountList extends AbstractArrayListComparsion<Account, com.example.forcesales.Data.Account.AccountList> implements Serializable {







    public com.example.forcesales.Data.Account.AccountList compareAccountName(String value) {
        return abstractContains(value, compare_account_name);
    }

    // public AccountList compareCloseDateGreater(Calendar value)
    // public AccountList compareCloseDateLess(Calendar value)
    public com.example.forcesales.Data.Account.AccountList compareCloseDate(Calendar value) {
        return abstractContains(value, compare_close_date);
    }

    public com.example.forcesales.Data.Account.AccountList compareOpportunityName(String value) {
        return abstractContains(value, compare_oportunity_name);
    }

//	public AccountList compareFindOwner(Client value) {
//		return (AccountList) abstractContains(value, compare_find_owner);
//	}
}
*/
