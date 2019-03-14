package TasksMenu;

import consoleKit.MenuItem;
import Tasks.TaskList;
import consoleKit.Console;
import consoleKit.MenuStack;
import consoleKit.Menu;
import consoleKit.QuitCmd;
import consoleKit.ReturnFromMenu;

/*
 * 
 * 												Tasks Class
 *     This class is the main menu of all the tasks features, this menu will give users access
 *     to all the features provided by the TaskList, as well as adding Task to the list.
 * 
 * 
 * 
 * Attributes:
 * MenuStack - menus - This stack holds all the menu options for the main menu.
 * TaskLIst - _List - This list comes from the main and holds the master list for use in other menus.
 * Menu - mainMenu - This Menu comes from the mainMenu, to allow the ability to return to the main menu.

 * 
 * Functions:
 * Constructor - Task - initializes all attributes passed from main.
 * void - execute() - Is an overriden function which works with MenuItem, allows for execution from the main Menu
 *String - toString() - Is an overriden function to give the menu option a name in the main menu.
*/

public final class Tasks implements MenuItem {
	
	private MenuStack menus;
	private TaskList _List;
	private Menu mainMenu;
	
	public Tasks(TaskList input, Menu _mainMenu, MenuStack _menus) {
		_List = input;
		mainMenu = _mainMenu;
		menus = _menus;
	}
	
	@Override
	public void execute() {
		Menu subMenu = new Menu("Task Manager", menus);
		
		subMenu.add(new QuitCmd());
		subMenu.add(new ReturnFromMenu(mainMenu.toString(), menus));
		subMenu.add(new addTask(_List));
		subMenu.add(new removeTask(_List));
		subMenu.add(new todayTasks(_List));
		subMenu.add(new completedTasks(_List));
		subMenu.add(new allTasks(_List));
		
	}
	
	@Override
	public String toString() {
		return "Manage tasks.";
	}
	

}
