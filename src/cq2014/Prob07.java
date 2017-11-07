package cq2014;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by RobertPC on 10/16/2017.
 */
public class Prob07 {
    public static final String filePath = "inputs/2014/Prob07.in.txt";

    public static void main(String[] args){
        try{
            //Initalize hashmap and fill it with the morse codes
            Map<String, String> morseCode = new HashMap<>();
            fillMorseCode(morseCode);
            String inLine = null;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            boolean doCipher = true;
            while((inLine = br.readLine()) != null) {
                StringBuilder buf = new StringBuilder();
                if (inLine.equals("END OF TRANSMISSION")) {
                    System.out.println("END OF TRANSMISSON");
                    doCipher = false;
                }
                else{
                    if (doCipher) {
                        //First section(normal text to morse code)
                        //Make all letters lowercase
                        String newString = inLine.toLowerCase();
                        //Split into words
                        String[] words = newString.split(" ");
                        //Loop through words
                        for (String s : words) {
                            //Loop through letters of each word
                            for (char c : s.toCharArray()) {
                                buf.append(morseCode.get(Character.toString(c)));
                                buf.append(morseCode.get("SPACE_LETTER"));
                            }
                            buf.append(morseCode.get("SPACE_WORD"));
                        }
                        System.out.println(buf.toString().substring(0, buf.toString().length() - 10));
                    } else {
                        //Second section(morse code to normal text)
                        //Split into word sections
                        String[] morseWords = inLine.split(morseCode.get("SPACE_WORD"));
                        for (String s : morseWords) {
                            //Split into letter sections
                            String[] morseLetters = s.split(morseCode.get("SPACE_LETTER"));
                            for (String s2 : morseLetters) {
                                buf.append(morseCode.get(s2));
                            }
                            buf.append(" ");
                        }
                        System.out.println(buf.toString().substring(0, buf.toString().length() - 1));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillMorseCode(Map<String, String> m){
        m.put("SPACE_WORD", "_______");
        m.put("SPACE_LETTER", "___");
        m.put("a", "=_===");
        m.put("b", "===_=_=_=");
        m.put("c", "===_=_===_=");
        m.put("d", "===_=_=");
        m.put("e", "=");
        m.put("f", "=_=_===_=");
        m.put("g", "===_===_=");
        m.put("h", "=_=_=_=");
        m.put("i", "=_=");
        m.put("j", "=_===_===_===");
        m.put("k", "===_=_===");
        m.put("l", "=_===_=_=");
        m.put("m", "===_===");
        m.put("n", "===_=");
        m.put("o", "===_===_===");
        m.put("p", "=_===_===_=");
        m.put("q", "===_===_=_===");
        m.put("r", "=_===_=");
        m.put("s", "=_=_=");
        m.put("t", "===");
        m.put("u", "=_=_===");
        m.put("v", "=_=_=_===");
        m.put("w", "=_===_===");
        m.put("x", "===_=_=_===");
        m.put("y", "===_=_===_===");
        m.put("z", "===_===_=_=");
        m.put("1", "=_===_===_===_===");
        m.put("2", "=_=_===_===_===");
        m.put("3", "=_=_=_===_===");
        m.put("4","=_=_=_=_===");
        m.put("5","=_=_=_=_=");
        m.put("6", "===_=_=_=_=");
        m.put("7", "===_===_=_=_=");
        m.put("8", "===_===_===_=_=");
        m.put("9", "===_===_===_===_=");
        m.put("0", "===_===_===_===_===");
        Map<String, String> tmp = new HashMap<>();
        Iterator it = m.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            String value = m.get(key);
            tmp.put(value, key);
        }
        m.putAll(tmp);
    }
}