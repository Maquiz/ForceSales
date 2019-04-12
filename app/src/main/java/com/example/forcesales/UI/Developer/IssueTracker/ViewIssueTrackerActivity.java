package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;

public class ViewIssueTrackerActivity extends AppCompatActivity {
    private static final int RESULTCODE_UPDATE_ISSUE = 0;

    private IssueTrackerList issue_tracker_list;
    private DeveloperList developer_list;
    private int current_issue_tracker_pos;

    private TextView title_edit;
    private TextView description_edit;
    private TextView assigned_edit;
    private TextView assigned_date_edit;
    private TextView due_date_edit;

    private void updateTextInfo() {
        IssueTracker current_issue = issue_tracker_list.get(current_issue_tracker_pos);

        title_edit.setText(current_issue.getNameOfTask());
        description_edit.setText(current_issue.getDescriptionOfTask());
        assigned_edit.setText(
                String.format(
                        "%s %s",
                        current_issue.getAssigned().getFirstName(),
                        current_issue.getAssigned().getLastName()
                )
        );
        assigned_date_edit.setText(
                String.format(
                        "%d/%d/%d",
                        current_issue.getAssignedDate().getMonth()+1,
                        current_issue.getAssignedDate().getDate(),
                        current_issue.getAssignedDate().getYear()+1900
                )
        );
        due_date_edit.setText(
                String.format(
                        "%d/%d/%d",
                        current_issue.getDueDate().getMonth()+1,
                        current_issue.getDueDate().getDate(),
                        current_issue.getDueDate().getYear()+1900
                )
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_issue_tracker);

        Intent current_intent = getIntent();
        issue_tracker_list = current_intent.getParcelableExtra(IssueTrackerList.PARCELABLE_STR);
        developer_list = current_intent.getParcelableExtra(DeveloperList.PARCELABLE_STR);
        current_issue_tracker_pos = current_intent.getIntExtra("INTEGER", 0);

        title_edit = findViewById(R.id.textView_issue_tracker_title_modified);
        description_edit = findViewById(R.id.textView_issue_tracker_description_modified);
        assigned_edit = findViewById(R.id.textView_issue_tracker_assigned_modified);
        assigned_date_edit = findViewById(R.id.textView_issue_tracker_assigned_date_modified);
        due_date_edit = findViewById(R.id.textView_issue_tracker_due_date_modified);

        updateTextInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater = getMenuInflater();
        menu_inflater.inflate(R.menu.manage_element, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manage_element_edit:
                Intent i = new Intent(this, AddOrUpdateIssueTrackerActivity.class);
                i.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) developer_list);
                i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) issue_tracker_list);
                i.putExtra("INTEGER", current_issue_tracker_pos);
                startActivityForResult(i, RESULTCODE_UPDATE_ISSUE);
                break;

            case R.id.manage_element_delete:
                issue_tracker_list.remove(current_issue_tracker_pos);
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULTCODE_UPDATE_ISSUE) {
            if (resultCode == RESULT_OK) {
                issue_tracker_list = data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR);
                developer_list = data.getParcelableExtra(DeveloperList.PARCELABLE_STR);
                updateTextInfo();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Intent result = new Intent();
        result.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) issue_tracker_list);
        result.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) developer_list);
        setResult(RESULT_OK, result);
        finish();
    }
}
