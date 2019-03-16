/**
 * @author Thomas A.
 */
package com.example.forcesales.Data.account;

import java.util.Calendar;

import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.TaskList;
import com.example.forcesales.Data.client.ClientArray;
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

public final class Account {
	private ClientArray clients;
	private Sales sales;
	private TaskList tasks;
	
	private String account_name;
	private String opportunity_name;
	private Calendar close_date;
//	private ClientArray owner;
	
	private CompareTwoObjects<String,String> cmp_acc_name = (a,b) -> { return a.equalsIgnoreCase(b); };
	private CompareTwoObjects<String,String> cmp_op_name = (a,b) -> { return a.equalsIgnoreCase(b); };
	private CompareTwoObjects<Calendar,Calendar> cmp_cal = (a,b) -> {
		return a.get(Calendar.DATE) == b.get(Calendar.DATE) &&
				a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
				a.get(Calendar.YEAR) == b.get(Calendar.YEAR);
	};
	
	public Account() {
		this.clients = new ClientArray();
		this.sales = new Sales();
		this.tasks = new TaskList();
		
		this.account_name = "";
		this.opportunity_name = "";
		this.close_date = Calendar.getInstance();
//		this.owner = new ClientArray();
	}
	
	
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

	public ClientArray getClients() {
		return clients;
	}
	
	public Calendar getCloseDate() {
		return this.close_date;
	}
	
	public String getOpportunityName() {
		return opportunity_name;
	}
	
//	public ClientArray getOwner() {
//		return this.owner;
//	}
	
	public Sales getSales() {
		return sales;
	}
	
	public TaskList getTasks() {
		return tasks;
	}
	
	
	public void setAccountName(String account_name) {
		this.account_name = account_name;
	}
	
	public void setClients(ClientArray clients) {
		this.clients = clients;
	}
	
	public void setCloseDate(Calendar close_date) {
		this.close_date = close_date;
	}
	
	public void setOpportunityName(String opportunity_name) {
		this.opportunity_name = opportunity_name;
	}
	
//	public void setOwner(ClientArray owner) {
//		this.owner = owner;
//	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}
}
