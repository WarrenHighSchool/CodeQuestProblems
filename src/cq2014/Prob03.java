package cq2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by RobertPC on 7/22/2017.
 */
public class Prob03 {
    //String to filePath
    public static final String filePath = "inputs/2014/Prob03.in.txt";

    public static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b){
            //We use b.compareTo(a) to have the comparator sort backwards
            return b.compareTo(a);
        }
    }
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
                //Make it an array of Integer objects
                Integer[] ints = new Integer[tokens.length];
                //Fill the ints array
                for(int i = 0; i < tokens.length; i++){
                    ints[i] = Integer.parseInt(tokens[i]);
                }
                //Sort that out(in descending order)
                Arrays.sort(ints, new IntegerComparator());
                //Loop through that and add to an array
                int[] outs = new int[ints.length];
                //Use start and end indexes to move each alternating number to each side
                int start = 0;
                int end = ints.length - 1;
                //Loop through ints, having i increment by 2 each run
                for(int i = 0; i < ints.length - 1; i+= 2){
                    //Have each alternating number go into outs[start] and outs[end] respectively
                    outs[start] = ints[i];
                    outs[end] = ints[i + 1];
                    //Increment start and end
                    start++;
                    end--;
                }
                //For odd-numbered length of given inputs of number, set the middle number to the last number in the descending order array
                outs[ints.length / 2] = ints[ints.length - 1];
                //Print out our output array of ints
                for(int n : outs){
                    System.out.print(n + " ");
                }
                //New line for next inputs
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
