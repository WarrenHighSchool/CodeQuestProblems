package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob01 {
    //String to file
    public static final String filePath = "inputs/2017/Prob01.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                String line = br.readLine();
                for(int i = 0; i < 2; i++){
                    System.out.println(line);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
