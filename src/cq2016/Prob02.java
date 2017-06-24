package cq2016;

import java.io.*;

public class Prob02{
    public static void main(String[] args) throws FileNotFoundException,IOException{
        //Variables for each coin, all initialized to zero
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        //Path to text file that will be read
        String filePath = "inputs/2016/Prob02.in.txt";
        //New BufferedReader object to read text file
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        //Grab first number using read line that will be stored into a string.
        String testCasesStr = br.readLine();
        //Parse the string to an integer since we know it will only contain an int
        int testCases = Integer.parseInt(testCasesStr);
        //Loop through rest of lines in text file with for loop
        for(int i = 0; i < testCases; i++){
			//Read line 
            String line = br.readLine();
			//Initialize blank string 
            String newLine = "";
			//Fill blank string with the current string, just cutting out the '$'. Note that String.replace('$', "") can also be used
            for(int j = 1; j < line.length(); j++){
               newLine += line.charAt(j); 
            }
			//Parse the string to a double since we know that it will contain a double
            double amount = Double.parseDouble(newLine);
			//Calculate amount of quarters needed by taking the least greatest integer of how many times 0.25 will go into the amount
            quarters = (int)(amount/0.25);
			//Next is dimes. Note that since we have a quarter amount, we will have to offset for that
			dimes = (int)((amount - (quarters * 0.25))/0.10);
			//Now nickels. We will have to factor both offsets
            nickels = (int)((amount - (quarters * 0.25) - (dimes * 0.10))/0.05);
			//Finally, pennies. We will have to factor all three of all of the offsets
			pennies = (int)((amount - (quarters * 0.25) - (dimes * 0.10) - (nickels * 0.05))/0.01);
			//Due to java rounding precision, an example would have a value greater than x.999 pennies but woudlnt count as a whole, so this basically rounds up the pennies 
			//if they have a decimal greater thatn x.9
			if((amount - (quarters * 0.25) - (dimes * 0.10) - (nickels * 0.05))/0.01 > ((int)((amount - (quarters * 0.25) - (dimes * 0.10) - (nickels * 0.05))/0.01)+.9)){
			   pennies = pennies + 1; 
			 }
			//Print out original string.
			System.out.println(line);
			//Print out quarters
			System.out.println("Quarters=" + quarters);
			//Print out dimes
			System.out.println("Dimes=" + dimes);
			//Print out nickels
			System.out.println("Nickels=" + nickels);
			//Print out pennies
			System.out.println("Pennies=" + pennies);
        }
		//Close BufferedReader resources
        br.close();
    }
}