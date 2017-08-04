package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 8/3/2017.
 */
public class Prob10 {
    //String to file path
    public static final String filePath = "inputs/2013/Prob10.in.txt";

    public static void main(String[] args){
        try {
            //Initialize inline
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while ((inLine = br.readLine()) != null) {
                //Initialize 4 different octets for each ip address
                int[] octets = new int[4];
                //Assign those octets
                for(int i = 0; i < inLine.length(); i += 8){
                    octets[i/8] = binaryToDecimal(inLine.substring(i, i + 8));
                }
                //Initialize class string
                String classType = null;
                //Assign class types
                if(octets[0] < 128){ classType = "A"; }
                else if(octets[0] >= 128 && octets[0] <= 191){ classType = "B"; }
                else if(octets[0] >= 192 && octets[0] <= 223){ classType = "C"; }
                else if(octets[0] >= 224 && octets[0] <= 239){ classType = "D"; }
                else{ classType = "E"; }
                //Print out properly
                System.out.println(octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3] + " [CLASS " + classType + "]");
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
