package view.client;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;

public class ClientMenu implements MenuItem {
	private String menu_name;
	private Account account;
	private MenuStack menu_stack;
	
	public ClientMenu(String menu_name, MenuStack menu_stack, Account account) {
		this.menu_name = menu_name;
		this.account = account;
		this.menu_stack = menu_stack;
	}

	@Override
	public void execute() {
		Menu subMenu = new Menu(menu_name, menu_stack);
		subMenu.add(new CreateClient("Add Client",account));
		subMenu.add(new PrintClient("View Clients", menu_stack, account));
		subMenu.add(new SearchClient("Search Client", menu_stack, account));
		subMenu.add(new DeleteClient("Remove Client", menu_stack, account));
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
		subMenu.execute();
	}
	
	@Override
	public String toString() {
		return menu_name;
	}
}
