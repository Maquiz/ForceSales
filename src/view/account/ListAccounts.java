package view.account;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.account.AccountArray;

final class ListAccounts implements MenuItem {
	private AccountArray account_array;
	private MenuStack menu_stack;
	private String option_name;
	
	public ListAccounts(String option_name, MenuStack menu_stack, AccountArray account_array) {
		this.account_array = account_array;
		this.menu_stack = menu_stack;
		this.option_name = option_name;
	}
	
	@Override
	public void execute() {
		for (Account i: account_array) {
			System.out.println(i);
		}
		System.out.println();
		
		Menu subMenu = new Menu("List Accounts", menu_stack);
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}
	
	@Override
	public String toString() {
		return option_name;
	}
}
