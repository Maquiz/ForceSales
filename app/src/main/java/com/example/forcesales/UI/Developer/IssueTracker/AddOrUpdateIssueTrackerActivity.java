package com.example.forcesales.UI.Developer.IssueTracker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.R;

import java.util.Calendar;

/*
 * TODO: https://javabeat.net/datepickerdialog-android/
 */

public class AddOrUpdateIssueTrackerActivity extends AppCompatActivity {
    //
    // Saleforce Objects
    //

    private DeveloperList developer_list;
    private IssueTrackerList issue_tracker_list;
    private int issue_tracker_pos;
    private IssueTracker.LABLE label_option;
    private boolean is_task_done;

    //
    // Android GUI Objects
    //

    private EditText textTitle;
    private EditText textDescription;

    private Button buttonDueDate;
    private Calendar calendar_due_date;

    private Button buttonAssign;
    private Button buttonPrevious;
    private Button buttonNext;

    private Button buttonOpenClosed;
    private Button buttonLabel;

    private Button buttonSubmit;
    private int select_dev_position;

    //
    // Other Objects
    //
    private String label_names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_ticket_client);

        developer_list =  getIntent().getParcelableExtra(DeveloperList.PARCELABLE_STR);
        issue_tracker_list = getIntent().getParcelableExtra(IssueTrackerList.PARCELABLE_STR);
        issue_tracker_pos = getIntent().getIntExtra("INTEGER", -1);

        textTitle = findViewById(R.id.report_issue_title);
        textDescription = findViewById(R.id.report_issue_description);
        buttonDueDate = findViewById(R.id.report_issue_due_date);
        buttonPrevious = findViewById(R.id.report_issue_select_person_previous);
        buttonNext = findViewById(R.id.report_issue_select_person_next);
        buttonAssign = findViewById(R.id.report_issue_select_person_name);
        buttonOpenClosed = findViewById(R.id.report_issue_openclosed);
        buttonLabel = findViewById(R.id.report_issue_label);
        buttonSubmit = findViewById(R.id.report_issue_submit);

        label_names = new String[IssueTracker.LABLE.values().length];
        int i = 0;
        for (IssueTracker.LABLE v: IssueTracker.LABLE.values()) {
            label_names[i++] = v.name();
        }

        if (issue_tracker_pos == -1) {
            select_dev_position = 0;
            buttonSubmit.setText("Add");
            calendar_due_date = Calendar.getInstance();
            label_option = IssueTracker.LABLE.NONE;
            is_task_done = false;
        }

        else {
            IssueTracker current_issue_tracker = issue_tracker_list.get(issue_tracker_pos);

            select_dev_position = developer_list.indexOf(current_issue_tracker.getAssigned());
            buttonSubmit.setText("Update");

            textTitle.setText(current_issue_tracker.getNameOfTask());
            textDescription.setText(current_issue_tracker.getDescriptionOfTask());
            calendar_due_date = current_issue_tracker.getCalendarDueDate();
            label_option = current_issue_tracker.getLabel();
            is_task_done = current_issue_tracker.isTaskDone();
        }

        updateCalenderButton();
        updateOpenClosedButton();
        buttonAssign.setText(developer_list.get(select_dev_position).getFirstName()+ " " + developer_list.get(select_dev_position).getLastName());
        buttonLabel.setText(label_option.name());

        setDeveloperOptionButtons();
        setCalendarDueDateButton();
        setIssueTrackerStatus();
        setSubmitButton();
    }

    private void updateCalenderButton() {
        buttonDueDate.setText(
                String.format(
                        "%s/%s/%s",
                        calendar_due_date.get(Calendar.MONTH)+1,
                        calendar_due_date.get(Calendar.DATE),
                        calendar_due_date.get(Calendar.YEAR)
                )
        );
    }

    private void updateOpenClosedButton() {
        if (is_task_done) {
            buttonOpenClosed.setText("Closed");
        }

        else {
            buttonOpenClosed.setText("Open");
        }
    }

    //
    // Button Activator
    //

    private void setDeveloperOptionButtons() {
        buttonPrevious.setOnClickListener(v -> {
            if(select_dev_position > 0)
            {
                select_dev_position--;
                buttonAssign.setText(developer_list.get(select_dev_position).getFirstName() + " " + developer_list.get(select_dev_position).getLastName());
            }

            else {
                Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        buttonNext.setOnClickListener(v -> {
            if(select_dev_position < developer_list.size()-1) {
                select_dev_position++;
                buttonAssign.setText(developer_list.get(select_dev_position).getFirstName() + " " + developer_list.get(select_dev_position).getLastName());
            }

            else {
                Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void setCalendarDueDateButton() {
        buttonDueDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog;

                datePickerDialog = new DatePickerDialog(
                        AddOrUpdateIssueTrackerActivity.this,       // context
                        R.style.Theme_AppCompat_Light_Dialog,               // This is optional, but I wanted to the style to look consistent (without this it would show red)
                        (view, year, month, dayOfMonth) -> {                //  DatePickerDialog.OnDateSetListener (when you press OK; Note that I am using lamadas)
                            calendar_due_date.set(year, month, dayOfMonth);
                            updateCalenderButton();
                        },
                        calendar_due_date.get(Calendar.YEAR),                 // You don't have to provides these arguments; however,
                        calendar_due_date.get(Calendar.MONTH),                // DatePickerDialog will go to current date otherwise.
                        calendar_due_date.get(Calendar.DATE)
                );

                datePickerDialog.show();
            }
        });
    }

    private void setIssueTrackerStatus() {
        buttonOpenClosed.setOnClickListener(v -> {
            is_task_done = !is_task_done;
            updateOpenClosedButton();
        });

        buttonLabel.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Set Label");
            builder.setItems(label_names, (dialog, which) -> {
                label_option = IssueTracker.LABLE.values()[which];
                buttonLabel.setText(label_option.name());
            });

            builder.show();
        });
    }


    private void setSubmitButton() {
        buttonSubmit.setOnClickListener(v -> {
            if (issue_tracker_pos == -1) {
                IssueTracker temp = new IssueTracker(
                        textTitle.getText().toString(),
                        textDescription.getText().toString(),
                        developer_list.get(select_dev_position),
                        calendar_due_date
                );

                temp.setLabel(label_option);
                if (is_task_done) { temp.setTaskDone(); }
                else { temp.unsetTaskDone(); }

                issue_tracker_list.add(temp);
            }

            else {
                IssueTracker value = issue_tracker_list.get(issue_tracker_pos);
                value.setNameOfTask(textTitle.getText().toString());
                value.setDescriptionOfTask(textDescription.getText().toString());
                value.changeAssigned(developer_list.get(select_dev_position));
                value.setCalendarDueDate(calendar_due_date);
                value.setLabel(label_option);

                if (is_task_done) { value.setTaskDone();}
                else { value.unsetTaskDone(); }
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) issue_tracker_list);
            resultIntent.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) developer_list);

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}