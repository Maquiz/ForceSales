/*
 * 
 * 														Task Class
 * This object holds task information such as a task name, is the task complete?, and who is assigned to this task?
 * 
 * Attributes:
 * nameOfTask - String: holds the name of the task.
 * isTaskDone - Boolean: defaults to false, set to true when the task is complete.
 * assigned - Employee: holds employee object of the employee working on the task.
 * assignedDate - Date: holds date the task was assigned.
 * dueDate - Date: holds due date of task
 * completionDate - Date: holds date which the task was completed.
 * 
 * Functions:
 * Constructor - Task(String, Employee, Date) - String input is set to name of task and Employee object is set to assigned Employee. 
 * 							isTaskDone defaults to false. Inputed Date will be set to task's due date.
 * String - getNameOfTask() - Returns name of task.
 * void - setNameOfTask(String) - Changes name of task to input string.
 * boolean - isTaskDone() - Returns boolean. False means the task is not done and True means the task is completed.
 * void - setTaskDone() - Sets isTaskDone attribute to true.
 * Employee - getAssigned() - Returned assigned Employee object.
 * void - changeAssigned(Employee) - Sets assigned Employee to input Employee.
 * Date - getAssignedDate() - returns date the task was assigned.
 * Date - getDueDate() - returns date the task is due
 * Date - getCompletionDate() - returns date the task was completed.
 * 
 */
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Task {

	//Attributes
	private String nameOfTask;
	private boolean isTaskDone;
	private Employee assigned;
	private Date assignedDate;
	private Date dueDate;
	private Date completionDate;
	
	//Constructor
	Task(String name, Employee who, Date due){
		this.nameOfTask = name;
		this.isTaskDone = false;
		this.assigned = who;
		this.assignedDate = new Date();
		this.dueDate = due;
		
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
		this.completionDate = new Date();
	}

	public Employee getAssigned() {
		return assigned;
	}

	public void changeAssigned(Employee assigned) {
		this.assigned = assigned;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}	
	
	
	
}
