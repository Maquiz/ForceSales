package com.example.forcesales.RecycleViewItems.Employee.Applications.Base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.TaskShowViewHolderBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * IssueTrackerSharedAdapter is the heart of the RecycleView.Adapter. It holds the information of the task list and
 * has the functionality to display that information onto the screen.
 *
 * Here is a note of the important functions:
 *  * onBindViewHolder(A holder, int position) - Is responsible for displaying the task list data to the screen
 *  * setCardLayout() - return the int id of the card you want to use (defaults to R.layout.task_card)
 *  * createViewHolder() - create a new TaskShowViewHolder object, must be implemented in the derived class.
 */

abstract public class ApplicationSharedAdapter<A extends TaskShowViewHolderBase> extends RecyclerView.Adapter<A> {
    private IssueTrackerList mTaskList;

    public ApplicationSharedAdapter(IssueTrackerList taskList) {
        mTaskList = taskList;
    }


    @Override
    public void onBindViewHolder(A holder, int position) {
        IssueTracker currentItem = mTaskList.get(position);

        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        holder.mTextView1.setText(currentItem.getNameOfTask());
        holder.mTextView2.setText("Assigned to: " + currentItem.getAssigned().getFirstName() + " " + currentItem.getAssigned().getLastName());
        holder.mTextView3.setText("Due: " + timeFormat.format(currentItem.getDueDate().getTime()) + " " + dateFormat.format(currentItem.getDueDate()));
    }


    abstract public A createViewHolder(View v);

    public int setCardLayout() {
        return R.layout.task_card;
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

    @Override
    public A onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setCardLayout(), parent, false);
        return createViewHolder(view);
    }
}
