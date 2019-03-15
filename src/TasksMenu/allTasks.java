package TasksMenu;

import consoleKit.MenuItem;
import Tasks.TaskList;
import consoleKit.Console;

/*
 * 
 * 												All Tasks Class
 * 		This is a sub menu option in the Tasks menu that allows the user to see all tasks in the system, when they were assigned
 * 		as well if the task is completed or not.
 * 
 * 
 * 
 * Attributes:
  * TaskList - _taskList - Holds master task list that was passed from main to Tasks menu to this sub menu. 
 * 
 * 
 * 
 * Functions:
 * Constructor - allTasks(TaskList) - Takes master TaskList from main to allow for use in this sub menu.
 * void - execute() - An overriden function that allows for the MenuItem to run this option and print out all tasks to screen.
 * void - toString() - An overriden function that provides a name to the submenu in the Tasks menu.
 */

public final class allTasks implements MenuItem {
	
	private final TaskList _taskList;
	
	public allTasks(TaskList input)
	{
		_taskList = input;
	}
	
	@Override
	public void execute() {
		int input;
		_taskList.getAllTasks();
	}
	
	@Override
	public String toString() {
		return "Show all tasks.";
	}
}
