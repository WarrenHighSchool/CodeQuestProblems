package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Prob03 {
    public static final String filePath = "inputs/2018/Prob03.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T -- > 0){
                String inLine = br.readLine();
                Scanner s = new Scanner(inLine).useDelimiter("\\D");
                String suffix;
                int num = s.nextInt();
                if(num == 1){
                    suffix = "st";
                }else if(num == 2){
                    suffix = "nd";
                }else if(num == 3){
                    suffix = "rd";
                } else{
                    suffix = "th";
                }
                System.out.println(num + suffix);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
