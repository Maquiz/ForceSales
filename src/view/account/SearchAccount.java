package view.account;

import java.util.Calendar;

import consoleKit.Console;
import consoleKit.Holder;
import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.account.AccountArray;

public class SearchAccount implements MenuItem {
	private String name;
	private MenuStack menu_stack;
	private AccountArray account_array;
	
	public SearchAccount(String name, MenuStack menu_stack, AccountArray account_array) {
		this.name = name;
		this.menu_stack = menu_stack;
		this.account_array = account_array;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public void execute() {
		String test;
		Holder<AccountArray> holder = new Holder<>();
		Menu subMenu = new Menu(name, menu_stack);
		
		subMenu.add(
			new SearchOptionAccount("Search Account Name", holder, account_array) {
				@Override
				public void execute() {
					Console.STDIN.nextLine();
					
					String value;
					System.out.print("Enter Account Name: ");
					value = Console.STDIN.nextLine();
					getHolder().set(getAccountArray().compareAccountName(value));
					printResult();
				}
			}
		);
		
		subMenu.add(
				new SearchOptionAccount("Search Opportunity Name", holder, account_array) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						
						String value;
						System.out.print("Enter Account Name: ");
						value = Console.STDIN.nextLine();
						getHolder().set(getAccountArray().compareOpportunityName(value));
						printResult();
					}
				}
			);
		
		subMenu.add(
				new SearchOptionAccount("Search Close Date", holder, account_array) {
					@Override
					public void execute() {
						int value[] = new int [3];
						System.out.println("For Close Date:");
						
						System.out.print("Enter year: ");
						value[0] = Console.STDIN.nextInt();
						System.out.print("Enter month: ");
						value[1] = Console.STDIN.nextInt();
						System.out.print("Enter date: ");
						value[2] = Console.STDIN.nextInt();
						
						Calendar search_value = Calendar.getInstance();
						search_value.set(value[0], value[1], value[2]);
						getHolder().set(getAccountArray().compareCloseDate(search_value));
						printResult();
					}
				}
			);
		
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}
}
