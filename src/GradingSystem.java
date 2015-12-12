/********************************************
 * Assignment 1
 * Name: Rafi Husna
 * Student ID: 1409853O-I011-0011
 * Course and Section: Data Structures, LP002
 * email: husnarafi94@gmail.com
 * 
 * Description: This program reads the file correctly and stores the student information according to the file.
 
 ********************************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GradingSystem {

	// using string data type to read file path
	
	private static final String FILEPATH = "/Users/husnarafi/Developer/Workspace/Java/GradingSystem/Course1.txt";
	private static String points;
	
	public static void main(String[] args) {

		// Read records from file(s)
		// store these records in data structure (objects -> datastructure)
		// apply sorting in data structure
		/*
		1: MA113,4
		2: 5
		3: Ho,Ivan,1109853A-I011-0018,95.12
		4 :Leong,Wai Kit,1109853A-I011-0567,49.62
		5 :Hua,Peng,1109853M-I011-0232,75.24
		6 :Zhu,Danyang,1109853U-I011-0002,85.0
		7 :Zhen,Ben,1109853Z-I011-1234,43.46
		*/
		
		// buffer reader code for reading source file 
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			
			int lineCounter = 1;
			Course course = new Course();
			
			for (String line; (line = br.readLine()) != null;) {
				System.out.println(lineCounter +":" + line);

				// line one contains course-code and credit
				if (lineCounter == 1) {
				
					// delimiter used to separate the course-code and credit
					String[] arr = line.split(",");
					
					// array 2
					String courseCode = arr[0];
					
					// conversion from String to Integer
					int courseCredit = Integer.parseInt(arr[1]);
					
					// setting the course file.java
					course.setCourseCode(courseCode);
					course.setCourseCredit(courseCredit);
					
					System.out.println("Course code : " + courseCode);
					System.out.println("Course credit : " +courseCredit);
				}
		
				// line 2 contains numberOfStudents
				if (lineCounter ==2){		
					
					// conversion from String to Integer
					int numberOfStudents = Integer.parseInt(line);
					
					// setting the numberOfStudents file.java
					course.setNumberOfStudents(numberOfStudents);
					
					System.out.println("Number of Students :" +numberOfStudents);
				}
				
				Student student = new Student();
				
				if (lineCounter >2){
					
					String[] arr = line.split(",");
					String studentSurname = arr[0];
					String studentGivenname = arr[1];
					String studentId = arr[2];
					
					// conversion from String to float
					float score = Float.parseFloat(arr[3]);
					
					//setting and storing student record in order
					student.setSurname(studentSurname);
					student.setGivenname(studentGivenname);
					student.setId(studentId);
					
					student.setScore(score);
			 		
					// reading the calculateGrade function
					String grade = calculateGrade(score);
					float points = calculatePoints(score);
					
					// recalling calculateGrade function
					// setting the grade function
					student.setGrade(grade);
					student.setPoints(points);
					
					// print the objects in the following format
					System.out.println("Student Surname: " + studentSurname);
					System.out.println("Student Givenname: " + studentGivenname);
					System.out.println("Student ID: " + studentId);
					System.out.println("Score: " + score);
					System.out.println("Grade: " + grade);
					
				}
					// read the file line by line	
				lineCounter = lineCounter+1; 
			}
		
			// if file not found, system will give following error
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// calculating the grade according to the grading scheme
	
	private static String calculateGrade(float score){
	
		String grade = null;
		
	private static float calculatePoints (float score){
		float points = null;
	
	
		
		// storing the grades appropriately
		// grade= determines the grade value
		
		// the function below checks the condition according to the grading scheme
		
		if (score>= 93 && score<=100) {
			grade = "A+";
			points = "4.0";
		}
		else if (score>= 88 && score<93){
			grade = "A";
			points = "3.7";
		}
		else if (score>=83 && score<88){
			grade = "A-";
			points = "3.3";
		}
		else if (score>=78 && score<83){
			grade = "B+";
			points = "3.0";
		}
		else if (score>=72 && score<78){
			grade = "B";
			points = "2.7";
		}
		else if (score>=68 && score<72){
			grade = "B-";
			points = "2.3";
		}
		else if (score>=63 && score<68){
			grade = "C+";
			points = "2.0";
		}
		else if (score>=58 && score<63){
			grade = "C";
			points = "1.7";
		}
		else if (score>=53 && score<58){ 
			grade = "C-";
			points = "1.3";
		}
		else if (score>=50 && score<53){
			grade = "D";
			points = "1.0";
		}
		else if (score>=40 && score<50){
			grade = "F";
			points = "0.0";
		}
		else if (score<40){
			grade = "O";
			points = "0.0";
		}
		
		// returns the value of grade
		return grade;
		
		// returns the value of points
		return points;
		
		
	}
	
	}
	
	
	
}
