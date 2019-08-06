package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob11 {
    public static final String filePath = "inputs/2018/Prob11.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                //Get inLine string array
                String[] inLineArr = br.readLine().split(" ");
                //Start setting all values
                int Cr = Integer.parseInt(inLineArr[0]);
                int Cg = Integer.parseInt(inLineArr[1]);
                int Cb = Integer.parseInt(inLineArr[2]);
                int tolerance = Integer.parseInt(inLineArr[3]);
                int Fr = Integer.parseInt(inLineArr[4]);
                int Fg = Integer.parseInt(inLineArr[5]);
                int Fb = Integer.parseInt(inLineArr[6]);
                int Br = Integer.parseInt(inLineArr[7]);
                int Bg = Integer.parseInt(inLineArr[8]);
                int Bb = Integer.parseInt(inLineArr[9]);
                /*
                    Check if the foreground color is "close" enough the the chroma key.
                    If so, then output the color of the background. If not, then output
                    the color of the foreground
                */
                //Calculate "distance" between foreground color and chroma key
                double distance = Math.sqrt(
                        Math.pow((Cr - Fr), 2) + Math.pow((Cg - Fg), 2) + Math.pow((Cb - Fb), 2)
                );
                //Print out either background or foreground color based on distance-tolerance comparison
                if(distance <= tolerance){
                    System.out.printf("%d %d %d\n", Br, Bg, Bb);
                }else{
                    System.out.printf("%d %d %d\n", Fr, Fg, Fb);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
