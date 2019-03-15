package view.client;

import consoleKit.Console;
import consoleKit.MenuItem;
import data.account.Account;
import data.client.Address;
import data.client.Client;

final class CreateClient implements MenuItem {
	private Account account;
	private String desc;
	private String value1[];
	private Address value2;
	
	public CreateClient(String desc, Account account) {
		this.account = account;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}
	
	@Override
	public void execute() {
		Client new_client;
		
		value1 = new String[3];
		value2 = new Address();
		
		getInformation();
		System.out.println();
		validateInformation();
		System.out.println();
		
		String validate;
		System.out.println();
		System.out.print("Are you okay with the following? (Y or Yes): ");
		validate = Console.STDIN.next();
		if (!validate.equalsIgnoreCase("Y") && !validate.equalsIgnoreCase("Yes")) {
			return;
		}
		
		new_client = new Client();
		new_client.setFirstName(value1[0]);
		new_client.setLastName(value1[1]);
		new_client.setEmail(value1[2]);
		new_client.setAddress(value2);
		
		account.getClients().add(new_client);
	}
	
	protected void getInformation() {
		Console.STDIN.nextLine();
		
		System.out.print("Enter first name: ");
		value1[0] = Console.STDIN.nextLine();
		
		System.out.print("Enter last name: ");
		value1[1] = Console.STDIN.nextLine();
		
		System.out.print("Enter email address: ");
		value1[2] = Console.STDIN.nextLine();
		
		System.out.print("Enter street address: ");
		value2.setStreetAddress(Console.STDIN.nextLine());
		
		System.out.print("Enter city: ");
		value2.setCity(Console.STDIN.nextLine());
		
		System.out.print("Enter state: ");
		value2.setState(Console.STDIN.nextLine());
		
		System.out.print("Enter zip code: ");
		value2.setZipCode(Console.STDIN.nextLine());
	}
	
	protected void validateInformation() {
		System.out.format("First Name: %s\n", value1[0]);
		System.out.format("Last name: %s\n", value1[1]);
		System.out.format("Email: %s\n", value1[2]);
		
		System.out.format("Street Address: %s\n", value2.getStreetAddress());
		System.out.format("City: %s\n", value2.getCity());
		System.out.format("State: %s\n", value2.getState());
		System.out.format("Zip Code: %s\n", value2.getZipCode());
	}
}
