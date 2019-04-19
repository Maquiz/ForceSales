package com.example.forcesales;

import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Client.ClientList;

public class ManageClientActivity extends AppCompatActivity {

    private Button mShowAllClient;
    private Button mAddClient;
    private Button mRemoveClient;
    private Button mFindClient;
    private ClientList _List = new ClientList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("APP", "onCreate called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_client);

        //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
        _List =  getIntent().getParcelableExtra("ACCOUNT_LIST");

        //initializes Developer Menu button, sets an on click listerner with intent to switch to the Developer Menu.
        mShowAllClient = (Button) findViewById(R.id.show_all_client_button);
        mShowAllClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Starts intent to ShowClientListActivity
                Intent i = new Intent(ManageClientActivity.this, ShowClientListActivity.class);

                //Stores the parcelable arraylist that contains all clients
                i.putExtra("ACCOUNT_LIST", (Parcelable) _List);

                //Starts the activity, although since this activity will not change the list, we will not require result/return.
                startActivity(i);

            }
        });

        //initializes Add Client Menu button, sets an on click listerner with intent to switch to the Employee Menu.
        mAddClient = (Button) findViewById(R.id.add_client_button);
        mAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageClientActivity.this, AddClientActivity.class);
                i.putExtra("ACCOUNT_LIST", (Parcelable) _List);
                startActivityForResult(i,1);

            }
        });

        //initializes Remove Client Menu button, sets an on click listerner with intent to switch to the Client Menu.
        mRemoveClient = (Button) findViewById(R.id.remove_client_button);
        mRemoveClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageClientActivity.this, RemoveClientActivity.class);
                i.putExtra("ACCOUNT_LIST", (Parcelable) _List);
                startActivityForResult(i, 1);

            }
        });

        //initializes Find Client Menu button, sets an on click listerner with intent to switch to the Find Client Menu.
        mFindClient = (Button) findViewById(R.id.find_client_button);
        mFindClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(ClientMenuActivity.this, SubmitTicketClientActivity.class);
//                startActivity(i);

                Toast toast = Toast.makeText(getApplicationContext(), "Coming soon.", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }

    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called, in ManageClient Activity, with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                _List = data.getParcelableExtra("ACCOUNT_LIST");
            }
        }
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ManageClientActivity");

        Intent result = new Intent();

        result.putExtra("ACCOUNT_LIST", (Parcelable) _List);
        setResult(RESULT_OK, result);
        finish();
    }
}
