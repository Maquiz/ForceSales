package com.example.forcesales.Data.Person;

/**
 * Person is a generic class that holds information that apply to either a Client,
 * Employee, or Developer.
 *
 * public:
 * 	constructor:
 * 		-> ()
 * 		-> (first_name,last_name,email,address)
 * 	getters:
 * 		-> getAddress
 * 		-> getEmail
 * 		-> getFirstName
 * 		-> getLastName
 * 	setter:
 * 		-> setAddress
 * 		-> setEmail
 * 		-> setFirstName
 * 		-> setLastName
 * 	(@object):
 * 		-> equals - The First and Last Name checks are case insensitive.
 *
 * TODO:
 * 		1. Add hire date?
 * 		2. Should the manager also be considered a client?
 */

public class Person {
    private String first_name;
    private String last_name;
    private String email;
    private Address address;
//	private Calender hired;

    public Person() {
        first_name = "";
        last_name = "";
        email = "";
        address = new Address();
    }

    public Person(String first_name,
                  String last_name,
                  String email,
                  Address address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person other2 = (Person) other;
            if (!other2.first_name.equalsIgnoreCase(this.first_name))
                return false;
            else if (!other2.last_name.equalsIgnoreCase(this.last_name))
                return false;
            else if (!other2.email.equals(this.email))
                return false;
            else if (!other2.address.equals(this.address))
                return false;

            return true;
        }

        return false;
    }


    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
}
