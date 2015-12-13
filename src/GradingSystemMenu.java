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

		for (Student student : studentBag) {
			for (Course course : student.getCourses()) {
				System.out.println("Course code : " + course.getCourseCode());
			}
			System.out.println("ID : " + student.getId());
		}

		// update GPA of all the students based on their courses
		gradingSystem.preProcessingOnFiles(studentBag);
		Student[] stdArray = convertBagToArray(studentBag);

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
			System.out.println(" 5. Print GPA, Grades with Student Surname by wild card");
			System.out.println(" 6. Student GPA's with Range Sorted:");
			System.out.println(" 7. Print score report by course code:");
			System.out.println(" 8. Print score report based on sorted field:");
			System.out.println(" 9. Print statistical report:");
			System.out.print("Select an option from the above: ");

			int itemCode = scanner.nextInt();
			QueryManager querymanager = new QueryManager();

			switch (itemCode) {
			case 1:
				System.out.print("Enter the Student ID: ");
				String studentIdForGpa = scanner.next();

				// student id
				// stnd bag

				// for given std id fidn the gpa

				float gpa = querymanager.findGpaByStudentId(studentIdForGpa, studentBag);
				if (gpa == -1) {
					System.out.print("No such student exists:");
				} else {
					System.out.print("GPA : " + gpa);
				}

				break;
			case 2:
				System.out.print("Please input the student ID:");
				String stdIdForGrade = scanner.next();

				Student student = querymanager.findStudentByStudentId(stdIdForGrade, studentBag);
				if (student == null) {
					System.out.print("No such student exists:");

				} else {
					// get courses from student
					for (Course course : student.getCourses()) {
						System.out.println(
								"Course Code : " + course.getCourseCode() + " Course Grade : " + course.getGrade());
					}
					System.out.println("GPA : " + student.getGpa());
				}

				break;

			case 3:
				querymanager.sortByTag(stdArray, QueryManager.SORT_BY_GPA, true);

				System.out.println("Student ID\t\tStudent Name\t\tGPA");
				System.out.println("----------------\t--------------\t--------------");

				for (int i = 0; i < stdArray.length; i++) {
					System.out.println(stdArray[i].getId() + "\t" + stdArray[i].getSurname() + ","
							+ stdArray[i].getGivenname() + "\t" + stdArray[i].getGpa());
				}

				break;
			case 4:

				System.out.print("Please input the Student Surname: ");
				String studentSurname = scanner.next();

				Bag<Student> stdWithSurname = querymanager.findStudentsBySurname(studentSurname, studentBag);

				System.out.println(stdWithSurname.size() + " record(s) found in UGMS");
				for (Student std : stdWithSurname) {
					System.out.println(std.getGivenname() + " " + std.getSurname() + " " + std.getId() + " ");
					for (Course course : std.getCourses()) {
						System.out.println(course.getCourseCode() + " " + course.getGrade());

					}
					System.out.print("GPA:" + std.getGpa());
				}

				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				// Please choose the course code first: LP002
				// After the course code is chosen (input by the user), a sample
				// report is shown below:
				// Course Code: LP002
				// Credit: 4
				// Number of Students: 8
				// Name ID Score Grade
				// -------------------- ------------------ ----- -----
				// 6
				// Chan, Henry 1109853A-I011-0224 86 AChoi,
				// Randy 1109853A-I011-0018 60 C
				// Ip, John 1109853A-I011-0456 66 C+
				// Lau, Mary 1109853U-I011-0002 75 B
				// Lee, Vito 1109853J-I011-0116 85 ALeung,
				// Terry 1109853P-I011-0955 80 B+
				// Ngai, Raymond 1109853Z-I011-0066 89 A
				// Tung, Tracy 1109853Q-I011-0016 51 D
				//
				System.out.print("Please choose the course code first:");
				String courseCode = scanner.next();

				Bag<Student> students = querymanager.findStudentsByCourse(courseCode, studentBag);
				boolean onlyRunFirstTime = true;

				System.out.println("\t");
				for (Student std : students) {

					float score = 0;
					String grade = null;

					for (Course course : std.getCourses()) {
						if (onlyRunFirstTime) {
							onlyRunFirstTime = false;
							System.out.println("Course Code:" + course.getCourseCode());
							System.out.println("Credit:" + course.getCourseCredit());
							System.out.println("Number of Students:" + course.getNumberOfStudents());
						}

						score = course.getScore();
						grade = course.getGrade();

					}
					System.out.println("Name\t" + std.getSurname() + "," + std.getGivenname() + "\tID\t" + std.getId()
							+ "\tScore\t" + score + "\tGrade\t" + grade);
				}

				break;
			case 8:
				System.out.println("(1) Surname; (2) ID; (3) Score; (4) Grade");
				System.out.print("Please choose the sorting field: ");

				int sortingField = scanner.nextInt();
				String sortingOrder = null;
				if (sortingField >= 1 && sortingField <= 4) {
					System.out.println("(A)scending order; (D)escending order");
					System.out.print("Please choose the sorting ways: ");
					sortingOrder = scanner.next();

					if (sortingOrder.equalsIgnoreCase("A") || sortingOrder.equalsIgnoreCase("B")) {
						switch (sortingField) {
						case 1:
							if (sortingOrder.equalsIgnoreCase("A")) {
								querymanager.sortByTag(stdArray, QueryManager.SORT_BY_SURNAME, true);
							} else {
								querymanager.sortByTag(stdArray, QueryManager.SORT_BY_SURNAME, false);
							}
							break;
						case 2:
							if (sortingOrder.equalsIgnoreCase("A")) {
								querymanager.sortByTag(stdArray, QueryManager.SORT_BY_ID, true);
							} else {
								querymanager.sortByTag(stdArray, QueryManager.SORT_BY_ID, false);
							}
							break;
						case 3:
							break;
						case 4:
							break;
						}
					} else {
						System.out.println("Invalid input");
					}
				} else {
					System.out.println("Invalid input");
				}

				for (Student std : stdArray) {
					System.out.println(std.getSurname());
				}

				break;
			case 9:

				// Get course code from user
				// initialize num and denometor
				// check this course code in loop
				// count total score in nume
				// count total values in denominator

				// student have courses..getstudentCourses
				// for each course, average, highest and lowest
				// iterate loop
				System.out.println("Course Code:");
				System.out.println("Course Credit: ");

				// String courseCode = scanner.next();
				// String courseCredit = scanner.next();

				float average = 0;
				float average1 = 0;
				float average2 = 0;
				float average3 = 0;

				for (Student std3 : studentBag) {
					for (Course course : std3.getCourses()) {

						if (course.getCourseCode().equals("MA113")) {
							// average=course.getScore() +average;

							// System.out.println("Course Code: " + courseCode);
							// System.out.println("Credit: " + courseCredit);

						}

						if (course.getCourseCode().equals("MA114")) {
							average = course.getScore() + average;

						}

						if (course.getCourseCode().equals("MA115")) {
							average = course.getScore() + average;
						}
					}

				}

				break;

			default:
				System.out.println("Invalid opton selected.");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private static Student[] convertBagToArray(Bag<Student> studentBag) {
		int length = studentBag.size();
		Student[] students = new Student[length];

		int counter = 0;
		for (Student std : studentBag) {
			students[counter] = std;
			counter = counter + 1;
		}

		return students;
	}
}
