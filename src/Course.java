import java.util.LinkedList;
import java.util.List;

public class Course {
	private String courseCode;
	private int courseCredit;
	private int numberOfStudents;
	private LinkedList<Student> students = new LinkedList<>();
	
	public String getCourseCode() {
		return courseCode;	
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public LinkedList<Student> getStudents() {
		return students;
	}

	public void setStudents(LinkedList<Student> students) {
		this.students = students;
	}

}
