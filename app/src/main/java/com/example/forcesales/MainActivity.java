package com.example.forcesales;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.forcesales.Data.Account.Account;
import com.example.forcesales.Data.Account.AccountList;
import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Developer.Developer;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.IssueTracker.IssueTracker;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.Data.Person.Address;
import com.example.forcesales.Data.Sale.Sale;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.UI.Developer.DeveloperMenuActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button mDeveloperMenu;
    private Button mEmployeeMenu;
    private Button mClientMenu;

    private Employee employee = new Employee();
    private SalesApplication salesApp = new SalesApplication();
    private Account account = new Account();
    private AccountList account_array = new AccountList();
    private Management management = new Management();

    public static final int RETURNCODE_SETCLIENT = 1;
    public static final int RETURNCODE_SETMANAGEMENT = 2;
    public static final int RETURNCODE_SETTASKS = 3;
    public static final int RETURNCODE_MAXMAGIC = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dev_first_name[] = {"Thomas", "Arend", "Maximilian"};
        String dev_last_name[] = {"A", "S", "B"};
        String dev_issue_title[] = {"Take Over The World","Make App Even More Better!","The Master With A Plan"};
        String dev_issue_description[] = {"", "Arend has done a great job with the android app", "He is going to glue it all together"};

        for (int i = 0; i < 3; i++) {
            Developer new_dev = new Developer();
            new_dev.setFirstName(dev_first_name[i]);
            new_dev.setLastName(dev_last_name[i]);
            new_dev.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
            new_dev.setEmail(String.format("%s.%s@forcesale.com", dev_first_name[i], dev_last_name[i]));
            management.getDeveloperList().add(new_dev);

            management.getIssueTracker().add(new IssueTracker(dev_issue_title[i], dev_issue_description[i], new_dev, Calendar.getInstance()));
        }



        salesApp.setFirstName("Joe");
        salesApp.setLastName("Cool");
        salesApp.setCompanyName("Gilroy Garlic");
        salesApp.setPhoneNumber("5102222222");
        salesApp.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
        salesApp.setEmail("joe@garlic.com");
        employee.getAppList().add(salesApp);


        account.setAccountName("McDonald's");
        account.setOpportunityName("Corporate Locations");
        account.setCloseDate(Calendar.getInstance());
        account_array.add(account);

        Client new_person = new Client();
        new_person.setFirstName("Homer");
        new_person.setLastName("Simpson");
        new_person.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
        new_person.setEmail("thisisatestemail@gmail.com");
        account.getClients().add(new_person);

        Client new_person2 = new Client();
        new_person2.setFirstName("Bart");
        new_person2.setLastName("Simpson");
        new_person2.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
        new_person2.setEmail("thisisatestemail@gmail.com");
        account.getClients().add(new_person2);

        Sale tempSale = new Sale(001);
        tempSale.setAmountPaid(0);
        tempSale.setTotalCost(100);

        account.getSales().addSale(tempSale);


        Task temp = new Task("Conference Call", new_person, Calendar.getInstance());
        account.getTasks().add(temp);

        Task temp2 = new Task("Coffee with Thomas", new_person, Calendar.getInstance());
        account.getTasks().add(temp2);

        Task temp3 = new Task("Review with Max", new_person, Calendar.getInstance());
        account.getTasks().add(temp3);

        Task temp4 = new Task("School", new_person, Calendar.getInstance());
        account.getTasks().add(temp4);

        //initializes Developer Menu button, sets an on click listerner with intent to switch to he Developer Menu.
        mDeveloperMenu = findViewById(R.id.developer_button);
        mDeveloperMenu.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, DeveloperMenuActivity.class);
            i.putExtra("MANAGEMENT", management);
            startActivityForResult(i, RETURNCODE_SETMANAGEMENT);
        });

        //initializes Employee Menu button, sets an on click listerner with intent to switch to he Employee Menu.
        mEmployeeMenu = (Button) findViewById(R.id.employee_button);
        mEmployeeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmployeeMenuActivity.class);

                i.putParcelableArrayListExtra("APPLICATIONS_LIST", employee.getAppList());

                startActivityForResult(i, RETURNCODE_MAXMAGIC);

            }
        });

        //initializes Client Menu button, sets an on click listerner with intent to switch to he Client Menu.
        mClientMenu = (Button) findViewById(R.id.client_button);
        mClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Prepping intent for the next activity.
                Intent i = new Intent(MainActivity.this, ClientMenuActivity.class);

                //debug log command
                Log.d("APP", "Pre-Transfer name is: " + account.getClients().get(0).getFirstName());

                //Storing the client list in the intent as a ParcelableArrayList.
                i.putExtra("ACCOUNT_LIST", (Parcelable) account.getClients());
                i.putParcelableArrayListExtra("TASK_LIST", account.getTasks());
                i.putExtra("SALE_LIST", (Parcelable) account.getSales());

                //Starting activity for a result, which means that this activity will expect a return when the next activity closes. See onActivityResult().
                startActivityForResult(i, RETURNCODE_SETTASKS);
            }
        });
    }

    //Once the next activity is ends (finish()) and the onCreate() is recalled for this activity, onActivityResult() is called and restores the changes made
    //to client list from the closed activity into this activity's account.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("APP", "onActivityResult called with a result code of " + resultCode + " and request code of " + requestCode);

        if(requestCode == RETURNCODE_SETCLIENT) {
            if(resultCode == RESULT_OK){
                account.setClients(data.getParcelableExtra("ACCOUNT_LIST"));
                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");
            }
        }

        else if (requestCode == RETURNCODE_SETMANAGEMENT) {
            if (resultCode == RESULT_OK) {
                management = data.getParcelableExtra("MANAGEMENT");
            }

            else {
                Log.w("APP", "onActivityResult: Something wrong has happened");
            }
        }

        if (requestCode == RETURNCODE_SETTASKS) {
            if (resultCode == RESULT_OK) {

                ArrayList<Task> temp;

                temp = data.getParcelableArrayListExtra("TASK_LIST");

                account.getTasks().clear();

                for (int i = 0; i < temp.size(); i++) {
                    account.getTasks().add(temp.get(i));
                }

                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");

            }

            Log.d("APP", "Tasks passed, post onActivity Result in MainActivity");
        }

    }
}
