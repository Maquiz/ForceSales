package TasksMenu;

import consoleKit.MenuItem;
import Tasks.TaskList;
import consoleKit.Console;

public class removeTask implements MenuItem {
	
	private final TaskList _taskList;
	
	public removeTask(TaskList input)
	{
		_taskList = input;
	}
	
	@Override
	public void execute() {
		int input;
		_taskList.getAllTasks();
		input = Console.intInRange("Enter a choice: ", 0, (_taskList.getSize() - 1));
		_taskList.removeTask(input);
	}
	
	@Override
	public String toString() {
		return "Remove a task.";
	}
}
