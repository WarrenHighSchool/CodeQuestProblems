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
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String inLine = "";
            int problemValue = Integer.parseInt(br.readLine());
            int probAmt = 0;
            ArrayList<String> key = new ArrayList<String>();
            while((inLine = br.readLine()).charAt(0) != 'S'){
                key.add(inLine);
                probAmt++;
            }
            Scantron master = new Scantron("master", key, problemValue);
            ArrayList<Scantron> students = new ArrayList<Scantron>();
            ArrayList<String> firstStudentKey = new ArrayList<String>();
            for(int i = 0; i < probAmt; i++){
                firstStudentKey.add(br.readLine());
            }
            students.add(new Scantron(inLine, firstStudentKey, problemValue));
            while((inLine = br.readLine()) != null){
                //inLine is now at Student #
                String student = inLine;
                ArrayList<String> studentKey = new ArrayList<String>();
                for(int i = 0; i < probAmt; i++){
                    studentKey.add(br.readLine());
                }
                students.add(new Scantron(student, studentKey, problemValue));
            }
            for(int i = 0; i < students.size(); i++){
                //printScantron(students.get(i));
                System.out.println(students.get(i).name + ": " +  master.compareTo(students.get(i)));
            }
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
