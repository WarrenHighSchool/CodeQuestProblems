package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RobertPC on 7/21/2017.
 */
public class Prob03 {
    //Prepare to read file
    public static final String filePath = "inputs/2013/Prob03.in.txt";

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Initialize hashmap
            Map<String, Integer> map = new HashMap<String, Integer>();
            //Initialize arraylist of names
            //We need to use an arraylist of names because we need to list the file extensions the way they were given in the file
            List<String> names = new ArrayList<String>();
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Split the line the right way
                String extension = inLine.split("\\.")[1];
                //If we dont already having a mapping for our extension, add one and make its value 1
                if(!map.containsKey(extension)){
                    names.add(extension);
                    map.put(extension, 0);
                }
                //Since we can't directly increment the Integer, get its value then set it to that value plus one
                Integer count = map.get(extension);
                //Put the proper value in
                map.put(extension, count + 1);
            }
            for(int i = 0; i < names.size(); i++){
                System.out.println(names.get(i) + " " + map.get(names.get(i)));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
