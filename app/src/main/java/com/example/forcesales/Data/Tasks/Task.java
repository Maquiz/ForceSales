package com.example.forcesales.Data.Tasks;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.Person.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.getInstance;

/*
 * 
 * 														Task Class
 * This object holds task information such as a task name, is the task complete?, and who is assigned to this task?
 * 
 * 
 * 
 * 
 * Attributes:
 * nameOfTask - String: holds the name of the task.
 * isTaskDone - Boolean: defaults to false, set to true when the task is complete.
 * assigned - Employee: holds employee object of the employee working on the task.
 * assignedDate - Calendar: holds date the task was assigned.
 * dueDate - Calendar: holds due date of task
 * completionDate - Calendar: holds date which the task was completed.
 * 
 * 
 * 
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
 * Calendar - getCalendarDueDate() - Returns the calendar object for due date, used for back end comparisons.
 * Date - getAssignedDate() - returns date the task was assigned.
 * Date - getDueDate() - returns date the task is due
 * Date - getCompletionDate() - returns date the task was completed.
 * 
 */



public class Task implements Parcelable {

	//Attributes
	private String nameOfTask;
	private boolean isTaskDone;
	private Client assigned;
	private Calendar assignedDate;
	private Calendar dueDate;
	private Calendar completionDate;
	
	//Constructor
	public Task(String name, Client who, Calendar due){
		this.nameOfTask = name;
		this.isTaskDone = false;
		this.assigned = who;
		this.assignedDate = getInstance();
		this.dueDate = due;
		this.completionDate = getInstance();
		
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
		this.completionDate = getInstance();
	}

	public Client getAssigned() {
		return assigned;
	}

	public void changeAssigned(Client assigned) {
		this.assigned = assigned;
	}
	
	public Calendar getCalendarDueDate() {
		return this.dueDate;
	}

	public Date getAssignedDate() {
		return assignedDate.getTime();
	}

	public Date getDueDate() {
		return dueDate.getTime();
	}

	public Date getCompletionDate() {
		return completionDate.getTime();
	}

	//parcelable methods
	@Override
	public int describeContents(){
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(nameOfTask);
		dest.writeByte((byte) (isTaskDone ? 1 : 0));
		dest.writeParcelable(assigned, flags);
		dest.writeLong(assignedDate.getTimeInMillis());
		dest.writeLong(dueDate.getTimeInMillis());
		long temp = 0;


		if(completionDate != null) {
			temp = completionDate.getTimeInMillis();
		}


		dest.writeLong(temp);

	}

	//creator
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
		public Task createFromParcel(Parcel in) {
			return new Task(in);
		}

		public Task[] newArray(int size) {
			return new Task[size];
		}
	};

	//de-parcel object
	private Task(Parcel in){
		nameOfTask = in.readString();
		isTaskDone = in.readByte() != 0;
		assigned = in.readParcelable(Client.class.getClassLoader());

		assignedDate = Calendar.getInstance();
		dueDate = Calendar.getInstance();
		completionDate = Calendar.getInstance();

		assignedDate.setTimeInMillis(in.readLong());
		dueDate.setTimeInMillis(in.readLong());
		completionDate.setTimeInMillis(in.readLong());
	}

	
	
}
