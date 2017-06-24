package cq2016;

import java.io.*;
import java.util.*;
/*
6/23/17 5:17 PM PST - Not finished
*/
public class Prob16{
	//Each cube
	public static class Star{
		private int energy;
		public int x;
		public int y;
		public int z;
		private boolean flewByAlready;
		
		public Star(int x, int y, int z){
			energy = 0;
			this.x = x;
			this.y = y;
			this.z = z;
			flewByAlready = false;
		}
		public void setEnergy(String energy){
			switch(energy){
				case "M":this.energy = 3;
				break;
				case "K":this.energy = 4;
				break;
				case "G":this.energy = 5;
				break;
				case "F":this.energy = 6;
				break;
				case "A":this.energy = 7;
				break;
				case "B":this.energy = 8;
				break;
				case "O":this.energy = 9;
				break;
			}
		}
		public String toString(){
			return "(" + x + ", " + y + ", " + z + ") Energy: " + energy;
		}
	}
	public static class Ship{
		//Instance variables for ship. Includes location, years traveled, and the level of the battery 
		public int x;
		public int y;
		public int z;
		private int yearsTraveled;
		private int batteryLevel;
		//Construct ship object 
		public Ship(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
			yearsTraveled = 0;
			batteryLevel = 20;
		}
		//Move the ship by a certain amount of x's, y's, and z's
		//Also account for these movements by increasing years traveled and decreasing battery level for each movement 
		public void move(int x, int y, int z){
			this.x += x;
			this.y += y;
			this.z += z;
			for(int a = x; a > 0; a--){
				yearsTraveled++;
				batteryLevel--;
			}
			for(int b = y; b > 0; b--){
				yearsTraveled++;
				batteryLevel--;
			}
			for(int c = z; c > 0; c--){
				yearsTraveled++;
				batteryLevel--;
			}
		}
		//Recharge the battery by a certain amount, but don't let the battery amount go above 20
		public void rechargeBattery(int amount){
			batteryLevel += amount;
			if(batteryLevel > 20){
				batteryLevel = 20;
			}
		}
	}
	//Print array of Stars(used for debug)
	public static void printArray(Star[][][] in){
		for(int i = 0; i < in.length; i++){
			for(int j = 0; j < in[0].length; j++){
				for(int k = 0; k < in[0][0].length; k++){
					System.out.println(in[i][j][k].toString());
				}
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//File path
		String file = "inputs/2016/Prob16.in.txt";
		//New BufferedResder object
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Get test cases
		int testCases = Integer.parseInt(br.readLine());
		//Loop through test cases 
		for(int i = 0; i < testCases; i++){
			//Grab cube amount
			int cubeAmount = Integer.parseInt(br.readLine());
			//Make a 3D array of Star objects with each length of cubeAmount
			Star[][][] cubeMap = new Star[cubeAmount][cubeAmount][cubeAmount];
			//Loop through and default all Star objects 
			for(int x = 0; x < cubeAmount; x++){
				for(int y = 0; y < cubeAmount; y++){
					for(int z = 0; z < cubeAmount; z++){
						cubeMap[x][y][z] = new Star(x, y, z);
					}
				}
			}
			//Grab numstars able to havest 
			int numStars = Integer.parseInt(br.readLine());
			//Loop through numstars 
			for(int j = 0; j < numStars; j++){
				//Read line
				String line = br.readLine();
				//Split accordingly. the indexes should be like so: line[0] = energy, line[1] = x; line[2] = y; line[3] = z
				String[] lineSplit = line.split(",");
				//make it easier to access variables
				String energy = lineSplit[0];
				int x = Integer.parseInt(lineSplit[1]);
				int y = Integer.parseInt(lineSplit[2]);
				int z = Integer.parseInt(lineSplit[3]);
				//modify the object and change energy 
				cubeMap[x][y][z].setEnergy(energy);
			}
			//Set destination star to numStars - 1
			Star destination = cubeMap[numStars - 1][numStars - 1][numStars - 1];
		}
	}
}

