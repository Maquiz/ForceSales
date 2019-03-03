/*
 * 
 * 														Task Class
 * This object holds task information such as a task name, is the task complete?, and who is assigned to this task?
 * 
 * Attributes:
 * nameOfTask - String: holds the name of the task.
 * isTaskDone - Boolean: defaults to false, set to true when the task is complete.
 * assigned - Employee: holds employee object of the employee working on the task.
 * 
 * Functions:
 * Task(String, Employee) - (Constructor) String input is set to name of task and Employee object is set to assigned Employee. 
 * 							isTaskDone defaults to false.
 * getNameOfTask() - Returns name of task.
 * setNameOfTask(String) - Changes name of task to input string.
 * isTaskDone() - Returns boolean. False means the task is not done and True means the task is completed.
 * setTaskDone() - Sets isTaskDone attribute to true.
 * getAssigned() - Returned assigned Employee object.
 * changeAssigned(Employee) - Sets assigned Employee to input Employee.
 * 
 */

public class Task {

	//Attributes
	private String nameOfTask;
	private boolean isTaskDone;
	private Employee assigned;
	
	//Constructor
	Task(String name, Employee who){
		this.nameOfTask = name;
		this.isTaskDone = false;
		this.assigned = who;
	}

	public String getNameOfTask() {
		return nameOfTask;
	}

	public void setNameOfTask(String nameOfTask) {
		this.nameOfTask = nameOfTask;
	}

	public boolean isTaskDone() {
		return isTaskDone;
	}

	public void setTaskDone() {
		this.isTaskDone = true;
	}

	public Employee getAssigned() {
		return assigned;
	}

	public void changeAssigned(Employee assigned) {
		this.assigned = assigned;
	}	
	
}
