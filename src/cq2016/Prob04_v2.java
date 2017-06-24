package cq2016;

import java.io.*;
import java.util.*;

public class Prob04_v2{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//file 
		String file = "inputs/2016/Prob04.in.txt";
		//New buffered reader object 
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Grab test cases
		int testCases = Integer.parseInt(br.readLine());
		//Loop through test cases 
		for(int i = 0; i < testCases; i++){
			//read line
			String line = br.readLine();
			//split it up 
			String[] lineSplit = line.split("\\|"); //needs "\\" before the pipe since | is a metacharacter	
			//Make it easier to keep track of 
			String word1 = lineSplit[0];
			String word2 = lineSplit[1];
			//Call isAnagram method
			if(isAnagram(word1, word2)){
				System.out.println(line + " = ANAGRAM");
			}else{
				System.out.println(line + " = NOT AN ANAGRAM");
			}
		}
		//clean up
		br.close();
	}
	
	public static boolean isAnagram(String word1, String word2){
		//intialize return value
		boolean returnValue = true;
		//check if sizes of both words are the same or if the words are the same 
		if(word1.length() != word2.length() || word1.equals(word2)){
			return false;
		}
		//convert to char array
		char[] word1Letters = word1.toCharArray();
		char[] word2Letters = word2.toCharArray();
		//sort char arrays 
		Arrays.sort(word1Letters);
		Arrays.sort(word2Letters);
		//Check to see mismatch, if there is a single mismatch, then it isnt an anagram 
		for(int i = 0; i < word1Letters.length; i++){
			if(word1Letters[i] != word2Letters[i]){
				return false;
			}
		}
		return returnValue;
	}
}