//Template for problems

package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob04 {
    //String to file
    public static final String filePath = "inputs/2017/Prob04.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Build fibonacci sequence
            long[] fibb = new long[91];
            fibb[0] = 0;
            fibb[1] = 1;
            for(int i = 2; i < fibb.length; i++){
                fibb[i] = fibb[i - 2] + fibb[i - 1];
            }
            //Loop through test cases
            while(T-- > 0){
                int index = Integer.parseInt(br.readLine());
                System.out.println(index + " = " + fibb[index - 1]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
