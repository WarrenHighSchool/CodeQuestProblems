package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob15 {
    //String to file path
    public static final String filePath = "inputs/2018/Prob15.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get inline
                String inLine = br.readLine();
                //Initialize output string builder
                StringBuilder sb = new StringBuilder();
                //Initialize refrence array(number will be index plus 1)
                final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                //Loop through each character in the input string
                for(int i = 0; i < inLine.length(); i++){
                    //Get character
                    char c = inLine.charAt(i);
                    //Get numerical value for character
                    int value = getIndex(LETTERS, c) + 1;
                    //Apply rules to different letters accordingly
                    // A though E
                    if(value >= 5){
                        value += 6;
                    }
                    //F through J
                    if(value >= 6 && value <= 10){
                        value = (int)Math.pow(value, 2);
                    }
                    //K through O
                    if(value >= 11 && value <= 15){
                        int remainder = value % 3;
                        value = (remainder * 5) + 1;
                    }
                    //U through Z
                    if(value >= 16){

                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }

    /**
     * Gets the index of a letter found in a character array
     *
     * @param arr the array of characters
     * @param c the character to find the index for
     * @return the index of the character(-1 if not found)
     */
    public static int getIndex(char[] arr, char c){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }
}
