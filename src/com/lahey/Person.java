package com.lahey;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Person {

    private int dateCount;
    private String personName;

    //broke up list
    ArrayList<Person> brokeUpWithList;

    //list of dates
    ArrayList<Person> hasDatedList;

    LinkedHashSet<Date> personDateSet = new LinkedHashSet<Date>();


    //*************************************************************************
    //* constructor
    //*************************************************************************
    public Person(){

        dateCount = 0;
        brokeUpWithList = new ArrayList<Person>();
        hasDatedList = new ArrayList<Person>();
    }

    public Person(String name){

        dateCount = 0;
        this.personName = name;
        brokeUpWithList = new ArrayList<Person>();
        hasDatedList = new ArrayList<Person>();

    }


    //*************************************************************************
    //* getters and setters
    //*************************************************************************
    protected void setPersonName(String name) {
        this.personName = name;
    }

    public String getPersonName() {
        return personName;
    }


    //*************************************************************************
    //*
    //*************************************************************************
    public void addDate(Date date){

        personDateSet.add(date);
    }


}//end public class Person
