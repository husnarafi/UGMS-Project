/********************************************
 * Assignment 1
 * 
 * Name: Rafi Husna 
 * Student ID: 1409853O-I011-0011 
 * Course and Section: Data Structures, LP002 
 * email: husnarafi94@gmail.com
 *
 * Description: This file stores the complete course information.
 ********************************************/

public class Course {
	private String courseCode;
	private int courseCredit;
	private int numberOfStudents;
	private float score;
	private String grade;
	private float points;

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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}



}
