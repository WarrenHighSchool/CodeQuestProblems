package cq2016;

import java.io.*;

public class Prob10{
	public static void main(String[] args) throws IOException{
		//String to filePath
		String filePath = "inputs/2016/Prob10.in.txt";
		//New bufferedreader
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//Grab test cases
		String testCasesStr = br.readLine();
		//Parse to int
		int testCases = Integer.parseInt(testCasesStr);
		//loop through test cases
		for(int i = 0; i < testCases; i++){
			//Grab time units
			String timeUnitsStr = br.readLine();
			//Parse to int
			int timeUnits = Integer.parseInt(timeUnitsStr);
			//create 2d array. array[0][x] will store altitude, array[1][x] will store elevation
			int[][] info = new int[2][timeUnits + 2];
			//Fill array at time unit 0 with proper defaults 
			info[0][0] = 0;
			info[1][0] = 0;
			//Loop through time units
			for(int j = 1; j <= timeUnits; j++){
				//Read line
				String line = br.readLine();
				//Split into altitude and elevator
				String[] lineSplit = line.split(",");
				//fill 2d array with proper values
				info[0][j] = Integer.parseInt(lineSplit[0]);
				info[1][j+1] = Integer.parseInt(lineSplit[1]);
			}
			//re-loop through time units, using the data from the array we just made 
			for(int k = 1; k < timeUnits + 1; k++){ 
				//A couple of conditions must be checked. First is that if the current altitude is 500ft or less above the ground, which is easy
				//Just use if(info[0][x] - info[1][x] <= 500){then print}
				//But first we must check if a crash is anticipated first. This can be achieved with an if-else if system
				
				//To anticipate a crash, we have to essentially see if the two "lines" intersect. This can be done by taking slope(current divided by previous) of both "lines"
				//and apply that slope to the current altitude line for the next time unit. If the simulated position of the next time unit for altitude is less than
				//the position of the ground at that time unit, then a crash will be predicted
				double altitudeSlope;
				//If previous point is not zero
				if(info[0][k-1] != 0){
					//Set slope to the current divided by previous 
					altitudeSlope = (double)info[0][k] / info[0][k-1];
				}
				//if previous is zero 
				else{
					//Set altitude to current point 
					altitudeSlope = (double)info[0][k];
				}
				//Initialize the predicted altitude at the next time unit that would occur
				double predictedAltitudeAtNextTimeUnit;
				//If slope is not zero 
				if(altitudeSlope != 0){
					//Set predicted altitude to current multiplied by slope 
					predictedAltitudeAtNextTimeUnit = info[0][k] * altitudeSlope;
				}
				//if slope is zero
				else{
					//set predicted to the same value at the current altitude 
					predictedAltitudeAtNextTimeUnit = info[0][k];
				}
				//if the predicted point is less than the next point(under), a crash would happen
				if(info[1][k+1] >= predictedAltitudeAtNextTimeUnit){ //If system anticipates a crash
					System.out.println("PULL UP!");
				}
				//if a crash is not anticipated but the altitude is 500 ft or less above the ground, then the flight has low altitude
				else if(info[0][k] - info[1][k] <= 500){ //The system does not anticipate a crash, but alititude is 500ft or less above the ground 
					System.out.println("Low Altitude!");
				}
				//everything is fine, print ok 
				else{ //The system does not anticipate a crash and altitude greater than 500 feet above the ground 
					System.out.println("ok");
				}
			}
		}
		br.close();
	}
}


