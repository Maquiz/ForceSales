package com.example.forcesales.Data.Tasks;
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

import android.os.Parcel;
import android.os.Parcelable;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;
import java.util.Calendar;

public class TaskList extends AbstractArrayListComparsion<Task,TaskList> implements Parcelable {

	// Attributes
	private CompareTwoObjects<Task,Boolean> compare_tasks = (a, b) -> a.isTaskDone() == b;
	private CompareTwoObjects<Task,Calendar> compare_date = (a, b) -> {
		Calendar a2 = a.getCalendarDueDate();
		return a2.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH)
				&& a2.get(Calendar.MONTH) == b.get(Calendar.MONTH)
				&& a2.get(Calendar.YEAR) == b.get(Calendar.YEAR);
	};

	//Constructor
	public TaskList(){
		super();
	}

	@Override
	protected TaskList createEmptyArrayList() {
		return new TaskList();
	}

	public TaskList getCompletedTasks() {
		return abstractContains(true, compare_tasks);
	}

	public TaskList getTasks() {
		return abstractContains(false, compare_tasks);
	}

	public TaskList getTodaysTasks() {
		return abstractContains(Calendar.getInstance(),compare_date).getTasks();
	}


	//parcelable methods
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeList(this);
	}

	//creator
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public TaskList createFromParcel(Parcel in){
			return new TaskList(in);
		}

		public TaskList[] newArray(int size){
			return new TaskList[size];
		}
	};

	//de-parecel object
	private TaskList(Parcel in) {

		in.readList(this, Task.class.getClassLoader());
	}
}

