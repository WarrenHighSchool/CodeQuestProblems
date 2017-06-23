package cq2015;

import java.io.*;

public class Prob08{
	//String to file path
	public static final String filePath = "Prob08.in.txt";
	//Main
	public static void main(String[] args){
		try{
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Read test cases 
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases 
			while(T-- > 0){
				//Read number of aircraft sections
				int N = Integer.parseInt(br.readLine());
				//Loop through number of aircraft sections
				while(N-- > 0){
					//Start reading data
					String name = br.readLine();
					//Aircraft info
					String airCraftCoordinates = br.readLine();
					String[] airCraftCoorSpl = airCraftCoordinates.split(",");
					double airCraftX = Double.parseDouble(airCraftCoorSpl[0]);
					double airCraftY = Double.parseDouble(airCraftCoorSpl[1]);
					//Start landing zone info
					String startLandingCoor = br.readLine();
					String[] startLandingSpl = startLandingCoor.split(",");
					double startX = Double.parseDouble(startLandingSpl[0]);
					double startY = Double.parseDouble(startLandingSpl[1]);
					//End landing zone info 
					String endLandingCoor = br.readLine();
					String[] endLandingSpl = endLandingCoor.split(",");
					double endX = Double.parseDouble(endLandingSpl[0]);
					double endY = Double.parseDouble(endLandingSpl[1]);
					//Now that we have info, start calculating slopes
					double startSlope = (double)(startY - airCraftY + 0.0)/(startX - airCraftX + 0.0);
					double endSlope = (double)(endY - airCraftY + 0.0)/(endX - airCraftX + 0.0);
					//Print properly
					if(startSlope <= -0.8 && startSlope >= -1.6 && endSlope <= -0.8 && endSlope >= -1.6){
						System.out.println(name + ", Clear To Land!");
					} else{
						System.out.println(name + ", Abort Landing!");
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}