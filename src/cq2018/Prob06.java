package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Prob06 {
    public static final String filePath = "inputs/2018/Prob06.in.txt";

    public static void main(String[] args){
        try{
            //Initialize and fill hashmap with constant values for LED
            HashMap<Integer, String> ledValues= new HashMap<>();
            ledValues.put(0, "off");
            ledValues.put(1, "red");
            ledValues.put(2, "green");
            ledValues.put(3, "blue");
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get individual words
                String[] inLineWords = br.readLine().split(" ");
                //Initialize int for total
                int total = 0;
                //Loop through individual states
                for(int i = 0; i < inLineWords.length; i++){
                    //Grab current word
                    String curWord = inLineWords[i];
                    //Battery(point value: 8)
                    if(i == 0){
                        if(curWord.equals("BROKEN"))
                            total += 8;
                    }
                    //Heat Exchanger(point value: 4)
                    if(i == 1){
                        if(curWord.equals("BROKEN"))
                            total += 4;
                    }
                    //Water Pump(point value: 2)
                    if(i == 2){
                        if(curWord.equals("BROKEN"))
                            total += 2;
                    }
                    //Temperature Sensor(point value: 1)
                    if(i == 3){
                        if(curWord.equals("BROKEN"))
                            total += 1;
                    }
                }
                /*
                    Algorithm for calculating LED values
                    Variables:  T = total value(obtained from sensor failures)
                                L = left left
                                R = right value

                    Equation:   4L + R = T
                                4L = T - R //R must be chosen to have T - R be divisible by 4, therefor (T - R) mod 4 = 0
                                R = T mod 4 //Since R will be the remainder from T/4, subtracting R from T will make it
                                                satisfy the condition (T  - R) mod 4 = 0
                                L = (T - R)/4
                */
                //Get the value for the right LED
                int right = total % 4;
                //Get the value for the left LED
                int left = (total - right)/4;
                //Print out the respective colors(left LED to right LED)
                System.out.println(String.format("%s %s", ledValues.get(left), ledValues.get(right)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }

    }
}
