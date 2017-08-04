package cq2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Prob03 {
    private static final String INPUT_FILE_NAME = "Prob03.in.txt";
    
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
				int firstInt = Integer.parseInt(lineSplit[0]);
				int secondInt = Integer.parseInt(lineSplit[1]);
				int addSum = firstInt + secondInt;
				int mulSum = firstInt * secondInt;
				System.out.println(addSum + " " + mulSum);
            }
            
            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
