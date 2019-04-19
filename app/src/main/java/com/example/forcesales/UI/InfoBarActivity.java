package com.example.forcesales.UI;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import com.example.forcesales.Data.Account.AccountList;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;

public class InfoBarActivity extends AppCompatActivity {

    private Button mDeveloper;
    private Button mEmployee;
    private Button mClient;

    private Management management;
    private AccountList account_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_info);

        management = getIntent().getParcelableExtra(Management.PARCELABLE_STR);
        account_list = getIntent().getParcelableExtra(AccountList.PARCELABLE_STR);

        setDeveloperButton();
        setEmployeeButton();
        setClientButton();

    }

    private void setDeveloperButton() {
        mDeveloper = findViewById(R.id.info_developer_button);
        mDeveloper.setOnClickListener(v -> {
            Intent i = new Intent(this, null);
            i.putExtra(Management.PARCELABLE_STR, management);
            startActivity(i);
        });
    }

    private void setEmployeeButton() {
        mEmployee = findViewById(R.id.info_employee_button);
        mEmployee.setOnClickListener(v -> {
            Intent i = new Intent(this, null);
            startActivity(i);
        });
    }

    private void setClientButton() {
        mClient = findViewById(R.id.info_client_button);
        mClient.setOnClickListener(v -> {
            Intent i = new Intent(this, null);
            startActivity(i);
        });
    }

}
