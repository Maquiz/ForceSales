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
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Management.Management;
import com.example.forcesales.Data.Person.Address;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.UI.Developer.DeveloperMenuActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   private Button mDeveloperMenu;
   private Button mEmployeeMenu;
   private Button mClientMenu;

    private Account account = new Account();
    private AccountList account_array = new AccountList();
    private Management management = new Management();

    public static final int RETURNCODE_SETCLIENT = 1;
    public static final int RETURNCODE_SETMANAGEMENT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



        Task temp = new Task("Test", "", new_person, Calendar.getInstance());

//        account.getTasks().addTask(temp);

        //initializes Developer Menu button, sets an on click listerner with intent to switch to he Developer Menu.
        mDeveloperMenu = (Button) findViewById(R.id.developer_button);
        mDeveloperMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DeveloperMenuActivity.class);
                i.putExtra("MANAGEMENT", management);
                startActivityForResult(i, RETURNCODE_SETMANAGEMENT);
            }
        });

        //initializes Employee Menu button, sets an on click listerner with intent to switch to he Employee Menu.
        mEmployeeMenu = (Button) findViewById(R.id.employee_button);
        mEmployeeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmployeeMenuActivity.class);
                startActivity(i);

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

                //Starting activity for a result, which means that this activity will expect a return when the next activity closes. See onActivityResult().
                startActivityForResult(i, RETURNCODE_SETCLIENT);

            }
        });
    }

    //Once the next activity is ends (finish()) and the onCreate() is recalled for this activity, onActivityResult() is called and restores the changes made
    //to client list from the closed activity into this activity's account.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Log.d("APP", "onActivityResult called with a result code of " + resultCode + " and request code of " + requestCode);


        if(requestCode == RETURNCODE_SETCLIENT) {
            if(resultCode == RESULT_OK){
                account.setClients(data.getParcelableExtra("ACCOUNT_LIST"));
                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");
            }
        }

        else if (requestCode == RETURNCODE_SETMANAGEMENT) {
            if (resultCode == RESULT_OK) {

            }
        }
    }

}
