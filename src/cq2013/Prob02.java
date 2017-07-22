package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 7/21/2017.
 */
public class Prob02 {
    //String to file
    public static final String filePath = "inputs/2013/Prob02.in.txt";

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Construct reverse string
                String palindrome = "";
                for(int i = inLine.length() - 1; i >= 0; i--){
                    palindrome += inLine.charAt(i);
                }
                //Print it out
                System.out.println(palindrome);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
