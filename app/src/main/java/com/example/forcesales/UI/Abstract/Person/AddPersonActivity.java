package com.example.forcesales.UI.Abstract.Person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.forcesales.Data.Person.Address;
import com.example.forcesales.Data.Person.Person;
import com.example.forcesales.Data.Person.PersonList;
import com.example.forcesales.R;

/*
 * AddPersonActivity is an abstract class for add an object that extends
 * from Person into an ArrayList that extends from PersonList. The
 * motivation behind this code is to reduce repetition.
 *
 * Here is an example of how a class extends from AddPersonActivity:
 *      public class AddEmployeeActivity extends AddPersonActivity<EmployeeList, Employee>
 *
 * The following methods must be overridden:
 *      getPersonList
 *      createNewPerson
 *      fillIntent
 *
 */

abstract public class AddPersonActivity<A extends PersonList, B extends Person> extends AppCompatActivity {
    protected A person_list;

    protected TextView mTitle;
    protected EditText mFirst;
    protected EditText mLast;
    protected EditText mStreet;
    protected EditText mCity;
    protected EditText mState;
    protected EditText mZip;
    protected EditText mEmail;
    protected Button mSubmit;


    // Create new variable or get variable
    abstract protected A getPersonList();
    abstract protected B createNewPerson();

    // Fills the intent with data.
    abstract protected Intent fillIntent(Intent i);

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_add_person);

        mTitle = findViewById(R.id.add_person_title);
        mFirst = findViewById(R.id.add_person_first);
        mLast = findViewById(R.id.add_person_last);
        mStreet = findViewById(R.id.add_person_street_address);
        mCity = findViewById(R.id.add_person_city);
        mState = findViewById(R.id.add_person_state);
        mZip = findViewById(R.id.add_person_zip_code);
        mEmail = findViewById(R.id.add_person_email);
        mSubmit = findViewById(R.id.add_person_submit);

        person_list = getPersonList();
        mSubmit.setOnClickListener(v -> {
            assignResult();
            setResult(RESULT_OK, fillIntent(new Intent()));
            finish();
        });
    }

    protected void assignResult() {
        B new_person = createNewPerson();
        new_person.setFirstName(mFirst.getText().toString());
        new_person.setLastName(mLast.getText().toString());
        new_person.setEmail(mEmail.getText().toString());

        Address new_address = new Address();
        new_address.setStreetAddress(mStreet.getText().toString());
        new_address.setCity(mCity.getText().toString());
        new_address.setState(mState.getText().toString());
        new_address.setZipCode(mZip.getText().toString());
        new_person.setAddress(new_address);

        person_list.add(new_person);
    }
}
