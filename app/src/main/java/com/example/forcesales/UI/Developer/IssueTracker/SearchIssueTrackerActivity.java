package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.IssueTrackerDetailedAdapter;
import com.example.forcesales.UI.Abstract.RecycleView.ShowDetailedInfo;

import java.util.ArrayList;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchIssueTrackerActivity extends AppCompatActivity implements ShowDetailedInfo {
    private static final int REQUESTCODE_SEARCHISSUE = 1;
    private static final int REQUESTCODE_VIEWISSUE = 2;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button mSearchButtom;

    private Management management;
    private IssueTrackerList search_element;

    private IssueTracker selected_issue;
    private int original_size;
    private int selected_element;
    private ArrayList<Integer> original_elements;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_recycleview_search);

        mSearchButtom = findViewById(R.id.recycleview_search_button_search);

        management = getIntent().getParcelableExtra(Management.PARCELABLE_STR);
        search_element = new IssueTrackerList();

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        updateAdapter();

        implementSearchButton();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE_VIEWISSUE) {
            if (resultCode == RESULT_OK) {
                search_element = data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR);

                if (search_element.size() < original_size) {
                    management.getIssueTracker().remove((int)original_elements.get(selected_element));
                    original_elements.remove(selected_element);
                    original_size = search_element.size();
                }

                updateAdapter();
            }
        }

        else if (requestCode == REQUESTCODE_SEARCHISSUE) {
            if (resultCode == RESULT_OK) {
                search_element = data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR);
                original_elements = (ArrayList<Integer>) data.getSerializableExtra("INTEGER_ARRAYLIST");
                original_size = search_element.size();
                updateAdapter();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent result = new Intent();
        result.putExtra(Management.PARCELABLE_STR, management);
        setResult(RESULT_OK, result);
        finish();
    }

    private void implementSearchButton() {
        mSearchButtom.setOnClickListener(v -> {
            Intent i = new Intent(this, SearchOptionIssueTrackerActivity.class);
            i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) management.getIssueTracker());
            startActivityForResult(i, REQUESTCODE_SEARCHISSUE);
        });
    }

    //
    // Functions for RecycleView.
    //

    public void showDetailedInformation(int position) {
        Intent i = new Intent(this, ViewIssueTrackerActivity.class);
        i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) search_element);
        i.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) management.getDeveloperList());
        i.putExtra("INTEGER", position);

        selected_element = position;
        selected_issue = search_element.get(position);
        startActivityForResult(i, REQUESTCODE_VIEWISSUE);
    }

    protected void updateAdapter() {
        mAdapter = new IssueTrackerDetailedAdapter(search_element,this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
