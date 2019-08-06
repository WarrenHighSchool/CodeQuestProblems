package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob09 {
    public static final String filePath = "inputs/2018/Prob09.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get a string array of the two numbers
                String[] inArr = br.readLine().split(",");
                //Initialize an array of 2 integer for the two numbers
                int[] inNums = new int[2];
                //Convert the strings to ints and copy them into the int array
                for(int i = 0; i < inArr.length; i++){
                    inNums[i] = Integer.parseInt(inArr[i]);
                }
                //Set the initial minuend, subtrahend, and difference values
                int minuend = Math.max(inNums[0], inNums[1]);
                int subtrahend = Math.min(inNums[0], inNums[1]);
                //Print out if the numbers are co-prime or not
                if(findIfCoPrime(minuend, subtrahend)){
                    System.out.println("COPRIME");
                }else{
                    System.out.println("NOT COPRIME");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }

    /**
     * A method to find if two numbers are co-prime using Euclid's algorithm, while also printing subtractions
     * sequentially. The order of the arguments does not matter, so the initial minuend can be the first or
     * second argument, and vice versa.
     *
     * @param a the first number
     * @param b the second number
     * @return if the two numbers are co-prime
     */
    public static boolean findIfCoPrime(int a, int b){
        //Set values from parameters
        int minuend = Math.max(a, b);
        int subtrahend = Math.min(a, b);
        int difference = a - b;
        //Initialize a boolean to indicate the two numbers are coprime
        boolean areCoPrime = false;
        //Loop until the difference is zero
        while(difference != 0){
            //Print out default statement
            System.out.println(String.format("%d-%d=%d", minuend, subtrahend, difference));
            //If difference is one, check 1 minus the subtrahend is zero. If so, then the numbers are co-prime
            if(difference == 1){
                if(1 - subtrahend == 0){
                    areCoPrime = true;
                }
            }
            //Set the next mineund and subtrahend
            minuend = Math.max(subtrahend, difference);
            subtrahend = Math.min(subtrahend, difference);
            //Set the difference
            difference = minuend - subtrahend;
        }
        //Print out the last subtraction(since the loop will exit)
        System.out.println(String.format("%d-%d=%d", minuend, subtrahend, difference));
        //Return the value of the boolean
        return areCoPrime;
    }
}
