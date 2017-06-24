import java.io.*;
import java.lang.*;

public class Prob09{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to filePathe
		String filePath = "inputs/2016/Prob09.in.txt";
		//Create new bufferedreader
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//Grab test cases
		String testCasesStr = br.readLine();
		//parse to int
		int testCases = Integer.parseInt(testCasesStr);
		//loop through test cases 
		for(int i = 0; i < testCases; i++){
			//read line
			String line = br.readLine();
			//parse into three separate sections
			String[] lineSplit = line.split(" ");
			//Assign three separate variables
			int zoomLevel = Integer.parseInt(lineSplit[0]);
			double latitude = Double.parseDouble(lineSplit[1]);
			double longitude = Double.parseDouble(lineSplit[2]);
			//Calculate x
			double xDouble = Math.abs( ((longitude + 180)/360) * Math.pow(2, zoomLevel));
			//Calculate y 
			double yDouble = Math.abs(
				( 1 -  
					( 
						(
							Math.log(
								(
									(
										Math.tan(
											latitude * (Math.PI/180)
										)
									)
									+
									(
										1 / (Math.cos(latitude * (Math.PI/180)))
									)
								)
							)
						)
					 / Math.PI) 
				) * Math.pow(2, (zoomLevel-1))
			);
			int xInt = (int)xDouble;
			int yInt = (int)yDouble;
			System.out.println("http://title.openstreetmap.org/" + zoomLevel + "/" + xInt + "/" + yInt + ".png");
		}
	}
}