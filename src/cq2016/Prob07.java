import java.io.*;

public class Prob07{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to file path
		String filePath = "Prob07.in.txt";
		//Create buffered reader object of new file reader
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//Get test cases
		String testCasesStr = br.readLine();
		//Parse test case into into
		int testCases = Integer.parseInt(testCasesStr);
		//Loop through test cases
		for(int i = 0; i < testCases; i++){
			//Grab number of next lines
			String numberOfLinesStr = br.readLine();
			//Parse numberOfLines to int 
			int numberOfLines = Integer.parseInt(numberOfLinesStr);
			//Initialzie 2d string array for comparisons(first column is original, second is cover message)
			String[][] lines = new String[2][numberOfLines];
			//Loop through number of lines
			for(int j = 0; j < numberOfLines; j++){
				//Read line
				String line = br.readLine();
				//Store string value into 2d array 
				lines[0][j] = line;
			}
			//Get coordinate of where secret message starts 
			String startPointCoordinate = br.readLine();
			//Split into array that allowed us to get the 'x' and 'y' point
			String[] startPointCoordinateArray = startPointCoordinate.split(",");
			//Assign x and y values to intd
			int xStart = Integer.parseInt(startPointCoordinateArray[0]);
			int yStart = Integer.parseInt(startPointCoordinateArray[1]);
			//initialize string to store lines to cover
			String coverLineAmountStr = br.readLine();
			//Parse into int
			int coverLineAmount = Integer.parseInt(coverLineAmountStr);
			//Loop through cover lines
			for(int j = 0; j < coverLineAmount; j++){
				//Read line 
				String line = br.readLine();
				//Store value into 2d array
				lines[1][j] = line;
			}
			//Reformat array to subtract first xStart lines from original message, and substring based on yStart. New array will be formed
			String[][] newLines = new String[2][numberOfLines-xStart];
			//Initialzie newLines indexer
			int newLinesIndexer = xStart;
			//Fill array row 0 with the lineIndexer(which started at xStart), with the substring of y start(basically remove anything before that index)
			for(int j = 0; j < newLines[0].length; j++){
				newLines[0][j] = lines[0][newLinesIndexer].substring(yStart);
				newLinesIndexer++;
			}
			//Since we don't have to offset the indexer(since it is the cover message), we can set the value of newLinesIndexer to 0
			newLinesIndexer = 0;
			//Fill array row 1 with the coverMessage
			for(int j = 0; j < newLines[1].length; j++){
				newLines[1][j] = lines[1][newLinesIndexer];
				newLinesIndexer++;
			}
			//Initialize amountOfCovers int to find the amount of O's(since we have to set array length when initialized)
			int amountOfCovers = 0;
			//Find amount of showings by looping through second part of 2d array 
			for(int j = 0; j < newLines[0].length; j++){
				//Now loop through string
				for(int k = 0; k < newLines[1][j].length(); k++){
					if(newLines[1][j].charAt(k) == 'O'){
						amountOfCovers++;
					}
				}
			}
			//Make string array where indexes represent paragraph lines, and elements represents a strinng(that will be broken up later) containing the covers
			String[] matchingCovers = new String[numberOfLines - xStart];
			//Fill string array with blanks rather than the default value of null
			for(int j = 0; j < matchingCovers.length; j++){
				matchingCovers[j] = "";
			}
			//Fill array
			for(int j = 0; j < newLines[0].length; j++){
				//Loop through individual stirngs
				for(int k = 0; k < newLines[1][j].length(); k++){
					if(newLines[1][j].charAt(k) == 'O'){
						matchingCovers[j] += k + " "; //This will also put a space at the end, ensuring that String.split will work
					}
				}
			}
			//Initialize string to print
			String outputMessage = "";
			//Compare newLines[0][index] with matchingCovers
			for(int j = 0; j < newLines[0].length; j++){
				//Split string array with space to get separate numbers
				String[] indexesStr = matchingCovers[j].split(" ");
				//Turn into an array of ints
				int[] indexes = new int[indexesStr.length];
				//Fill indexes
				for(int k = 0; k < indexes.length; k++){
					indexes[k] = Integer.parseInt(indexesStr[k]);
				}
				//Now find letters with indexes
				for(int k = 0; k < indexes.length; k++){
					outputMessage += newLines[0][j].charAt(indexes[k]);
				}
			}
			//Print out message 
			System.out.println(outputMessage);
		}
		//Close buffered reader 
		br.close();
	}
}