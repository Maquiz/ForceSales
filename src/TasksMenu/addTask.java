package TasksMenu;

import consoleKit.MenuItem;
import consoleKit.Console;
import java.util.Calendar;

import Tasks.Employee;
import Tasks.Task;
import Tasks.TaskList;

/*
 * 
 * 														Remove Task Class
 * 		This class is a sub menu of the Tasks menu, it allows the user the ability to remove a task from a task list
 * 
 * 
 * 
 * Attributes:
 * TaskList - _taskList - Holds master task list that was passed from main to Tasks menu to this sub menu.
 * int - MAX_ADVANCE - Used to prevent users from inputting a year that is more that 100 years away.
 * 
 * Functions:
 * Constructor - addTask(TaskList) - Accepts master task list from main for use through out the class
 * void - execute() - An overriden function that allows for the MenuItem to run the task of adding a task to the list.
 * void - toString() - An overriden function that provides a name to the submenu in the Tasks menu.
 * 
 * 
 */

public final class addTask implements MenuItem {
	
	private final TaskList _taskList;
    private static final int MAX_ADVANCE = 100;
	
	public addTask(TaskList input)
	{
		_taskList = input;
	}
	
	//needs get employee to initialize employee
	@Override
	public void execute() {
		Calendar dueDate = Calendar.getInstance();
        int yr, mo, day, hr, min;
        String taskName;
        int thisyr = 2019;
        
        Task temp;
        
        //temp object remove during error fixing
		Employee Arend = new Employee("Arend");
        
        taskName = Console.getString("Enter task name:");
        yr = Console.intInRange("Enter a year:", thisyr, thisyr+MAX_ADVANCE);
        mo = Console.intInRange("Enter a month:", Calendar.JANUARY+1, Calendar.DECEMBER+1) - 1;
        day = Console.intInRange("Enter a day:", 1, 31);
        hr = Console.intInRange("Enter an hour:", 0, 23);
        min = Console.intInRange("Enter a minute:", 0, 59);	
        dueDate.set(yr, mo, day, hr, min);
        
        temp = new Task(taskName, Arend, dueDate);
        
        _taskList.addTask(temp);
        
	}
	
	@Override
	public String toString() {
		return "Add a Task";
	}

}
