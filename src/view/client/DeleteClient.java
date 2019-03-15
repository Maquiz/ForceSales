package view.client;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.client.Client;

final class DeleteClient implements MenuItem {
	private String menu_name;
	private MenuStack stack_menu;
	private Account account;

	public DeleteClient(String menu_name, MenuStack stack_menu, Account account) {
		this.menu_name = menu_name;
		this.stack_menu = stack_menu;
		this.account = account;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu(menu_name, stack_menu);
		
		for (Client i: account.getClients()) {
			subMenu.add(new DeleteSelectedClient(stack_menu, account, i));
		}
		subMenu.add(new ReturnFromMenu("Return", stack_menu));
		
		subMenu.execute();
	}

	@Override
	public String toString() {
		return menu_name;
	}
}
