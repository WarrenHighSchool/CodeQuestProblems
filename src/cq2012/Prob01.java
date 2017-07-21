package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob01 {
    public static final String filePath = "inputs/2012/Prob01.in.txt";


    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Initialize total
            double total = 0.0;
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Initialize amount for each type of coin
                int quarters = 0;
                int dimes = 0;
                int nickels = 0;
                int halfdollars = 0;
                int pennies = 0;
                //Split input line so on one side there is type of coin, and other has the quantity
                String[] inLineSpl = inLine.split("=");
                //Use a switch for which type of coin is being used
                //Add the quantity to the amount of that certain coin
                switch(inLineSpl[0]) {
                    case "QUARTER":
                        quarters += Integer.parseInt(inLineSpl[1]);
                        break;
                    case "DIME":
                        dimes += Integer.parseInt(inLineSpl[1]);
                        break;
                    case "NICKEL":
                        nickels += Integer.parseInt(inLineSpl[1]);
                        break;
                    case "HALFDOLLAR":
                        halfdollars += Integer.parseInt(inLineSpl[1]);
                        break;
                    case "PENNY":
                        pennies += Integer.parseInt(inLineSpl[1]);
                        break;
                }
                //Add based on each type of coin
                total += (0.0 + (quarters * 0.25));
                total += (0.0 + (dimes * 0.10));
                total += (0.0 + (nickels * 0.05));
                total += (0.0 + (halfdollars * 0.50));
                total += (0.0 + (pennies * 0.01));
            }
            //Print it
            System.out.println(total);
            //Clean up
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
