package cq2019;

/* Prob03.java
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

public class Prob03 {
    public static final String filePath = "inputs/2019/Prob03.txt";

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
                //Use a scanner to get the two boolean values
                Scanner s = new Scanner(inLine);
                boolean bool1 = s.nextBoolean();
                boolean bool2 = s.nextBoolean();
                //If both are true, print out true. Otherwise, print false
                if(bool1 == bool2){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
