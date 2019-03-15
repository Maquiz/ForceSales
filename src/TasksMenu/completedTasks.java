package TasksMenu;

import Tasks.TaskList;
import consoleKit.MenuItem;

/*
 * 
 * 												Completed Tasks Class
 * 		This is a sub menu option in the Tasks menu that allows the user to see all  completedtasks in the system, when they were completed.
 * 
 * 
 * 
 * Attributes:
  * TaskList - _taskList - Holds master task list that was passed from main to Tasks menu to this sub menu. 
 * 
 * 
 * 
 * Functions:
 * Constructor - completedTasks(TaskList) - Takes master TaskList from main to allow for use in this sub menu.
 * void - execute() - An overriden function that allows for the MenuItem to run this option and print out all completed tasks to screen.
 * void - toString() - An overriden function that provides a name to the submenu in the Tasks menu.
 */


public final class completedTasks implements MenuItem {
	
	private final TaskList _taskList;
	
	public completedTasks(TaskList input)
	{
		_taskList = input;
	}
	
	@Override
	public void execute() {
		_taskList.getCompletedTasks();
	}
	
	@Override
	public String toString() {
		return "Show tasks that have been completed.";
	}
}
