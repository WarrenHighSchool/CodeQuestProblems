package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob02 {
    public static final String filePath = "inputs/2018/Prob02.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Grab text
                String inLine = br.readLine();
                //Initalize a vowel counter
                int vowelCount = 0;
                //Loop through the characters in the string
                for(int i = 0; i < inLine.length(); i++){
                    //Grab current char
                    char inChar = inLine.charAt(i);
                    //If current char is vowel, increment counter
                    if(isVowel(inChar))
                        vowelCount++;
                }
                //Print out number of vowels
                System.out.println(vowelCount);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }

    public static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
