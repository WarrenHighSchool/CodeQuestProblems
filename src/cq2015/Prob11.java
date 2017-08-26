package cq2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;

public class Prob11{
	//Path to file
	public static final String filePath = "inputs/2014/Prob11.in.txt";

	public static void main(String[] args){
		try{
			//Prepare to read file
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Grab test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases
			while(T-- > 0){
				//Hashmap for keeping track of how many soundex's are generated
				Map<Character, Integer> mappings = new HashMap<>();
				//Grab amount of names
				int N = Integer.parseInt(br.readLine());
				//Loop through names
				while(N-- > 0){
					//Read line
					String inLine = br.readLine();
					for(int i = 0; i < inLine.length(); i++){
						char curChar = inLine.charAt(i);
						if(isInNumberedGroup(curChar)){

						}
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * returns the group for a designated character
	 * @param c the character to get the group for
	 * @return the group number of the character
	 */
	public static int getGroup(char c){
		if(c == 'b' || c == 'f' || c == 'p' || c == 'v'){
			return 1;
		}
		else if(c == 'c' || c == 'g' || c == 'j' || c == 'k' || c == 'q' || c == 's' || c == 'x' || c == 'z'){
			return 2;
		}
		else if(c == 'd' || c == 't'){
			return 3;
		}
		else if(c == 'l'){
			return 4;
		}
		else if(c == 'm' || c == 'n'){
			return 5;
		}
		else if (c == 'r'){
			return 6;
		}
		return -1;
	}

	/**
	 * returns true or false based on if the character is in a numbered group
	 * @param c the character to check for in a numbered group
	 * @return true or false based on if the character is a part of the numbered groups
	 */
	public static boolean isInNumberedGroup(char c){ return getGroup(c) >= 1 && getGroup(c) <= 6; }

	/**
	 * returns true or false based on if the character is either 'h' or 'w'
	 * @param c the character to check if it is a wildcard character
	 * @return true or false based on if the character is a wildcard character or not
	 */
	public static boolean isWildLetter(char c){ return c == 'h' || c == 'w'; }
}