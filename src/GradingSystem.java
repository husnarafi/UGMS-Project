import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GradingSystem {

	
	
	private static final String FILEPATH = "./Course1.txt";
	
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
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			
			int lineCounter = 1;
			Course course = new Course();
			
			for (String line; (line = br.readLine()) != null;) {
				System.out.println(lineCounter +":" + line);

				// line one contains course-code and credit
				if (lineCounter == 1) {
					String[] arr = line.split(",");
					
					// array 2
					String courseCode = arr[0];
					int courseCredit = Integer.parseInt(arr[1]);
					
					course.setCourseCode(courseCode);
					course.setCourseCredit(courseCredit);
					
					System.out.println("Course code : " + courseCode);
					System.out.println("Course credit : " +courseCredit);
				}
		
				
				if (lineCounter ==2){					
					int numberOfStudents = Integer.parseInt(line);
					course.setNumberOfStudents(numberOfStudents);
					System.out.println("Number of Students :" +numberOfStudents);
				}
				
				Student student = new Student();
				
				if (lineCounter >2){
					
					String[] arr = line.split(",");
					String studentSurname = arr[0];
					String studentGivenname = arr[1];
					String studentId = arr[2];
					float score = Float.parseFloat(arr[3]);
					
					student.setSurname(studentSurname);
					student.setGivenname(studentGivenname);
					student.setId(studentId);
					
					student.setScore(score);
			 		
					String grade = calculateGrade(score);
					student.setGrade(grade);
					
				
					System.out.println("Student Surname: " + studentSurname);
					System.out.println("Student Givenname: " + studentGivenname);
					System.out.println("Student ID: " + studentId);
					System.out.println("Score: " + score);
					System.out.println("Grade: " + grade);
					
				}
						
				lineCounter = lineCounter+1; //2, 3, 
			}
		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String calculateGrade(float score) {
		
		String grade = null;
		
		if (score>= 93 && score<=100) {
			grade = "A+";
		}
		else if (score>= 88 && score<93){
			grade = "A";
		}
		else if (score>=83 && score<88){
			grade = "A-";
		}
		else if (score>=78 && score<83){
			grade = "B+";
		}
		else if (score>=72 && score<78){
			grade = "B";
		}
		else if (score>=68 && score<72){
			grade = "B-";
		}
		else if (score>=63 && score<68){
			grade = "C+";
		}
		else if (score>=58 && score<63){
			grade = "C";
		}
		else if (score>=53 && score<58){ 
			grade = "C-";
		}
		else if (score>=50 && score<53){
			grade = "D";
		}
		else if (score>=40 && score<50){
			grade = "F";
		}
		else if (score<40){
			grade = "O";
		}
		
		return grade;
		
		
	}
	
	 

}
