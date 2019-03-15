package view.client;

import consoleKit.MenuItem;
import consoleKit.MenuStack;
import data.account.Account;
import data.client.Client;

class SelectClient implements MenuItem {
	protected Client client;
	protected Account account;
	protected MenuStack menu_stack;
	
	public SelectClient(MenuStack menu_stack, Account account, Client client) {
		this.client = client;
		this.account = account;
		this.menu_stack = menu_stack;
	}
	
	@Override
	public void execute() {
		menu_stack.toPreviousMenu();
	}
	
	@Override
	public String toString() {
		return PrintClient.printSummaryInfo(client);
	}
}
