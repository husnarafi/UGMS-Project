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
