package cq2016;

import java.io.*;

public class Prob01{
    
    public static void main(String[] args){
        try {
            //String to filepath
            String filePath = "src/cq2015/Prob01.in.txt";
            //Create new buffered reader object of a filereader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Read line for test cases
            String testCasesStr = br.readLine();
            //Parse into int
            int testCases = Integer.parseInt(testCasesStr);
            //Loop through test cases
            for (int i = 0; i < testCases; i++) {
                //read line
                String line = br.readLine();
                // Parse into int
                int value = Integer.parseInt(line.trim());
                //Draw board of value just obtained(look at method below)
                drawBoard(value);
            }
            //Clean up
            br.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    //Method to draw board of '#' using a nested for loop, by creating a n * n grid
     public static void drawBoard(int n){
        for(int i = 0; i < n; i++){ //Both loops iterate n times
            for(int j = 0; j < n; j++){
				//Print n amount of stars with space
                System.out.print("# ");    
            }
			//After n amount has printed, goto new line
            System.out.println();
        }
    }
}

