package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 8/7/2017.
 */
public class Prob05 {
    //String to filePath
    public static final String filePath = "inputs/2012/Prob05.in.txt";

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Split into tokens
                String[] tokens = inLine.split(" ");
                //Properly assign all elements
                double origPrincipal = Double.parseDouble(tokens[0]);
                double monthlyInterestRate = (double)(Double.parseDouble(tokens[1])/1200.0);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
