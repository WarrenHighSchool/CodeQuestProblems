package cq2015;

import java.io.*;

public class Prob03{
	
	public static final String filePath = "inputs/2015/Prob03.in.txt";
	
	public static void main(String[] args){
		try{
			//New BufferedReader object 
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Read test cases 
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases
			while(T-- > 0){
				//Read number of years
				int N = Integer.parseInt(br.readLine());
				//Loop through number of years 
				while(N-- > 0){
					//Store year into int
					int year = Integer.parseInt(br.readLine());
					
					//PRENOTE: You can eliminate writing a lot of unnecessary code. Count the amount of leap years and common year conditionals. In our given pseudocode, we have three common year options,
					//and two leap year options. If we defualt isLeapYear to false, the nwe dont have to re set them to false. 
					
					//Run conditionals
					boolean isLeapYear = false;
					//"If year is prior to 1582, then it is a common year"
					if(year < 1582){
						isLeapYear = false;
					}
					//"Else if the year is not divisible by 4 then it is a common year"
					else if(year % 4 != 0){
						isLeapYear = false;
					}
					//"Else if the year is not divisible by 100 then it is a leap year"
					else if(year % 100 != 0){
						isLeapYear = true;
					}
					//"Else if the year is not divisible by 100 then it is a leap year"
					else if(year % 400 != 0){
						isLeapYear = false;
					}
					//"Else the year is a leap year"
					else{
						isLeapYear = true;
					}
					//Print as neccesary
					if(isLeapYear){
						System.out.println("Yes");
					} else{
						System.out.println("No");
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}