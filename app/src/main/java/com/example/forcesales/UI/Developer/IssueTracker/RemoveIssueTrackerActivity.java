package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.IssueTrackerRemoveAdapter;

import java.util.Iterator;
import java.util.Stack;

public class RemoveIssueTrackerActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private IssueTrackerList issue_tracker_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        issue_tracker_list = getIntent().getParcelableExtra(IssueTrackerList.PARCELABLE_STR);

        mRecycleView = findViewById(R.id.abstract_recycleview_list);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);
        mAdapter = new IssueTrackerRemoveAdapter(issue_tracker_list);
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater = getMenuInflater();
        menu_inflater.inflate(R.menu.manage_deletion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manage_deletion_delete:
                itemMenuDelete();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void itemMenuDelete() {
        IssueTrackerRemoveAdapter issue_tracker_adapter = (IssueTrackerRemoveAdapter) mAdapter;
        Iterator<Integer> x = issue_tracker_adapter.getElementsToRemove().descendingIterator();
        while (x.hasNext()) {
            issue_tracker_list.remove(x.next().intValue());
        }

        Intent result = new Intent();
        result.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) issue_tracker_list);
        setResult(RESULT_OK, result);
        finish();
    }
}
