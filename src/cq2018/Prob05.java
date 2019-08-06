package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob05 {
    public static final String filePath = "inputs/2018/Prob05.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Grab initial integer
                int N = Integer.parseInt(br.readLine());
                //Make copy(we need to keep original N for printing at the end)
                int N_copy = Integer.valueOf(N);
                //Initialize counter for sequence length
                int len = 1;
                while(N != 1){
                    //If current number is even
                    if(N % 2 ==0){
                        N = Integer.valueOf(N)/2;
                    }
                    //If odd
                    else{
                        N = (3 * Integer.valueOf(N)) + 1;
                    }
                    len++;
                }
                System.out.println(String.format("%d:%d", N_copy, len));
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
