package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Prob07 {
    public static final String filePath = "inputs/2018/Prob07.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Grab number of following lines
                int N = Integer.parseInt(br.readLine());
                //Initialize a boolean array to represent if the words ara palindromes.
                boolean[] palindromes = new boolean[N];
                //The indexes will correspond to the indexes for the N amount of words
                for(int i = 0; i < N; i++){
                    //Get case-insensitive string
                    String word = br.readLine().toLowerCase();
                    //Make a character array of the word
                    char[] letters = word.toCharArray();
                    //Initialize a boolean for if the current word is a palindrome
                    //Default to true and set to false if it isn't
                    boolean isPalindrome = true;
                    //Loop through the character array, checking the letters
                    for(int j = 0; j < letters.length; j++){
                        if(!(letters[j] == letters[letters.length - 1 - j])){
                            isPalindrome = false;
                        }
                    }
                    //Input into array
                    palindromes[i] = Boolean.valueOf(isPalindrome);
                }
                //Initialize a boolean for if all words are palindromes
                boolean allPalindromes = true;
                //Initialize a StringBuffer so we don't have to loop twice when checking our numbers
                StringBuilder sb = new StringBuilder();
                //Loop through the boolean array of palindromes
                for(int i = 0; i < palindromes.length; i++){
                    if(!palindromes[i]){
                        if(allPalindromes){
                            sb.append("False - ");
                            allPalindromes = false;
                        }
                        sb.append((i + 1));
                        sb.append(", ");
                    }
                }
                //Print out correct message
                if(allPalindromes){
                    //Just true
                    System.out.println("True");
                }else{
                    //Formatted message with last comma removed
                    System.out.println(sb.toString().substring(0, sb.length() - 2));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
