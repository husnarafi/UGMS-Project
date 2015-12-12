import java.util.LinkedList;

public class StudentRecord {
	private String id;
	private String surname;
	private String givenname;
	private float gpa;
	private LinkedList<CourseRecord> course = new LinkedList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public LinkedList<CourseRecord> getCourse() {
		return course;
	}

	public void setCourse(LinkedList<CourseRecord> course) {
		this.course = course;
	}

	public static class CourseRecord {
		private String courseCode;
		private int courseCredit;
		private String grade;
		private float score;

		public CourseRecord(String courseCode, int courseCredit, String grade, float score) {
			this.courseCode = courseCode;
			this.courseCredit = courseCredit;
			this.grade = grade;
			this.score = score;
		}
	}
}
