package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob07 {
    public static final String filePath = "inputs/2012/Prob07.in.txt";

    public static class Scantron{
        public String name;
        public ArrayList<String> key;
        public int pointValue;

        /**
         * Constructs a Scanton object
         *
         * @param name name of the student
         * @param key an ArrayList of strings containing the students scorecard
         * @param pointValue the value for each point
         */
        public Scantron(String name, ArrayList<String> key, int pointValue){
            this.name = name;
            this.key = key;
            this.pointValue = pointValue;
        }

        /**
         * This method should only be used with the master key
         * It returns the amount right that the comparison Scantron got right
         *
         * @param s a students Scantron to compare to master
         * @return the amount right(based on point value)
         */
        public int compareTo(Scantron s){
            int returnVal = 0;
            for(int i = 0; i < key.size(); i++){
                String curProbKey = key.get(i);
                String studentProbKey = s.getKey().get(i);
                if(curProbKey.equals(studentProbKey)){
                    returnVal += pointValue;
                }
            }
            return returnVal;
        }

        /**
         * gets the key for the current student(or master Scantron)
         *
         * @return the key in the ArrayList of Strings
         */
        public ArrayList<String> getKey(){ return key; }

        /**
         * returns the name of the object along with the key as it would appear in the input file
         *
         * @return
         */
        public String toString(){
            String returnVal = "";
            returnVal += name + "\n";
            for(int i = 0; i < key.size(); i++){
                returnVal += key.get(i) + "\n";
            }
            return returnVal;
        }
    }
    public static void main(String[] args){
        try{
            //Prepare to read the file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Initialize inLine
            String inLine = "";
            //Grab the point value for each problem
            int problemValue = Integer.parseInt(br.readLine());
            //Initialize amount of problems(is not given, but can be found and is consistent from student to student)
            int probAmt = 0;
            //Initialize ArrayList that will contain Key
            ArrayList<String> key = new ArrayList<>();
            //Keep looping until the line read isn't scantron data
            while((inLine = br.readLine()).charAt(0) != 'S'){
                //Add the line of text to the scantron data
                key.add(inLine);
                //Increment the amount of problems
                probAmt++;
            }
            //Now construct our master scantron key
            Scantron master = new Scantron("master", key, problemValue);
            //We dont know how many students there are, so we use an arraylist of Scantron objects for each student
            ArrayList<Scantron> students = new ArrayList<>();
            //Since in our earlier loop checking for student ended at the same of the student, we must make a first student array list
            ArrayList<String> firstStudentKey = new ArrayList<>();
            //Loop through problem amt and add it to firstStudentKey
            for(int i = 0; i < probAmt; i++){
                firstStudentKey.add(br.readLine());
            }
            //Add the first student to the students arraylist
            students.add(new Scantron(inLine, firstStudentKey, problemValue));
            //Now we can go through the rest of the students
            while((inLine = br.readLine()) != null){
                //inLine is now at Student #
                //Initialize student key
                ArrayList<String> studentKey = new ArrayList<>();
                //Fill student key
                for(int i = 0; i < probAmt; i++){
                    studentKey.add(br.readLine());
                }
                //Add that to the students arraylist
                students.add(new Scantron(inLine, studentKey, problemValue));
            }
            //Loop through students array list
            for(int i = 0; i < students.size(); i++){
                //Print out the comparison between the master Scantron and the selected student
                System.out.println(students.get(i).name + ": " +  master.compareTo(students.get(i)));
            }
            //Clean up
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printScantron(Scantron s){
        System.out.println(s.name);
        for(int i = 0; i < s.getKey().size(); i++){
            System.out.println(s.getKey().get(i));
        }
    }
}
