package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;
import com.example.forcesales.UI.Developer.DeveloperMenuActivity;


public class ManageIssueTrackerActivity extends AppCompatActivity {
    private static final int REQUESTCODE_ADDISSUE = 1;
    private static final int REQUESTCODE_SETMANAGER = 2;

    private Button buttonShowAllIssues;
    private Button buttonAddIssue;
    private Button mRemoveTask;
    private Button mFindTask;

    private Management management;
    private IssueTrackerList issue_tracker_list;
    private DeveloperList developer_list;


    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_issue_tracker);
        Log.d("APP", "onCreate called in ManageIssueTrackerActivity");

        //pull task list object from previous activity
        management = getIntent().getParcelableExtra(Management.PARCELABLE_STR);
        issue_tracker_list = management.getIssueTracker();
        developer_list = management.getDeveloperList();

        // Show all software tickets
        buttonShowAllIssues = findViewById(R.id.show_all_task_button);
        buttonShowAllIssues.setOnClickListener(v -> {
            Intent i = new Intent(ManageIssueTrackerActivity.this, ShowIssueTrackerListActivity.class);
            i.putExtra(Management.PARCELABLE_STR, management);
            startActivityForResult(i, REQUESTCODE_SETMANAGER);
        });

        // Add new issue
        buttonAddIssue = findViewById(R.id.add_task_button);
        buttonAddIssue.setOnClickListener(v -> {
            Intent i = new Intent(ManageIssueTrackerActivity.this, AddIssueTrackerActivity.class);
            i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) issue_tracker_list);
            i.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) developer_list);
            startActivityForResult(i, REQUESTCODE_ADDISSUE);

        });

        // Remove Issue
        mRemoveTask = (Button) findViewById(R.id.remove_task_button);
        mRemoveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To be implemented
            }
        });

        // Find issue
        mFindTask = (Button) findViewById(R.id.find_task_button);
        mFindTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To be implemented
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called, in ManageIssueTrackerActivity Activity, with a result code of " + resultCode + " and request code of " + requestCode);
        if (requestCode == REQUESTCODE_ADDISSUE) {
            if (resultCode == RESULT_OK) {
                management.setDeveloperList(data.getParcelableExtra(DeveloperList.PARCELABLE_STR));
                management.setIssueTracker(data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR));
            }
        }

        else if (requestCode == REQUESTCODE_SETMANAGER) {
            if (resultCode == RESULT_OK) {
                management = data.getParcelableExtra(Management.PARCELABLE_STR);
            }
        }

    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {
        Log.d("APP", "onBackPressed() Override called in ManageIssueTrackerActivity");

        Intent result = new Intent();
        result.putExtra(Management.PARCELABLE_STR, management);
        setResult(RESULT_OK, result);
        finish();
    }
}
