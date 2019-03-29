package com.example.forcesales.Data.Tasks;

import com.example.forcesales.Data.Person.Person;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.Person.Person;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.getInstance;

/*
 *
 * 												Abstract Task Class
 * This object holds task information such as a task name, is the task complete?, and who is assigned to
 * this task?
 *
 * Note: Because of how Parcel works, all values need to be initalized.
 *
 * Attributes:
 * nameOfTask - String: holds the name of the task.
 * descriptionOfTask - String: holds the description of the task.
 * isTaskDone - Boolean: defaults to false, set to true when the task is complete.
 * completionDate - Calendar: holds date which the task was completed.
 * isPersonAssigned - Boolean: determines if there is a person actually assigned to the task
 * assigned - <A extends Person>: holds employee object of the employee working on the task.
 * assignedDate - Calendar: holds date the task was assigned.
 * dueDate - Calendar: holds due date of task (WARNING: can be null).
 *
 *
 * Functions:
 * Constructor - AbstractTask(String, String, <A extends Person>, Date) - String input is set to name of task
 *                  and Employee object is set to assigned Employee. isTaskDone defaults to false. Inputed
 *                  Date will be set to task's due date.
 *
 * String - getNameOfTask() - Returns name of task.
 * void - setNameOfTask(String) - Changes name of task to input string.
 * String - getDescriptionOfTask() - Returns description of task.
 * void - setDescriptionOfTask(String) -_Sets the description of the task.
 * boolean - isTaskDone() - Returns boolean. False means the task is not done and True means the task is
 *                              completed.
 * void - setTaskDone() - Sets isTaskDone to true and completionDate to the current time.
 * void - unsetTaskDone() - Sets isTaskDone to false.
 * boolean - isPersonAssigned() - Returns isPersonAssigned. States if there is actually a person assigned to
 *                                  the task.
 * <A extends Person> - getAssigned() - Returns an object that extends from Person. Note, it is your
 *                                      responsibility to check if the the returned object is logically
 *                                      valid (use isPersonAssigned()).
 * void - changeAssigned(<A extends Person>) - Assigns an object that extends from Person to assigned. Note
 *                                              that if the object is null, isPersonAssigned will be set to
 *                                              false, otherwise, it will be set to true.
 *
 * Calendar - getCalendarDueDate() - Returns the calendar object for due date, used for back end comparisons.
 * void - setCalendarDueDate(Calendar) - Assigns the calender to dueDate.
 * Date - getAssignedDate() - returns date the task was assigned.
 * Date - getDueDate() - returns date the task is due
 * Date - getCompletionDate() - returns date the task was completed.
 */



public class AbstractTask<A extends Person> implements Parcelable {

    //Attributes
    private String nameOfTask;
    private String descriptionOfTask;
    private boolean isTaskDone;
    private Calendar completionDate;
    private boolean isPersonAssigned;
    private A assigned; // TODO: Make into ArrayList
    private final Calendar assignedDate;
    private Calendar dueDate;


    protected AbstractTask(String name, String description, A who, Calendar due){
        this.nameOfTask = name;
        this.descriptionOfTask = description;
        this.isTaskDone = false;
        this.completionDate = getInstance();
        this.isPersonAssigned = true;
        this.assigned = who;
        this.assignedDate = getInstance();
        this.dueDate = due;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getDescriptionOfTask() { return descriptionOfTask; }

    public void setDescriptionOfTask(String descriptionOfTask) {
        this.descriptionOfTask = descriptionOfTask;
    }


    public boolean isTaskDone() {
        return isTaskDone;
    }

    public void setTaskDone() {
        this.isTaskDone = true;
        this.completionDate = getInstance();
    }

    public void unsetTaskDone() {
        this.isTaskDone = false;
    }

    public boolean isPersonAssigned() {
        return isPersonAssigned;
    }

    public A getAssigned() {
            return assigned;
    }

    public void changeAssigned(A assigned) {
        if (assigned == null) {
            isPersonAssigned = false;
        }

        else {
            isPersonAssigned = true;
            this.assigned = assigned;
        }
    }


    public Calendar getCalendarDueDate() {
        return this.dueDate;
    }

    public void setCalendarDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
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


//	//Attributes
//	private String nameOfTask;
//	private boolean isTaskDone;
//	private Employee assigned;
//	private Calendar assignedDate;
//	private Calendar dueDate;
//	private Calendar completionDate;

    //parcelable methods
    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nameOfTask);
        dest.writeString(descriptionOfTask);
        dest.writeByte((byte) (isTaskDone ? 1 : 0));
        dest.writeParcelable(assigned, flags);
        dest.writeByte((byte) (isPersonAssigned ? 1 : 0));

        dest.writeLong(assignedDate.getTimeInMillis());
        dest.writeLong(dueDate.getTimeInMillis());
        long temp = 0;

        // Because of how Parcelable works, you can never have a null value, right?
        if(completionDate != null) {
            temp = completionDate.getTimeInMillis();
        }

        dest.writeLong(temp);
    }

    //creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public AbstractTask createFromParcel(Parcel in) {
            return new AbstractTask(in);
        }

        public AbstractTask[] newArray(int size) {
            return new AbstractTask[size];
        }
    };

    //de-parcel object
    protected AbstractTask(Parcel in) {
        nameOfTask = in.readString();
        descriptionOfTask = in.readString();
        isTaskDone = in.readByte() != 0;
        assigned = in.readParcelable(Client.class.getClassLoader());
        isPersonAssigned = in.readByte() != 0;

        assignedDate = Calendar.getInstance();
        dueDate = Calendar.getInstance();
        completionDate = Calendar.getInstance();

        assignedDate.setTimeInMillis(in.readLong());
        dueDate.setTimeInMillis(in.readLong());
        completionDate.setTimeInMillis(in.readLong());
    }
}
