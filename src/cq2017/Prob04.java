package cq2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class Prob04 {
    private static final String INPUT_FILE_NAME = "inputs/2017/Prob04.in.txt";
    
    public static void main(String[] args) {
        try {
            // prepare to read the file
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;
            
            // get the number of test cases
            int T = Integer.parseInt(br.readLine());
            /*
			int[] fibb = new int[90];
			fibb[0] = 0;
			fibb[1] = 1;
			for(int i = 2; i < fibb.length; i++){
				fibb[i] = fibb[i - 1] + fibb[i-2];
			}
			*/
			BigInteger[] fibb = new BigInteger[90];
			fibb[0] = new BigInteger("0");
			fibb[1] = new BigInteger("1");
			for(int i = 2; i < fibb.length; i++){
				BigInteger addition = fibb[i - 1].add(fibb[i-2]);
				fibb[i] = addition;
			}
            // loop through test cases
            while (T-- > 0) {
                inLine = br.readLine();
				int index = Integer.parseInt(inLine);
				System.out.println(fibb[index - 1]);
            }
            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
