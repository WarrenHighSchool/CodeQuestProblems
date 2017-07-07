package cq2016;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by RobertPC on 7/5/2017.
 */
public class Prob07_v2 {
    public static final String filePath = "inputs/2016/Prob07.in.txt";

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0){
                int M = Integer.parseInt(br.readLine());
                String[] message = new String[M];
                for(int i = 0; i < M; i++){
                    message[i] = br.readLine();
                }
                String startCorStr = br.readLine();
                String[] startCorSpl = startCorStr.split(",");
                int startX = Integer.parseInt(startCorSpl[0]);
                int startY = Integer.parseInt(startCorSpl[1]);
                int N = Integer.parseInt(br.readLine());
                String[] coverMsg = new String[N];
                for(int i = 0; i < N; i++){
                    coverMsg[i] = br.readLine();
                }
                //Make a new message which is derived from the startx and starty
                String[] newMsg = new String[N];
                for(int i = startX; i < message.length; i++){
                    String curString = message[i];
                    newMsg[i - startX] = curString.substring(startY);
                }
                String outputMsg = "";
                for(int i = 0; i < coverMsg.length; i++){
                    for(int j = 0; j < coverMsg[i].length(); j++){
                        if(coverMsg[i].charAt(j) == 'O'){
                            outputMsg += newMsg[i].charAt(j);
                        }
                    }
                }
                System.out.println(outputMsg);
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
