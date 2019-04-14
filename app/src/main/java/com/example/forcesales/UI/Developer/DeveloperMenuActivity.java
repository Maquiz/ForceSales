package com.example.forcesales.UI.Developer;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Employee.EmployeeList;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;

/* This is an implementation of the developer menu interface for a developer to interact with.
 * They will have the ability to create an employee for the SaleForce coorporation and manage
 * the Issue Tracker.
 */

public class DeveloperMenuActivity extends AppCompatActivity {
    private static final int REQUESTCODE_MANAGETICKETS = 1;
    private static final int REQUESTCODE_ADDEMPLOYEE = 2;

    private Management management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_menu);

        management = getIntent().getParcelableExtra("MANAGEMENT");

        Button sw_ticket = findViewById(R.id.button_dev_sw_ticket);
        sw_ticket.setOnClickListener(v -> {
            Intent i = new Intent(this, ManageIssueTrackerActivity.class);
            i.putExtra(Management.PARCELABLE_STR, management);
            startActivityForResult(i, REQUESTCODE_MANAGETICKETS);
        });


        Button add_employee = findViewById(R.id.button_dev_add_employee);
        add_employee.setOnClickListener(v -> {
            Intent i = new Intent(this, AddEmployeeActivity.class);
            i.putExtra(EmployeeList.PARCELABLE_STR, (Parcelable) management.getEmployeeList());
            startActivityForResult(i, REQUESTCODE_ADDEMPLOYEE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("DEVMENU", String.format("requestCode: %d", requestCode));

        if (requestCode == REQUESTCODE_MANAGETICKETS) {
            if (resultCode == RESULT_OK) {
                management = data.getParcelableExtra(Management.PARCELABLE_STR);
            }
        }

        else if (requestCode == REQUESTCODE_ADDEMPLOYEE) {
            if (resultCode == RESULT_OK) {
                management.setEmployeeList(data.getParcelableExtra(EmployeeList.PARCELABLE_STR));
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