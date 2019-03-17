package com.example.forcesales.Data.Person;

import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

/**
 * PersonList is an abstract list for the Client, Employee, and Developer. Refer to
 * AbstractArrayListComparsion for implementation details. Note that this class is
 * not meant to be used directly.
 *
 * For implementation, here is an example for ClientArray:
 *      "ClientArray extends PersonList<Client,ClientArray>"
 *
 *  Personal Notes:
 *      a. Advance Lamadas - https://nofluffjuststuff.com/magazine/2016/09/time_to_really_learn_generics_a_java_8_perspective
 */

abstract public class PersonList<A extends Person, B extends PersonList<A,B>> extends AbstractArrayListComparsion<A,B> {
    // To avoid being repetitious I am using lambda expressions for the following functions
    private CompareTwoObjects<A,String> compareFirstName = (v,s) -> v.getFirstName().equalsIgnoreCase(s);
    private CompareTwoObjects<A,String> compareLastName = (v,s) -> v.getLastName().equalsIgnoreCase(s);
    private CompareTwoObjects<A,String> compareEmail = (v,s) -> v.getEmail().equals(s);
    private CompareTwoObjects<A,Address> compareAddress = (v, s) -> v.getAddress().equals(s);

    private CompareTwoObjects<A,Address> compareAddressStreet = (v,s) -> v.getAddress().compareStreetAddress(s);
    private CompareTwoObjects<A,Address> compareAddressZipCode = (v,s) -> v.getAddress().compareZipCode(s);
    private CompareTwoObjects<A,Address> compareAddressCity = (v,s) -> v.getAddress().compareCity(s);
    private CompareTwoObjects<A,Address> compareAddressState = (v,s) -> v.getAddress().compareState(s);


    protected PersonList() {
        super();
    }


    public B containsFirstName(String v) {
        return abstractContains(v, compareFirstName);
    }

    public B containsLastName(String v) {
        return abstractContains(v, compareLastName);
    }

    public B containsEmail(String v) {
        return abstractContains(v, compareEmail);
    }

    public B containsAddress(Address v) {
        return abstractContains(v, compareAddress);
    }

    public B containsAddressStreet(Address v) {
        return abstractContains(v, compareAddressStreet);
    }

    public B containsAddressZipCode(Address v) {
        return abstractContains(v, compareAddressZipCode);
    }

    public B containsAddressCity(Address v) {
        return abstractContains(v, compareAddressCity);
    }

    public B containsAddressState(Address v) {
        return abstractContains(v, compareAddressState);
    }
}
