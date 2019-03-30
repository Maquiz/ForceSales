package com.example.forcesales.UI.Developer.IssueTracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.IssueTrackerShowAdapter;

public class ShowIssueTrackerListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_list);

        IssueTrackerList sw_issue_list = getIntent().getParcelableExtra(ManageIssueTrackerActivity.ISSUETRACKER);

        mRecyclerView = findViewById(R.id.show_all_task_recycleview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new IssueTrackerShowAdapter(sw_issue_list);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
