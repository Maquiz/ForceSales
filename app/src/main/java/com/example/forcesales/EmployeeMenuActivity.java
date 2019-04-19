package com.example.forcesales;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Employee.AddAccountsActivity;
import com.example.forcesales.Employee.ApplicationsActivity;
import com.example.forcesales.Employee.SupportTicketActivity;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.IssueTrackerDetailedAdapter;
import com.example.forcesales.RecycleViewItems.Employee.Applications.ApplicationShowAdapter;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;

import java.util.ArrayList;

public class EmployeeMenuActivity extends AppCompatActivity {

    private Button mApplications;
    private TextView mAcceptStat;
    private TextView mDeniedStat;
    private Employee employee;


    private ArrayList<SalesApplication> _List = new ArrayList<>();
    private ArrayList<SalesApplication> _AList = new ArrayList<>();
    private ArrayList<SalesApplication> _DList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);




    //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
    _List = getIntent().getParcelableArrayListExtra("APPLICATIONS_LIST");
    _AList = getIntent().getParcelableArrayListExtra("APPROVED_LIST");
    _DList = getIntent().getParcelableArrayListExtra("DENIED_LIST");
    employee = getIntent().getParcelableExtra("EMPLOYEE");

       // SalesApplication sa = _List.get(0);

    //initializes Manage Client Menu button, sets an on click listerner with intent to switch to the emplo Menu.
        Button sw_ticket = findViewById(R.id.support_tickets_button);
        sw_ticket.setOnClickListener(v -> {
            Intent i = new Intent(this, ManageIssueTrackerActivity.class);
            i.putExtra(Employee.PARCELABLE_STR, employee);
            startActivityForResult(i, 2);
        });



    //initializes Manage Sales Menu button, sets an on click listerner with intent to switch to he Employee Menu.
    mApplications = (Button) findViewById(R.id.manage_applications_button);
        mApplications.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(EmployeeMenuActivity.this, ApplicationsActivity.class);

            i.putParcelableArrayListExtra("APPLICATIONS_LIST", _List);
            i.putParcelableArrayListExtra("APPROVED_LIST", _AList);
            i.putParcelableArrayListExtra("DENIED_LIST", _DList);
            startActivityForResult(i,1);

        }
    });


        mAcceptStat = findViewById(R.id.acceptAmount);
        mAcceptStat.setText("Accepted Applications: " + _AList.size());

        mDeniedStat = findViewById(R.id.deniedAmount);
        mDeniedStat.setText("Denied Applications: " + _DList.size() );
}


    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                _List = data.getParcelableArrayListExtra("APPLICATIONS_LIST");
                _AList = data.getParcelableArrayListExtra("APPROVED_LIST");
                _DList = data.getParcelableArrayListExtra("DENIED_LIST");
            }
        }

        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                _List = data.getParcelableArrayListExtra("APPLICATIONS_LIST");
                _AList = data.getParcelableArrayListExtra("APPROVED_LIST");
                _DList = data.getParcelableArrayListExtra("DENIED_LIST");
            }
        }
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ClientMenuActivity");

        Intent result = new Intent();

        result.putExtra("APPLICATIONS_LIST", _List);
        result.putExtra("APPROVED_LIST", _AList);
        result.putExtra("DENIED_LIST", _DList);
        setResult(RESULT_OK, result);
        finish();


    }


}
