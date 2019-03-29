package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Tasks.TaskList;
import java.util.ArrayList;


public class ManageTaskActivity extends AppCompatActivity {

    private Button mShowAllTask;
    private Button mAddTask;
    private Button mRemoveTask;
    private Button mFindTask;
    private TaskList _Task;
    private ArrayList<Client> _List;
  
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_task);



            Log.d("APP", "onCreate called in ManageTaskActivity");

            //pull task list object from previous activity
            _Task =  getIntent().getParcelableExtra("TASK_LIST");
            _List =  getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");

            //initializes Show Task List Menu button, sets an on click listerner with intent to switch to the Show all tasks activity.
            mShowAllTask = (Button) findViewById(R.id.show_all_task_button);
            mShowAllTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Starts intent to ShowTaskListActivity
                    Intent i = new Intent(ManageTaskActivity.this, ShowTaskListActivity.class);

                    //Stores the parcelable TaskList that contains all tasks
                    i.putParcelableArrayListExtra("TASK_LIST", _Task);

                    //Starts the activity, although since this activity will not change the list, we will not require result/return.
                    startActivity(i);

                }
            });

            //initializes Add Task Menu button, sets an on click listerner with intent to switch to the Add task prompt.
            mAddTask = (Button) findViewById(R.id.add_task_button);
            mAddTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //starts intent to AddTaskActivity
                    Intent i = new Intent(ManageTaskActivity.this, AddTaskActivity.class);

                    //Storing the task list in this intent
                    i.putParcelableArrayListExtra("TASK_LIST", _Task);
                    i.putParcelableArrayListExtra("ACCOUNT_LIST", _List);

                    //starting actvity for result to return the list when a task has been added.
                    startActivityForResult(i,2);

                }
            });

            //initializes Remove Task Menu button, sets an on click listerner with intent to switch to the Remove task Menu.
            mRemoveTask = (Button) findViewById(R.id.remove_task_button);
            mRemoveTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    //starts intent to RemoveTaskActivty
//                    Intent i = new Intent(ManageTaskActivity.this, RemoveTaskActivity.class);
//
//                    //storing the task list in this intent
//                    i.putParcelableArrayListExtra("TASK_LIST", _Task);
//
//                    //starting activity for result to return the list when a task has been deleted.
//                    startActivityForResult(i, 2);

                    Toast toast = Toast.makeText(getApplicationContext(), "Coming soon.", Toast.LENGTH_SHORT);
                    toast.show();

                }
            });

            //initializes Find Client Menu button, sets an on click listerner with intent to switch to the Find Client Menu.
            mFindTask = (Button) findViewById(R.id.find_task_button);
            mFindTask.setOnClickListener(new View.OnClickListener() {
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


            if(requestCode == 2){
                if(resultCode == RESULT_OK){
                    _Task = data.getParcelableExtra("TASK_LIST");
                }
            }
        }

        //When the back button is pressed it passes the current client list back to the previous activity.
        @Override
        public void onBackPressed() {

            Log.d("APP", "onBackPressed() Override called in ManageTaskActivity");

            Intent result = new Intent();

            result.putParcelableArrayListExtra("TASK_LIST", _Task);
            setResult(RESULT_OK, result);
            finish();
        }
    }
