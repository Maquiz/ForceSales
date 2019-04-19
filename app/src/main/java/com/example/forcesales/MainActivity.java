package com.example.forcesales;

import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.forcesales.ClientMenu.ClientMenuActivity;
import com.example.forcesales.ClientMenu.EmployeeMenuActivity;
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
import com.example.forcesales.UI.InfoBarActivity;

import java.util.Calendar;

/*
 * TODO: See If It Is Possible to Remove Employee and Account
 */

public class MainActivity extends AppCompatActivity {

    private Button mDeveloperMenu;
    private Button mEmployeeMenu;
    private Button mClientMenu;

    private Employee employee = new Employee();
    private Management empManagement = new Management();
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


        //Application test info
        String applicant_first_name[] = {"Joe", "Billy", "Maria"};
        String applicant_last_name[] = {"Cool", "Ball", "Money"};
        String applicant_company_name[] = {"Gilroy Garlic", "Oakland A's", "Robinhood"};
        String applicant_email[] = {"joe@garlic.com", "Bill@A.com", "Maria@Robinhood.org"};

        for(int i = 0; i < 3; i++){
            SalesApplication salesApp = new SalesApplication();
            salesApp.setFirstName(applicant_first_name[i]);
            salesApp.setLastName(applicant_last_name[i]);
            salesApp.setCompanyName(applicant_company_name[i]);
            salesApp.setPhoneNumber("5102222222");
            salesApp.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
            salesApp.setEmail(applicant_email[i]);
            employee.getAppList().add(salesApp);
        }
        //Employee Tasks
        String emp_first_name[] = {"Thomas", "Arend", "Maximilian"};
        String emp_last_name[] = {"A", "S", "B"};
        String emp_issue_title[] = {"Take Over The World","Make App Even More Better!","The Master With A Plan"};
        String emp_issue_description[] = {"", "Arend has done a great job with the android app", "He is going to glue it all together"};

        for (int i = 0; i < 3; i++) {
            Developer new_dev = new Developer();
            new_dev.setFirstName(dev_first_name[i]);
            new_dev.setLastName(dev_last_name[i]);
            new_dev.setAddress(new Address("742 Evergreen Terrace", "Hayward", "CA", "94545"));
            new_dev.setEmail(String.format("%s.%s@forcesale.com", dev_first_name[i], dev_last_name[i]));
            empManagement.getDeveloperList().add(new_dev);

            empManagement.getIssueTracker().add(new IssueTracker(dev_issue_title[i], dev_issue_description[i], new_dev, Calendar.getInstance()));
        }

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
        mEmployeeMenu =  findViewById(R.id.employee_button);
        mEmployeeMenu.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EmployeeMenuActivity.class);
            i.putParcelableArrayListExtra("APPLICATIONS_LIST", employee.getAppList());
            i.putParcelableArrayListExtra("APPROVED_LIST", employee.getApprovedList());
            i.putParcelableArrayListExtra("DENIED_LIST", employee.getDeniedList());
            i.putExtra("EMPLOYEE", empManagement);
            startActivityForResult(i, RETURNCODE_MAXMAGIC);

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
                i.putExtra("TASK_LIST", (Parcelable) account.getTasks());
                i.putExtra("SALE_LIST", (Parcelable) account.getSales());

                //Starting activity for a result, which means that this activity will expect a return when the next activity closes. See onActivityResult().
                startActivityForResult(i, RETURNCODE_SETTASKS);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater = getMenuInflater();
        menu_inflater.inflate(R.menu.mainmenu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainmenu_info_info:
                Intent i = new Intent(this, InfoBarActivity.class);
                i.putExtra(Management.PARCELABLE_STR, management);
                i.putExtra(AccountList.PARCELABLE_STR, (Parcelable) account_array);
                startActivity(i); // We don't really need to return anything, right?
                break;
            default:
                return super.onOptionsItemSelected(item);

        }

        return true;
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

        if(requestCode == RETURNCODE_MAXMAGIC) {
            if(resultCode == RESULT_OK){
                employee.setAppList(data.getParcelableExtra("APPLICATIONS_LIST"));
                employee.setApprovedList (data.getParcelableExtra("APPROVED_LIST"));
                employee.setDeniedList(data.getParcelableExtra("DENIED_LIST"));
                empManagement = data.getParcelableExtra("EMPLOYEE");
                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");
            }
        }

        if (requestCode == RETURNCODE_SETTASKS) {
            if (resultCode == RESULT_OK) {


                account.setTasks(data.getParcelableExtra("TASK_LIST"));
                account.setClients(data.getParcelableExtra("ACCOUNT_LIST"));


                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");

            }

            Log.d("APP", "Tasks passed, post onActivity Result in MainActivity");
        }

    }

}
