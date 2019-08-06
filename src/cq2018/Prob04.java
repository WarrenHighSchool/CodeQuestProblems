package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class Prob04 {
    public static final String filePath = "inputs/2018/Prob04.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Initialize HashMap for R, P, and S, and start their values at 0
                HashMap<String, Integer> plays = new HashMap<>();
                plays.put("R", 0);
                plays.put("P", 0);
                plays.put("S", 0);
                /*
                    ROCK beats SCISSORS
                    SCISSORS beats PAPER
                    PAPER beats ROCK
                */
                //Get array of plays
                String[] inLineArr = br.readLine().split(" ");
                //Loop through each play and add them to the hashmap counter
                for(String s : inLineArr){
                    //Get current hashmap value
                    int val = plays.get(s);
                    plays.put(s, (val + 1));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
