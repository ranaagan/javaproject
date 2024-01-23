package Models;

public class Course {
	
	private int courseID;
	private String courseName;
	private String instructor;
	private int courseCredits;
	private int capacity;
	private int registeredStudents;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getCourseCredits() {
		return courseCredits;
	}
	public void setCourseCredits(int courseCredits) {
		this.courseCredits = courseCredits;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(int registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

}
