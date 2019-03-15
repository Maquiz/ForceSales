package view.Menu;

import TasksMenu.Tasks;
import consoleKit.Menu;
import consoleKit.MenuStack;
import data.account.Account;
import data.account.AccountArray;
import view.account.AccountMenu;
import view.client.ClientMenu;
import SalesMenu.SaleMenu;

public final class MainMenu extends Menu {
	private Account account;
	private AccountArray account_array;

	public MainMenu(String name, MenuStack menus) {
		super(name, menus);
		this.account = new Account();
		this.account_array = new AccountArray();
		
		
		this.add(new ClientMenu("Manage clients", menus, account));
		this.add(new Tasks(account.getTasks(), this, menus));
		this.add(new AccountMenu("Manage accounts", account_array, menus));
		this.add(new SaleMenu("Manage Sales", account.getSales(), menus));
	}

}
