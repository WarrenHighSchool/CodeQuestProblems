package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob10 {
    public static final String filePath = "inputs/2012/Prob10.in.txt";

    public static void main(String[] args){
        try{
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Initialize inLine
            String inLine = "";
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Number to perform factorial on
                int facNum = Integer.parseInt(inLine);
                //We have to use BigInteger since these numbers can get pretty big
                BigInteger cur = new BigInteger(inLine);
                //Start loop at facNum - 1, and set cur to cur.multiply the BigInteger of i
                for(int i = facNum - 1; i > 0; i--){
                    cur = cur.multiply(new BigInteger(Integer.toString(i)));
                }
                //Print it out
                System.out.println(cur);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
