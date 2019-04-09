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
import com.example.forcesales.R;
import com.example.forcesales.UI.Developer.DeveloperMenuActivity;


public class ManageIssueTrackerActivity extends AppCompatActivity {
    public static final String DEVELOPERLIST = "com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity.Management.DEVELOPERLIST";
    public static final String ISSUETRACKER = "com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity.Management.ISSUETRACKER";

    private static final int REQUESTCODE_ADDISSUE = 1;

    private Button buttonShowAllIssues;
    private Button buttonAddIssue;
    private Button mRemoveTask;
    private Button mFindTask;
    private IssueTrackerList sw_ticket_list;
    private DeveloperList developer_list;
  
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_issue_tracker);

            Log.d("APP", "onCreate called in ManageIssueTrackerActivity");

            //pull task list object from previous activity
            sw_ticket_list = getIntent().getParcelableExtra(DeveloperMenuActivity.ISSUETRACKER);
            developer_list = getIntent().getParcelableExtra(DeveloperMenuActivity.DEVELOPERLIST);

            // Show all software tickets
            buttonShowAllIssues = findViewById(R.id.show_all_task_button);
            buttonShowAllIssues.setOnClickListener(v -> {
                Intent i = new Intent(ManageIssueTrackerActivity.this, ShowIssueTrackerListActivity.class);
                i.putExtra(ISSUETRACKER, (Parcelable) sw_ticket_list);
                startActivity(i);
            });

            // Add new issue
            buttonAddIssue = findViewById(R.id.add_task_button);
            buttonAddIssue.setOnClickListener(v -> {
                    Intent i = new Intent(ManageIssueTrackerActivity.this, AddIssueTrackerActivity.class);
                    i.putExtra(ManageIssueTrackerActivity.ISSUETRACKER, (Parcelable) sw_ticket_list);
                    i.putExtra(ManageIssueTrackerActivity.DEVELOPERLIST, (Parcelable) developer_list);
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

        //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){

            Log.d("APP", "onActivityResult called, in ManageIssueTrackerActivity Activity, with a result code of " + resultCode + " and request code of " + requestCode);
            if (requestCode == REQUESTCODE_ADDISSUE) {
                if (resultCode == RESULT_OK) {
                    developer_list = data.getParcelableExtra(ManageIssueTrackerActivity.DEVELOPERLIST);
                    sw_ticket_list = data.getParcelableExtra(ManageIssueTrackerActivity.ISSUETRACKER);
                }
            }

        }

        //When the back button is pressed it passes the current client list back to the previous activity.
        @Override
        public void onBackPressed() {

            Log.d("APP", "onBackPressed() Override called in ManageIssueTrackerActivity");

            Intent result = new Intent();
            result.putExtra(DeveloperMenuActivity.DEVELOPERLIST, (Parcelable) developer_list);
            result.putExtra(DeveloperMenuActivity.ISSUETRACKER, (Parcelable) sw_ticket_list);

            setResult(RESULT_OK, result);
            finish();
        }
    }
