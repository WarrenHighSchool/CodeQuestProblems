package cq2019;

/* Prob04.java
 *
 * Note: For the 2019 year, inputs come from the standard input channel.
 * Since I only have the inputs in text files, I will be using a BufferedReader,
 * similar to the other competition years. The code that does the actual work
 * should be the same though, it is just how the inputs are handled is different
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Prob04 {
    public static final String filePath = "inputs/2019/Prob04.txt";

    public static void main(String[] args){
        try{
            //BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get input
                String inLine = br.readLine();
                //Use a scanner to get the int and boolean value
                Scanner s = new Scanner(inLine);
                int speed = s.nextInt();
                boolean isBirthday = s.nextBoolean();
                //Establish max speeds based on birthday
                int noTicketMax;
                int smallTicketMax;
                if(isBirthday){
                    noTicketMax = 65;
                    smallTicketMax = 85;
                }else{
                    noTicketMax = 60;
                    smallTicketMax =  80;
                }
                //Establish what ticket to give and print it out
                if(speed <= noTicketMax){
                    System.out.println("no ticket");
                }
                else if(speed > noTicketMax && speed <= smallTicketMax){
                    System.out.println("small ticket");
                }
                else{
                    System.out.println("big ticket");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
