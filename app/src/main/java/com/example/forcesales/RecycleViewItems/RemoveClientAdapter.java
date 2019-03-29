package com.example.forcesales.RecycleViewItems;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.R;

import java.util.ArrayList;

public class RemoveClientAdapter extends RecyclerView.Adapter<RemoveClientAdapter.RemoveClientViewHolder> {

    private static ArrayList<Client> mClientList;

    public static class RemoveClientViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public Button mRemoveButton;

        public RemoveClientViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.client_list_text1);
            mTextView2 = itemView.findViewById(R.id.client_list_text2);
            mRemoveButton = itemView.findViewById(R.id.remove_button);

            mRemoveButton.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {
                    Toast toast = Toast.makeText(itemView.getContext(), mClientList.get(getAdapterPosition()).getFirstName() + " removed.", Toast.LENGTH_SHORT);
                    toast.show();
                    mClientList.remove(getAdapterPosition());
                    mRemoveButton.setClickable(false);
                    mRemoveButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    mRemoveButton.setText("Bye!");
                }
            });

        }
    }

    public RemoveClientAdapter(ArrayList<Client> clientList){
        mClientList = clientList;
    }

    @Override
    public RemoveClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_client_card, parent, false);
        RemoveClientViewHolder cvh = new RemoveClientViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(RemoveClientViewHolder holder, int position) {
        Client currentItem = mClientList.get(position);

        holder.mTextView1.setText(currentItem.getFirstName() + " " + currentItem.getLastName());
        holder.mTextView2.setText(currentItem.getEmail());

    }

    @Override
    public int getItemCount() {
        return mClientList.size();
    }
}
