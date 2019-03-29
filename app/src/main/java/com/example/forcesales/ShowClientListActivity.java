package com.example.forcesales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Client.ClientList;
import com.example.forcesales.RecycleViewItems.ClientShowAdapter;
import java.util.ArrayList;

public class ShowClientListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);

        ClientList _List =  getIntent().getParcelableExtra("ACCOUNT_LIST");

        mRecyclerView = findViewById(R.id.show_all_client_recycleview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ClientShowAdapter(_List);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
