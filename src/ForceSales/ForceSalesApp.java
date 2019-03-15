package ForceSales;

import consoleKit.MenuStack;
import view.Menu.MainMenu;

public class ForceSalesApp {
	
	public static void main(String[] arg) {
		
		MenuStack menu_stack = new MenuStack();
		MainMenu main_menu = new MainMenu("Main Menu", menu_stack);
		
		System.out.println("ForceSales APP - HOMEWORK 1");
		
		while(true) {
			menu_stack.run();
		}
	}

}
