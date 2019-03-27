package com.example.forcesales.RecycleViewItems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.R;

import java.util.ArrayList;

public class ClientShowAdapter extends RecyclerView.Adapter<ClientShowAdapter.ClientShowViewHolder> {

    private ArrayList<Client> mClientList;

    public static class ClientShowViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;

        public ClientShowViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.client_list_text1);
            mTextView2 = itemView.findViewById(R.id.client_list_text2);
            mTextView3 = itemView.findViewById(R.id.client_list_text3);
            mTextView4 = itemView.findViewById(R.id.client_list_text4);
            mTextView5 = itemView.findViewById(R.id.client_list_text5);
        }
    }

    public ClientShowAdapter(ArrayList<Client> clientList){
        mClientList = clientList;
    }

    @Override
    public ClientShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_card, parent, false);
        ClientShowViewHolder cvh = new ClientShowViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ClientShowViewHolder holder, int position) {
        Client currentItem = mClientList.get(position);

        holder.mTextView1.setText(currentItem.getFirstName() + " " + currentItem.getLastName());
        holder.mTextView2.setText(currentItem.getEmail());
    }

    @Override
    public int getItemCount() {
        return mClientList.size();
    }
}
