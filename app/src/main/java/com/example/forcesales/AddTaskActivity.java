package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Tasks.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity {

    private EditText mAddText1;
    private Button mAssignButton;
    private EditText mAddText3;
    private EditText mAddText4;
    private EditText mAddText5;
    private EditText mAddText6;
    private EditText mAddText7;
    private Button mAddButton;
    private Button mLeftButton;
    private Button mRightButton;
    private ArrayList<Client> _List;
    private ArrayList<Task> _Task;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
        _List =  getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");
        _Task = getIntent().getParcelableArrayListExtra("TASK_LIST");

        mAddText1 = findViewById(R.id.add_task_box1);
        mAssignButton = findViewById(R.id.add_task_button2);
        mAddText3 = findViewById(R.id.add_task_box3);
        mAddText4 = findViewById(R.id.add_task_box4);
        mAddText5 = findViewById(R.id.add_task_box5);
        mAddText6 = findViewById(R.id.add_task_box6);
        mAddText7 = findViewById(R.id.add_task_box7);
        mAddButton = findViewById(R.id.add_task_button);
        mLeftButton = findViewById(R.id.left_task_button3);
        mRightButton = findViewById(R.id.right_task_button4);

        mAssignButton.setText(_List.get(position).getFirstName()+ " " + _List.get(position).getLastName());

        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position > 0)
                {
                    position--;
                    mAssignButton.setText(_List.get(position).getFirstName() + " " + _List.get(position).getLastName());
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position < _List.size())
                {
                    position++;
                    mAssignButton.setText(_List.get(position).getFirstName() + " " + _List.get(position).getLastName());
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "End of List", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Box3 = month
//                Box4 = date
//                Box5 = year
//                Box6 = hour
//                Box7 = minute

//                Calendar set constructor: year, month, date, hour, minute
                Calendar tempCal = Calendar.getInstance();
                tempCal.set(Integer.parseInt(mAddText5.getText().toString()), Integer.parseInt(mAddText3.getText().toString()), Integer.parseInt(mAddText4.getText().toString()), Integer.parseInt(mAddText6.getText().toString()), Integer.parseInt(mAddText7.getText().toString()));

                // Update to Include Description.
                Task temp = new Task(mAddText1.getText().toString(),_List.get(position), tempCal);


                _Task.add(temp);

                Intent resultIntent = new Intent();
                resultIntent.putParcelableArrayListExtra("TASK_LIST", _Task);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

    }

}
