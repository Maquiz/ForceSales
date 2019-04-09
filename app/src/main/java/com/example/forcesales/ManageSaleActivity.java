package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;

import java.util.ArrayList;

public class ManageSaleActivity extends AppCompatActivity {

    private Button mShowAllSale;
    private Button mAddSale;
    private Button mRemoveSale;
    private Button mFindSale;
    private Sales _Sales;
    private ArrayList<Client> _List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_sale);

        Log.d("APP", "onCreate called in ManageSaleActivity");

        //pull task list object from previous activity
        _Sales =  getIntent().getParcelableExtra("SALE_LIST");
        _List =  getIntent().getParcelableArrayListExtra("ACCOUNT_LIST");

        //initializes Show Task List Menu button, sets an on click listerner with intent to switch to the Show all tasks activity.
        mShowAllSale = (Button) findViewById(R.id.show_all_sale_button);
        mShowAllSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Starts intent to ShowSaleListActivity
                Intent i = new Intent(ManageSaleActivity.this, ShowSaleListActivity.class);

                //Stores the parcelable TaskList that contains all tasks
                i.putExtra("SALE_LIST", _Sales);

                //Starts the activity, although since this activity will not change the list, we will not require result/return.
                startActivity(i);

            }
        });

        //initializes Add Sale Menu button, sets an on click listerner with intent to switch to the Add task prompt.
        mAddSale = (Button) findViewById(R.id.add_sale_button);
        mAddSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //starts intent to AddSaleActivity
                Intent i = new Intent(ManageSaleActivity.this, AddSaleActivity.class);

                //Storing the task list in this intent
                i.putExtra("SALE_LIST", _Sales);
                i.putParcelableArrayListExtra("ACCOUNT_LIST", _List);

                //starting actvity for result to return the list when a Sale has been added.
                startActivityForResult(i,3);

            }
        });

        //initializes Remove Sale Menu button, sets an on click listerner with intent to switch to the Remove Sale Menu.
        mRemoveSale = (Button) findViewById(R.id.remove_sale_button);
        mRemoveSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //starts intent to RemoveSaleActivty
                Intent i = new Intent(ManageSaleActivity.this, RemoveSaleActivity.class);

                //storing the task list in this intent
                i.putExtra("SALE_LIST", _Sales);

                //starting activity for result to return the list when a Sale has been deleted.
                startActivityForResult(i, 3);

//                    Toast toast = Toast.makeText(getApplicationContext(), "Coming soon.", Toast.LENGTH_SHORT);
//                    toast.show();

            }
        });

        //initializes Find Sale Menu button, sets an on click listerner with intent to switch to the Find Sale Menu.
        mFindSale = (Button) findViewById(R.id.find_sale_button);
        mFindSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(ClientMenuActivity.this, SubmitTicketClientActivity.class);
//                startActivity(i);

                Toast toast = Toast.makeText(getApplicationContext(), "Coming soon.", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }

    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the sales list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called, in ManageSale Activity, with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == 3){
            if(resultCode == RESULT_OK){
                _Sales = data.getParcelableExtra("SALE_LIST");
            }
        }
    }

    //When the back button is pressed it passes the updated sales list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called in ManageSalesActivity");

        Intent result = new Intent();

        result.putExtra("SALE_LIST", _Sales);
        setResult(RESULT_OK, result);
        finish();
    }
}
