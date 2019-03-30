package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;

import java.util.Calendar;

public class AddIssueTrackerActivity extends AppCompatActivity {

    private EditText textTitle;
    private EditText textDescription;

    private Button buttonAssign;
    private Button buttonPrevious;
    private Button buttonNext;

    private Button buttonSubmit;
    private int position;

    private DeveloperList developer_list;
    private IssueTrackerList issue_tracker_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_ticket_client);

        developer_list =  getIntent().getParcelableExtra(ManageIssueTrackerActivity.DEVELOPERLIST);
        issue_tracker_list = getIntent().getParcelableExtra(ManageIssueTrackerActivity.ISSUETRACKER);

        textTitle = findViewById(R.id.report_issue_title);
        textDescription = findViewById(R.id.report_issue_description);
        buttonPrevious = findViewById(R.id.report_issue_select_person_previous);
        buttonNext = findViewById(R.id.report_issue_select_person_next);
        buttonAssign = findViewById(R.id.report_issue_select_person_name);
        buttonSubmit = findViewById(R.id.report_issue_submit);

        buttonAssign.setText(developer_list.get(position).getFirstName()+ " " + developer_list.get(position).getLastName());
        position = 0;


        buttonPrevious.setOnClickListener(v -> {
            if(position > 0)
            {
                position--;
                buttonAssign.setText(developer_list.get(position).getFirstName() + " " + developer_list.get(position).getLastName());
            }

            else {
                Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        buttonNext.setOnClickListener(v -> {
            if(position < developer_list.size()-1)
            {
                position++;
                buttonAssign.setText(developer_list.get(position).getFirstName() + " " + developer_list.get(position).getLastName());
            }
            else{
                Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        buttonSubmit.setOnClickListener(v -> {
            // Update to Include Description.
            IssueTracker temp = new IssueTracker(textTitle.getText().toString(),textDescription.getText().toString(), developer_list.get(position), Calendar.getInstance());
            issue_tracker_list.add(temp);

            Intent resultIntent = new Intent();
            resultIntent.putParcelableArrayListExtra(ManageIssueTrackerActivity.ISSUETRACKER, issue_tracker_list);

            setResult(RESULT_OK, resultIntent);
            finish();
        });

    }

}
