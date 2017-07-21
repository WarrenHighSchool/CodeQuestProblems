package cq2016;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Created by RobertPC on 7/21/2017.
 */
public class Prob03_v2 {
    public static final String filePath = "inputs/2016/Prob03.in.txt";

    public static void main(String[] args){
        try{
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0) {
                //Read line
                String line = br.readLine();
                //Split it
                String[] tokens = line.split(", ");
                //Print the right triangle type
                printTriangleType(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
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
