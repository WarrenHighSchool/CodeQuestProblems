import java.io.*;
import java.util.*;

public class Prob06_v2{
	public static class Student{
		//Instance variables for name of student, their school, etc
		public String name;
		public String school;
		public String gradeData;
		public double gpa;
		public int totalCreditHours;
		//Constructor 
		public Student(String name, String school, String gradeData){
			this.name = name;
			this.school = school;
			this.gradeData = gradeData; 
			calcCredits();
		}
		//Method to calculate credits. This is automatically called every time the object is constructed
		public void calcCredits(){
			//Split up the grades, so each string represents one course, which contains the grade for the class along with the hours for that class 
			String[] grades = gradeData.split(",");
			//Initialzie gradePoint total for student 
			int gradePointsTotal = 0;
			//loop through each course 
			for(int i = 0; i < grades.length; i++){
				//Grade value of current course 
				int gradeValue = 0;
				//Split into grade letter and grade hour with chars. We know there will only be two chars(IE 'A' and '4')
				char[] tmp = grades[i].toCharArray();
				//Switch to find the gradeValue for each designated letter
				switch(tmp[0]){
					case 'A':gradeValue = 4;
					break;
					case 'B':gradeValue = 3;
					break;
					case 'C':gradeValue = 2;
					break;
					case 'D':gradeValue = 1;
					break;
				}
				//gradePoint total is that gradeValue multiplied by the hours for that course 
				gradePointsTotal += gradeValue * Integer.parseInt(Character.toString(tmp[1]));
				//We also need to keep track of the total credit hours for the case of a tie in GPA 
				totalCreditHours += Integer.parseInt(Character.toString(tmp[1]));
			}
			//Gpa is equal to the grade point total divided by the credit hours 
			gpa = (double)gradePointsTotal / totalCreditHours; 
		}
	}
	/*
	//Comparator for sorting students 
	public static class StudentComparator implements Comparator<Student>{
		public int compare(Student a, Student b){
			int rslt = 0;
			//First check if a gpa if higher than the other and return a value. If gpa's are equal, then move on to compare the credit hours 
			if(a.gpa < b.gpa){
				rslt = -1;
			}
			else if (a.gpa > b.gpa){
				rslt = 1;
			}
			else{
				rslt = 0;
			}
			//Compare credit hours 
			if(rslt == 0){
				if(a.totalCreditHours < b.totalCreditHours){
					rslt = -1;
				}
				else{
					rslt = 1;
				}
			}
			return rslt;
		}
	}
	*/
	public static void main(String[] args) throws FileNotFoundException,IOException{
		//String to file path 
		String file = "Prob06.in.txt";
		//BufferedReader object 
		BufferedReader br = new BufferedReader(new FileReader(file));
		//Grab test cases 
		int testCases = Integer.parseInt(br.readLine());
		//loop through test cases 
		for(int i = 0; i < testCases; i++){
			//Grab school name 
			String schoolName = br.readLine();
			//Grab number of studnets 
			int numStudents = Integer.parseInt(br.readLine());
			//Initialize an array of Student objects with length of numStudents 
			Student[] students = new Student[numStudents];
			//loop through numstudents 
			for(int j = 0; j < numStudents; j++){
				//Grab line 
				String line = br.readLine();
				//Split accordingly 
				String[] lineSplit = line.split(":");
				//Set name and data string 
				String name = lineSplit[0];
				String gradeData = lineSplit[1];
				//Constuct object with our given data 
				Student curStudent = new Student(name, schoolName, gradeData);
				//Add to array of Students 
				students[j] = curStudent;
			}
			/*
			//Sort student objects using a comparator. First compare gpa, if those are the same, then compare grade hours 
			Arrays.sort(students, new StudentComparator());
			//Print out name of last value in array which is valedictorian
			System.out.println(schoolName + " = " + students[students.length - 1].name);
			*/
			//Initialize top student 
			Student topStudent = null; 
			//Loop through amount of students
			for(int j = 0; j < numStudents; j++){
				//Set current student
				Student curStudent = students[j];
				//Due to how we initialized the top student earlier, this just basically sets the first student as the top and then compares
				if(topStudent == null){
					topStudent = students[j];
				} else{ //If we are past the first student so we can start comparisons 
					//If the gpa's are identical, move on to comparing credit hours 
					if(curStudent.gpa == topStudent.gpa){
						//If the current student being checked has the same gpa and more credit hours than the current best student, then make the current student the best student
						if(curStudent.totalCreditHours > topStudent.totalCreditHours){
							topStudent = curStudent;
						}
					} else{ //Otherwise, if the current student has a gpa that is higher than the current top student, make the current student the best student
						if(curStudent.gpa > topStudent.gpa){
							topStudent = curStudent;
						}
					}
				}
			}
			//Print out valedictorian for the school
			System.out.println(schoolName + " = " + topStudent.name);
		}
	}
}





