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
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String inLine = "";
            while((inLine = br.readLine()) != null){
                int facNum = Integer.parseInt(inLine);
                BigInteger cur = new BigInteger(inLine);
                for(int i = facNum - 1; i > 0; i--){
                    cur = cur.multiply(new BigInteger(Integer.toString(i)));
                }
                System.out.println(cur);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
