package com.example.forcesales.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.R;
import java.util.ArrayList;

public class ApplicationsActivity extends AppCompatActivity {

    private ArrayList<SalesApplication> _List = new ArrayList<>();

    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;

    public Button mAccept;
    public Button mDeny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_review);

        //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
        _List = getIntent().getParcelableArrayListExtra("APPLICATIONS_LIST");

        SalesApplication sa = _List.get(0);


        mTextView1 = findViewById(R.id.app_review_name);
        mTextView2 = findViewById(R.id.app_company);
        mTextView3 = findViewById(R.id.app_address);
        mTextView4 = findViewById(R.id.app_email);
        mTextView5 = findViewById(R.id.app_phone_num);


        mTextView1.setText(sa.getFirstName() + " " + sa.getLastName());
        mTextView2.setText(sa.getCompanyName());
        mTextView3.setText(sa.getAddress().toString());
        mTextView4.setText(sa.getEmail());
        mTextView5.setText(sa.getPhoneNumber());

        mAccept = (Button) findViewById(R.id.accept_app);
        mAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Account Accepted", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        mDeny = (Button) findViewById(R.id.deny_app);
        mDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Account Denied", Toast.LENGTH_SHORT);
                toast.show();
                finish();
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
