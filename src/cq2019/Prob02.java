package cq2019;

/* Prob02.java
 *
 * Note: For the 2019 year, inputs come from the standard input channel.
 * Since I only have the inputs in text files, I will be using a BufferedReader,
 * similar to the other competition years. The code that does the actual work
 * should be the same though, it is just how the inputs are handled is different
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Prob02 {
    public static final String filePath = "inputs/2019/Prob02.txt";

    public static void main(String[] args){
        try{
            //BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get input
                String inLine = br.readLine();
                //Use a scanner to get the two ints
                Scanner s = new Scanner(inLine);
                int int1 = s.nextInt();
                int int2 = s.nextInt();
                //If the integers are not equal, print out their sum. If equal, print out 2 times their sum
                if(int1 != int2){
                    System.out.println(int1 + int2);
                }else{
                    System.out.println(2 * (int1 + int2));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
