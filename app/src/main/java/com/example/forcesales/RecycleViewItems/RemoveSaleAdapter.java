package com.example.forcesales.RecycleViewItems;

import android.graphics.Color;
import android.graphics.PorterDuff;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;

import java.util.ArrayList;
import java.util.List;

public class RemoveSaleAdapter extends RecyclerView.Adapter<RemoveSaleAdapter.RemoveSaleViewHolder> {

    private static List<Sale> mSaleList;

    public static class RemoveSaleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public Button mRemoveButton;

        public RemoveSaleViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.client_list_text1);
            mTextView2 = itemView.findViewById(R.id.client_list_text2);
            mRemoveButton = itemView.findViewById(R.id.remove_button);

            mRemoveButton.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {
                    Toast toast = Toast.makeText(itemView.getContext(), mSaleList.get(getAdapterPosition()).getSaleId() + " removed.", Toast.LENGTH_SHORT);
                    toast.show();
                    mSaleList.remove(getAdapterPosition());
                    mRemoveButton.setClickable(false);
                    mRemoveButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    mRemoveButton.setText("Bye!");
                }
            });

        }
    }

    public RemoveSaleAdapter(List<Sale> saleList){
        mSaleList = saleList;
    }

    @Override
    public RemoveSaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_client_card, parent, false);
        RemoveSaleViewHolder cvh = new RemoveSaleViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(RemoveSaleViewHolder holder, int position) {
        Sale currentItem = mSaleList.get(position);

        holder.mTextView1.setText("ID: " + currentItem.getSaleId());
        holder.mTextView2.setText("Paid: $" + currentItem.getAmountPaid());

    }

    @Override
    public int getItemCount() {
        return mSaleList.size();
    }
}
