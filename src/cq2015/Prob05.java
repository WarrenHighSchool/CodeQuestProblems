package cq2015;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Prob05{
	//Text file to read
	public static final String filePath = "inputs/2015/Prob05.in.txt";
	//Class to keep track of each per capita income for a respective year
	public static class Income{
		//Instance variables 
		public int year;
		public double perCapIncome;
		public int asteriskAmt;
		//Constructor
		public Income(double perCapIncome, int year){
			this.perCapIncome = perCapIncome;
			this.year = year;
			asteriskAmt = (int)(perCapIncome/1000);
		}
		//toString
		public String toString(){
			String returnStr = year + " ";
			for(int i = 0; i < asteriskAmt; i++){
				returnStr += "*";
			}
			return returnStr;
		}
	}
	//Comparator for sorting by year 
	public static class CapIncomeYearComparator implements Comparator<Income>{
		public int compare(Income a, Income b){
			if(a.year > b.year){
				return 1;
			}
			if(a.year < b.year){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	public static void main(String[] args){
		try{
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Get test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases 
			while(T-- > 0){
				//Read region
				String region = br.readLine();
				//Get num of data points
				int N = Integer.parseInt(br.readLine());
				//Make array of empty Income objects based on N length
				Income[] incomes = new Income[N];
				//Loop through data points
				for(int i = 0; i < N; i++){
					//Read line
					String line = br.readLine();
					//Split properly
					String[] lineSpl = line.split(" ");
					//Add to Income array with properly instantiated objects 
					incomes[i] = new Income(Double.parseDouble(lineSpl[0]), Integer.parseInt(lineSpl[1]));
				}
				//Sort Income objects by year 
				Arrays.sort(incomes, new CapIncomeYearComparator());
				//Print out toStrings of each object 
				for(Income i : incomes){
					System.out.println(i);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}