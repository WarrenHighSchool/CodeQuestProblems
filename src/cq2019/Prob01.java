package cq2019;

/* Prob01.java
 *
 * Note: For the 2019 year, inputs come from the standard input channel.
 * Since I only have the inputs in text files, I will be using a BufferedReader,
 * similar to the other competition years. The code that does the actual work
 * should be the same though, it is just how the inputs are handled is different
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob01 {
    public static final String filePath = "inputs/2019/Prob01.txt";

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
                //Print out lowercase variant of input
                System.out.println(inLine.toLowerCase());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
