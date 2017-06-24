package cq2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Prob05_v2{
	public static final String fileIn = "Prob05.in.txt";
	
	public static void main(String[] args){
		try{
			//New DecimalFormat object
			DecimalFormat df = new DecimalFormat("#.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(fileIn));
			//Grab testCases
			int T = Integer.parseInt(br.readLine());
			//Loop through testCases 
			while(T-- > 0){
				//Grab line
				String line = br.readLine();
				//get proper line 
				String newLine = line.replace("$", "");
				//Print out appropriate
				System.out.println("Total of the bill: " + line);
				System.out.println("15% = $" + df.format(Double.parseDouble(newLine) * 0.15));
				System.out.println("18% = $" + df.format(Double.parseDouble(newLine) * 0.18));
				System.out.println("20% = $" + df.format(Double.parseDouble(newLine) * 0.20));	
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}