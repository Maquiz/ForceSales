package view.account;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.account.AccountArray;

final class DeleteAccount implements MenuItem {
	private AccountArray account_array;
	private MenuStack menu_stack;
	private String option_name;
	
	private SelectAccount select_account;
	
	public DeleteAccount(String option_name, MenuStack menu_stack, AccountArray account_array) {
		this.account_array = account_array;
		this.menu_stack = menu_stack;
		this.option_name = option_name;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu("", menu_stack);
		
		for (Account account: account_array) {
		subMenu.add(
			new SelectAccount(account_array, account, menu_stack) {
				public void execute() {
					this.getAccountArray().remove(this.getAccount());
					this.getMenuStack().toPreviousMenu();
				}
			});
		}
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}

	@Override
	public String toString() {
		return option_name;
	}
}
