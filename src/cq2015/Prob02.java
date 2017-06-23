package cq2015;


import java.io.*;
import java.math.BigInteger;

/**
 * Created by RobertPC on 6/22/2017.
 */
public class Prob02{
    public static final String filePath = "Prob02.in.txt";

    public static void main(String[] args){
        try{
            //New BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Read test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Read team amount
                int N = Integer.parseInt(br.readLine());
                //BigInteger to start with
                BigInteger grains = new BigInteger("0");
                //Loop through teams
                while(N-- > 0){
                    //New BigInteger with current team count
                    BigInteger cur = new BigInteger(br.readLine());
                    //Add it to grains
                    grains = grains.add(cur);
                }
                System.out.println(grains);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}