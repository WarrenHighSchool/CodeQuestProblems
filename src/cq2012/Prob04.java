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
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String key = br.readLine();
            char[] keySet = key.toCharArray();
            String inLine = "";
            while((inLine = br.readLine()) != null){
                String decodedMsg = "";
                String[] words = inLine.split(" ");
                for(int i = 0; i < words.length; i++){
                    String[] letters = words[i].split("-");
                    for(int j = 0; j < letters.length; j++){
                        decodedMsg += keySet[Integer.parseInt(letters[j]) - 1];
                    }
                    decodedMsg += ' ';
                }
                System.out.println(decodedMsg);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
