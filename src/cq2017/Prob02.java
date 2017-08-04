package cq2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Prob02 {
    private static final String INPUT_FILE_NAME = "Prob02.in.txt";
    
    public static void main(String[] args) {
        try {
            // prepare to read the file
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;
            
            // get the number of test cases
            int T = Integer.parseInt(br.readLine());
            
            // loop through test cases
            while (T-- > 0) {
                inLine = br.readLine();
				String[] lineSplit = inLine.split(" ");
				int nonIndex = Integer.parseInt(lineSplit[1]);
				String outputString = "";
				for(int i = 0; i < lineSplit[0].length(); i++){
					if(i != nonIndex){
						outputString += lineSplit[0].charAt(i);
					}
				}
				System.out.println(outputString);
            }
            
            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
