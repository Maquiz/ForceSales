package com.example.forcesales.RecycleViewItems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ApplicationShowAdapter extends RecyclerView.Adapter<ApplicationShowAdapter.ApplicationShowViewHolder> {



    @NonNull
    @Override
    public ApplicationShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationShowViewHolder applicationShowViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ApplicationShowViewHolder extends RecyclerView.ViewHolder {


        public ApplicationShowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
