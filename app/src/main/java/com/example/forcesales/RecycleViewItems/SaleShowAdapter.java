package com.example.forcesales.RecycleViewItems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.R;
import java.util.List;

public class SaleShowAdapter extends RecyclerView.Adapter<SaleShowAdapter.SaleShowViewHolder> {

    private List<Sale> mSaleList;

    public static class SaleShowViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;

        public SaleShowViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.task_list_text1);
            mTextView2 = itemView.findViewById(R.id.task_list_text2);
            mTextView3 = itemView.findViewById(R.id.task_list_text3);
            mTextView4 = itemView.findViewById(R.id.task_list_text4);
            mTextView5 = itemView.findViewById(R.id.task_list_text5);
        }
    }

    public SaleShowAdapter(List<Sale> saleList){
        mSaleList = saleList;
    }

    @Override
    public SaleShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card, parent, false);
        SaleShowViewHolder cvh = new SaleShowViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(SaleShowViewHolder holder, int position) {
        Sale currentItem = mSaleList.get(position);


        holder.mTextView1.setText(Integer.toString(currentItem.getSaleId()));
        holder.mTextView2.setText(" Amount Paid: $" + currentItem.getAmountPaid());
        holder.mTextView3.setText("Total Cost:  $" + currentItem.getTotalCost());
    }

    @Override
    public int getItemCount() {
        return mSaleList.size();
    }
}