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

	// file-path constant
	private static final String FILEPATH1 = "./Course1.txt";
	private static final String FILEPATH2 = "./Course2.txt";
	private static final String FILEPATH3 = "./Course3.txt";

	public static void main(String[] args) {

		GradingSystem gradingSystem = new GradingSystem();

		Bag<Student> studentBag = new Bag<Student>();

		gradingSystem.getStudentBagFromFile(studentBag, FILEPATH1);
		gradingSystem.getStudentBagFromFile(studentBag, FILEPATH2);
		gradingSystem.getStudentBagFromFile(studentBag, FILEPATH3);

		System.out.println("No. of Students : " + studentBag.size());

		for (Student student : studentBag) {
			for (Course course : student.getCourses()) {
				System.out.println("Course code : " + course.getCourseCode());
			}
			System.out.println("ID : " + student.getId());
			System.out.println("No. of courses " + student.getCourses().size());
		}

		// Read records from file(s)
		// store these records in data structure (objects -> datastructure)
		// apply sorting in data structure

		// Bag bag = new Bag();

	}

	private void getStudentBagFromFile(Bag<Student> studentBag, String filePath) {

		// buffer reader code for reading source file
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			int lineCounter = 1;

			Student student;
			Course course = new Course();

			for (String line; (line = br.readLine()) != null;) {

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

				}

				// line 2 contains numberOfStudents
				if (lineCounter == 2) {

					// conversion from String to Integer
					int numberOfStudents = Integer.parseInt(line);

					// setting the numberOfStudents file.java
					course.setNumberOfStudents(numberOfStudents);

				}

				if (lineCounter > 2) {
					student = new Student();

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
					String grade = calculateGrade(score);
					float points = calculatePoints(score);

					// recalling calculateGrade function
					// setting the grade function
					course.setGrade(grade);
					course.setPoints(points);

					// student ?
					// check if student already exists in the bag ? if yes ->
					// add the new course
					// if no -> add the student to bag

					Student studentInBag = contains(studentBag, student);
					if (studentInBag != null) {
						
						studentInBag.getCourses().add(course);
						// update the course info only
					} else {
						student.getCourses().add(course);
						studentBag.add(student);
					}

				}

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

	/**
	 * Checks the given student id with the bag student id
	 * @param studentBag
	 * @param student
	 * @return return the matched student from the bag
	 */
	private Student contains(Bag<Student> studentBag, Student student) {

		// iterate through all element of the bag
		// check the given student id with bag student id's
		// if the given id matches with bag id --> return the student
		// else return null

		for (Student std : studentBag) {
			if (std.getId().equals(student.getId())) {
				return std;
			}
		}

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
