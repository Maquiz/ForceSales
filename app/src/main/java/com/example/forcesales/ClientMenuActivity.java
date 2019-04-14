package com.example.forcesales;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.Task;


import java.util.ArrayList;

public class ClientMenuActivity extends AppCompatActivity {

    private Button mManageClient;
    private Button mManageSale;
    private Button mManageTask;
    private Button mSubmitTicket;
    private ArrayList<Client> _List = new ArrayList<>();
    private ArrayList<Task> _Tasks;
    private Sales _Sales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);

        //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
        _List = getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");
        _Tasks = getIntent().getParcelableArrayListExtra("TASK_LIST");
        _Sales = getIntent().getParcelableExtra("SALE_LIST");


        //initializes Manage Client Menu button, sets an on click listerner with intent to switch to he Developer Menu.
        mManageClient = (Button) findViewById(R.id.manage_client_button);
        mManageClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starts intent to ManageClientActivity
                Intent i = new Intent(ClientMenuActivity.this, ManageClientActivity.class);

                //Stores the parcelable arraylist that contains all clients
                i.putParcelableArrayListExtra("ACCOUNT_LIST", _List);

                //Starts the activity so that it expects a return from the activity when finish() is called in the next activity.
                startActivityForResult(i, 1);

            }
        });

        //initializes Manage Sales Menu button, sets an on click listerner with intent to switch to he Employee Menu.
        mManageSale = (Button) findViewById(R.id.manage_sales_button);
        mManageSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ClientMenuActivity.this, ManageSaleActivity.class);

                i.putExtra("SALE_LIST", _Sales);

                startActivityForResult(i, 3);

//                Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
//                toast.show();

            }
        });

        //initializes Manage Tasks Menu button, sets an on click listerner with intent to switch to he Client Menu.
        mManageTask = (Button) findViewById(R.id.manage_tasks_button);
        mManageTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClientMenuActivity.this, ManageTaskActivity.class);

                i.putExtra("TASK_LIST", _Tasks);
                i.putExtra("ACCOUNT_LIST", _List);

                startActivityForResult(i, 2);

            }
        });

        //initializes Submit Ticket Menu button, sets an on click listerner with intent to switch to he Client Menu.
        mSubmitTicket = (Button) findViewById(R.id.submit_ticket_button);
        mSubmitTicket.setOnClickListener(new View.OnClickListener() {
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
                _List = data.getParcelableArrayListExtra("ACCOUNT_LIST");
            }
        }

        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                _Tasks = data.getParcelableExtra("TASK_LIST");
            }
        }

    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ClientMenuActivity");

        Intent result = new Intent();

        result.putParcelableArrayListExtra("ACCOUNT_LIST", _List);

        result.putParcelableArrayListExtra("TASK_LIST", _Tasks);

        setResult(RESULT_OK, result);
        finish();
    }

}

