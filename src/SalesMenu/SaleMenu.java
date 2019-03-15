package SalesMenu;

import Sale.Sales;
import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;

public class SaleMenu implements MenuItem {
	private Sales account_sales;
	private MenuStack menu_stack;
	private String option_name;
	
	public SaleMenu(String option_name, Sales _account_sales, MenuStack menu_stack) {
		this.account_sales = _account_sales;
		this.menu_stack = menu_stack;
		this.option_name = option_name;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu("Sales Management", menu_stack);
		//Create Sale
		subMenu.add(new CreateSale(account_sales, menu_stack));
		//Print All Sales
		subMenu.add(new PrintAllSales("Print All Sales", menu_stack, account_sales));
		
		//.add(new SearchAccount("Search account", menu_stack, account_array));
		//Add Item
		subMenu.add(new AddItem("Delete accounts", menu_stack, account_sales));
		subMenu.add(new ReturnFromMenu("Return", menu_stack));
	}
	
	@Override
	public String toString() {
		return option_name;
	}
}

/*
 * 1. Create Account
 * 2. Select Account
 * 3. Delete Account
 * 4. Search Account
 */
