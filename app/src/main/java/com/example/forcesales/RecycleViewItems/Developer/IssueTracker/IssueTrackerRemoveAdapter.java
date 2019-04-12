package com.example.forcesales.RecycleViewItems.Developer.IssueTracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.IssueTrackerSharedAdapter;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.Base.TaskShowViewHolderBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

/*
 * IssueTrackerRemoveAdapter is responsible for handling the deletion of a group of items.
 * If the item is selected, a checkbox will appear and the check will be set true (the reserve
 * is also true.
 *
 * Note that since the removal card is different from the normal card. setCardLayout had to be
 * overridden.
 */

public class IssueTrackerRemoveAdapter extends IssueTrackerSharedAdapter<IssueTrackerRemoveAdapter.TaskShowViewHolder> {
    private TreeSet<Integer> mOptionSelected;

    public static class TaskShowViewHolder extends TaskShowViewHolderBase {
        public TreeSet<Integer> mOptionSelected;
        public CheckBox mCheckBox;

        public TaskShowViewHolder(View itemView, TreeSet<Integer> optionSelected)
        {
            super(itemView);
            mCheckBox = itemView.findViewById(R.id.checkBox);
            this.mOptionSelected = optionSelected;

            itemView.setOnClickListener(v -> {
                if (mCheckBox.isChecked()) {
                    mCheckBox.setChecked(false);
                    mCheckBox.setVisibility(View.GONE);
                    optionSelected.remove(getAdapterPosition());
                }

                else {
                    mCheckBox.setVisibility(View.VISIBLE);
                    mCheckBox.setChecked(true);
                    optionSelected.add(getAdapterPosition());
                }
            });
        }
    }

    public IssueTrackerRemoveAdapter(IssueTrackerList taskList) {
        super(taskList);
        mOptionSelected = new TreeSet<>();
    }

    @Override
    public TaskShowViewHolder createViewHolder(View v) {
        return new TaskShowViewHolder(v, mOptionSelected);
    }

    @Override
    public int setCardLayout() {
        return R.layout.remove_task_card;
    }

    public TreeSet<Integer> getElementsToRemove() {
        return mOptionSelected;
    }
}