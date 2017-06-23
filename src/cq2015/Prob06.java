package cq2015;

import java.io.*;

public class Prob06{
	public static final String filePath = "Prob06.in.txt";
	
	public static class WordWorm{
		public String word;
		public boolean isValid;
		
		public WordWorm(String theWord, boolean theIsValid){
			word = theWord;
			isValid = theIsValid;
		}
		
		public String toString(){
			return word;
		}
	}
	public static void main(String[] args){
		try{
			//New BufferedReader 
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Grab test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases
			while(T-- > 0){
				//Read line 
				String line = br.readLine();
				//Split into rows and columns
				String[] lineSpl = line.split(" ");
				//Assign proper ints 
				int R = Integer.parseInt(lineSpl[0]);
				int C = Integer.parseInt(lineSpl[1]);
				//Create char array based on these 
				char[][] chars = new char[R][C];
				//Loop through test R lines
				for(int i = 0; i < R; i++){
					//Read next line 
					String inLine = br.readLine();
					//Split by spaces 
					String[] inLineSpl = inLine.split(" ");
					//Add to char array properly
					for(int j = 0; j < C; j++){
						chars[R][C] = inLineSpl[C].charAt(0);
					}
				}
				//Grab number of words
				int N = Integer.parseInt(br.readLine());
				//Make array of WordWorm objects
				WordWorm[] words = new WordWorm[N];
				//Loop through words
				for(int i = 0; i < N; i++){
					//Read string 
					String inLine = br.readLine();
					//Add to array words
					words[i] = new WordWorm(inLine, findWormWord(chars, inLine));
				}
				//Print out properly
				for(WordWorm w : words){
					if(w.isValid){
						System.out.println(w);
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean findWormWord(char[][] chars, String inLine){
		char[] inLineSpl = inLine.toCharArray();
		boolean isFound = false;
		while(!isFound){
			//
			int preR = 0;
			int preC = 0;
			int curR = 0;
			int curC = 0;
			
			//if at end of char array and not found, automatically return false
			if(!isFound && (curR == chars.length && curC == chars[0].length)){
				return false;
			}
		}
		return isFound;
	}
}