package com.example.forcesales.ClientMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.Data.Sale.Sales;
import com.example.forcesales.Data.Tasks.TaskList;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.RemoveSaleAdapter;
import com.example.forcesales.RecycleViewItems.RemoveTaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class RemoveSaleActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Sales _Sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        _Sale = getIntent().getParcelableExtra("SALES_LIST");
        ArrayList<Sale> _List = _Sale.getSalesList();

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RemoveSaleAdapter(_List);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it RemoveSaleActivity");
        Intent result = new Intent();
        result.putExtra("SALES_LIST", (Parcelable) _Sale);
        setResult(RESULT_OK, result);
        finish();
    }

}
