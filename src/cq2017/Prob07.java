package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Prob07 {

    //Batter class
    public static class Batter{
        public String name;
        public int atBats;
        public int singles;
        public int doubles;
        public int triples;
        public int homes;

        public Batter(String name, String[] batData){
            this.name = name;
            for(String s : batData){
                switch(s){
                    case "K":atBats++;
                    break;
                    case "1B":atBats++; singles++;
                    break;
                    case "2B":atBats++; doubles++;
                    break;
                    case "3B":atBats++; triples++;
                    break;
                    case "HR":atBats++; homes++;
                }
            }
            calculateSLG();
        }

        public double calculateSLG(){
            return (((1 * singles) + (2 * doubles) + (3 * triples) + (4 * homes) + 0.0) / (atBats + 0.0));
        }
    }

    //String to file
    public static final String filePath = "inputs/2017/Prob07.in.txt";

    public static void main(String[] args){
        try{
            //New DecimalFormat
            DecimalFormat df = new DecimalFormat("0.000");
            df.setRoundingMode(RoundingMode.HALF_UP);
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                String inLine = br.readLine();
                String[] lineSpl = inLine.split(":");
                Batter b = new Batter(lineSpl[0], lineSpl[1].split(","));
                System.out.println(b.name + "=" + df.format(b.calculateSLG()));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
