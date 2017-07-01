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
        String inLine = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        double total = 0.0;
            while((inLine = br.readLine()) != null){
                int quarters = 0;
                int dimes = 0;
                int nickels = 0;
                int halfdollars = 0;
                int pennies = 0;
                String[] inLineSpl = inLine.split("=");
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
                //System.out.println("Adding " + (quarters * 0.25) + " to " + total);
                total += (0.0 + (quarters * 0.25));
                //System.out.println("Adding " + (dimes * 0.10) + " to " + total);
                total += (0.0 + (dimes * 0.10));
                //System.out.println("Adding " + (nickels * 0.05) + " to " + total);
                total += (0.0 + (nickels * 0.05));
                //System.out.println("Adding " + (halfdollars * 0.50) + " to " + total);
                total += (0.0 + (halfdollars * 0.50));
                //System.out.println("Adding " + (pennies * 0.01) + " to " + total);
                total += (0.0 + (pennies * 0.01));
                //System.out.println("Total = " + total);
            }
            System.out.println(total);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
