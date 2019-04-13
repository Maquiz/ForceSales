package com.example.forcesales;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Employee.AddAccountsActivity;
import com.example.forcesales.Employee.ApplicationsActivity;
import com.example.forcesales.Employee.SupportTicketActivity;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.IssueTrackerDetailedAdapter;
import com.example.forcesales.RecycleViewItems.Employee.Applications.ApplicationShowAdapter;

import java.util.ArrayList;

public class EmployeeMenuActivity extends AppCompatActivity {

    private Button mSupportTicket;
    private Button mApplications;
    private Button mAddAccount;
    private Button mAddClient;

    private ArrayList<SalesApplication> _List = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);


    //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
    _List = getIntent().getParcelableArrayListExtra("APPLICATIONS_LIST");

       // SalesApplication sa = _List.get(0);

    //initializes Manage Client Menu button, sets an on click listerner with intent to switch to the emplo Menu.
    mSupportTicket = (Button) findViewById(R.id.support_tickets_button);
        mSupportTicket.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
            toast.show();
        }
    });

    //initializes Manage Sales Menu button, sets an on click listerner with intent to switch to he Employee Menu.
    mApplications = (Button) findViewById(R.id.manage_applications_button);
        mApplications.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(EmployeeMenuActivity.this, ApplicationsActivity.class);

            i.putParcelableArrayListExtra("APPLICATIONS_LIST", _List);

            startActivity(i);

        }
    });

    //initializes add Account button, sets an on click listerner with intent to switch to he Add Account activity.
    mAddAccount = (Button) findViewById(R.id.add_account_button);
        mAddAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
            toast.show();

        }
    });

    //initializes Add Client Button, sets an on click listerner with intent to switch to he Client Menu.
        mAddClient = (Button) findViewById(R.id.add_client_from_employee_button);
        mAddClient.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//                Intent i = new Intent(ClientMenuActivity.this, SubmitTicketClientActivity.class);
//                startActivity(i);

            Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
            toast.show();

        }
    });

}


    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                _List = data.getParcelableArrayListExtra("APPLICATIONS_LIST");
            }
        }
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ClientMenuActivity");

        Intent result = new Intent();

        result.putParcelableArrayListExtra("APPLICATIONS_LIST", _List);
        setResult(RESULT_OK, result);
        finish();
    }
}
