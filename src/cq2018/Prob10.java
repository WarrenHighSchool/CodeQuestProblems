package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob10 {
    public static final String filePath = "inputs/2018/Prob10.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get R-C pair in String format
                String[] RCPair = br.readLine().split(",");
                //Set R and C as ints
                int R = Integer.parseInt(RCPair[0]);
                int C = Integer.parseInt(RCPair[1]);
                //Get r1-c1 pair in String format
                String[] r1c1Pair = br.readLine().split(",");
                //Set r1 and c1 as ints
                int r1 = Integer.parseInt(r1c1Pair[0]);
                int c1 = Integer.parseInt(r1c1Pair[1]);
                //Get r2-c2 pair in String format
                String[] r2c2Pair = br.readLine().split(",");
                //Set r2 and c2 as ints
                int r2 = Integer.parseInt(r2c2Pair[0]);
                int c2 = Integer.parseInt(r2c2Pair[1]);
                //Get absolute value of change in X coordinates
                int dX = Math.abs(c2 - c1);
                //Get absolute value of change in Y coordinates
                int dY = Math.abs(r2 - r1);
                //If dX and dY are equal, then yes
                //TODO: Verify this.
                if(dX == dY) {
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
