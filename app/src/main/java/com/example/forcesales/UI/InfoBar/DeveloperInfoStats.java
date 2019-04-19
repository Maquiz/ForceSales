package com.example.forcesales.UI.InfoBar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;

import java.util.Dictionary;
import java.util.Hashtable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeveloperInfoStats extends AppCompatActivity {
    private Management management;
    private Dictionary<String,Integer> label_tally;
    private Dictionary<String,Integer> opened_closed_tally;

    private TextView mOpen;
    private TextView mClose;
    private TextView mNONE;
    private TextView mWONTFIX;
    private TextView mDUPLICATE;
    private TextView mQUESTION;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_info);

        management = getIntent().getParcelableExtra(Management.PARCELABLE_STR);
        label_tally = new Hashtable<>();
        opened_closed_tally = new Hashtable<>();

        mOpen = findViewById(R.id.developer_info_open);
        mClose = findViewById(R.id.developer_info_close);
        mNONE = findViewById(R.id.developer_info_none);
        mWONTFIX = findViewById(R.id.developer_info_wont_fix);
        mDUPLICATE = findViewById(R.id.developer_info_duplicate);
        mQUESTION = findViewById(R.id.developer_info_question);

        calculateTally();
        displayTally();
    }

    private void calculateTally() {
        for (IssueTracker.LABLE i: IssueTracker.LABLE.values()) {
            label_tally.put(i.name(), 0);
        }

        opened_closed_tally.put("Open", 0);
        opened_closed_tally.put("Close", 0);

        for (IssueTracker i: management.getIssueTracker()) {
            calcuateLabel(i);
            calcuateOpenClosed(i);
        }
    }

    private void calcuateLabel(IssueTracker i) {
        String name = i.getLabel().name();
        label_tally.put(name, label_tally.get(name)+1);
    }

    public void calcuateOpenClosed(IssueTracker i) {
        if (i.isTaskDone()) {
            opened_closed_tally.put("Close", opened_closed_tally.get("Close")+1);
        } else {
            opened_closed_tally.put("Open", opened_closed_tally.get("Open")+1);
        }
    }

    @SuppressLint("SetTextI18n")
    public void displayTally() {
        mOpen.setText(opened_closed_tally.get("Open").toString());
        mClose.setText(opened_closed_tally.get("Close").toString());

        TextView textview_issue_lable_group[] = {mNONE, mWONTFIX, mDUPLICATE, mQUESTION};
        IssueTracker.LABLE label_issue_lable_group[] = IssueTracker.LABLE.values();
        for (int i = 0; i < IssueTracker.LABLE.values().length; i++) {
            textview_issue_lable_group[i].setText(label_tally.get(label_issue_lable_group[i].name()).toString());
        }
    }
}

