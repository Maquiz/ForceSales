package com.example.forcesales.TestHelper;

import android.content.Intent;
import android.os.Bundle;

import com.example.forcesales.Data.Developer.Developer;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;
import com.example.forcesales.UI.Developer.IssueTracker.ManageIssueTrackerActivity;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class IssueTrackerHelper extends AppCompatActivity {
    static private final int REQUESTCODE_RETURN = 1;
    public Management management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        management = new Management();
        String name[][] = {{"A","B"}, {"B","C"}, {"C","D"}, {"D","E"}};
        String issue[][] = { {"name1","description1"}, {"name2","description2"},
                {"name3","description3"}, {"name4","description4"}};

        for (int i = 0; i < name.length; i++) {
            Developer developer = new Developer();
            developer.setFirstName(name[i][0]);
            developer.setLastName(name[i][1]);
            developer.setEmail(String.format("%s.%s@forcesale.com",name[i][0],name[i][1]));
            management.getDeveloperList().add(developer);

            IssueTracker issue_tracker =
                    new IssueTracker(issue[i][0],
                            issue[i][1],
                            developer,
                            Calendar.getInstance());
            management.getIssueTracker().add(issue_tracker);
        }

        Intent i = new Intent(this, ManageIssueTrackerActivity.class);
        i.putExtra(Management.PARCELABLE_STR, management);
        startActivityForResult(i, REQUESTCODE_RETURN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE_RETURN) {
            if (resultCode == RESULT_OK) {
                management = data.getParcelableExtra(Management.PARCELABLE_STR);
            }
        }
    }
}