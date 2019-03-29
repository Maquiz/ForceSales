package com.example.forcesales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.forcesales.Data.Account.Account;
import com.example.forcesales.Data.Account.AccountList;
import com.example.forcesales.Data.Client.Client;
import com.example.forcesales.Data.Client.ClientList;
import com.example.forcesales.Data.Person.Address;
import com.example.forcesales.Data.Tasks.Task;
import com.example.forcesales.Data.Tasks.TaskList;

import java.util.ArrayList;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_WEEK;

public class MainActivity extends AppCompatActivity {

   private Button mDeveloperMenu;
   private Button mEmployeeMenu;
   private Button mClientMenu;

    private Account account = new Account();
    private AccountList account_array = new AccountList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account.setAccountName("McDonald's");
        account.setOpportunityName("Corporate Locations");
        account.setCloseDate(Calendar.getInstance());
        account_array.add(account);

        Client new_person = new Client();
        new_person.setFirstName("Homer");
        new_person.setLastName("Simpson");
        new_person.setAddress(new Address("742 Evergreen Terrace" , "Hayward", "CA", "94545"));
        new_person.setEmail("thisisatestemail@gmail.com");
        account.getClients().add(new_person);

        Client new_person2 = new Client();
        new_person2.setFirstName("Bart");
        new_person2.setLastName("Simpson");
        new_person2.setAddress(new Address("742 Evergreen Terrace" , "Hayward", "CA", "94545"));
        new_person2.setEmail("thisisatestemail@gmail.com");
        account.getClients().add(new_person2);



        Task temp = new Task("Conference Call", new_person, Calendar.getInstance());
        account.getTasks().add(temp);

        Task temp2 = new Task("Coffee with Thomas", new_person, Calendar.getInstance());
        account.getTasks().add(temp2);

        Task temp3 = new Task("Review with Max", new_person, Calendar.getInstance());
        account.getTasks().add(temp3);

        Task temp4 = new Task("School", new_person, Calendar.getInstance());
        account.getTasks().add(temp4);



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
                i.putParcelableArrayListExtra("ACCOUNT_LIST", account.getClients());
                i.putParcelableArrayListExtra("TASK_LIST", account.getTasks());
                //i.putParcelableArrayListExtra("SALES_LIST", account.getSales());

                //Starting activity for a result, which means that this activity will expect a return when the next activity closes. See onActivityResult().
                startActivityForResult(i, 2);

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

                ArrayList<Client> temp;

                temp = data.getParcelableArrayListExtra("ACCOUNT_LIST");

                account.getClients().clear();

                for(int i = 0; i < temp.size(); i++) {
                    account.getClients().add(temp.get(i));
                }

                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");

            }
        }

        if(requestCode == 2){
            if(resultCode == RESULT_OK){

                ArrayList<Task> temp;

                temp = data.getParcelableArrayListExtra("ACCOUNT_LIST");

                account.getTasks().clear();

                for(int i = 0; i < temp.size(); i++) {
                    account.getTasks().add(temp.get(i));
                }

                Log.d("APP", "Clients passed, post onActivityResult in MainActivity.");

            }

            Log.d("APP", "Tasks passed, post onActivity Result in MainActivity");
        }
    }

}
