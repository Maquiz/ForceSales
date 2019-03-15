package SalesMenu;

import Sale.Sales;
import consoleKit.MenuItem;
import consoleKit.MenuStack;

public class PrintAllSales implements MenuItem {

	private Sales account_sales;

	public PrintAllSales(String string, MenuStack menu_stack, Sales account_sales) {
		// TODO Auto-generated constructor stub
		
		this.account_sales = account_sales;
		
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account_sales.printSales();
	}

}
