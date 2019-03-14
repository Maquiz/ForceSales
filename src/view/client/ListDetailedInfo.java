package view.client;

import consoleKit.MenuStack;
import data.account.Account;
import data.client.Client;

final class ListDetailedInfo extends SelectClient {

	public ListDetailedInfo(MenuStack menu_stack, Account account, Client client) {
		super(menu_stack, account, client);
	}

	@Override
	public void execute() {
		System.out.println(PrintClient.printDetailedInfo(this.client));
		super.execute();
	}

}
