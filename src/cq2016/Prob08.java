package cq2016;

import java.io.*;
import java.util.*;
import static java.lang.String.CASE_INSENITIVE_ORDER;

public class Prob08{
	//Song class to keep track of song-artist pairs 
	public static class Song{
		public String name;
		public String author;
		
		public Song(String name, String author){
			this.name = name;
			this.author = author;
		}
		
		public String effectiveAuthor(){
			return author.replace("The ", "");
		}
		
		public String toString(){
			return name + " - " + author;
		}
	}
	//comparator for sorting the array of song objects 
	public static class SongComparator implements Comparator<Song>{
		public int compare(Song a, Song b){
			//To prevent authors with all capitals in their name from being sorted impropely, we take the effective authors, split them up, take their first word, 
			//and make sure only the first letter is capitalized. We ignore the rest of the words for purposes of sorting 
			String aEff = a.effectiveAuthor();
			String bEff = b.effectiveAuthor();
			String[] aEffSplit = aEff.split(" ");
			String[] bEffSplit = bEff.split(" ");
			String aFirst = aEffSplit[0].substring(0, 1) + aEffSplit[0].substring(1).toLowerCase();
			String bFirst = bEffSplit[0].substring(0, 1) + bEffSplit[0].substring(1).toLowerCase();
			//First compare the authors to each other
			//Implement CASE_INSENITIVE_ORDER later
			int rslt = aFirst.compareTo(bFirst);
			//if the authors are the same, the value of rslt will be 0. we can then compare songs 
			if(rslt == 0){
				rslt = a.name.compareTo(b.name);
			}
			//Return result 
			return rslt;
		}
	}
	//Print out every objects toString() in the array 
	public static void printArray(Song[] in){
		for(Song a : in){
			System.out.println(a.toString());
		}
	}
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to file path
		String file = "Prob08.in.txt";
		//New BufferedReader object
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Read test cases
		String testCasesStr = br.readLine();
		//parse to int
		int testCases = Integer.parseInt(testCasesStr);
		//loop through test cases
		for(int i = 0; i < testCases; i++){
			//Grab song-artist pairs 
			String songArtistPairsStr = br.readLine();
			//Parse to int 
			int songArtistPairs = Integer.parseInt(songArtistPairsStr);
			//Make new array of song objects based on the amount of song artist pairs 
			Song[] pairsOrig = new Song[songArtistPairs];
			//Loop through pairs
			for(int j = 0; j < songArtistPairs; j++){
				//Read Line
				String line = br.readLine();
				//Split up string into song and author 
				String[] lineSplit = line.split(" - ");
				//Make new song object based current song and author 
				Song curSong = new Song(lineSplit[0], lineSplit[1]);
				//Store into array we created earlier
				pairsOrig[j] = curSong;
			}
			//Initialize new array 
			Song[] pairs = new Song[songArtistPairs];
			//Copy into new array 
			System.arraycopy(pairsOrig, 0 , pairs, 0, pairsOrig.length);
			//Sort array 
			Arrays.sort(pairs, new SongComparator());
			//Print 
			printArray(pairs);
		}
	}
}