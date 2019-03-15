package SalesMenu;

import Sale.Item;
import Sale.Sales;
import consoleKit.MenuItem;
import consoleKit.MenuStack;

public class AddItem implements MenuItem {

	
	private Sales account_sales;
	private MenuStack stackMenu;
	private Item item = new Item("Awesome Software", 1000.00f, 1);
	
	public AddItem(String string, MenuStack menu_stack, Sales account_sales) {
		// TODO Auto-generated constructor stub
		this.account_sales = account_sales;
		this.stackMenu = menu_stack;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//Hard Coded Item at this point
		account_sales.getSale(0).addItem(item);
	}

}
