package view.account;

import java.util.Calendar;

import Sale.Sales;
import Tasks.TaskList;
import consoleKit.Console;
import consoleKit.MenuItem;
import data.account.Account;
import data.account.AccountArray;
import data.client.ClientArray;

final class CreateAccount implements MenuItem {
	private AccountArray account_array;
	private Account account;
	private String value1[];
	private int value2[];
	
	public CreateAccount(AccountArray account_array) {
		this.account_array = account_array;
	}
	
	@Override
	public void execute() {
		account = new Account();
		value1 = new String [2];
		value2 = new int [3];
		
		provideDetails();
		assignDetails();
		
		account_array.add(account);
	}
	
	private void provideDetails() {
		Console.STDIN.nextLine();
		
		System.out.print("Enter account name: ");
		value1[0] = Console.STDIN.nextLine();
		
		System.out.print("Enter opportunity name: ");
		value1[1] = Console.STDIN.nextLine();
		
		System.out.println("For the calendar:");
		System.out.print("Enter year: ");
		value2[0] = Console.STDIN.nextInt();
		System.out.print("Enter month: ");
		value2[1] = Console.STDIN.nextInt();
		System.out.print("Enter date: ");
		value2[2] = Console.STDIN.nextInt();
		Console.STDIN.nextLine();
	}
	
	private void assignDetails() {
		account.setClients(new ClientArray());
		account.setSales(new Sales());
		account.setTasks(new TaskList());
		
		Calendar close_date = Calendar.getInstance();
		close_date.set(value2[0], value2[1], value2[2]);
		account.setAccountName(value1[0]);
		account.setCloseDate(close_date);
		account.setOpportunityName(value1[1]);
	}
	
	@Override
	public String toString() {
		return "Create Account";
	}
}
