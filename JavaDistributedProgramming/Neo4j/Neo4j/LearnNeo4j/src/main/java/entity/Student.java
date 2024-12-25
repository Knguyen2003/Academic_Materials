package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class Student {
	private String studentID;
	private String name;
	private float gpa;
	
	

	public Student() {
		
	}

	public Student(String studentID, String name, float gpa) {

		this.studentID = studentID;
		this.name = name;
		this.gpa = gpa;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
	
	

}
