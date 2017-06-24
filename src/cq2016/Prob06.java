import java.io.*;

public class Prob06{
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to file 
		String filePath = "Prob06.in.txt";
		//New BufferedReader instace
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		//Grab test cases string 
		String testCasesStr = br.readLine();
		//Parse string into integer
		int testCases = Integer.parseInt(testCasesStr);
		//Loop through test cases(schools)
		for(int i = 0; i < testCases; i++){
			//Name of high school
			String highSchool = br.readLine();
			//String for number of students
			String numStudentsStr = br.readLine();
			//Parse string into int 
			int numStudents = Integer.parseInt(numStudentsStr);
			//Initialize String array for student names(there will also be an array for gpa's, which will have corresponding indexes to the students names)
			String[] studentNames = new String[numStudents];
			//Initiaze int array for gpa's of students that will correspond to the studentName array indexes 
			double[] studentGPAs = new double[numStudents];
			//Initialzie creditHours array to keep track of grade hours incase students have identical GPA's(corresponding indexes with the two above arrays)
			int[] creditHours = new int[numStudents];
			//Set max hours int 
			int maxHours = 0;
			//Loop through amount of students 
			for(int j = 0; j < numStudents; j++){
				//Read line for students information(name + grades with gpa hours)
				String studentInfo = br.readLine();
				//Split the string into two, having the name seperate from grades with gpa hours 
				String[] infoSplit = studentInfo.split(":");
				//Make strings easier to use by assigning names to them rather than using the array
				String name = infoSplit[0];
				String info = infoSplit[1];
				//Add student name to studentNames array
				studentNames[j] = name;
				//Initialize amount of grades 
				int amountOfGrades = 0;
				//Find the amount of grades by counting commas. There will be x + 1 grades, where x is commas 
				for(int k = 0; k < info.length(); k++){
					if(info.charAt(k) == ','){
						amountOfGrades++;
					}
				}
				//Need to add one more to length since there is no comma at end of string 
				amountOfGrades++;
				//Fill array with grade points by taking string of letter a, b, c, or d, and multiplying accordingly
				double[] gradePoints = new double[amountOfGrades]; //To find GPA, add all the of the elements in this array and divide by length
				
				//Initialzie array indexer/counter for adding to new array
				int gradePointIndexer = 0;
				//Make temp credit hours array which holds the credit hours for corresponding classes. total hours is all of these added up 
				int[] creditHoursTemp = new int[amountOfGrades];
				//Fill up array with corresponding grades
				for(int k = 0; k < info.length(); k+=2){
					//If comma dedected, increment k so variables dont get set to comma 
					if(info.charAt(k) == ','){
						k++;
						int gradePoint = 0;
					}
					//Set the letter of the grade to charAt k
					char gradeLetter = info.charAt(k);
					//Set number of grade to charAt k + 1
					char gradeHoursChar = info.charAt(k+1);
					//Convert character to string(because of some issues when converting char to int
					String gradeHoursStr = Character.toString(gradeHoursChar);
					//Convert string to int
					int gradeHours = Integer.parseInt(gradeHoursStr);
					//Fill up creditHours array
					creditHoursTemp[gradePointIndexer] = gradeHours;
					//Add to gradePoints array based on gradehours * (gpa for letter)
					if(gradeLetter == 'A'){
						gradePoints[gradePointIndexer] = 4.0 * gradeHours;
					}
					else if(gradeLetter == 'B'){
						gradePoints[gradePointIndexer] = 3.0 * gradeHours;
					}
					else if(gradeLetter == 'C'){
						gradePoints[gradePointIndexer] = 2.0 * gradeHours;
					}
					else{
						gradePoints[gradePointIndexer] = 1.0 * gradeHours;
					}
					gradePointIndexer++;
				}
				//initialize total credit hours int 
				int totalCreditHours = 0;
				//creditHours[j] will be equal to the toal amount of credit hours 
				for(int b = 0; b < creditHoursTemp.length; b++){
					totalCreditHours += creditHoursTemp[b];
				}
				//set creditHours 
				creditHours[j] = totalCreditHours;
				//get first value of maxHours 
				maxHours = Math.max(creditHours[0], creditHours[1]);
				//Set maxHours to greatest value of creditHours
				if(creditHours.length > 2){
					for(int b = 2; b < creditHours.length; b++){
						maxHours = Math.max(maxHours, creditHours[b]);
					}
				}
				//Initialize finalGPA variable
				double finalGpa = 0.0;
				//Initialize temporary variable for sum of all elemtns in gradePoints array 
				double tmp = 0.0;
				//Set finalGPA variable by adding up all elements of gradePoints array and divide it by the length 
				for(int k = 0; k < gradePoints.length; k++){
					tmp += gradePoints[k];
				}
				//Calculate final GPA for student 
				finalGpa = tmp/totalCreditHours;
				//Add that gpa to the studentGPAs array 
				studentGPAs[j] = finalGpa;
			}
			//Initialize array for students with same gpa 
			int[] sameGPAStudents = new int[numStudents];
			//Fill sameGPAStudents with -1
			for(int n = 0; n < sameGPAStudents.length; n++){
				sameGPAStudents[n] = -1;
			}
			//Initalize highestGPA double
			double highestGPA = Math.max(studentGPAs[0], studentGPAs[1]);
			//Find highest GPA of array(if array is greater than two elements since we compared the first two already)
			if(studentGPAs.length > 2){
				for (int m = 2; m < studentGPAs.length; m++){
					highestGPA = Math.max(highestGPA, studentGPAs[m]);
				}
			}
			//Initialize integer for the index of the highest gpa 
			int indexOfHighestGPA = -1;
			//Find if students have identical gpa's 
			for(int m = 0; m < studentGPAs.length; m++){
				if(studentGPAs[m] == highestGPA && m != findIndex(studentGPAs, highestGPA)){
					sameGPAStudents[m] = m;
				}
			}
			//initialize index of student with most hours 
			int studentWithMostHours = -1;
			//set boolean to indicate there is multiple students with identical gpa's 
			boolean identicalGPAs = false;
			//If sameGPAStudents has anything but -1, then two students have same gpa's 
			for(int m = 0; m < sameGPAStudents.length; m++){
				if(sameGPAStudents[m] != -1){
					identicalGPAs = true;
					studentWithMostHours = findIndexInt(creditHours, maxHours);
				}
			}
			//If there are no identical GPA's in the studentGPAs array, then find the index of the student with the highest gpa and print them out 
			if(!identicalGPAs){
				//Find the index of the highest gpa 
				indexOfHighestGPA = findIndex(studentGPAs, highestGPA);
				//System.out.println("index of highest gpa: " + indexOfHighestGPA);
				System.out.println(highSchool + " = " + studentNames[indexOfHighestGPA]);
			}
			//If there are identical gpa's, print out the student with the highest gpa and most hours 
			else{
				System.out.println(highSchool + " = " + studentNames[studentWithMostHours]);
			}
		}
		//Close BufferedReader object
		br.close();
	}
	
	//Method to find the index of an element(double) in an array(double)
	//Used for GPA array 
	public static int findIndex(double[] array, double element ){
		int returnValue = -1; 
		for(int i = 0; i < array.length; i++){
			if(array[i] == element){
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}
	//Method to find index of an element(int) in an array(int)
	//Used for student array 
	public static int findIndexInt(int[] array, int element){
		int returnValue = -1;
		for(int i = 0; i < array.length; i++){
			if(array[i] == element){
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}
}