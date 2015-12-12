import java.util.Scanner;

/********************************************
 * Assignment 1
 * 
 * Name: Rafi Husna Student ID: 1409853O-I011-0011 Course and Section: Data
 * Structures, LP002 email: husnarafi94@gmail.com
 * 
 * Description: This program reads the file correctly and stores the student
 * information according to the file.
 ********************************************/

public class GradingSystemMenu {

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
		
		// update GPA of all the students based on their courses
		gradingSystem.preProcessingOnFiles(studentBag);

		// print all the student records

		// What do you want to do?
		// 1. Find GPA of a student
		// 2. Print grades of a student courses
		// 3. Print sorted GPA's report
		// 4. Print GPA, Grades with student surname
		// 5. Print GPA, Grades with student surname by wild card
		// 6. Student GPA's with Range sorted
		// 7. Print score report by course code
		// 8. print score report based on sorted field
		// 9. Print statistical report

		// Read records from file(s)
		// store these records in data structure (objects -> datastructure)
		// apply sorting in data structure

		// Create a Scanner object
		try (Scanner scanner = new Scanner(System.in)) {

			// Read values from Console
			System.out.println(" 1. Find GPA of a student:");
			System.out.println(" 2. Print grades of Students Courses:");
			System.out.println(" 3. Print sorted GPA's report:");
			System.out.println(" 4. Print GPA, Grades with Student Surname:");
			System.out
					.println(" 5. Print GPA, Grades with Student Surname by wild card");
			System.out.println(" 6. Student GPA's with Range Sorted:");
			System.out.println(" 7. Print score report by course code:");
			System.out.println(" 8. Print score report based on sorted field:");
			System.out.println(" 9. Print statistical report:");
			System.out.print("Select an option from the above: ");

			String input = scanner.next();
			int itemCode = Integer.parseInt(input);

			switch (itemCode) {
			case 1:
				System.out.print("Enter the Student ID: ");
				String studentId = scanner.next();
				
				// student id
				// stnd bag
				
//				for given std id fidn the gpa
				
				float gpa = findGpaByStudentId(studentId, studentBag);
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;

			default:
				System.out.println("Invalid opton selected.");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	
	}

}
