package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

/**
 * Created by RobertPC on 8/2/2017.
 */
public class Prob09 {
    //String to file
    public static final String filePath = "inputs/2013/Prob09.in.txt";

    public static void main(String[] args){
        try{
            //Initialize inLine
            String inLine = "";
            //Initialize DecimalFormat and set rounding mode
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.HALF_UP);
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Keep track of sets
            int setCount = 1;
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Initialize hashmap
                //A key in the hashmap will be a value from the data set
                //A value in the hashmap will be the number that the specific number has appeared
                Map<Integer, Integer> modeMap = new HashMap<>();
                //Split into tokens
                String[] tokens  = inLine.split(",");
                //Initialize array of integers for that
                int[] numbers = new int[tokens.length];
                //Fill the numbers array with ints
                for(int i = 0; i < tokens.length; i++){
                    numbers[i] = Integer.parseInt(tokens[i]);
                }
                //Sort that array
                Arrays.sort(numbers);
                double mean = 0.0;
                //Find mean
                for(int i = 0; i < numbers.length; i++){
                    mean += numbers[i];
                }
                mean = (double)mean/numbers.length;
                double median = 0.0;
                //Find median
                if(numbers.length % 2 == 0){
                    median = (double)(numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2])/2;
                }
                else{
                    median = numbers[numbers.length / 2];
                }
                //Add to modeMap
                for(int i = 0; i < numbers.length; i++){
                    if(!modeMap.containsKey(numbers[i])){
                        modeMap.put(numbers[i], 0);
                    }
                    int count = modeMap.get(numbers[i]);
                    modeMap.put(numbers[i], count + 1);
                }
                //Iterator to loop through our hashmap
                Iterator i = modeMap.keySet().iterator();
                //ArrayList to keep track of modes(will only contain one element if there is one mode)
                ArrayList<Integer> modes = new ArrayList<>();
                //Initialize appeared mode int
                int best = -1;
                //Loop through hashmap
                while(i.hasNext()){
                    //Retrieve the key
                    Integer k = (Integer)i.next();
                    //Retrieve the value for that key
                    Integer v = modeMap.get(k);
                    //Set the highest amount of times a number has appeared
                    if(v > best){
                        best = v;
                    }
                }
                //Re-set iterator to the start of the hashmap
                i = modeMap.keySet().iterator();
                while(i.hasNext()){
                    //Grab the current key
                    Integer k = (Integer)i.next();
                    //Grab the value for that key
                    Integer v = modeMap.get(k);
                    //If the value is the same as the best, the key(s) is/are the mode
                    if(v == best){
                        modes.add(k);
                    }
                }
                //Construct modeString
                String modeString = "";
                for(int k = 0; k < modes.size(); k++){
                    modeString += modes.get(k) + ",";
                }
                //Remove last comma
                modeString = modeString.substring(0, modeString.length() - 1);
                //Print out properly
                System.out.println("Set " + setCount + ": Mean=" + df.format(mean) + ", Median=" + df.format(median) + ", Mode=" + modeString);
                //Increment setCount
                setCount++;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
