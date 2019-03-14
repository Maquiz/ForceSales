import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import Tasks.Employee;
import Tasks.Task;
import Tasks.TaskList;
import TasksMenu.Tasks;
import TasksMenu.addTask;
import TasksMenu.todayTasks;
import consoleKit.MenuStack;
import consoleKit.Menu;
import consoleKit.QuitCmd;

public class ForceSalesApp {

	public static void main(String[] arg) {
		
		//menus stuff
		MenuStack menus = new MenuStack();
		
		
		//Fake Employee objects for testing
		Employee Arend = new Employee("Arend");
		Employee Thomas = new Employee("Thomas");
		Employee Max = new Employee("Max");
		
		Calendar test = Calendar.getInstance();
		
		Task job1 = new Task("Sales report", Arend, test);
		Task job2 = new Task("Profit Report", Thomas, test);
		Task job3 = new Task("Growth report", Max, test);
		
		job3.setTaskDone();
		
		TaskList _List = new TaskList();
		
		_List.addTask(job1);
		_List.addTask(job2);
		_List.addTask(job3);
		
		Menu mainMenu = new Menu("Main menu", menus);
		mainMenu.add(new QuitCmd());
		mainMenu.add(new Tasks(_List, mainMenu,menus));
		
		
		System.out.println("Force Sales Pre-Alpha 0.1");
		
		while(true) {
			menus.run();
		}
	 
	}
	
}


