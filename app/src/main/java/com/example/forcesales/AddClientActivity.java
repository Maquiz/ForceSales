package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Person.Address;
import java.util.ArrayList;

public class AddClientActivity extends AppCompatActivity {

    private EditText mAddText1;
    private EditText mAddText2;
    private EditText mAddText3;
    private EditText mAddText4;
    private EditText mAddText5;
    private EditText mAddText6;
    private EditText mAddText7;
    private Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        //pull client list from the previous intent for use in this activity. (no casting required, just store in a ArrayList<Client>)
        ArrayList<Client> _List =  getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");

        mAddText1 = findViewById(R.id.add_client_box1);
        mAddText2 = findViewById(R.id.add_client_box2);
        mAddText3 = findViewById(R.id.add_client_box3);
        mAddText4 = findViewById(R.id.add_client_box4);
        mAddText5 = findViewById(R.id.add_client_box5);
        mAddText6 = findViewById(R.id.add_client_box6);
        mAddText7 = findViewById(R.id.add_client_box7);
        mAddButton = findViewById(R.id.add_client_button);


        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Client temp = new Client();

                temp.setFirstName(mAddText1.getText().toString());
                temp.setLastName(mAddText2.getText().toString());
                temp.setAddress(new Address(mAddText3.getText().toString(), mAddText4.getText().toString(), mAddText5.getText().toString(), mAddText6.getText().toString()));
                temp.setEmail(mAddText7.getText().toString());

                _List.add(temp);

                Intent resultIntent = new Intent();
                resultIntent.putParcelableArrayListExtra("ACCOUNT_LIST", _List);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

    }
}
