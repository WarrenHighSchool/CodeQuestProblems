package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by RobertPC on 8/3/2017.
 */
public class Prob13 {
    //String to filepath
    public static final String filePath = "inputs/2013/Prob13.in.txt";

    public static void main(String[] args){
        try {
            //Initialize inline
            String inLine = null;
            //Initialize hashmap for mappings
            Map<String, Integer> map = new HashMap<>();
            //Set those mappings
            map.put("A", 0);
            map.put("B", 1);
            map.put("X", 2);
            map.put("1", 3);
            map.put("5", 4);
            map.put("8", 5);
            map.put("U", 6);
            map.put("Q", 7);
            map.put("Y", 8);
            map.put("3", 9);
            map.put("R", 10);
            map.put("G", 11);
            map.put("K", 12);
            map.put("4", 13);
            map.put("E", 14);
            map.put("7", 15);
            //Initialize hashmap for binary numbers 0-15
            Map<Integer, String> binaryNums = new HashMap<>();
            //Set those mappings
            binaryNums.put(0, "0000");
            binaryNums.put(1,"0001");
            binaryNums.put(2, "0010");
            binaryNums.put(3, "0011");
            binaryNums.put(4, "0100");
            binaryNums.put(5, "0101");
            binaryNums.put(6, "0110");
            binaryNums.put(7, "0111");
            binaryNums.put(8, "1000");
            binaryNums.put(9, "1001");
            binaryNums.put(10, "1010");
            binaryNums.put(11, "1011");
            binaryNums.put(12, "1100");
            binaryNums.put(13, "1101");
            binaryNums.put(14, "1110");
            binaryNums.put(15, "1111");
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Split into tokens
                String[] tokens = inLine.split(" ");
                //Assign name
                String name = tokens[0];
                //Assign the proper encoded message
                String encodedMsg = tokens[1].replace("https://www.youtube.com/watch?v=", "");
                //Split into an array of Strings for each two letters in the String
                String[] msgSplit = new String[encodedMsg.length() / 2];
                //Fill that array
                for(int i = 0; i < encodedMsg.length(); i += 2){
                    msgSplit[i / 2] = encodedMsg.substring(i, i + 2);
                }
                //Initialize string for message
                String message = "";
                //Loop through msgsplit
                for(int i = 0; i < msgSplit.length; i++){
                    //Split into each letter
                    char char1 = msgSplit[i].charAt(0);
                    char char2 = msgSplit[i].charAt(1);
                    //Find the reverse mappings using the table given and the hashmap we made
                    int char1Mapping = map.get(Character.toString(char1));
                    int char2Mapping = map.get(Character.toString(char2));
                    //Get a 4-bit binary representation of our mapping using our hashmap for binary mappings numbers 0-15
                    String char1BinaryString = binaryNums.get(char1Mapping);
                    String char2BinaryString = binaryNums.get(char2Mapping);
                    //Concatenate the two strings into one 8-bit binary number
                    String totalBinaryString = char1BinaryString.concat(char2BinaryString);
                    //Add the character of the ASCII number by getting the decimal number for that binary number
                    message += (char)binaryToDecimal(totalBinaryString);
                }
                //Print out the name of the user and also the message we constructed
                System.out.println(name + " " + message);
                //Clean up
                br.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * converts a binary string to a decimal number
     *
     * @param s a String of the binary number
     * @return an integer in decimal format of the binary number
     */
    public static int binaryToDecimal(String s){
        int exponent = 7;
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            total += Character.getNumericValue(s.charAt(i)) * Math.pow(2, exponent);
            exponent--;
        }
        return total;
    }
}
