package view.client;

import consoleKit.MenuStack;
import data.account.Account;
import data.client.Client;

final class DeleteSelectedClient extends SelectClient {

	public DeleteSelectedClient(MenuStack menu_stack, Account account, Client client) {
		super(menu_stack, account, client);
	}

	@Override
	public void execute() {
		account.getClients().remove(client);
		super.execute();
	}

}
