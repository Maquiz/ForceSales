package Tasks;
/*
 * 												TaskList Class
 * This class handles storing all the task objects into a list. As well as functions which allow the returning of
 * tasks that are complete, not complete, or assigned to a specific employee.
 * 
 * 
 * 
 * 
 * Attributes:
 * _List - List: An array list which holds task objects.
 * 
 * 
 * 
 * 
 * Functions:
 * void - addTask(Task) - Takes input Task and adds it to the TaskList.
 * void - getCompletedTasks() - Prints out all completed tasks and their completion date.
 * void - getTasks() - Prints out all Tasks that have not been completed and shows their due date.
 * void - getAllTasks() - Prints all tasks in the Task List. This should be called before calling removeTask(), also shows assignment date.
 * void - getTodaysTasks() - Prints all tasks that are due on the date that this function is called.
 * void - removeTask(int) - Removes task at index, call getAllTasks() before selecting an index.
 * int - getSize() - Returns List size as an int.
 * Task - get() - Return task at an index.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class TaskList {
	
	//Attributes
	private List<Task> _List;
	
	//Constructor
	public TaskList(){
		_List = new ArrayList<>();
	}
	
	public void addTask(Task insert) {
		_List.add(insert);
	}
	
	public void getCompletedTasks() {
		int count = 1;
		for(int i = 0; i < _List.size(); i++) {
			if(_List.get(i).isTaskDone() == true) {
				System.out.println(count + ". " +_List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned() + " | Completed on: " + _List.get(i).getCompletionDate());
				count++;
			}
		}
	}
	
	public void getTasks() {
		int count = 1;
		for(int i = 0; i < _List.size(); i++) {
			if(_List.get(i).isTaskDone() == false) {
				System.out.println(count + ". " + _List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned() + " | Due: " + _List.get(i).getDueDate());
				count++;
			}
		}
	}
	
	public void getAllTasks() {
		int count = 0;
		for(int i = 0; i < _List.size(); i++) {
				System.out.println(count + ". " + _List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned() + " | Assigned on: " + _List.get(i).getAssignedDate());
				count++;
			}
	}
	
	public void getTodaysTasks() {
		int count = 0;
		Calendar temp = Calendar.getInstance();
		System.out.println("Today's Tasks:");
		for(int i = 0; i < _List.size(); i++) {
			if(_List.get(i).getCalendarDueDate().get(Calendar.DAY_OF_MONTH) == temp.get(Calendar.DAY_OF_MONTH) && _List.get(i).getCalendarDueDate().get(Calendar.MONTH) == temp.get(Calendar.MONTH) && _List.get(i).getCalendarDueDate().get(Calendar.YEAR) == temp.get(Calendar.YEAR) && _List.get(i).isTaskDone() == false) {
				System.out.println(count + ". " + _List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned() + " | Assigned on: " + _List.get(i).getAssignedDate());
				count++;
			}
		}
	}
	
	public void removeTask(int index) {
		_List.remove(index);
	}
	
	public int getSize() {
		return _List.size();
	}
	
	public Task get(int index) {
		return _List.get(index);
	}

}
