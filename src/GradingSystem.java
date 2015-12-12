import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GradingSystem {

	private static final String FILEPATH_1 = "./Course1.txt";
	private static final String FILEPATH_2 = "./Course2.txt";
	private static final String FILEPATH_3 = "./Course3.txt";

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

		Course course1 = gradingSystem.readCourseFile(FILEPATH_1);
		Course course2 = gradingSystem.readCourseFile(FILEPATH_2);
		Course course3 = gradingSystem.readCourseFile(FILEPATH_3);

		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

		LinkedList<StudentRecord> studentRecords = new LinkedList<StudentRecord>();
		
		for (Course course : courses) {
			
			for (Student student : course.getStudents()) {
				// check if student is already added
				// if yes.. then add course information for this student
				// if no then add the student
				
			}
			
		}

	}
	
	private Student contains(LinkedList<StudentRecord> students, Student student) {
		
		return null;
	}

	private Course readCourseFile(String filePath) {

		Course course = null;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			Student student;
			int lineCounter = 1;

			for (String line; (line = br.readLine()) != null;) {

				course = new Course();
				student = new Student();

				if (lineCounter == 1) {

					String[] arr = line.split(",");
					String courseCode = arr[0];
					int courseCredit = Integer.parseInt(arr[1]);

					course.setCourseCode(courseCode);
					course.setCourseCredit(courseCredit);

				} else if (lineCounter == 2) {

					int numberOfStudents = Integer.parseInt(line);
					course.setNumberOfStudents(numberOfStudents);

				} else if (lineCounter > 2) {

					String[] arr = line.split(",");
					String studentSurname = arr[0];
					String studentGivenname = arr[1];
					String studentId = arr[2];
					float score = Float.parseFloat(arr[3]);

					student.setSurname(studentSurname);
					student.setGivenname(studentGivenname);
					student.setId(studentId);
					student.setScore(score);
					student.setGrade(calculateGrade(score));
				}

				course.getStudents().add(student);
				lineCounter = lineCounter + 1;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return course;

	}

	/**
	 * 
	 * @param score
	 * @return the grade based on the score
	 */
	private String calculateGrade(float score) {
		String grade = null;
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

		return grade;
	}

}
