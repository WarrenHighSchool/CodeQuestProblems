package cq2015;

import java.io.*;
import java.util.ArrayList;

public class Prob07{
	//Path to file 
	public static final String filePath = "Prob07.in.txt";
	//Class for enemy ships
	public static class EnemyShip{
		//Instance variables
		public String name;
		public String classType;
		public int x;
		public int y;
		//Constructor
		public EnemyShip(String name, String classType, int x, int y){
			this.name = name;
			this.classType = classType;
			this.x = x;
			this.y = y;
		}
		//Advances the ship based on the class type of the ship
		public void advance(){
			switch(classType){
				case "A": x -= 10;
				break;
				case "B": x -= 20;
				break;
				case "C": x -= 30;
				break;
			}
		}
		//Getter method to get x location
		public int getX(){
			return x;
		}
		//Getter method to get y location
		public int getY(){
			return y;
		}
		//Return in format of name and the ship's x location
		public String toString(){
			return name + " xLoc: " + x;
		}
	}
	//Main
	public static void main(String[] args){
		try{
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Read test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases 
			while(T-- > 0){
				//Read numbers of alien ships that follow
				int N = Integer.parseInt(br.readLine());
				//Initialize ArrayList of EnemyShip objects 
				ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();
				//Loop through numShips
				for(int i = 0; i < N; i++){
					//Read line 
					String line = br.readLine();
					//Split into <ShipName> and <Class>:<X>,<Y>
					String[] nameAndClassSplit = line.split("_");
					//Split <Class>:<X>,<Y> into <Class> and <X>,<Y>
					String[] classAndPosSplit = nameAndClassSplit[1].split(":");
					//Split <X>,<Y> into <X> and <Y>
					String[] posSplit = classAndPosSplit[1].split(",");
					//Assign proper Strings 
					String shipName = nameAndClassSplit[0];
					String shipClass = classAndPosSplit[0];
					int xPos = Integer.parseInt(posSplit[0]);
					int yPos = Integer.parseInt(posSplit[1]);
					//Make new object and assign into our ArrayList
					enemyShips.add(new EnemyShip(shipName, shipClass, xPos, yPos));
				}
				//Initialize amount destroyed
				int amtDestroyed = 0;
				while(amtDestroyed < N){
					//find lowest x. if x's are same, compare the two to get lowest y
					EnemyShip curLowest = enemyShips.get(0);
					for(int i = 1; i < enemyShips.size(); i++){
						//Get current EnemyShip object
						EnemyShip curShip = enemyShips.get(i);
						//Compare x's 
						if(curLowest.getX() > curShip.getX()){
							curLowest = curShip;
						}
						if(curLowest.getX() == curShip.getX()){
							if(curLowest.getY() > curShip.getY()){
								curLowest = curLowest;
							}
							else{
								curLowest = curShip;
							}
						}
					}
					//Once found the lowest x(or highest y with lowest x), mark index it is at
					int destrIndex = enemyShips.indexOf(curLowest);
					//once print out proper message that it is removed
					System.out.println("Destroyed Ship: " + curLowest.toString());
					//remove ship from arraylist 
					enemyShips.remove(destrIndex);
					//call function to move all ships after we destroy one
					for(int i = 0; i < enemyShips.size(); i++){
						enemyShips.get(i).advance();
					}
					//Increase destroyed count
					amtDestroyed++;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}