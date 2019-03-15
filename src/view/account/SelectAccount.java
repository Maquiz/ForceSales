package view.account;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import data.account.Account;
import data.account.AccountArray;

abstract class SelectAccount implements MenuItem {
	private AccountArray account_array;
	private Account account;
	private MenuStack stack_menu;
	
	public SelectAccount(AccountArray account_array, Account account, MenuStack stack_menu) {
		this.account_array = account_array;
		this.account = account;
		this.stack_menu = stack_menu;
	}
	
	
//	@Override
//	public void execute() {
//		stack_menu.toPreviousMenu();
//	}
	public AccountArray getAccountArray() {
		return this.account_array;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public MenuStack getMenuStack() {
		return this.stack_menu;
	}
	
	@Override
	abstract public void execute();
	
	@Override
	public String toString() {
		return String.format("%s (%s)",
				this.account.getOpportunityName(), this.account.getAccountName());
	}

}
