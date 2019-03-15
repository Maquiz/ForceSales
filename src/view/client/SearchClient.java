package view.client;

import consoleKit.Console;
import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import data.account.Account;
import data.client.Address;

final class SearchClient implements MenuItem {
	private String name;
	private MenuStack menu_stack;
	private Account account;

	public SearchClient(String name, MenuStack menu_stack, Account account) {
		this.name = name;
		this.menu_stack = menu_stack;
		this.account = account;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu(name, menu_stack);
		
		subMenu.add(
			new SearchOptionClient("Search first name", account) {
				@Override
				public void execute() {
					Console.STDIN.nextLine();
					String search_value;
					System.out.print("Enter a first name: ");
					search_value = Console.STDIN.nextLine();
					printInfo(account.getClients().containsFirstName(search_value));
				}
			}
		);
		
		subMenu.add(
				new SearchOptionClient("Search last name", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						System.out.print("Enter a last name: ");
						String search_value;
						search_value = Console.STDIN.nextLine();
						printInfo(account.getClients().containsLastName(search_value));
					}
				}
			);
		
		subMenu.add(
				new SearchOptionClient("Search email", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						System.out.print("Enter email: ");
						String search_value;
						search_value = Console.STDIN.nextLine();
						printInfo(account.getClients().containsEmail(search_value));
					}
				}
			);
		
		subMenu.add(
				new SearchOptionClient("Search address city", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						String city;
						System.out.print("Enter city: ");
						city = Console.STDIN.nextLine();
						
						Address search_value = new Address();
						search_value.setCity(city);
						printInfo(account.getClients().containsAddressCity(search_value));
					}
				}
			);
		
		subMenu.add(
				new SearchOptionClient("Search address state", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						String state;
						System.out.print("Enter state: ");
						state = Console.STDIN.nextLine();
						
						Address search_value = new Address();
						search_value.setState(state);
						printInfo(account.getClients().containsAddressState(search_value));
					}
				}
			);
		
		subMenu.add(
				new SearchOptionClient("Search address street", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						String street;
						System.out.print("Enter street: ");
						street = Console.STDIN.nextLine();
						
						Address search_value = new Address();
						search_value.setStreetAddress(street);
						printInfo(account.getClients().containsAddressStreet(search_value));
					}
				}
			);
		
		subMenu.add(
				new SearchOptionClient("Search address zip code", account) {
					@Override
					public void execute() {
						Console.STDIN.nextLine();
						String zip_code;
						System.out.print("Enter zip code: ");
						zip_code = Console.STDIN.nextLine();
						
						Address search_value = new Address();
						search_value.setZipCode(zip_code);
						printInfo(account.getClients().containsAddressZipCode(search_value));
					}
				}
			);
		
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}
}
