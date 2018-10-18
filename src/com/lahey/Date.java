package com.lahey;

import java.util.ArrayList;

public class Date {

    //static variable
    private static int iDateCounter = 0;

    //class variables
    private int dateNumber;
    private Person personOne;
    private Person personTwo;
    private boolean brokeUp;
    private ArrayList<String> activityList;

    //*************************************************************************
    //* constructor
    //*************************************************************************
    public Date(){

        this.dateNumber = iDateCounter++;
    }

    //*************************************************************************
    //* getters & setters
    //*************************************************************************
    public int getDateNumber(){
        return dateNumber;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(Person personTwo) {
        this.personTwo = personTwo;
    }

    public boolean isBrokeUp() {
        return brokeUp;
    }

    public void setBrokeUp(boolean brokeUp) {
        this.brokeUp = brokeUp;
    }

    //*************************************************************************
    //* collection methods
    //*************************************************************************
    public void addActivity(String activity){

        activityList.add(activity);
    }

    public ArrayList getActivityLIst(){

        return this.activityList;
    }


}//end public class Date
