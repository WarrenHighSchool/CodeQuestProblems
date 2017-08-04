package cq2014;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 7/23/2017.
 */
public class Prob05 {
    //String to file
    public static final String filePath = "inputs/2014/Prob05.in.txt";

    public static void main(String[] args){
        try{
            //Initalize inLine
            String inLine = "";
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Replace the dashes with blanks
                String newLine = inLine.replace("-", "");
                //Initialize switch for 1 and 3
                int switcher = 1;
                //Initialize total
                int total = 0;
                //Initialize total before checkbit
                int totalBeforeCheck = 0;
                //Split to array of ints and fill it
                int[] nums = new int[newLine.length()];
                for(int i = 0; i < newLine.length(); i++){
                    nums[i] = Integer.parseInt(Character.toString(newLine.charAt(i)));
                }
                //Loop through nums array
                for(int i = 0; i < nums.length; i++){
                    //Add the total sum
                    total += (switcher * nums[i]);
                    //Alternate the switching multiplier respecitvely
                    if(switcher == 1){
                        switcher = 3;
                    }
                    else{
                        switcher = 1;
                    }
                    if(i == nums.length - 2){
                        totalBeforeCheck = total;
                    }
                }
                //Check if valid or not
                if(total % 10 == 0){
                    //If so, print valid
                    System.out.println("VALID");
                }
                else{
                    //Otherwise print the bit that would make it valid
                    System.out.println(findProperCheckBit(totalBeforeCheck));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Finds the proper check bit for the total BEFORE the check bit was implemented
     *
     * @param total the total before the check bit's number has been added
     * @return the check bit that would make the total valid
     */
    public static int findProperCheckBit(int total){
        for(int i = 0; i < 10; i++){
            if((total + i) % 10 == 0){
                return i;
            }
        }
        return -1;
    }
}
