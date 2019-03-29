package com.example.forcesales.UI.Developer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Developer.Developer;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;

import java.util.ArrayList;
import java.util.Calendar;

public class DeveloperMenuActivity extends AppCompatActivity {
    public static final String TASKLIST = "com.example.forcesales.UI.Developer.DeveloperMenuTest.TASKLIST";

    private static final int RETURN_TASK_OBJECT = 1;

    private ArrayList<Developer> developer_list;
    private Task test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_menu);

        test = new Task("Thomas's Value", "This task has a special meaning!", new Client(), Calendar.getInstance());

        Button sw_ticket = findViewById(R.id.button_dev_sw_ticket);
        sw_ticket.setOnClickListener(v -> {
            Intent i = null;
            Toast t = Toast.makeText(DeveloperMenuActivity.this, "SW TICKET: Need to connect soon", Toast.LENGTH_SHORT);
            t.show();

        });


        Button add_employee = findViewById(R.id.button_dev_add_employee);
        add_employee.setOnClickListener(v -> {
            Intent i = null;
            Toast t = Toast.makeText(getApplicationContext(), "ADD EMPLOYEE: Need to connect soon", Toast.LENGTH_SHORT);
            t.show();

//            startActivity(i);
//            startActivityForResult(i,1);
        });

//        Button test_menu = findViewById(R.id.button_dev_test_menu);
//        test_menu.setOnClickListener(v -> {
//            Intent i = new Intent(this, DeveloperMenuTest.class);
//            i.putExtra(TASKLIST, test);
//
//            startActivityForResult(i, RETURN_TASK_OBJECT);
//        });

//        test = new Task();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast t = Toast.makeText(getApplicationContext(), "Obtaining Results", Toast.LENGTH_SHORT);
        t.show();

        Log.d("DEVMENU", String.format("requestCode: %d", requestCode));

        if (requestCode == RETURN_TASK_OBJECT) {
            if (resultCode == RESULT_OK) {
                test = data.getParcelableExtra(TASKLIST);
                Log.d("DEVMENU", "Result for Task object: ");
                Log.d("DEVMENU", String.format("%s: %s", "Name", test.getNameOfTask()));
                Log.d("DEVMENU", String.format("%s: %s", "Description", test.getDescriptionOfTask()));
                Log.d("DEVMENU", String.format("%s: %s", "Completion Date", String.format("%d/%s",test.getCompletionDate().getMonth(), test.getCompletionDate().getDate())));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast t = Toast.makeText(getApplicationContext(), "Returning", Toast.LENGTH_SHORT);
        t.show();

        Intent result = new Intent();
//        result.putParcelableArrayListExtra()

        setResult(RESULT_OK, result);
        finish();
    }
}