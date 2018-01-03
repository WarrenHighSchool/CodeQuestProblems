//Template for problems

package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Prob06 {
    //String to file
    public static final String filePath = "inputs/2017/Prob06.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Build mappings
            Map<Character, String> mappings = new HashMap<>();
            fillMappings(mappings);
            //Loop through test cases
            while(T-- > 0){
                //get lines of text message
                int N = Integer.parseInt(br.readLine());
                //Loop through N messages
                while(N-- > 0){
                    //Grab line
                    String inLine = br.readLine();
                    //Convert to lower case
                    String line = inLine.toLowerCase();
                    //Initialize stringbuilder
                    StringBuilder icao = new StringBuilder();
                    //Split into words with spaces(so there isn't a dash and a space in
                    //one output)
                    String[] words = line.split(" ");
                    //Loop through individual words
                    for(String s : words){
                        //Loop through each letter of said word
                        for(int i = 0; i < s.length(); i++){
                            char cur = s.charAt(i);
                            //If not the last letter, append word and dash
                            if(i != s.length() - 1){
                                icao.append(mappings.get(cur) + "-");
                            } else{
                                //Otherwise just append word
                                icao.append(mappings.get(cur));
                            }
                        }
                        //Add a space for every word
                        icao.append(" ");
                    }
                    //Print
                    System.out.println(icao.toString());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillMappings(Map<Character, String> m){
        m.put('a', "Alpha");
        m.put('b', "Bravo");
        m.put('c', "Charlie");
        m.put('d', "Delta");
        m.put('e', "Echo");
        m.put('f', "Foxtrot");
        m.put('g', "Golf");
        m.put('h', "Hotel");
        m.put('i', "India");
        m.put('j', "Juliet");
        m.put('k', "Kilo");
        m.put('l', "Lima");
        m.put('m', "Mike");
        m.put('n', "November");
        m.put('o', "Oscar");
        m.put('p', "Papa");
        m.put('q', "Quebec");
        m.put('r', "Romeo");
        m.put('s', "Sierra");
        m.put('t', "Tango");
        m.put('u', "Uniform");
        m.put('v', "Victor");
        m.put('w', "Whiskey");
        m.put('x', "Xray");
        m.put('y', "Yankee");
        m.put('z', "Zulu");
    }
}
