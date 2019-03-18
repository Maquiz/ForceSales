package com.example.forcesales.Data.Developer;

import com.example.forcesales.Data.Person.PersonList;

public class DeveloperList extends PersonList<Developer,DeveloperList> {
    public DeveloperList() {
        super();
    }

    @Override
    protected DeveloperList createEmptyArrayList() {
        return new DeveloperList();
    }
}
