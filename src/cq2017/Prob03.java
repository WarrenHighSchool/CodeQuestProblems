package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob03 {
    //String to file
    public static final String filePath = "inputs/2017/Prob03.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                String inLine = br.readLine();
                int n1 = Integer.parseInt(inLine.split(" ")[0]);
                int n2 = Integer.parseInt(inLine.split(" ")[1]);
                int addition = n1 + n2;
                int product = n1 * n2;
                System.out.println(addition + " " + product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
