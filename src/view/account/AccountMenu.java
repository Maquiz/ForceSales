package view.account;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.account.AccountArray;

public class AccountMenu implements MenuItem {
	private AccountArray account_array;
	private MenuStack menu_stack;
	private String option_name;
	
	public AccountMenu(String option_name, AccountArray account_array, MenuStack menu_stack) {
		this.account_array = account_array;
		this.menu_stack = menu_stack;
		this.option_name = option_name;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu("Account Mangement", menu_stack);
		
		subMenu.add(new CreateAccount(account_array));
		subMenu.add(new ListAccounts("List accounts", menu_stack, account_array));
		subMenu.add(new SearchAccount("Search account", menu_stack, account_array));
		subMenu.add(new DeleteAccount("Delete accounts", menu_stack, account_array));
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}
	
	@Override
	public String toString() {
		return option_name;
	}
}

/*
 * 1. Create Account
 * 2. Select Account
 * 3. Delete Account
 * 4. Search Account
 */