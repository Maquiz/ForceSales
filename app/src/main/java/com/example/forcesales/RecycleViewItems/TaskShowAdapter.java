package com.example.forcesales.RecycleViewItems;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class TaskShowAdapter extends RecyclerView.Adapter<TaskShowAdapter.TaskShowViewHolder> {

    private List<Task> mTaskList;

    public static class TaskShowViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;

        public TaskShowViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.task_list_text1);
            mTextView2 = itemView.findViewById(R.id.task_list_text2);
            mTextView3 = itemView.findViewById(R.id.task_list_text3);
            mTextView4 = itemView.findViewById(R.id.task_list_text4);
            mTextView5 = itemView.findViewById(R.id.task_list_text5);
        }
    }

    public TaskShowAdapter(List<Task> taskList){
        mTaskList = taskList;
    }

    @Override
    public TaskShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card, parent, false);
        TaskShowViewHolder cvh = new TaskShowViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(TaskShowViewHolder holder, int position) {
        Task currentItem = mTaskList.get(position);

        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        holder.mTextView1.setText(currentItem.getNameOfTask());
        holder.mTextView2.setText("Assigned to: " + currentItem.getAssigned().getFirstName() + " " + currentItem.getAssigned().getLastName());
        holder.mTextView3.setText("Due: " + timeFormat.format(currentItem.getDueDate().getTime()) + " " + dateFormat.format(currentItem.getDueDate()));
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}