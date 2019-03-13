/**
 * @author Thomas A.
 */
package data.account;

import java.util.Calendar;

import Sale.Sale;
import Sale.Sales;
import Tasks.TaskList;
import data.client.ClientArray;

/*
 * The Account class will be the parent object that contains all of the
 * information, needed for a specific work force.
 * 
 * public:
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
	private ClientArray owner;
	
	
	public Account() {
		this.clients = new ClientArray();
		this.sales = new Sales();
		this.tasks = new TaskList();
		
		this.account_name = "";
		this.opportunity_name = "";
		this.close_date = Calendar.getInstance();
		this.owner = new ClientArray();
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
	
	public ClientArray getOwner() {
		return this.owner;
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
	
	public void setClients(ClientArray clients) {
		this.clients = clients;
	}
	
	public void setCloseDate(Calendar close_date) {
		this.close_date = close_date;
	}
	
	public void setOpportunityName(String opportunity_name) {
		this.opportunity_name = opportunity_name;
	}
	
	public void setOwner(ClientArray owner) {
		this.owner = owner;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}
}
