package com.example.forcesales.RecycleViewItems.Employee.Applications;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.R;

import java.util.ArrayList;

public class ApplicationShowAdapter extends RecyclerView.Adapter<ApplicationShowAdapter.ApplicationShowViewHolder> {

    private ArrayList<SalesApplication> mApplicationList  = new ArrayList<SalesApplication>();
    private ArrayList<SalesApplication> mApprovedList  = new ArrayList<SalesApplication>();
    private ArrayList<SalesApplication> mDeniedList  = new ArrayList<SalesApplication>();

    public static class ApplicationShowViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;
        public Button mAccept;
        public Button mDeny;

        public ApplicationShowViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.app_review_name);
            mTextView2 = itemView.findViewById(R.id.app_company);
            mTextView3 = itemView.findViewById(R.id.app_address);
            mTextView4 = itemView.findViewById(R.id.app_email);
            mTextView5 = itemView.findViewById(R.id.app_phone_num);
            mAccept =  itemView.findViewById(R.id.accept_app);
            mDeny = itemView.findViewById(R.id.deny_app);
        }
    }

    public ApplicationShowAdapter (ArrayList<SalesApplication> applicationList, ArrayList<SalesApplication> approvedList,ArrayList<SalesApplication> deniedList) {
        mApplicationList = applicationList;
        mApprovedList = approvedList;
        mDeniedList = deniedList;
    }

    @Override
    public ApplicationShowViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_application_review,parent, false);
        ApplicationShowViewHolder avh = new ApplicationShowViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationShowViewHolder holder, int position) {
        SalesApplication sa = mApplicationList.get(position);

        holder.mTextView1.setText(sa.getFirstName() + " " + sa.getLastName());
        holder.mTextView2.setText(sa.getCompanyName());
        holder.mTextView3.setText(sa.getAddress().toString());
        holder.mTextView4.setText(sa.getEmail());
        holder.mTextView5.setText(sa.getPhoneNumber());

        //Accept Button
        holder.mAccept.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(), "Account Accepted", Toast.LENGTH_SHORT);
            toast.show();
            //Add to Accepted List
            mApprovedList.add(mApplicationList.get(position));
            //Remove item from list
            mApplicationList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,mApplicationList.size());
        });

        //Decline Button
        holder.mDeny.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(), "Account Denied", Toast.LENGTH_SHORT);
            toast.show();
            //Add to decline list
            mDeniedList.add(mApplicationList.get(position));
            //Remove from main list
            mApplicationList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,mApplicationList.size());
        });
    }

    @Override
    public int getItemCount() { return mApplicationList.size();}

}
