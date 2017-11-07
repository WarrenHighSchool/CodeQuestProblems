package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob02 {
    //String to file
    public static final String filePath = "inputs/2017/Prob02.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                String[] split = br.readLine().split(" ");
                String newString = "";
                for(int i = 0; i < split[0].length(); i++){
                    if(i != Integer.parseInt(split[1])){
                        newString += split[0].charAt(i);
                    }
                }
                System.out.println(newString);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
