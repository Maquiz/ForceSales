package TasksMenu;

/*
 * 										Mark Task as Complete Class
 * 		This class is a sub menu of Tasks that will list out tasks that are not completed and gies
 * user the ability to type in the name of the task and it will mark that task as complete.
 * 
 * 
 * 
 * 
 * Attributes:
 * _List - List: An array list which holds task objects.
 * 
 * 
 * 
 * Functions:
 * Constructor - markCompleteTasks(TaskList) - Provides use of the master list throughout the class.
 * void - execute() - An overriden method that askes for user input, then search for the task object based on input and mark it as complete
 * String - toString() - Provides a name for submenu.
 *
 */

import Tasks.TaskList;
import consoleKit.Console;
import consoleKit.MenuItem;

public class markCompleteTasks implements MenuItem {
	
	private final TaskList _List;
	
	public markCompleteTasks(TaskList input) {
		_List = input;
	}
	
	@Override
	public void execute() {
		String input;
		boolean isSet = false;
		
		System.out.println();
		
		_List.getTasks();
		
		input = Console.getString("Please type in the name of the task: ");
		
		for(int i = 0; i < _List.getSize(); i++) {
			if(input.equals(_List.get(i).getNameOfTask()))
			{
				_List.get(i).setTaskDone();
				isSet = true;
			}

		}
		
		if(isSet == true) {
			System.out.println("Task marked as completed");
		}
		else {
			System.out.println("Task could not be found.");
		}
		
	}
	
	@Override
	public String toString() {
		return "Mark task as complete.";
	}

}
