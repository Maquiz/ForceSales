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
import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.RecycleViewItems.SaleShowAdapter;
import com.example.forcesales.RecycleViewItems.TaskShowAdapter;

import java.util.List;

public class ShowSaleListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Sales temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        temp = getIntent().getParcelableExtra("SALE_LIST");
        List<Sale> _List = temp.getSalesList();

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SaleShowAdapter(_List);

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
        Intent i = new Intent(this, AddSaleActivity.class);
        i.putExtra("SALES_LIST", (Parcelable) temp);
        startActivityForResult(i,3);
    }

    private void menuItemDelete() {
        Intent i = new Intent(this, RemoveSaleActivity.class);
        i.putExtra("SALES_LIST",(Parcelable) temp);
        startActivityForResult(i, 3);
    }

    protected void updateAdapter() {
        List<Sale> _List = temp.getSalesList();
        mAdapter = new SaleShowAdapter((_List));
        mRecyclerView.setAdapter(mAdapter);
    }

    //After the next activity calls @finish() and onCreate() for this activity is called, onActivityResult() is called, overriding the client list.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called, in Manage Task Activity, with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == 3){
            if(resultCode == RESULT_OK){
                temp = data.getParcelableExtra("SALES_LIST");
                updateAdapter();
            }
        }
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it ManageSaleActivity");

        Intent result = new Intent();

        result.putExtra("SALES_LIST", (Parcelable) temp);
        setResult(RESULT_OK, result);
        finish();
    }
}

