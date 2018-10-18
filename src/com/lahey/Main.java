package com.lahey;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> scenarioList = new ArrayList<String>();
        ArrayList<Person> personList = new ArrayList<Person>();
        LinkedHashSet<Integer> activityNumberSet = new LinkedHashSet<Integer>();
        LinkedHashSet<Date> dateSet = new LinkedHashSet<Date>();

        Random random = new Random();
        int iPersonIndex = random.nextInt(5);

        int iLoopIndex = 0;
        int iLoopMax = 10;
        int iFirstPersonIndex = 0;
        int iSecondPersonIndex = 0;
        int iActivityIndex = 0;
        //if scenarioIndex = 15, then the couple broke up
        int iNumberOfActivities = 0;
        int iActivityMax = 6;

        int iBreakUp = 15;
        String sBreakUp = " broke up with ";

        Person personOne = null;
        Person personTwo = null;

        //make 10 introductions
        for(iLoopIndex = 0 ; iLoopIndex < iLoopMax ; iLoopIndex++){

            Date theDate = new Date();
            dateSet.add(theDate);

            iFirstPersonIndex = random.nextInt(personList.size() -1);
            iSecondPersonIndex = random.nextInt(personList.size() -1);
            iNumberOfActivities = random.nextInt(5) +1; //at least 1 activity, and not more than 6 activities
            iActivityIndex = random.nextInt(scenarioList.size() -1);

            personOne = personList.get(iFirstPersonIndex);
            personTwo = personList.get(iSecondPersonIndex);
            theDate.setPersonOne(personOne);
            theDate.setPersonTwo(personTwo);

            if(personOne.equals(personTwo)){

                theDate.addActivity(personOne.getPersonName() + "");
            }
            else {

                //get set of indexes for activities
                getSetOfUniqueNumbers(random, activityNumberSet, iNumberOfActivities, iActivityMax );

                for(iActivityIndex = 0 ; iActivityIndex < iNumberOfActivities +1 ; iActivityIndex++ ){





                }//end for(iActivityIndex = 0 ; iActivityIndex < iNumberOfActivities +1 ; iActivityIndex++ )



            }

        }//end for(int i = 0 i < 10 i++)

    }//end public static void main(String[] args)

    public static void displayDate(Date date){

        int dateNumber = date.getDateNumber();
        ArrayList<String> tempList = date.getActivityLIst();


    }//end public static void displayDate(Date date)


    public static void getSetOfUniqueNumbers(Random random,
                             LinkedHashSet<Integer> activityNumberSet, int iNumbersNeeded, int iMax ){

        while (activityNumberSet.size() < iNumbersNeeded)
        {
            Integer next = random.nextInt(iMax) + 1;

            // As we're adding to a set, this will automatically do a containment check
            activityNumberSet.add(next);
        }

    }//end public static void getDateActivities


    public static void initialize(ArrayList personList, ArrayList scenarioList){

        personList.add(new Female("Wonder Woman"));
        personList.add(new Female("Cat Woman"));
        personList.add(new Female("Jean Grey"));
        personList.add(new Male("Batman"));
        personList.add(new Male("Wolverine"));
        personList.add(new Male("Superman"));

        scenarioList.add(" played chess with ");
        scenarioList.add(" went to dinner with ");
        scenarioList.add(" went to a movie with");
        scenarioList.add(" went bowling with");
        scenarioList.add(" tickled ");
        scenarioList.add(" learned a few words of French from ");
        scenarioList.add(" bought and icecream cone for ");
        scenarioList.add(" skipped around the block with ");
        scenarioList.add(" painted the barn with ");
        scenarioList.add(" kissed ");
        scenarioList.add(" made popcorn for ");
        scenarioList.add(" gave flowers to ");
        scenarioList.add(" looked at  ");
        scenarioList.add(" recieved a box of chocolates from ");
        scenarioList.add(" won money playing poker with ");
        scenarioList.add(" broke up with ");

    }//end public static void initialize(ArrayList personList, ArrayList scenarioList)


}//end public class Main
