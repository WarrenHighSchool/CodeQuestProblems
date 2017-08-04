package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RobertPC on 7/23/2017.
 */
public class Prob06 {
    //String to file
    public static final String filePath = "inputs/2013/Prob06.in.txt";

    public static class Person{
        //Instance variables
        public String name;
        public int score;

        /**
         * Constructs a person object which holds a name and score
         *
         * @param name the name of the person
         * @param score the score of the person
         */
        public Person(String name, int score){
            this.name = name;
            this.score = score;
        }

        /**
         * gets the name of the current person
         *
         * @return name of the person
         */
        public String getName(){ return name; }

        /**
         * gets the score of the person
         *
         * @return score the person has
         */
        public int getScore(){ return score; }

        /**
         * returns the name and score of the person
         * @return returns the name and score of the person separated by a space
         */
        public String toString(){ return name + " " + score; }
    }
    //Comparator for Collections.sort to compare two Person objects(comparing their score)
    public static class PersonComparator implements Comparator<Person>{
        public int compare(Person p1, Person p2){
            if(p1.getScore() > p2.getScore()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Initialize ArrayList of Person objects
            List<Person> people = new ArrayList<>();
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Split into tokens
                String[] tokens = inLine.split(":");
                //Get total score for person by looping through tokens[1]
                int totalScore = 0;
                String[] scoreTokens = tokens[1].split(",");
                for(int i = 0; i < scoreTokens.length; i++){
                    totalScore += Integer.parseInt(scoreTokens[i]);
                }
                //Add new person object to arraylist
                people.add(new Person(tokens[0], totalScore));
            }
            //Sort our arraylist out
            people.sort(new PersonComparator());
            //Print out winners
            System.out.println("FIRST:" + people.get(0).getName());
            System.out.println("SECOND:" + people.get(1).getName());
            System.out.println("THIRD:" + people.get(2).getName());
            System.out.println("LAST:" + people.get(people.size() - 1).getName());
        } catch (Exception e){ e.printStackTrace(); }
    }
}
