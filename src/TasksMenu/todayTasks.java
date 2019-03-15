package TasksMenu;

import Tasks.TaskList;
import consoleKit.MenuItem;

/*
 * 
 * 												Today's Tasks Class
 * 		This is a sub menu option in the Tasks menu that allows the user to see all tasks in the system that are due today, 
 * when they were assigned.
 * 
 * 
 * 
 * Attributes:
  * TaskList - _taskList - Holds master task list that was passed from main to Tasks menu to this sub menu. 
 * 
 * 
 * 
 * Functions:
 * Constructor - todaysTasks(TaskList) - Takes master TaskList from main to allow for use in this sub menu.
 * void - execute() - An overriden function that allows for the MenuItem to run this option and print out all tasks due today to screen.
 * void - toString() - An overriden function that provides a name to the submenu in the Tasks menu.
 */

public final class todayTasks implements MenuItem {
	
	private final TaskList _taskList;
	
	public todayTasks(TaskList input)
	{
		_taskList = input;
	}
	
	@Override
	public void execute() {
		_taskList.getTodaysTasks();
	}
	
	@Override
	public String toString() {
		return "Show tasks due today.";
	}
}
