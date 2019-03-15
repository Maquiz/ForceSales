package SalesMenu;

import Sale.Sale;
import Sale.Sales;
import consoleKit.Console;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;

public class CreateSale implements MenuItem {
	private Sales account_sales;
	private MenuStack menu_stack;
	private int id;
	
	public CreateSale(Sales account_sales, MenuStack _menustack) {
		// TODO Auto-generated constructor stub
		this.account_sales = account_sales;
		this.menu_stack = _menustack;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		provideDetails();
		Sale sale = new Sale(id);
		this.account_sales.addSale(sale);	

	}
	
	private void provideDetails() {
		Console.STDIN.nextLine();
		
		System.out.print("Enter the Sale ID: ");
		id = Console.STDIN.nextInt();
	}

}
