package com.example.forcesales.Employee;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Employee.Applications.ApplicationShowAdapter;

import java.util.ArrayList;

public class ApplicationsActivity extends AppCompatActivity {

    private ArrayList<SalesApplication> _List = new ArrayList<SalesApplication>();
    private ArrayList<SalesApplication> _AList = new ArrayList<SalesApplication>();
    private ArrayList<SalesApplication> _DList = new ArrayList<SalesApplication>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        employee = getIntent().getParcelableExtra(Employee.PARCELABLE_STR);
        _List = getIntent().getParcelableArrayListExtra("APPLICATIONS_LIST");
        _AList = getIntent().getParcelableArrayListExtra("APPROVED_LIST");
        _DList = getIntent().getParcelableArrayListExtra("DENIED_LIST");

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ApplicationShowAdapter(_List,_AList,_DList);
        mRecyclerView.setAdapter(mAdapter);

        //pull client list from the previous intent for use in t
        // is activity. (no casting required, just store in a ArrayList<Client>)

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
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ClientMenuActivity");

        Intent result = new Intent();
       // result.putParcelableArrayListExtra("APPLICATIONS_LIST", _List);
        result.putParcelableArrayListExtra("APPLICATIONS_LIST", _List);
        result.putParcelableArrayListExtra("APPROVED_LIST", _AList);
        result.putParcelableArrayListExtra("DENIED_LIST", _DList);
        setResult(RESULT_OK, result);
        finish();

    }
    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
    }
}
