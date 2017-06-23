package cq2015;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 6/22/2017.
 */
public class Prob01{
    public static void main(String[] args){
        try{
            //String to filePath
            String filePath = "inputs/2015/Prob01.in.txt";
            //New BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Read test cases into int value
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Read amount of names
                int N = Integer.parseInt(br.readLine());
                //Loop through amount of names
                while(N-- > 0){
                    //Read names
                    String name = br.readLine();
                    //Split name by spaces. First will be name[0], middle is name[1], last is name[2]
                    String[] nameSplit = name.split(" ");
                    //Initialize fine string and concatenate CAPITALIZED letters of the first char of each
                    String outPut = "";
                    outPut += Character.toString(nameSplit[0].charAt(0)).toUpperCase();
                    outPut += Character.toString(nameSplit[2].charAt(0)).toUpperCase();
                    outPut += Character.toString(nameSplit[1].charAt(0)).toUpperCase();
                    //Print
                    System.out.println(outPut);
                }
            }
            //Clean up
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
