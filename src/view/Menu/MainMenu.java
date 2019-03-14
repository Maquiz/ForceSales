package view.Menu;

import TasksMenu.Tasks;
import consoleKit.Menu;
import consoleKit.MenuStack;
import data.account.Account;
import view.client.ClientMenu;

public final class MainMenu extends Menu {
	private Account account;

	public MainMenu(String name, MenuStack menus) {
		super(name, menus);
		this.account = new Account();
		
		this.add(new ClientMenu("Manage clients", menus, account));
		this.add(new Tasks(account.getTasks(), this, menus));
	}

}
