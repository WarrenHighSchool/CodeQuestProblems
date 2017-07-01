package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob06 {
    public static final String filePath = "inputs/2012/Prob06.in.txt";

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String inLine = "";
            while((inLine = br.readLine()) != null){
                String lowerCaseLine = inLine.toLowerCase();
                //construct backwards string
                String backWardsString = "";
                for(int i = lowerCaseLine.length() - 1; i >= 0; i--){
                    backWardsString += lowerCaseLine.charAt(i);
                }
                if(lowerCaseLine.equals(backWardsString)) {
                    System.out.println("yes");
                } else{
                    System.out.println("no");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
