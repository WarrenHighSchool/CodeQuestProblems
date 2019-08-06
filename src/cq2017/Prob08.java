package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class Prob08 {
    //String to file
    public static final String filePath = "inputs/2017/Prob08.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Grab inline of distance and speed(as a string array)
                String[] inLine = br.readLine().split(" ");
                //Set distance
                double distance = Double.parseDouble(inLine[0]) * 1_000_000L;
                //Set speed and divide by 3600 to get it in miles per second(more precise)
                double speed = Double.parseDouble(inLine[1]) / 3600.0;
                System.out.println(distance + "/" + speed);
                //Calculate time needed(in seconds)
                double time = (distance/speed);
                System.out.println(time);
                //Get amount of seconds in a day
                long SECONDS_IN_DAY = TimeUnit.DAYS.toSeconds(1);
                //Divide(and round down) the time needed by seconds in a day to get days needed
                int days_needed = (int)(time/SECONDS_IN_DAY);
                //Subtract the amount of seconds for days needed from the total time
                time -= (days_needed * SECONDS_IN_DAY);
                //Get amount of seconds in an hour
                long SECONDS_IN_HOUR = TimeUnit.HOURS.toSeconds(1);
                //Divide and round down the time needed by seconds in an hour to get hours needed
                int hours_needed = (int)(time/SECONDS_IN_HOUR);
                //Subtract the amount of seconds for days needed from the total time
                time -= (hours_needed * SECONDS_IN_HOUR);
                //Get amount of seconds in a minute
                long SECONDS_IN_MINUTE = TimeUnit.MINUTES.toSeconds(1);
                //Divide and round down the time needed by seconds in a minute to get minutes needed
                int minutes_needed = (int)(time / SECONDS_IN_MINUTE);
                //Subtract the amount of seconds for minutes needed from the total time
                time -= (minutes_needed * SECONDS_IN_MINUTE);
                //Time will now be equal the the rest of the seconds needed
                System.out.printf("Time to Mars: %d days, %d hours, %d minutes, %d seconds\n", days_needed, hours_needed, minutes_needed, (int)time);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
