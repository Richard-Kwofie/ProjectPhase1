package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Table(name="studenttable")
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StudentID;
	private String StudentName;
	
	@OneToOne
	private Grade Grade;

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Grade getGrade() {
		return Grade;
	}

	public void setGrade(Grade grade) {
		Grade = grade;
	}

	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", StudentName=" + StudentName + ", Grade=" + Grade + "]";
	}
	

}





