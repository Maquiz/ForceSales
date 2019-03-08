/**
 * @author Thomas A.
 */
package data.account;

import java.util.Calendar;

import data.client.ClientArray;

/**
 * The Account class will be responsible for connecting the following objects the clients, sales,  
 * 
 * TODO:
 * 		1. Implement Account Class completely once everyone has implemented their section
 * 		2. Do a error check for null values?
 */
public final class Account {
	private ClientArray clients;
	private Object sales;
	private Object tasks;
	private String account_name;
	private String opportunity_name;
	private Calendar close_date;
	
	public Account() {
		this.clients = new ClientArray();
		this.account_name = "";
		this.opportunity_name = "";
		this.close_date = Calendar.getInstance();
	}
	
	// Returns the account name
	public String getAccountName() {
		return account_name;
	}
	
	// Sets the account name
	public void setAccountName(String account_name) {
		this.account_name = account_name;
	}
	
	// Returns the opportunity name
	public String getOpportunityName() {
		return opportunity_name;
	}
	
	// Sets the opportunity name
	public void setOpportunityName(String opportunity_name) {
		this.opportunity_name = opportunity_name;
	}

	// Returns the groups of clients
	public ClientArray getClients() {
		return clients;
	}

	// Sets the group of clients.
	public void setClients(ClientArray clients) {
		this.clients = clients;
	}
	
	// Returns the close date
	public Calendar getCloseDate() {
		return this.close_date;
	}
	
	// Sets the close date.
	public void setCloseDate(Calendar close_date) {
		this.close_date = close_date;
	}
}
