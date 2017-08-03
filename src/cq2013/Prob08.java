package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Created by RobertPC on 8/2/2017.
 */
public class Prob08 {
    //String to file path
    public static final String filePath = "inputs/2013/Prob08.in.txt";

    public static void main(String[] args) {
        try {
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while ((inLine = br.readLine()) != null) {
                //Split into tokens
                String[] tokens = inLine.split(" ");
                //Parse to BigIntegers
                int n = Integer.parseInt(tokens[0]);
                int k = Integer.parseInt(tokens[1]);
                BigInteger top = factorial(n);
                BigInteger bottom = factorial(k).multiply(factorial(n - k));
                BigInteger result = top.divide(bottom);
                System.out.println(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BigInteger factorial(int n) {
        if (n == 0) {
            return new BigInteger("1");
        }
        BigInteger fact = new BigInteger("1"); // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
        }
        return fact;
    }
}
