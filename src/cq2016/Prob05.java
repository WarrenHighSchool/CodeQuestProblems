import java.io.*;

public class Prob05{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to filepath
		String filePath = "inputs/2016/Prob05.in.txt";
		//Create new BufferedReader instance of a file reader for the text file 
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//String for amount of testcases
		String testCasesStr = br.readLine();
		//Oarse string into int 
		int testCases = Integer.parseInt(testCasesStr);
		//Loop through with amount of test cases 
		for(int i = 0; i < testCases; i++){
			//Read next line 
			String line = br.readLine();
			//Replace any parts of string that arent numbers, in this case, "$"
			String newLine = line.replace("$", "");
			//Parse string into double 
			double value = Double.parseDouble(newLine);
			//Print out values as necessary, using rounding method. 
			System.out.println("Total of the bill: " + line);
			System.out.println("15% = $" + round(Double.toString(value * 0.15)));
			System.out.println("18% = $" + round(Double.toString(value * 0.18)));
			System.out.println("20% = $" + round(Double.toString(value * 0.20)));
		}
	}

	public static String round(String inputString){
		//Default boolean to round up the second number after decimal 
		boolean roundSecondDecimal = false; 
		//Initialize decimal index int 
		int decimalIndex = -1; 
		//Search through string to find decimal
		for(int i = 0; i < inputString.length(); i++){
			//If decimal, or '.' has been found 
			if(inputString.charAt(i) == '.'){
				//Set the decimal index to i
				decimalIndex = i;
				//Break out of loop
				break;
			}
		}
		//If the third decimal number(the one that would round up the second decimal number) is greater than 5, set the boolean to true
		if(Integer.parseInt(Character.toString(inputString.charAt(decimalIndex + 3))) >= 5){
			roundSecondDecimal = true;
		}
		//Consturct new string that will hold the rounded value to two decimal places
		String returnString = "";
		//Number that will be rounded up 
		int numberToBeRoundedUp = Integer.parseInt(Character.toString(inputString.charAt(decimalIndex + 2)));
		//if numberToBeRoundedUp < 9, Add to new string, stopping right before the numberToBeRoundedUp will be added
		if(numberToBeRoundedUp < 9){	
			for(int i = 0; i <= decimalIndex + 1; i++){
				returnString += inputString.charAt(i);
			}
		}
		//otherwise, add onto string one number before
		else{
			for(int i = 0; i <= decimalIndex; i++){
				returnString += inputString.charAt(i);
			}
		}
		//If the rounding boolean is true, add the (number + 1) to the string
		if(roundSecondDecimal && numberToBeRoundedUp < 9){
			returnString += (numberToBeRoundedUp + 1);
		}
		//If number was 9 and boolean is true , then round up decimal before that
		else if(Integer.parseInt(Character.toString(inputString.charAt(decimalIndex + 2))) == 9){
			if(roundSecondDecimal){
				returnString += Integer.parseInt(Character.toString(inputString.charAt(decimalIndex + 1))) + 1;
				returnString += "0";
			}
			else{
				returnString += inputString.charAt(decimalIndex + 1);
				returnString += inputString.charAt(decimalIndex + 2);
			}
		}
		//Otherwise, just add the number how it was 
		else{
			returnString += numberToBeRoundedUp;
		}
		//Return the new string
		return returnString;
	}
}
