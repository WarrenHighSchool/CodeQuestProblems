package cq2016;

import java.io.*;

public class Prob03{
    public static void main(String[] args) throws IOException{
        //Sides of the triangles
        int firstSide = 0;
        int secondSide = 0;
        int thirdSide = 0;
        //Path to text file(in this example, the text file is in the same directory as the java file)
        String filePath = "inputs/2016/Prob03.in.txt";
        //New BufferedReader obeject of a FileReader which reads the text file
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        //Read first line to obtain test cases in string form
        String testCasesStr = br.readLine();
        //Convert test cases string into int 
        int testCases = Integer.parseInt(testCasesStr);
        //Loop through each line using the amount of test cases as a conditional
        for(int i = 0; i < testCases; i++){
            //Read line 
            String line = br.readLine();
            //Remove all commas
            String newLine = line.replace(",", "");
			//Split newLine into 3 different numbers
			String[] sides = newLine.split(" ");
            //Initialize strings for each loop
            String firstNumber = sides[0];
            String secondNumber = sides[1];
            String thirdNumber = sides[2];
			//Parse into int
			firstSide = Integer.parseInt(firstNumber);
			secondSide = Integer.parseInt(secondNumber);
			thirdSide = Integer.parseInt(thirdNumber);
            //Call method to print triangle type 
            printTriangleType(firstSide, secondSide, thirdSide);{   
            }
        }  
		br.close();
    }
    
    public static void printTriangleType(int side1, int side2, int side3){
        //Initialize string for type because of how java conditionals and returns work
        String type;
        //Make new array for triangle sides 
        int[] sides = {side1, side2, side3};
        //Check if it is actually a triangle 
        if(sides[0] + sides[1] > sides[2] && sides[0] + sides[2] > sides[1] && 
        sides[1] + sides[2] > sides [0]){
            //Equilateral triangle first
            if(sides[0] == sides[1] && sides[1] == sides[2]){
                type = "Equilateral";
            }
            //Now scalene
            else if(sides[0] != sides[1] && sides[1] != sides[2] && sides[0] != sides[2]){
                type = "Scalene";
            }
            //Now isosceles, since it cannot be any of the others
            else{
                type = "Isosceles";
            }
            //Print out which type of triangle it is 
            System.out.println(type);
        }   
        else{
			System.out.println("Not a Triangle");
		}
	}
}