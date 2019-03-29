package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.forcesales.Data.Account.Account;
import com.example.forcesales.Data.Account.AccountList;
import com.example.forcesales.Data.Application.SalesApplication;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Client.ClientList;
import com.example.forcesales.Data.Employee.Employee;
import com.example.forcesales.Data.Employee.EmployeeList;
import com.example.forcesales.Data.Person.Address;
import com.example.forcesales.Data.Tasks.Task;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   private Button mDeveloperMenu;
   private Button mEmployeeMenu;
   private Button mClientMenu;


   private Employee employee = new Employee("Joe Cool");
   private SalesApplication salesApp = new SalesApplication();
   private Account account = new Account();
   private AccountList account_array = new AccountList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salesApp.setFirstName("Joe");
        salesApp.setLastName("Cool");
        salesApp.setCompanyName("Gilroy Garlic");
        salesApp.setPhoneNumber("510222222");
        salesApp.setAddress(new Address("742 Evergreen Terrace" , "Hayward", "CA", "94545"));
        salesApp.setEmail("joe@garlic.com");
        employee.getAppList().add(salesApp);


        account.setAccountName("McDonald's");
        account.setOpportunityName("Corporate Locations");
        account.setCloseDate(Calendar.getInstance());
        account_array.add(account);

        Client new_person = new Client();
        new_person.setFirstName("First");
        new_person.setLastName("Last");
        new_person.setAddress(new Address("742 Evergreen Terrace" , "Hayward", "CA", "94545"));
        new_person.setEmail("thisisatestemail@gmail.com");
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);
        account.getClients().add(new_person);



        Task temp = new Task("Test", new_person, Calendar.getInstance());

        account.getTasks().addTask(temp);

        //initializes Developer Menu button, sets an on click listerner with intent to switch to he Developer Menu.
        mDeveloperMenu = (Button) findViewById(R.id.developer_button);
        mDeveloperMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DeveloperMenuActivity.class);
                startActivityForResult(i, 1);

            }
        });

        //initializes Employee Menu button, sets an on click listerner with intent to switch to he Employee Menu.
        mEmployeeMenu = (Button) findViewById(R.id.employee_button);
        mEmployeeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmployeeMenuActivity.class);

                i.putParcelableArrayListExtra("APPLICATIONS_LIST", employee.getAppList());

                startActivityForResult(i, 2);

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
                i.putParcelableArrayListExtra("ACCOUNT_LIST", account.getClients());

                //Starting activity for a result, which means that this activity will expect a return when the next activity closes. See onActivityResult().
                startActivityForResult(i, 1);

            }
        });
    }

    //Once the next activity is ends (finish()) and the onCreate() is recalled for this activity, onActivityResult() is called and restores the changes made
    //to client list from the closed activity into this activity's account.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == 1){
            if(resultCode == RESULT_OK){

                ArrayList<Client> temp = new ArrayList<>();

                temp = data.getParcelableArrayListExtra("ACCOUNT_LIST");

                account.getClients().clear();

                for(int i = 0; i < temp.size(); i++) {
                    account.getClients().add(temp.get(i));
                }

                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");

            }
        }
        if(requestCode == 2){}
    }

}
