package cq2016;

import java.io.*;
import java.util.*;
/*
6/23/17 5:19 PM PST - Not finished
*/
public class 	Prob14{
	public static class Frame{
		public String firstMove;
		public String secondMove;
		public boolean previousIsSpare;
		public boolean previousIsStrike;
		//Constructor for strike 
		public Frame(String move, boolean previousIsSpare, boolean previousIsStrike){
			firstMove = move;
			secondMove = null;
			this.previousIsSpare = previousIsSpare;
			this.previousIsStrike = previousIsStrike;
		}
		//Constructor for non-strike
		public Frame(String firstMove, String secondMove, boolean previousIsSpare, boolean previousIsStrike){
			this.firstMove = firstMove;
			this.secondMove = secondMove;
			this.previousIsSpare = previousIsSpare;
			this.previousIsStrike = previousIsStrike;
		}
		
		public boolean containsSpare(){
			return secondMove.equals("/");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//Read file 
		String file = "inputs/2016/Prob14.in.txt";
		//New buffered reader object
		BufferedReader br = new BufferedReader(new FileReader(file));
		//grab test cases 
		int testCases = Integer.parseInt(br.readLine());
		//loop through test cases 
		for(int i = 0; i < testCases; i++){
			//Read line 
			String line = br.readLine();
			
		}
	}
}