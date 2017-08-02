package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.math.RoundingMode;

/**
 * Created by RobertPC on 7/31/2017.
 */
public class Prob07 {
    //String to file
    public static final String filePath = "inputs/2013/Prob07.in.txt";

    public static void main(String[] args){
        try{
            //Set constants
            final int AMT_TWENTY = 2000;
            final int AMT_TEN = 1000;
            final int AMT_FIVE = 500;
            final int AMT_ONE = 100;
            final int AMT_QUART = 25;
            final int AMT_DIME = 10;
            final int AMT_NICKEL = 5;
            //Initialize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //New decimalformat and set rounding mode
            DecimalFormat df = new DecimalFormat("#.00");
            df.setRoundingMode(RoundingMode.HALF_UP);
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Initialize amount for each bill
                int amtTwenty = 0;
                int amtTen = 0;
                int amtFive = 0;
                int amtOne = 0;
                int amtQuart = 0;
                int amtDime = 0;
                int amtNickel = 0;
                int amtPenny = 0;
                //Split the numbers
                String[] tokens = inLine.split(", ");
                //Parse them to doubles
                double amtOwed = Double.parseDouble(tokens[0]);
                double amtGiven = Double.parseDouble(tokens[1]);
                //Assign those to ints(amount of pennies)
                int amtOwedPennies = (int)(100 * amtOwed);
                int amtGivenPennies = (int)(100 * amtGiven);
                int change = amtGivenPennies - amtOwedPennies;
                while(change > 0) {
                    //Start subtracting accordingly and counting each amount of unit
                    if (change - AMT_TWENTY >= 0) {
                        change -= AMT_TWENTY;
                        amtTwenty++;
                    } else if (change - AMT_TEN >= 0) {
                        change -= AMT_TEN;
                        amtTen++;
                    } else if (change - AMT_FIVE >= 0) {
                        change -= AMT_FIVE;
                        amtFive++;
                    } else if (change - AMT_ONE >= 0) {
                        change -= AMT_ONE;
                        amtOne++;
                    } else if (change - AMT_QUART >= 0) {
                        change -= AMT_QUART;
                        amtQuart++;
                    } else if (change - AMT_DIME >= 0) {
                        change -= AMT_DIME;
                        amtDime++;
                    } else if (change - AMT_NICKEL >= 0) {
                        change -= AMT_NICKEL;
                        amtNickel++;
                    } else if (change - 1 >= 0) {
                        change--;
                        amtPenny++;
                    }
                    //Break out of the loop if we are done
                    if (change == 0) {
                        break;
                    }
                }
                //Initialize an output string
                String outString = "";
                //If we have a unit, concatenate it onto the output string, with the type, amount, and a comma
                if(amtTwenty > 0){
                    outString += "TWENTY=" + amtTwenty + ",";
                }
                if(amtTen > 0){
                    outString += "TEN=" + amtTen + ",";
                }
                if(amtFive > 0){
                    outString += "FIVE=" + amtFive + ",";
                }
                if(amtOne > 0){
                    outString += "ONE=" + amtOne + ",";
                }
                if(amtQuart > 0){
                    outString += "QUARTER=" + amtQuart + ",";
                }
                if(amtDime > 0){
                    outString += "DIME=" + amtDime + ",";
                }
                if(amtNickel > 0){
                    outString += "NICKEL=" + amtNickel + ",";
                }
                if(amtPenny > 0){
                    outString += "PENNY=" + amtPenny + ",";
                }
                //Print out the original amount of change
                //Print out the output string with the last character removed(the comma)
                System.out.println("$" + df.format(amtGiven - amtOwed) + ", " + outString.substring(0, outString.length() - 1));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
