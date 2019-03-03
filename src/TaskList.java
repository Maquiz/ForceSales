/*
 * 												TaskList Class
 * This class handles storing all the task objects into a list. As well as functions which allow the returning of
 * tasks that are complete, not complete, or assigned to a specific employee.
 * 
 * Attributes:
 * _List - List: An arraylist which holds task objects.
 * 
 * Functions:
 * addTask(Task) - Takes input Task and adds it to the TaskList.
 * getCompletedTasks() - Prints out all completed tasks.
 * getTasks() - Prints out all Tasks that have not been completed.
 * getAllTasks() - Prints all tasks in the Task List. This should be called before calling removeTask()
 * removeTask(int) - Removes task at index, call getAllTasks() before selecting an index.
 * getSize() - Returns List size as an int.
 */

import java.util.List;
import java.util.ArrayList;

public class TaskList {
	
	//Attributes
	private List<Task> _List;
	
	//Constructor
	TaskList(){
		_List = new ArrayList<>();
	}
	
	public void addTask(Task insert) {
		_List.add(insert);
	}
	
	public void getCompletedTasks() {
		int count = 1;
		for(int i = 0; i < _List.size(); i++) {
			if(_List.get(i).isTaskDone() == true) {
				System.out.println(count + ". " +_List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned());
				count++;
			}
		}
	}
	
	public void getTasks() {
		int count = 1;
		for(int i = 0; i < _List.size(); i++) {
			if(_List.get(i).isTaskDone() == false) {
				System.out.println(count + ". " + _List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned());
				count++;
			}
		}
	}
	
	public void getAllTasks() {
		int count = 0;
		for(int i = 0; i < _List.size(); i++) {
				System.out.println(count + ". " + _List.get(i).getNameOfTask() + " | Assigned to: " + _List.get(i).getAssigned());
				count++;
			}
	}
	
	public void removeTask(int index) {
		_List.remove(index);
	}
	
	public int getSize() {
		return _List.size();
	}

}
