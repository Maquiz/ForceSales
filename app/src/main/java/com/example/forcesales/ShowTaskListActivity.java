package com.example.forcesales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.RecycleViewItems.ClientShowAdapter;
import com.example.forcesales.RecycleViewItems.TaskShowAdapter;

import java.util.List;

public class ShowTaskListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Task> _List;
    List<Client> _Client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        _List = getIntent().getParcelableArrayListExtra("TASK_LIST");
        _Client = getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TaskShowAdapter(_List);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // The object responsible for setting the menu
        MenuInflater inflater = getMenuInflater();

        // Set the menubar to the manage_list menu
        inflater.inflate(R.menu.manage_list, menu);

        // Function requires you to return a boolean value
        return true;
    }

    @Override
    // Instead of using onClickListener, you need to use onOptionsItemSelected instead.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manage_list_add:      // if the current item is equal to R.id.manage_list_add
                menuItemAdd();              // Do intent stuff.
                break;                      // Leave switch statement.
            case R.id.manage_list_delete:
                menuItemDelete();
                break;
            default:                        // If you have not met any of the cases
                return super.onOptionsItemSelected(item);
        }

        // If you start a activity, does it return here?
        return true;
    }

    private void menuItemAdd() {
        Intent i = new Intent(this, AddTaskActivity.class);
        i.putExtra("TASK_LIST", (Parcelable) _List);
        i.putExtra("ACCOUNT_LIST", (Parcelable) _Client);
        startActivityForResult(i,2);
    }

    private void menuItemDelete() {
        Intent i = new Intent(this, RemoveTaskActivity.class);
        i.putExtra("TASK_LIST", (Parcelable) _List);
        startActivityForResult(i, 2);
    }

    protected void updateAdapter() {
        mAdapter = new TaskShowAdapter((_List));
        mRecyclerView.setAdapter(mAdapter);
    }

    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called, in Manage Task Activity, with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                _List = data.getParcelableExtra("TASK_LIST");
                updateAdapter();
            }
        }
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ManageClientActivity");

        Intent result = new Intent();

        result.putExtra("TASK_LIST", (Parcelable) _List);
        setResult(RESULT_OK, result);
        finish();
    }
}
