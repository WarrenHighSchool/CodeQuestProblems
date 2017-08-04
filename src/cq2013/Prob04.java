package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by RobertPC on 7/22/2017.
 */
public class Prob04 {
    //String to filePath
    public static final String filePath= "inputs/2013/Prob04.in.txt";

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while not at end of file
            while((inLine = br.readLine()) != null){
                StringBuilder buf = new StringBuilder();
                //Split into an array of strings
                String[] tokens = inLine.split(",");
                //Make int array same length of string array
                int[] numbers = new int[tokens.length];
                //Fill int array with parsed ints from the string array
                for(int i = 0; i < tokens.length; i++){
                    numbers[i] = Integer.parseInt(tokens[i]);
                }
                //Sort that out
                Arrays.sort(numbers);
                //Loop through numbers
                for(int i = 0; i < numbers.length; i++){
                    //If not last number, print number and comma
                    if(i != numbers.length - 1){
                        System.out.print(numbers[i] + ",");
                    } else{
                        //If last number, only print number and no comma
                        System.out.print(numbers[i]);
                    }
                }
                //Print a new line for the next inputs
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
