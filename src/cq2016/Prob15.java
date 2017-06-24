import java.io.*;
import java.util.*;

public class Prob15{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to file 
		String file = "Prob15.in.txt";
		//New BufferedReader object
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Acquire test cases 
		int testCases = Integer.parseInt(br.readLine());
		//Loop through test cases 
		while(testCases-- > 0){
			//Read disk amount
			int n = Integer.parseInt(br.readLine());
			//Print out amount of disks in stack
			System.out.println(n);
			//Solve towers
			solveTowers(n, "A", "B", "C");
		}
	}
	public static void printMove(String from, String to){
		System.out.println(from + "->" + to);
	}
	public static void solveTowers(int n, String from, String spare, String to){
		if(n == 1){
			printMove(from, to);
		}else{
			//This first solveTowers bascially takes all the discs from the first stack except the biggest one, and moves them to stack B using 
			//peg C as a helper
			solveTowers(n - 1, from, to, spare);
			//When all of the others have been moved, this moves the biggest disc from to the last peg
			printMove(from, to);
			//Move the rest of the discs from stack B to stack C using stack A as a helper 	
			solveTowers(n - 1, spare, from, to);
		}
	}
}