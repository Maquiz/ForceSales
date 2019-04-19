package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SearchOptionIssueTrackerActivity extends AppCompatActivity {
    private ArrayList original_element;

    private IssueTrackerList parent;
    private IssueTrackerList child;

    private EditText mTitle;
    private EditText mDescription;

    private Button mCompletedTask;
    private Button mIncompletedTask;
    private Button mTodayTask;
    private Button mEverything;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_issue_tracker);

        parent = getIntent().getParcelableExtra(IssueTrackerList.PARCELABLE_STR);
        original_element = new ArrayList();

        mTitle = findViewById(R.id.search_issue_tracker_title);
        mDescription = findViewById(R.id.search_issue_tracker_description);
        mCompletedTask = findViewById(R.id.search_issue_tracker_complete_task);
        mIncompletedTask = findViewById(R.id.search_issue_tracker_incomplete_task);
        mTodayTask = findViewById(R.id.search_issue_tracker_todays_task);
        mEverything = findViewById(R.id.search_issue_tracker_everything);

        mCompletedTask.setOnClickListener(v -> {
            onSubmitAction();
            child = child.getCompletedTasks();
            getOriginalElement();
            endActivity();
        });

        mIncompletedTask.setOnClickListener(v -> {
            onSubmitAction();
            child = child.getTasks();
            getOriginalElement();
            endActivity();
        });

        mTodayTask.setOnClickListener(v -> {
            onSubmitAction();
            child = child.getTodaysTasks();
            getOriginalElement();
            endActivity();
        });

        mEverything.setOnClickListener(v -> {
            onSubmitAction();
            getOriginalElement();
            endActivity();
        });
    }

    private void onSubmitAction() {
        child = copyArray();

        if (mTitle.getText().length() != 0) {
            child = child.containsTitle(mTitle.getText().toString());
        }

        if (mDescription.getText().length() != 0) {
            child = child.containsDescription(mDescription.getText().toString());
        }
    }

    private IssueTrackerList copyArray() {
        IssueTrackerList result = new IssueTrackerList();
        for (IssueTracker i: parent) {
            result.add(i);
        }

        return result;
    }

    private void endActivity() {
        Intent result = new Intent();
        result.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) child);
        result.putExtra("INTEGER_ARRAYLIST", original_element);
        setResult(RESULT_OK, result);
        finish();
    }

    private void getOriginalElement() {
        for (IssueTracker i: child) {
            original_element.add(parent.indexOf(i));
        }
    }
}
