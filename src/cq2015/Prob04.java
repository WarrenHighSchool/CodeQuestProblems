package cq2015;

import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Prob04{
	public static final String filePath = "Prob04.in.txt";
	
	public static void main(String[] args){
		try{
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//New DecimalFormat object + set proper rounding mode
			DecimalFormat df = new DecimalFormat("#.0");
			df.setRoundingMode(RoundingMode.HALF_UP);
			//Get test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases
			while(T-- > 0){
				//Get amount of temp conversions
				int N = Integer.parseInt(br.readLine());
				//Loop though temp conversions
				while(N-- > 0){
					//Read line
					String line = br.readLine();
					//Split line properly
					String[] lineSplit = line.split(" ");
					//Assign String values to the number of the temperature and the scale
					String origTemp = lineSplit[0];
					String scale = lineSplit[1];
					//Assign origTemp to double value for math purposes
					double origTempDbl = Double.parseDouble(origTemp);
					//Do cases for if scale is celsius or fahrenheit
					if(scale.equals("C")){
						double newTemp = (double)(((9.0/5) * origTempDbl + 0.0) + 32);
						System.out.println(line + " = " + df.format(newTemp) + " F");
					} else{
						double newTemp = (double)((5.0/9)*(origTempDbl - 32));
						System.out.println(line + " = " + df.format(newTemp) + " C");
					}
				}
			}
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}