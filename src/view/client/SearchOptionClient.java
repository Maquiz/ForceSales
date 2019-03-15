package view.client;

import consoleKit.MenuItem;
import consoleKit.MenuStack;
import data.account.Account;
import data.client.Client;
import data.client.ClientArray;

abstract class SearchOptionClient implements MenuItem {
	private String name;
	protected Account account;
	
	public SearchOptionClient(String name, Account account) {
		this.account = account;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	abstract public void execute();
	
	protected void printInfo(ClientArray client_array) {
		System.out.println("Here is the result:");
		for (Client i: client_array) {
			System.out.println(PrintClient.printSummaryInfo(i));
		}
	}
	

}
