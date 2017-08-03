package cq2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by rober on 8/2/2017.
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
                Map<Integer, Integer> modeMap = new HashMap<Integer, Integer>();
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
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
