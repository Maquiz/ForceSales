package com.example.forcesales.RecycleViewItems.Developer.IssueTracker;

import android.view.View;

import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.IssueTrackerSharedAdapter;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.TaskShowViewHolderBase;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;


/*
 * IssueTrackerDetailedAdapter is responsible for allowing the user to obtain additional information about the selected issue.
 * Click on the the element they are interested in and they will be sent to the
 */

public class IssueTrackerDetailedAdapter extends IssueTrackerSharedAdapter<IssueTrackerDetailedAdapter.TaskShowViewHolderShow> {
    private ManageIssueTrackerActivity mIssueTrackerListActivity;

    public static class TaskShowViewHolderShow extends TaskShowViewHolderBase {
        public TaskShowViewHolderShow(View itemView, ManageIssueTrackerActivity mIssueTrackerListActivity) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                mIssueTrackerListActivity.showDetailedInformation(getAdapterPosition());
            });
        }
    }

    @Override
    public TaskShowViewHolderShow createViewHolder(View v) {
        return new TaskShowViewHolderShow(v, mIssueTrackerListActivity);
    }

    public IssueTrackerDetailedAdapter(IssueTrackerList taskList, ManageIssueTrackerActivity issue_tracker_list_activity) {
        super(taskList);
        mIssueTrackerListActivity = issue_tracker_list_activity;
    }
}