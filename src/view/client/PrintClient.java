package view.client;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.client.Client;

final class PrintClient implements MenuItem {
	private String menu_name;
	private Account account;
	private MenuStack menu_stack;
	
	public PrintClient(String name, MenuStack menus, Account account) {
		this.menu_name = name;
		this.account = account;
		this.menu_stack = menus;
	}
	
	public void execute() {
		Menu subMenu = new Menu(menu_name, menu_stack);
		
		for (Client i: account.getClients()) {
			subMenu.add(new ListDetailedInfo(menu_stack, account,i));
		}
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
		
		subMenu.execute();
	}
	
	@Override
	public String toString() {
		return menu_name;
	}
	
	
	static public String printSummaryInfo(Client client) {
		return String.format("%s %s | %s | %s, %s",
				client.getFirstName(), client.getLastName(),
				client.getEmail(),
				client.getAddress().getCity(), client.getAddress().getState());
	}
	
	static public String printDetailedInfo(Client client) {
		return String.format("%s\n%s\n%s\n", printFullName(client), printEmail(client), printAddress(client));
	}
	
	static protected String abstractPrintString(String desc, String result) {
		return String.format("%s: %s", desc, result);
	}
	
	static public String printFullName(Client client) {
		return abstractPrintString("Name",String.format("%s %s", client.getFirstName(), client.getLastName()));
	}
	
	static public String printEmail(Client client) {
		return abstractPrintString("Email",client.getEmail());
	}
	
	static public String printAddress(Client client) {
		String value[] = new String[4];
		value[0] = client.getAddress().getStreetAddress();
		value[1] = client.getAddress().getCity();
		value[2] = client.getAddress().getState();
		value[3] = client.getAddress().getZipCode();
		
		return abstractPrintString("Address", String.format("\n\t%s\n\t%s, %s, %s", value[0],value[1],value[2],value[3]));
	}
}
