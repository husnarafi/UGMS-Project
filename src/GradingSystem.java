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

	// filepath constant
	private static final String FILEPATH1 = "./Course1.txt";
	private static final String FILEPATH2 = "./Course2.txt";
	private static final String FILEPATH3 = "./Course3.txt";

	public static void main(String[] args) {

		GradingSystem gradingSystem = new GradingSystem();

		// Read records from file(s)
		// store these records in data structure (objects -> datastructure)
		// apply sorting in data structure
		/*
		 * 1: MA113,4 2: 5 3: Ho,Ivan,1109853A-I011-0018,95.12 4 :Leong,Wai
		 * Kit,1109853A-I011-0567,49.62 5 :Hua,Peng,1109853M-I011-0232,75.24 6
		 * :Zhu,Danyang,1109853U-I011-0002,85.0 7
		 * :Zhen,Ben,1109853Z-I011-1234,43.46
		 */

		// Bag bag = new Bag();
		Bag<Student> studentBag = new Bag<Student>();

		// buffer reader code for reading source file
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH1))) {

			int lineCounter = 1;

			Student student = new Student();
			Course course = new Course();

			for (String line; (line = br.readLine()) != null;) {
				System.out.println(lineCounter + ":" + line);

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
					System.out.println("Course credit : " + courseCredit);
				}

				// line 2 contains numberOfStudents
				if (lineCounter == 2) {

					// conversion from String to Integer
					int numberOfStudents = Integer.parseInt(line);

					// setting the numberOfStudents file.java
					course.setNumberOfStudents(numberOfStudents);

					System.out.println("Number of Students :"
							+ numberOfStudents);
				}

				if (lineCounter > 2) {

					String[] arr = line.split(",");
					String studentSurname = arr[0];
					String studentGivenname = arr[1];
					String studentId = arr[2];

					// conversion from String to float
					float score = Float.parseFloat(arr[3]);

					// setting and storing student record in order
					student.setSurname(studentSurname);
					student.setGivenname(studentGivenname);
					student.setId(studentId);

					course.setScore(score);

					// reading the calculateGrade function
					String grade = gradingSystem.calculateGrade(score);
					float points = gradingSystem.calculatePoints(score);

					// recalling calculateGrade function
					// setting the grade function
					course.setGrade(grade);
					course.setPoints(points);

					// print the objects in the following format
					System.out.println("Student Surname: " + studentSurname);
					System.out.println("Student Givenname: " + studentGivenname);
					System.out.println("Student ID: " + studentId);
					System.out.println("Score: " + score);
					System.out.println("Grade: " + grade);

				}

				student.getCourses().add(course);
				studentBag.add(student);

				// read the file line by line
				lineCounter = lineCounter + 1;
			}

			// if file not found, system will give following error
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Bag<Student> getStudentBagFromFile(String filePath) {

		return null;
	}

	/**
	 * 
	 * @param score
	 * @return the grade according to the grading scheme
	 */
	private String calculateGrade(float score) {
		String grade = null;

		// storing the grades appropriately
		// grade= determines the grade value

		// the function below checks the condition according to the grading
		// scheme

		if (score >= 93 && score <= 100) {
			grade = "A+";
		} else if (score >= 88 && score < 93) {
			grade = "A";
		} else if (score >= 83 && score < 88) {
			grade = "A-";
		} else if (score >= 78 && score < 83) {
			grade = "B+";
		} else if (score >= 72 && score < 78) {
			grade = "B";
		} else if (score >= 68 && score < 72) {
			grade = "B-";
		} else if (score >= 63 && score < 68) {
			grade = "C+";
		} else if (score >= 58 && score < 63) {
			grade = "C";
		} else if (score >= 53 && score < 58) {
			grade = "C-";
		} else if (score >= 50 && score < 53) {
			grade = "D";
		} else if (score >= 40 && score < 50) {
			grade = "F";
		} else if (score < 40) {
			grade = "O";
		}

		// returns the value of grade
		return grade;

	}

	/**
	 * 
	 * @param score
	 * @return the points of a course
	 */
	private float calculatePoints(float score) {
		float points = 0;

		// storing the grades appropriately
		// grade= determines the grade value

		// the function below checks the condition according to the grading
		// scheme

		if (score >= 93 && score <= 100) {
			points = 4.0f;
		} else if (score >= 88 && score < 93) {
			points = 3.7f;
		} else if (score >= 83 && score < 88) {
			points = 3.3f;
		} else if (score >= 78 && score < 83) {
			points = 3.0f;
		} else if (score >= 72 && score < 78) {
			points = 2.7f;
		} else if (score >= 68 && score < 72) {
			points = 2.3f;
		} else if (score >= 63 && score < 68) {
			points = 2.0f;
		} else if (score >= 58 && score < 63) {
			points = 1.7f;
		} else if (score >= 53 && score < 58) {
			points = 1.3f;
		} else if (score >= 50 && score < 53) {
			points = 1.0f;
		} else if (score >= 40 && score < 50) {
			points = 0.0f;
		} else if (score < 40) {
			points = 0.0f;
		}

		// returns the value of points
		return points;

	}

}
