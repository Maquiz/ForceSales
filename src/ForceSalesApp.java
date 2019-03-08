import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import Tasks.Employee;
import Tasks.Task;
import Tasks.TaskList;

public class ForceSalesApp {

	public static void main(String[] arg) {
		
		//Fake Employee objects for testing
		Employee Arend = new Employee("Arend");
		Employee Thomas = new Employee("Thomas");
		Employee Max = new Employee("Max");
		
		Calendar test = Calendar.getInstance();
		
		Task job1 = new Task("Sales report", Arend, test);
		Task job2 = new Task("Profit Report", Thomas, test);
		Task job3 = new Task("Growth report", Max, test);
		
		TaskList list = new TaskList();
		
		
		job1.setTaskDone();
		
		list.addTask(job1);
		list.addTask(job2);
		list.addTask(job3);
		
		boolean flag = true;
		
		int option;

		Scanner keyboard = new Scanner(System.in);
		
		while(flag == true)
		{
			System.out.println("Select an option");
			System.out.println("1. Get all Tasks.");
			System.out.println("2. Get Completed Tasks.");
			System.out.println("3. Get Tasks.");
			System.out.println("4. Get Today's Tasks.");
			System.out.println("5. Exit.");
			
			option = keyboard.nextInt();
			
			for(int i = 0; i < 25; i++)
			{
				System.out.println("\n");
			}
		
			switch(option){
				
			case 1:
				list.getAllTasks();
				break;
			case 2:
				list.getCompletedTasks();
				break;
			case 3:
				list.getTasks();
				break;
			case 4:
				list.getTodaysTasks();
				break;
			case 5:
				flag = false;
			}
			
			for(int i = 0; i < 2; i++)
			{
				System.out.println("\n");
			}
		
		}	
		
	}
	 
}


