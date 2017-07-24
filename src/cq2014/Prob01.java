package cq2014;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 7/22/2017.
 */
public class Prob01 {
    //String to file
    public static final String filePath = "inputs/2014/Prob01.in.txt";

    public static void main(String[] args){
        try{
           //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                int value = Integer.parseInt(inLine);
                if((value % 3 == 0) && (value % 7 ==0)){
                    System.out.println("CODEQUEST");
                }
                else if(value % 3 == 0){
                    System.out.println("CODE");
                }
                else if(value % 7 == 0){
                    System.out.println("QUEST");
                }
                else{
                    System.out.println(value);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
