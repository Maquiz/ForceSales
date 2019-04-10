package com.example.forcesales.UI.Developer.IssueTracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.forcesales.Data.Developer.DeveloperList;
import com.example.forcesales.Data.IssueTracker.IssueTrackerList;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.R;
import com.example.forcesales.RecycleViewItems.Developer.IssueTracker.IssueTrackerShowAdapter;

public class ManageIssueTrackerActivity extends AppCompatActivity {
    private static final int REQUESTCODE_ADDISSUE = 1;
    private static final int REQUESTCODE_VIEWISSUE = 2;
    private static final int REQUESTCODE_REMOVEISSUE = 3;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Management management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_list);

        management = getIntent().getParcelableExtra(Management.PARCELABLE_STR);

        mRecyclerView = findViewById(R.id.abstract_recycleview_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        updateAdapter();
    }

    @Override
    public void onBackPressed() {
//        Log.d("APP", "onBackPressed() Override called in ManageIssueTrackerActivity");
        Intent result = new Intent();
        result.putExtra(Management.PARCELABLE_STR, management);
        setResult(RESULT_OK, result);
        finish();
    }

    //
    // Passing Intent Data
    //

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE_ADDISSUE) {
            if (resultCode == RESULT_OK) {
                management.setDeveloperList(data.getParcelableExtra(DeveloperList.PARCELABLE_STR));
                management.setIssueTracker(data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR));
            }
        }

        else if (requestCode == REQUESTCODE_VIEWISSUE) {
            if (resultCode == RESULT_OK) {
                management.setIssueTracker(data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR));
                management.setDeveloperList(data.getParcelableExtra(DeveloperList.PARCELABLE_STR));
            }
        }

        else if (requestCode == REQUESTCODE_REMOVEISSUE) {
            if (resultCode == RESULT_OK) {
                management.setIssueTracker(data.getParcelableExtra(IssueTrackerList.PARCELABLE_STR));
            }
        }

        // onCreate does not get called when you return to this activity
        // therefore, you need to manually update the Adapter.
        updateAdapter();
    }


    protected void updateAdapter() {
        mAdapter = new IssueTrackerShowAdapter(management.getIssueTracker(),this);
        mRecyclerView.setAdapter(mAdapter);
    }


    //
    // Public Method
    //

    // IssueTrackerShowAdapter will activate this function when it registers a OnClickListener event.
    public void showDetailedInformation(int position) {
        Intent i = new Intent(ManageIssueTrackerActivity.this, ViewIssueTrackerActivity.class);
        i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) management.getIssueTracker());
        i.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) management.getDeveloperList());
        i.putExtra("INTEGER", position);
        startActivityForResult(i, REQUESTCODE_VIEWISSUE);
    }


    //
    // Menu Functions
    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // The object responsible for setting the menu
        MenuInflater inflater = getMenuInflater();

        // Set the menubar to the manage_list menu
        inflater.inflate(R.menu.manage_list, menu);

        // Function requires you to return a boolean value
        return true;
    }

    @Override
    // Instead of using onClickListener, you need to use onOptionsItemSelected instead.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manage_list_add:      // if the current item is equal to R.id.manage_list_add
                menuItemAdd();              // Do intent stuff.
                break;                      // Leave switch statement.
            case R.id.manage_list_delete:
                menuItemDelete();
                break;
            default:                        // If you have not met any of the cases
                return super.onOptionsItemSelected(item);
        }

        // If you start a activity, does it return here?
        return true;
    }

    private void menuItemAdd() {
        Intent i = new Intent(this, AddOrUpdateIssueTrackerActivity.class);
        i.putExtra(DeveloperList.PARCELABLE_STR, (Parcelable) management.getDeveloperList());
        i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) management.getIssueTracker());
        startActivityForResult(i,REQUESTCODE_ADDISSUE);
    }

    private void menuItemDelete() {
        Intent i = new Intent(this, RemoveIssueTrackerActivity.class);
        i.putExtra(IssueTrackerList.PARCELABLE_STR, (Parcelable) management.getIssueTracker());
        startActivityForResult(i, REQUESTCODE_REMOVEISSUE);
    }
}
