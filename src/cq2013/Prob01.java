package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Created by RobertPC on 7/21/2017.
 */
public class Prob01 {
    //String to filepath
    public static final String filePath = "inputs/2013/Prob01.in.txt";

    public static void main(String[] args){
        try {
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while bf isn't at end of file
            while ((inLine = br.readLine()) != null) {
                //Print the line exactly as read
                System.out.println(inLine);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
