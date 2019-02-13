package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob01 {
    public static final String filePath = "inputs/2018/Prob01.in.txt";

    public static void main(String[] args){
        try{
            //Instantiate a BufferedReader object to read file data
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab amount of test cases
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0){
                //Read grade
                int grade = Integer.parseInt(br.readLine());
                //Initialize the print text
                String printText;
                //Set print text properly
                printText = grade < 70 ? "FAIL" : "PASS";
                //Print out pass or fail
                System.out.println(printText);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
