package com.lahey;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String sSaturdayNight = " is free on Saturday night.";

        //list of date scenarios
        ArrayList<String> activityList = new ArrayList<String>();


        //list of people who could go on a date
        ArrayList<Person> personList = new ArrayList<Person>();


        //set of randomly generated activitiy indexes
        LinkedHashSet<Integer> activityIndexSet = null;

        //set of randomly generated activitiy indexes
        LinkedHashSet<Integer> personIndexSet = null;

        //list of all dates
        LinkedHashSet<Date> allDatesSet = new LinkedHashSet<Date>();

        //map of break ups
        HashMap<Person, Person> breakUpMap = new HashMap<Person, Person>();

        Random random = new Random();
        int iPersonIndex = random.nextInt(5);

        int iLoopIndex = 0;
        int iLoopMax = 10;
        int iFirstPersonIndex = 0;
        int iSecondPersonIndex = 0;
        int iActivityIndex = 0;
        //if scenarioIndex = 15, then the couple broke up

        int iNumberOfDateActivities = 0;

        int iActivityLower = 0;
        int iActivityUpper = 6;

        int iNumberOfPeople = 2;
        int iPeopleLower = 0;
        int iPeopleUpper = 5;

        int iBreakUp = 15;
        String sBreakUp = " broke up with ";

        Person personOne = null;
        Person personTwo = null;

        boolean bFindActivities = false;
        boolean bBreakup = false;

        initialize(personList, activityList, breakUpMap);

        //*********************************************************************
        //* This is the main loop of this application
        //* It repeats 10 times, generating 10 random dates
        //*********************************************************************
        iLoopMax = 3;
        for(iLoopIndex = 0 ; iLoopIndex < iLoopMax ; iLoopIndex++){


            //Randomly select two Person(s) for the date
            iFirstPersonIndex = random.nextInt(personList.size() -1);
            iSecondPersonIndex = random.nextInt(personList.size() -1);

            personOne = personList.get(iFirstPersonIndex);
            personTwo = personList.get(iSecondPersonIndex);

            //check to see if the to people already broke up
            //iterate through hashmap and check to see if set exists

//            for(Map.Entry<Person, Person> mapEntry : breakUpMap.entrySet()){
//
//                Person keyPerson = mapEntry.getKey();
//                Person valuePerson = mapEntry.getValue();
//
//
//                if(personOne.equals(keyPerson)){}
//
//
//
//
//                if( (personOne.equals(keyPerson) && personTwo.equals(valuePerson))
//                        || (personOne.equals(valuePerson) && personTwo.equals(keyPerson))
//
//                )
//
//                    bFindActivities = false;
//                )


            for(Map.Entry<Person, Person> mapEntry : breakUpMap.entrySet()){

                if( (personOne.equals(mapEntry.getKey()) && personTwo.equals(mapEntry.getValue())) ||
                        (personTwo.equals(mapEntry.getKey()) && personOne.equals(mapEntry.getValue()))) {

                     bBreakup = true;
                }

                break;
            }//end for(Map.Entry<Person, Person> mapEntry : breakUpMap.entrySet())


            if(bBreakup){

                //this loop
                //doesn't count as a date
//                iLoopIndex--;

                System.out.printf("Ack! %s and %s can't be matched!  They already broke up!",personOne, personTwo);

            }
            else if(personOne.equals(personTwo)){

                //instantiate a date
                Date theDate = new Date();
                allDatesSet.add(theDate);

                //add persons to the date
                theDate.setPersonOne(personOne);
                theDate.setPersonTwo(personTwo);

                theDate.addActivity(theDate.getPersonOne().getPersonName() +
                        sSaturdayNight +
                        theDate.getPersonTwo().getPersonName());
            }
            else {

                //instantiate a date
                Date theDate = new Date();
                allDatesSet.add(theDate);

                //add persons to the date
                theDate.setPersonOne(personOne);
                theDate.setPersonTwo(personTwo);

                //get random number of date activities
                iNumberOfDateActivities = random.nextInt(5) + 1; //at least 1 activity, and not more than 6 activities

                System.out.println("Number of date activities: " + iNumberOfDateActivities);

                //instantiate date activity index set
                activityIndexSet = new LinkedHashSet<Integer>();

                //generate set of random Integers & put them in the activity index set
                iActivityUpper = activityList.size() -1;
                getSetOfUniqueNumbers(random, activityIndexSet, iNumberOfDateActivities, iActivityLower, iActivityUpper);

                //put the generated indexes in an array
                Integer[] activityIndexArray = activityIndexSet.toArray(new Integer[activityIndexSet.size()]);
                for(int i = 0 ; i < activityIndexArray.length ; i++){

                    do{

                        theDate.addActivity(theDate.getPersonOne().getPersonName() +
                                activityList.get(activityIndexArray[i]) +
                                theDate.getPersonTwo().getPersonName());

                        if(sBreakUp.equals(activityList.get(activityIndexArray[i]))){

                            breakUpMap.put(theDate.getPersonOne(), theDate.getPersonTwo());
                            breakUpMap.put(theDate.getPersonTwo(), theDate.getPersonOne());
                        }

                    }while( !(sBreakUp.equals(activityList.get(activityIndexArray[i]))) );

                    //add date to date list
                    //display nbr dates foer each person
                    //display all dates

                }//endfor(int i = 0 ; i < activityIndexArray.length ; i++)

            }//end if(theDate.getPersonOne().equals(theDate.getPersonTwo()))




        }//end for(int i = 0 i < 10 i++)

    }//end public static void main(String[] args)

    public static void displayDate(Date date){

        int dateNumber = date.getDateNumber();
        ArrayList<String> tempList = date.getActivityLIst();


    }//end public static void displayDate(Date date)


    /**
     * This method generates a set of specified size, of unique random integers,
     * with the specified lower and upper bounds.
     *
     * @param random to generate random numbers, preferably only one per class
     * @param integerNumberSet the set to contain the random nnumbers generated by this method
     * @param iNumbersNeeded the number of randomly generated numbers to put in the set
     * @param iLower  the lower boundary for the randomly generated numbers
     * @param iUpper  the upper boundary for the randomly generated numbers
     */
    public static void getSetOfUniqueNumbers(Random random,
             LinkedHashSet<Integer> integerNumberSet, int iNumbersNeeded, int iLower, int iUpper ){

        if((iUpper - iLower) < iNumbersNeeded){

            System.out.println("Your lower and upper boundaries do not allow you to generate" +
                    "the reqiuired number of Integers");

            System.out.printf("Upper Boundary %d - Lower Boundary %d == %d ", iUpper, iLower, (iUpper - iLower));
            System.out.println("iNumberNeeded = " + iNumbersNeeded);
        }
        else {

            while (integerNumberSet.size() < iNumbersNeeded)
            {
                Integer next = random.nextInt(iUpper - iLower) + iLower;

                // As we're adding to a set, this will automatically do a containment check
                integerNumberSet.add(next);
            }
        }//end if((iUpper - iLower) < iNumbersNeeded)

    }//end public static void getSetOfUniqueNumbers(Random random,
        //LinkedHashSet<Integer> integerNumberSet, int iNumbersNeeded, int iLower, int iUpper )


    public static void initialize(ArrayList personList, ArrayList scenarioList, HashMap<Person, Person> breakUpMap){

        //initial people
        Person superman = new Male("Superman");
        Person wonderWoman = new Female("Wonder Woman");
        personList.add(superman);
        personList.add(wonderWoman);

        //initial activities
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

        //initial breakup
        breakUpMap.put(superman, wonderWoman);

    }//end public static void initialize(ArrayList personList, ArrayList scenarioList)


}//end public class Main
