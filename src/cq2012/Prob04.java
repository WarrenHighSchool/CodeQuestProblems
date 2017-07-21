package cq2012;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Created by RobertPC on 6/29/2017.
 */
public class Prob04 {
    public static final String filePath = "inputs/2012/Prob04.in.txt";

    public static void main(String[] args){
        try{
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Read key into memory
            String key = br.readLine();
            //Split key into an array of chars
            char[] keySet = key.toCharArray();
            //Initialize inLine
            String inLine = "";
            //Loop while br isn't at end of file
            while((inLine = br.readLine()) != null){
                //Initialize decoded message
                String decodedMsg = "";
                //Split the message by spaces(so each index will contain a word)
                String[] words = inLine.split(" ");
                //Loop through each word
                for(int i = 0; i < words.length; i++){
                    //Now split it into each letter
                    String[] letters = words[i].split("-");
                    //Loop through that letters array
                    for(int j = 0; j < letters.length; j++){
                        //Add the letter from the keySet of the index which is letters[j]
                        decodedMsg += keySet[Integer.parseInt(letters[j]) - 1];
                    }
                    //Add a space so each word is separated
                    decodedMsg += ' ';
                }
                //Print it out
                System.out.println(decodedMsg);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
