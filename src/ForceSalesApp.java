public class ForceSalesApp {

	public static void main(String[] arg) {
		
		//Fake Employee objects for testing
		Employee Arend = new Employee("Arend");
		Employee Thomas = new Employee("Thomas");
		Employee Max = new Employee("Max");
		
		Task job1 = new Task("Sales report", Arend);
		Task job2 = new Task("Profit Report", Thomas);
		Task job3 = new Task("Growth report", Max);
		
		TaskList list = new TaskList();
		
		
		job1.setTaskDone();
		
		list.addTask(job1);
		list.addTask(job2);
		list.addTask(job3);
		
		//list.getAllTasks();
		
		//list.getCompletedTasks();
		
		list.getTasks();
		
		
		
		
		
		
		
	}
}
