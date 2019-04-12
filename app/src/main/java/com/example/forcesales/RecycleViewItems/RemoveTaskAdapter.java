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

import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.R;

import java.util.ArrayList;

public class RemoveTaskAdapter extends RecyclerView.Adapter<RemoveTaskAdapter.RemoveTaskViewHolder> {

    private static ArrayList<Task> mTaskList;

    public static class RemoveTaskViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;
        public Button mRemoveButton;

        public RemoveTaskViewHolder(View itemView)
        {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.client_list_text1);
            mTextView2 = itemView.findViewById(R.id.client_list_text2);
            mRemoveButton = itemView.findViewById(R.id.remove_button);

            mRemoveButton.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {
                    Toast toast = Toast.makeText(itemView.getContext(), mTaskList.get(getAdapterPosition()).getNameOfTask() + " removed.", Toast.LENGTH_SHORT);
                    toast.show();
                    mTaskList.remove(getAdapterPosition());
                    mRemoveButton.setClickable(false);
                    mRemoveButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    mRemoveButton.setText("Bye!");
                }
            });

        }
    }

    public RemoveTaskAdapter(ArrayList<Task> taskList){
        mTaskList = taskList;
    }

    @Override
    public RemoveTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_client_card, parent, false);
        RemoveTaskViewHolder cvh = new RemoveTaskViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(RemoveTaskViewHolder holder, int position) {
        Task currentItem = mTaskList.get(position);

        holder.mTextView1.setText(currentItem.getNameOfTask());
        holder.mTextView2.setText(currentItem.getDescriptionOfTask());

    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
