public class Student implements Comparable<Student>{
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
		
		if (this.gpa == student.getGpa())
			return 0;
		else
			return this.gpa > student.getGpa() ? 1 : -1;
	}

}
