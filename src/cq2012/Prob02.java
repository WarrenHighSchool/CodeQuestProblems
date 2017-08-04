package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob02 {
    public static final String filePath = "inputs/2012/Prob02.in.txt";

    public static void main(String[] args){
        try{
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Initialize inLine
            String inLine = "";
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Split string into two numbers
                String[] inLineSpl = inLine.split(" ");
                //Parse them to ints
                int timesSub = Integer.parseInt(inLineSpl[0]);
                int heraldSub = Integer.parseInt(inLineSpl[1]);
                //Now just check for which one is greater(the else is executed if they are equal)
                if(timesSub > heraldSub){
                    System.out.println("Times has " + (timesSub - heraldSub) + " more subscribers");
                }
                else if(timesSub < heraldSub){
                    System.out.println("Herald has " + (heraldSub - timesSub) + " more subscribers");
                }
                else{
                    System.out.println("Times and Herald have the same amount of subscribers:");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
