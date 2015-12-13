/********************************************
 * Assignment 1
 * 
 * Name: Rafi Husna 
 * Student ID: 1409853O-I011-0011 
 * Course and Section: DataStructures, LP002 
 * email: husnarafi94@gmail.com
 *
 * Description: This file stores the complete student information.
 ********************************************/

public class Student implements Comparable<Student> {
	public static int SORT_TAG = QueryManager.SORT_BY_GPA;
	public static boolean SORT_ASCENDING = true;

	private String surname;
	private String givenname;
	private String id;
	private float gpa;
	private Bag<Course> courses = new Bag<Course>();

	public Bag<Course> getCourses() {
		return courses;
	}

	public void setCourses(Bag<Course> courses) {
		this.courses = courses;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGivenname() {
		return givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Student student) {

		if (SORT_TAG == QueryManager.SORT_BY_GPA) {
			return sortByGpa(student, SORT_ASCENDING);
		} else if (SORT_TAG == QueryManager.SORT_BY_SURNAME) {
			return sortBySurname(student, SORT_ASCENDING);
		} else if (SORT_TAG == QueryManager.SORT_BY_ID) {
			sortById(student, SORT_ASCENDING);
		} else if (SORT_TAG == QueryManager.SORT_BY_SCORE) {
			sortByScore(student, SORT_ASCENDING);
		} else if (SORT_TAG == QueryManager.SORT_BY_GRADE) {
			sortByGrade(student, SORT_ASCENDING);
		}

		return 0;

	}

	private int sortByGpa(Student student, boolean ascending) {
		if (this.gpa == student.getGpa()) {
			return 0;
		} else {
			if (ascending) {
				return this.gpa > student.gpa ? 1 : -1;
			} else {
				return this.gpa < student.gpa ? 1 : -1;
			}
		}
	}

	private int sortBySurname(Student student, boolean ascending) {
		if (this.surname.equals(student.getSurname())) {
			return 0;
		} else {
			if (ascending) {
				return this.surname.compareTo(student.surname) > 0 ? 1 : -1;
			} else {
				return this.surname.compareTo(student.surname) < 0 ? -1 : 1;
			}
		}
	}

	private int sortById(Student student, boolean ascending) {
		if (this.surname.equals(student.getSurname())) {
			return 0;
		} else {
			if (ascending) {
				return this.id.compareTo(student.id) > 0 ? 1 : -1;
			} else {
				return this.id.compareTo(student.id) < 0 ? -1 : 1;
			}
		}
	}

	private int sortByScore(Student student, boolean ascending) {
		float leftScore = 0;
		float rightScore = 0;

		for (Course c1 : this.getCourses()) {
			leftScore = c1.getScore();
			break;
		}

		for (Course c2 : student.getCourses()) {
			rightScore = c2.getScore();
			break;
		}

		if (leftScore == rightScore) {
			return 0;
		} else {
			if (ascending) {
				return leftScore > rightScore ? 1 : -1;
			} else {
				return leftScore < rightScore ? 1 : -1;
			}
		}
	}

	private int sortByGrade(Student student, boolean ascending) {
		String left = null;
		String right = null;

		for (Course c1 : this.getCourses()) {
			left = c1.getGrade();
			break;
		}

		for (Course c2 : student.getCourses()) {
			right = c2.getGrade();
			break;
		}

		if (left.equals(right)) {
			return 0;
		} else {
			if (ascending) {
				return left.compareTo(right) > 0 ? 1 : -1;
			} else {
				return left.compareTo(right) < 0 ? -1 : 1;
			}
		}
	}

}
