package cq2016;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob02_v2{
    public static final String filePath = "inputs/2016/Prob02.in.txt";

    public static void main(String[] args){
        try{
            //New BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0) {
                //Grab amount
                String amount = br.readLine();
                //Remove cash sign
                String newAmt = amount.replace("$", "");
                //Parse that to double
                double amtDouble = Double.parseDouble(newAmt);
                //Get an INT value for amount of pennies
                int amtInt = (int)(amtDouble * 100);
                //Initialize coins
                int quarters = 0;
                int dimes = 0;
                int nickels = 0;
                int pennies = 0;
                //Sequentially subtract
                while (amtDouble > 0) {
                    double predictedOutQuart = amtInt - 25;
                    double predictedOutDime = amtInt - 10;
                    double predictedOutNickel = amtInt - 5;
                    double predictedOutPenny = amtInt - 1;
                    if(predictedOutQuart > 0){
                        amtInt -= 25;
                        quarters++;
                    }
                    else if(predictedOutDime > 0){
                        amtInt -= 10;
                        dimes++;
                    }
                    else if(predictedOutNickel > 0){
                        amtInt -= 5;
                        nickels++;
                    }
                    else if(predictedOutPenny >= 0){
                        amtInt -= 1;
                        pennies++;
                    }
                    if(amtInt == 0){
                        break;
                    }
                }
                System.out.println(amount);
                System.out.println("Quarters=" + quarters);
                System.out.println("Dimes=" + dimes);
                System.out.println("Nickels=" + nickels);
                System.out.println("Pennies=" + pennies);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}