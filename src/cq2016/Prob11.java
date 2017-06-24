package cq2016;

import java.io.*;

public class Prob11{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//Letters in order. Indexes will correspond with the char array of the cipher 
		final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		//String to file
		String filePath = "inputs/2016/Prob11.in.txt";
		//BufferedReader object
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//Grab test cases
		String testCasesStr = br.readLine();
		//Parse into int
		int testCases = Integer.parseInt(testCasesStr);
		//Loop through test cases
		for(int i = 0; i < testCases; i++){
			//encrypt or decrypt?
			boolean encrypt = false;
			//string that says ENCRYPT or DECRYPT
			String opType = br.readLine();
			//Set boolean properly
			encrypt = opType.equals("ENCRYPT");
			//Read cipher
			String cipherString = br.readLine();
			//Turn into array of chars 
			char[] cipher = cipherString.toCharArray();
			//get number of messages
			String numMessagesStr = br.readLine();
			//parse to int
			int numMessages = Integer.parseInt(numMessagesStr);
			//Loop through numMessages
			for(int j = 0; j < numMessages; j++){
				String line = br.readLine();
				//initialize string to print 
				String printString = "";
				//encrypt or decrypt?
				if(encrypt){
					//loop through string 
					for(int k = 0; k < line.length(); k++){
						//currentchar
						char curChar = line.charAt(k);
						//is it a capital letter?
						boolean isCapital = false;
						if(Character.toString(curChar).equals(Character.toString(curChar).toUpperCase())){
							isCapital = true;
						}
						else{
							isCapital = false;
						}
						//parse through the two arrays
						//for encrypting, we find the index in the ordered letters, and use that index for the cipher array 
						if(curChar == ' '){ //is there is a space, just add a space 
							printString += ' ';
						}
						//if capital letter, add the capital letter of that
						else if(isCapital){
							printString += Character.toUpperCase(cipher[findIndex(letters, Character.toUpperCase(curChar))]);
						}
						//if no capital, add normal letter 
						else{
							printString += cipher[findIndex(letters, Character.toUpperCase(curChar))];
						}
					}
					//print it 
					System.out.println(printString);
				}
				else{ //decrypt 
					//loop through string 
					for(int k = 0; k < line.length(); k++){
						//currentchar 
						char curChar = line.charAt(k);
						//capital?
						boolean isCapital = false;
						if(Character.toString(curChar).equals(Character.toString(curChar).toUpperCase())){
							isCapital = true;
						}
						else{
							isCapital = false;
						}
						//parse through the two arrays
						//for decrypting, we find the index in the cipher, and use the index of the normal letters 
						if(curChar == ' '){ //is there is a space, just add a space 
							printString += ' ';
						}
						//if capital letter, add the capital letter of that
						else if(isCapital){
							printString += Character.toUpperCase(letters[findIndex(cipher, Character.toLowerCase(curChar))]);
						}
						//if no capital, add normal letter 
						else{
							printString += Character.toLowerCase(letters[findIndex(cipher, Character.toLowerCase(curChar))]);
						}
					}
					//print it 
					System.out.println(printString);
				}
			}
		}
	}
	/**
	*helper method 
	*@param c1 
	*@param c2
	*/
	public static int findIndex(char[] c1, char c2){
		int returnValue = -1; //return -1 if not found 
		for(int i = 0; i < c1.length; i++){
			if(c1[i] == c2){
				returnValue = i;
				break;
			}
		}
		return returnValue; 
	}
}