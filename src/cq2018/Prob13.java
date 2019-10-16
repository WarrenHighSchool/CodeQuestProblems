package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Prob13 {
    //String to file path
    public static final String filePath = "inputs/2018/Prob13.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get number of people
                int numPeople = Integer.parseInt(br.readLine());
                //Get string of data
                String data = br.readLine();
                /*
                * Since we get the names of the people in the string of data, there really
                * isn't any use storing their names right now, but the readLine() must still
                * be called to ensure that the BufferedReader parses the input file correctly
                */
                for(int i = 0; i < numPeople; i++){
                    br.readLine();
                }
                //Remove the outside brackets so we can deal with individual arrays
                data = data.substring(1, data.length()).substring(0, data.length() - 2);
                //Find and note indexes of opening brackets
                List<Integer> openingIndexes = new ArrayList<>();
                for(int i = 0; i < data.length(); i++){
                    if(data.charAt(i) == '['){
                        openingIndexes.add(i);
                    }
                }
                //Find and note indexes of closing brackets
                List<Integer> closingIndexes = new ArrayList<>();
                for(int i = 0; i < data.length(); i++){
                    if(data.charAt(i) == ']'){
                        closingIndexes.add(i);
                    }
                }
                //Get String arrays of individual elements for each array
                String[] names = data.substring(openingIndexes.get(0) + 1, closingIndexes.get(0)).split(",");
                String[] ages = data.substring(openingIndexes.get(1) + 1, closingIndexes.get(1)).split(",");
                String[] instas = data.substring(openingIndexes.get(2) + 1, closingIndexes.get(2)).split(",");
                String[] twitters = data.substring(openingIndexes.get(3) + 1, closingIndexes.get(3)).split(",");
                String[] mobiles = data.substring(openingIndexes.get(4) + 1, closingIndexes.get(4)).split(",");
                String[] emails = data.substring(openingIndexes.get(5) + 1, closingIndexes.get(5)).split(",");
                //Parse through each array and print a string for a person's profile
                for(int i = 0; i < numPeople; i++){
                    System.out.printf("Name: %s\nAge: %s\nInstagram: %s\nTwitter: %s\nPhone: %s\nEmail: %s\n",
                            names[i], ages[i], instas[i], twitters[i], mobiles[i], emails[i]);
                }
            }
            //Close the BufferedReader object
            br.close();
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
