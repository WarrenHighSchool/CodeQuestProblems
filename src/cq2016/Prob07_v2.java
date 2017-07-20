package cq2016;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 7/5/2017.
 */
public class Prob07_v2 {
    //String to filePath
    public static final String filePath = "inputs/2016/Prob07.in.txt";
    //Main
    public static void main(String[] args){
        try{
            //New BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //get amount of lines for message
                int M = Integer.parseInt(br.readLine());
                //Initialize string array with length M
                String[] message = new String[M];
                //Fill the array with the message
                for(int i = 0; i < M; i++){
                    message[i] = br.readLine();
                }
                //Grab string for start coordinate
                String startCorStr = br.readLine();
                //Split that with a comma
                String[] startCorSpl = startCorStr.split(",");
                //Get startX and startY values
                int startX = Integer.parseInt(startCorSpl[0]);
                int startY = Integer.parseInt(startCorSpl[1]);
                //Grab amount of lines for cover message(should be M - startY) 
                int N = Integer.parseInt(br.readLine());
                //Initialize array of string for cover message
                String[] coverMsg = new String[N];
                //Fill cover message string araay
                for(int i = 0; i < N; i++){
                    coverMsg[i] = br.readLine();
                }
                //Make a new message which is derived from the startx and starty
                //This takes the original message and trims it properly
                String[] newMsg = new String[N];
                //Fill trimmed message array
                for(int i = startX; i < message.length; i++){
                    String curString = message[i];
                    newMsg[i - startX] = curString.substring(startY);
                }
                //Initialize output message
                String outputMsg = "";
                //Concatenate the proper characters onto outputMsg
                //Since newMsg and coverMsg are the same in length, we can use 'i' and 'j' to ondex both simultaneously 
                //Loop through coverMsg
                for(int i = 0; i < coverMsg.length; i++){
                    //Loop through each selected string's characters
                    for(int j = 0; j < coverMsg[i].length(); j++){
                        //If current char is O, add the corresponding letter of the other array to outputMsg
                        if(coverMsg[i].charAt(j) == 'O'){
                            outputMsg += newMsg[i].charAt(j);
                        }
                    }
                }
                //Print it out
                System.out.println(outputMsg);
            }
            //Clean up 
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
