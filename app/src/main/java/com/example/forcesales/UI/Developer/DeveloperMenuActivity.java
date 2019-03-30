package com.example.forcesales.UI.Developer;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;

/* This is an implementation of the developer menu interface for a developer to interact with.
 * They will have the ability to create an employee for the SaleForce coorporation and manage
 * the Issue Tracker.
 */

public class DeveloperMenuActivity extends AppCompatActivity {
    public static final String DEVELOPERLIST = "com.example.forcesales.UI.Developer.DeveloperMenuActivity.Management.DEVELOPERLIST";
    public static final String ISSUETRACKER = "com.example.forcesales.UI.Developer.DeveloperMenuActivity.Management.ISSUETRACKER";

    private static final int REQUESTCODE_MANAGETICKETS = 1;

    private Management management;
    private Task test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_menu);

        management = getIntent().getParcelableExtra("MANAGEMENT");

//        test = new Task("Thomas's Value", "This task has a special meaning!", new Client(), Calendar.getInstance());

        Button sw_ticket = findViewById(R.id.button_dev_sw_ticket);
        sw_ticket.setOnClickListener(v -> {
            Intent i = new Intent(this, ManageIssueTrackerActivity.class);

//            management.getIssueTracker().add(new IssueTracker("Does it work on DeveloperMenuActivity", "Does it!?", new Developer(), Calendar.getInstance()));

            i.putExtra(DEVELOPERLIST, (Parcelable) management.getDeveloperList());
            i.putExtra(ISSUETRACKER, (Parcelable) management.getIssueTracker());

            startActivityForResult(i,REQUESTCODE_MANAGETICKETS);
        });


        Button add_employee = findViewById(R.id.button_dev_add_employee);
        add_employee.setOnClickListener(v -> {
//            Intent i = new Intent(this, ShowT);
            Toast t = Toast.makeText(getApplicationContext(), "ADD EMPLOYEE: Need to connect soon", Toast.LENGTH_SHORT);
            t.show();

//            startActivity(i);
//            startActivityForResult(i,1);
        });

        Button test_menu = findViewById(R.id.button_dev_test_menu);
        test_menu.setOnClickListener(v -> {
//            Intent i = new Intent(this, DeveloperMenuTest.class);
//            i.putExtra(TASKLIST, test);
//
//            startActivityForResult(i, RETURN_TASK_OBJECT);
        });

//        test = new Task();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("DEVMENU", String.format("requestCode: %d", requestCode));

        if (requestCode == REQUESTCODE_MANAGETICKETS) {
            if (resultCode == RESULT_OK) {
                management.setDeveloperList(data.getParcelableExtra(DEVELOPERLIST));
                management.setIssueTracker(data.getParcelableExtra(ISSUETRACKER));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent result = new Intent();

        result.putExtra("MANAGEMENT", management);

        setResult(RESULT_OK, result);
        finish();
    }
}