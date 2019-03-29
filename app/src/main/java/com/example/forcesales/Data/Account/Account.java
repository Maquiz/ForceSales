/**
 * @author Thomas A.
 */
package com.example.forcesales.Data.Account;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Calendar;

import com.example.forcesales.Data.Client.ClientList;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.TaskList;
import com.example.forcesales.Data.util.CompareTwoObjects;

/*
 * The Account class will be the parent object that contains all of the
 * information, needed for a specific work force.
 * 
 * public:
 * 	constructor:
 * 		-> () - Init private members
 * 	(@Object) methods:
 * 		-> equals - For strings, does a case-insensitive check.
 * 	getters:
 * 		-> getAccountName
 * 		-> getClients
 * 		-> getCloseDate
 * 		-> getOpportunityName
 * 		-> getOwner
 * 		-> getSales
 * 		-> getTasks
 * 	setter:
 * 		-> setAccountName
 *	 	-> setClients
 * 		-> setCloseDate
 * 		-> setOpportunityName
 * 		-> setOwner
 * 		-> setSales
 * 		-> setTasks
 * 
 * TODO:
 * 		1. Implement Account Class completely once everyone has implemented their section
 * 		2. Do a error check for null values?
 */

public final class Account implements Parcelable {
	private ClientList clients;
	private Sales sales;
	private TaskList tasks;
	
	private String account_name;
	private String opportunity_name;
	private Calendar close_date;
//	private ClientList owner;
	
	private CompareTwoObjects<String,String> cmp_acc_name = (a,b) -> a.equalsIgnoreCase(b);
	private CompareTwoObjects<String,String> cmp_op_name = (a,b) -> a.equalsIgnoreCase(b);
	private CompareTwoObjects<Calendar,Calendar> cmp_cal = (a,b) ->
			a.get(Calendar.DATE) == b.get(Calendar.DATE) &&
			a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
			a.get(Calendar.YEAR) == b.get(Calendar.YEAR);


	public Account() {
		this.clients = new ClientList();
		this.sales = new Sales();
		this.tasks = new TaskList();
		
		this.account_name = "";
		this.opportunity_name = "";
		this.close_date = Calendar.getInstance();
	}


	protected Account(Parcel in) {
		clients = in.readParcelable(ClientList.class.getClassLoader());
		sales = in.readParcelable(Sales.class.getClassLoader());
		tasks = in.readParcelable(TaskList.class.getClassLoader());
		account_name = in.readString();
		opportunity_name = in.readString();
		close_date = (Calendar) in.readSerializable();
	}

	public static final Creator<Account> CREATOR = new Creator<Account>() {
		@Override
		public Account createFromParcel(Parcel in) {
			return new Account(in);
		}

		@Override
		public Account[] newArray(int size) {
			return new Account[size];
		}
	};

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account cmp = (Account) obj;
			
			if (!cmp_acc_name.compare(cmp.getAccountName(), this.getAccountName()))
				return false;
			else if (!cmp_op_name.compare(cmp.getOpportunityName(), this.getOpportunityName()))
				return false;
			else if (!cmp_cal.compare(cmp.getCloseDate(), this.getCloseDate()))
				return false;
//			else if (!cmp.getOwner().equals(this.getOwner()))
//				return false;
			else if (!cmp.getClients().equals(this.getClients()))
				return false;
//			else if (!cmp.getSales().equals(this.getSales()))
//				return false;
//			else if (!cmp.getTasks().equals(this.getTasks()))
//				return false;
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s | %s/%s/%s",
				account_name,
				opportunity_name,
				close_date.get(Calendar.MONTH), close_date.get(Calendar.DATE), close_date.get(Calendar.YEAR));
	}


	public String getAccountName() {
		return account_name;
	}

	public ClientList getClients() {
		return clients;
	}
	
	public Calendar getCloseDate() {
		return this.close_date;
	}
	
	public String getOpportunityName() {
		return opportunity_name;
	}
	
	public Sales getSales() {
		return sales;
	}
	
	public TaskList getTasks() {
		return tasks;
	}
	
	public void setAccountName(String account_name) {
		this.account_name = account_name;
	}
	
	public void setClients(ClientList clients) {
		this.clients = clients;
	}
	
	public void setCloseDate(Calendar close_date) {
		this.close_date = close_date;
	}
	
	public void setOpportunityName(String opportunity_name) {
		this.opportunity_name = opportunity_name;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(clients, flags);
		dest.writeParcelable(sales, flags);
		dest.writeParcelable(tasks, flags);
		dest.writeString(account_name);
		dest.writeString(opportunity_name);
		dest.writeSerializable(close_date);
	}
}
