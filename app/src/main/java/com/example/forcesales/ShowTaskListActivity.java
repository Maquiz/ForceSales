package com.example.forcesales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.RecycleViewItems.TaskShowAdapter;

import java.util.List;

public class ShowTaskListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        List<Task> _List = getIntent().getParcelableArrayListExtra("TASK_LIST");

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TaskShowAdapter(_List);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
