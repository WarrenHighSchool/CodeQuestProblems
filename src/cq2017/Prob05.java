//Template for problems

package cq2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Prob05 {
    //String to file
    public static final String filePath = "inputs/2017/Prob05.in.txt";

    public static void main(String[] args){
        try{
            //Initialize bufferedreader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Get test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Grab file inputs
                String lastYear = br.readLine();
                String thisYear = br.readLine();
                //Split into names
                String[] lastYearNames = lastYear.split(",");
                String[] thisYearNames = thisYear.split(",");
                /*
                Use a hashmap to identify the people who have donated and which year they have
                Value 1 = Only donated last year
                Value 2 = Donated both years
                Value 3 = Only donated this year
                */
                Map<String, Integer> names = new HashMap<>();
                //Autofill last year names with values of 1
                for(String s : lastYearNames){
                    names.put(s, 1);
                }
                //Fill this year names. If the hashmap contains a person's name, they donated both years,
                //so give them a value of 2. Otherwise, give people who haven't appeared yet a value of 3
                //for the this year only donations
                for(String s : thisYearNames){
                    if(names.containsKey(s)){
                        int val = names.get(s);
                        names.put(s, (val + 1));
                    } else{
                        names.put(s, 3);
                    }
                }
                //Initialize lists for people in different categories
                List<String> lastOnly = new ArrayList<>();
                List<String> both = new ArrayList<>();
                List<String> thisOnly = new ArrayList<>();
                //Grab iterator for names hashmap
                Iterator it = names.keySet().iterator();
                //Arrange the names into their proper list
                while(it.hasNext()){
                    String k = (String)it.next();
                    int v = names.get(k);
                    switch(v){
                        case 1: lastOnly.add(k);
                        break;
                        case 2: both.add(k);
                        break;
                        case 3: thisOnly.add(k);
                    }
                }
                //Sort
                Collections.sort(lastOnly);
                Collections.sort(both);
                Collections.sort(thisOnly);
                //Buffer for String
                StringBuilder buf = new StringBuilder();
                //Add last year only names to buffer
                for(int i = 0; i < lastOnly.size(); i++) {
                    if(i == lastOnly.size() - 1){
                        buf.append(lastOnly.get(i));
                    }else{
                        buf.append(lastOnly.get(i) + ",");
                    }
                }
                buf.append("\n");
                //Add both year names to buffer
                for(int i = 0; i < both.size(); i++) {
                    if(i == both.size() - 1){
                        buf.append(both.get(i));
                    }else{
                        buf.append(both.get(i) + ",");
                    }
                }
                buf.append("\n");
                //Add only this year names to buffer
                for(int i = 0; i < thisOnly.size(); i++) {
                    if(i == thisOnly.size() - 1){
                        buf.append(thisOnly.get(i));
                    }else{
                        buf.append(thisOnly.get(i) + ",");
                    }
                }
                System.out.println(buf.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
