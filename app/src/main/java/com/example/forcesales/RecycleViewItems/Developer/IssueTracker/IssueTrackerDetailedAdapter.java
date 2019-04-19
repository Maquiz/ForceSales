package com.example.forcesales.RecycleViewItems.Developer.IssueTracker;

import android.view.View;

import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.IssueTrackerSharedAdapter;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.TaskShowViewHolderBase;
import com.example.forcesales.UI.Abstract.RecycleView.ShowDetailedInfo;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;


/*
 * IssueTrackerDetailedAdapter is responsible for allowing the user to obtain additional information about the selected issue.
 * Click on the the element they are interested in and they will be sent to the
 */

public class IssueTrackerDetailedAdapter extends IssueTrackerSharedAdapter<IssueTrackerDetailedAdapter.TaskShowViewHolderShow> {
    private ShowDetailedInfo show_detailed_info;

    public static class TaskShowViewHolderShow extends TaskShowViewHolderBase {
        public TaskShowViewHolderShow(View itemView, ShowDetailedInfo mIssueTrackerListActivity) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                mIssueTrackerListActivity.showDetailedInformation(getAdapterPosition());
            });
        }
    }

    @Override
    public TaskShowViewHolderShow createViewHolder(View v) {
        return new TaskShowViewHolderShow(v, show_detailed_info);
    }

    public IssueTrackerDetailedAdapter(IssueTrackerList taskList, ShowDetailedInfo issue_tracker_list_activity) {
        super(taskList);
        show_detailed_info = issue_tracker_list_activity;
    }
}