package cq2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


/**
 * Created by RobertPC on 10/10/2017.
 */
public class Prob02 {
    public static final String filePath = "inputs/2014/Prob02.in.txt";

    public static class Card{
        //Instance variables
        private int number;
        private char suit;
        private String color;

        public Card(int number, char suit){
            this.number = number;
            this.suit = suit;
            color = getColor(suit);
        }

        /**
         * returns the color of the corresponding suit\
         *
         * @param suit the suit to find the color of
         * @return the color of that said suit
         */
        public String getColor(char suit){
            String color = null;
            switch(suit){
                case 'S':
                    color = "BLACK";
                break;
                case 'C':
                    color = "BLACK";
                break;
                case 'D':
                    color = "RED";
                break;
                case 'H':
                    color = "RED";
                break;
            }
            return color;
        }

        public String getSuit(){
            String returnString = null;
            switch(suit){
                case 'C': returnString = "CLUBS";
                    break;
                case 'D': returnString = "DIAMONDS";
                    break;
                case 'H': returnString = "HEARTS";
                    break;
                case 'S': returnString = "SPADES";
                    break;
            }
            return returnString;
        }

        public int getNumber(){ return number; }

        public char getSuitChar(){ return suit; }

        public String getColor(){ return color; }
    }
    public static void main(String[] args){
        try{
            //Setup mappings for special suit scenarios (jack = 11, queen = 12, king = 13, and ace = 14)
            Map<Character, Integer> suitMappings = new HashMap<>();
            fillSuitMappings(suitMappings);
            //Assign different sections for printing
            Map<String, Integer> COLORS = new HashMap<>();
            Map<String, Integer> SUITS = new HashMap<>();
            Map<Integer, Integer> NUMBERS = new HashMap<>();
            defaultSections(COLORS, SUITS, NUMBERS);
            //Initialize inLine
            String inLine;
            //Prepare to read file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Initialize hand count
            int handNum = 1;
            //Loop while not at end of text file
            while((inLine = br.readLine()) != null){
                List<Card> cardList = new ArrayList<>();
                String[] cards = inLine.split(" ");
                for(String s : cards){
                    String s1 = s.substring(0, s.length() - 1);
                    char c2 = s.charAt(s.length() - 1);
                    if(s1.matches("\\d+")){
                        cardList.add(new Card(Integer.parseInt(s1), c2));
                    } else {
                        cardList.add(new Card(suitMappings.get(s1.charAt(0)), c2));
                    }
                }
                System.out.println("HAND " + handNum);
                for(int i = 0; i < cardList.size(); i ++){
                    String color = cardList.get(i).getColor();
                    int colorVal = COLORS.get(color);
                    COLORS.put(color, (colorVal + 1));
                }
                Iterator colorIt = COLORS.keySet().iterator();
                while(colorIt.hasNext()){
                    String color = (String)colorIt.next();
                    System.out.println(COLORS.get(color) + "-" + color);
                }
                Iterator suitIt = SUITS.keySet().iterator();
                while(suitIt.hasNext()){
                    String color = (String)suitIt.next();
                    System.out.println(SUITS.get(color) + "-" + color);
                    /*

                    if(SUITS.get(color) != 1){

                    } else{
                        System.out.println(SUITS.get(color) + "-" + color.substring(0, color.length()));
                    }
                    */
                }
                handNum++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillSuitMappings(Map<Character, Integer> map){
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);
    }

    public static void defaultSections(Map<String, Integer> m1, Map<String, Integer> m2, Map<Integer, Integer> m3){
        m1.put("RED", 0);
        m1.put("BLACK", 0);
        m2.put("CLUBS", 0);
        m2.put("DIAMONDS", 0);
        m2.put("HEARTS", 0);
        m2.put("SPADES", 0);
        for(int i = 1; i <= 14; i++){
            m3.put(i, 0);
        }
    }
}
