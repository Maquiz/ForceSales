package com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.forcesales.R;

public class TaskShowViewHolderBase extends RecyclerView.ViewHolder {
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;

    public TaskShowViewHolderBase(View itemView) {
        super(itemView);
        mTextView1 = itemView.findViewById(R.id.task_list_text1);
        mTextView2 = itemView.findViewById(R.id.task_list_text2);
        mTextView3 = itemView.findViewById(R.id.task_list_text3);
        mTextView4 = itemView.findViewById(R.id.task_list_text4);
        mTextView5 = itemView.findViewById(R.id.task_list_text5);
    }
}