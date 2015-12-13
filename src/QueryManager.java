/********************************************
 * Assignment 1
 * 
 * Name: Rafi Husna 
 * Student ID: 1409853O-I011-0011 
 * Course and Section: DataStructures, LP002 
 * email: husnarafi94@gmail.com
 *
 * Description: This file contains multiple data structures 
 * for e.g. (finding student by surname, find Gpa by students ID) etc.

 ********************************************/
public class QueryManager {

	public static final int SORT_BY_GPA = 1;
	public static final int SORT_BY_SURNAME = 2;
	public static final int SORT_BY_ID = 3;
	public static final int SORT_BY_SCORE = 4;
	public static final int SORT_BY_GRADE = 5;

	public float findGpaByStudentId(String studentId, Bag<Student> studentBag) {
		// input function-> std id and std bag
		// iterate through std bag
		// check the std id with given id
		// if std id matches then get the gpa
		// else no students id exists

		for (Student std : studentBag) {
			if (studentId.equals(std.getId())) {
				return std.getGpa();
			}
		}

		return -1;
	}

	public Student findStudentByStudentId(String studentId, Bag<Student> studentBag) {
		// we have course code, grade and gpa in our studentbag
		// recalling student function
		// iterate loop
		// check the student id in std bag
		// if yes, then coursecode, grade and gpa
		for (Student std : studentBag) {
			if (studentId.equals(std.getId())) {
				return std;
			}
		}
		return null;
	}

	public Bag<Student> findStudentsBySurname(String surname, Bag<Student> studentBag) {
		Bag<Student> students = new Bag<Student>();

		for (Student std : studentBag) {
			if (surname.equalsIgnoreCase(std.getSurname())) {
				students.add(std);

			}
		}
		return students;
	}

	public Bag<Student> findStudentsByMinGpa(float gpa, Bag<Student> studentBag) {
		Bag<Student> students = new Bag<Student>();
		for (Student std : studentBag) {
			if (std.getGpa() >= gpa) {
				students.add(std);
			}
		}
		return students;
	}

	public Bag<Student> findStudentsBySurnameStartsWith(String startsWith, Bag<Student> studentBag) {
		Bag<Student> students = new Bag<Student>();

		for (Student std : studentBag) {
			if (std.getSurname().startsWith(startsWith)) {
				students.add(std);
			}
		}
		return students;
	}

	public Bag<Student> findStudentsByCourse(String courseCode, Bag<Student> studentBag) {
		Bag<Student> students = new Bag<Student>();

		for (Student std : studentBag) {
			for (Course course : std.getCourses()) {
				if (courseCode.equals(course.getCourseCode())) {
					Student s = new Student();
					s.setGivenname(std.getGivenname());
					s.setSurname(std.getSurname());
					s.setId(std.getId());
					s.setGpa(std.getGpa());
					Bag<Course> c = new Bag<Course>();
					c.add(course);
					s.setCourses(c);
					students.add(s);
				}
			}
		}
		return students;
	}

	public void sortByTag(Student[] arr, int sortTag, boolean value) {
		Student.SORT_TAG = sortTag;
		Student.SORT_ASCENDING = value;
		Merge.sort(arr);
	}
}
