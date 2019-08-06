package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob08 {
    public static final String filePath = "inputs/2018/Prob08.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0){
                //Get the gimble angles
                String commandGimAngles[] = br.readLine().split(" ");
                //Initialize an array that will be doubles of our input
                double[] cgAngles = new double[3];
                //Copy the values from the string array to the double array
                for(int i = 0; i < commandGimAngles.length; i++){
                    cgAngles[i] = Double.parseDouble(commandGimAngles[i]);
                }
                //Subtract 180 from each value
                for(int i = 0; i < cgAngles.length; i++){
                    cgAngles[i] = cgAngles[i] - 180;
                }
                //Check each value. If negative, take the absolute value of that negative and subtract it from 360
                //Also if equal to 360 exactly, then set to 0
                for(int i = 0; i < cgAngles.length; i++){
                    if(cgAngles[i] < 0.0){
                        cgAngles[i] = 360 - Math.abs(cgAngles[i]);
                    }
                    if(cgAngles[i] == 360.0){
                        cgAngles[i] = 0.0;
                    }
                }
                //Print out each result, with a precision of 2 decimal places
                System.out.println(String.format("%.2f %.2f %.2f", cgAngles[0], cgAngles[1], cgAngles[2]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
