package cq2015;

import java.io.*;

public class Prob10{
	//String to file 
	public static final String filePath = "Prob10.in.txt";
	//Main
	public static void main(String[] args){
		try{
			String inLine = "";
			//New BufferedReader Object 
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Initialize player point values 
			int p1 = 0;
			int p2 = 0;
			//Loop through file. No test cases is included here 
			while((inLine = br.readLine()) != null){
				boolean gameEnded = false;
				if(p1 == 0 && p2 == 0){
					System.out.println("Game start");
				}
				//Grab value of player to increase 
				int inLineValue = Integer.parseInt(inLine);
				//System.out.println("inline: " + inLineValue);
				//Increase properly
				if (inLineValue == 1){
					if(p1 < 30){
						p1 += 15;
					}
					else{
						//Win
						if(p2 != 50){
							p1 += 10;
						}
						//Player two has 50 points, take advantage from them back to duece
						else if(p2 == 50){
							p2 = 40;
						}
					}
					//System.out.println("P1 = " + p1);
				}
				else{
					if(p2 < 30){
						p2 += 15;
					}
					else{
						//Win
						if(p1 != 50){
							p2 += 10;
						}
						//Player one has 50 points, take advantage from them back to duece
						else if(p1 == 50){
							p1 = 40;
						}
					}
					//System.out.println("P2 = " + p2);
				}
				//Set winners. Winner is deterimed if a player has 60 points(advantage + another win)
				//or if the other player doesnt have 40 and the current player surpasses 40
				if(p1 == 60 || (p1 == 50 && p2 < 40)){
					System.out.println("Game Player 1");
					gameEnded = true;
					p1 = 0;
					p2 = 0;
				}
				else if(p2 == 60 || (p2 == 50 && p1 < 40)){
					System.out.println("Game Player 2");
					gameEnded = true;
					p1 = 0;
					p2 = 0;
				}
				//If tied up at 40 
				else if(p1 == 40 && p2 == 40){
					System.out.println("duece");
				}
				//
				else if(p1 == 50 && p2 == 40){
					System.out.println("Advantage Player 1");
				}
				else if(p2 == 50 && p1 == 40){
					System.out.println("Advantage Player 2");
				}
				//
				else if(p1 == p2 && p1 != 40){
					System.out.println(p1 + "-all");
				}
				else if(p1 == 0){
					System.out.println("love-" + p2);
				}
				else if(p2 == 0){
					System.out.println(p1 + "-love");
				}
				else{
					System.out.println(p1 + "-" + p2);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}