package com.example.forcesales;

import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.example.forcesales.Data.Client.ClientList;
import com.example.forcesales.RecycleViewItems.RemoveClientAdapter;

public class RemoveClientActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ClientList _List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        getSupportActionBar().setTitle("Remove Clients");

        _List =  getIntent().getParcelableExtra("ACCOUNT_LIST");

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RemoveClientAdapter(_List);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    //When the back button is pressed it passes the current client list back to the previous activity.
    @Override
    public void onBackPressed() {

        Log.d("APP", "onBackPressed() Override called it RemoveClientActivity");

        Intent result = new Intent();
        result.putExtra("ACCOUNT_LIST", (Parcelable) _List);
        setResult(RESULT_OK, result);
        finish();
    }
}
