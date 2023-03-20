package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name="subjecttable")
public class Subject {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private int SubjectID;
private String SubjectName;

@ManyToOne
private Grade grade;

@ManyToOne
private Teacher Teacher;

public int getSubjectID() {
	return SubjectID;
}

public void setSubjectID(int subjectID) {
	SubjectID = subjectID;
}

public String getSubjectName() {
	return SubjectName;
}

public void setSubjectName(String subjectName) {
	SubjectName = subjectName;
}

public Grade getGrade() {
	return grade;
}

public void setGrade(Grade grade) {
	this.grade = grade;
}

public Teacher getTeacher() {
	return Teacher;
}

public void setTeacher(Teacher teacher) {
	Teacher = teacher;
}

@Override
public String toString() {
	return "Subject [SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + ", grade=" + grade + ", Teacher="
			+ Teacher + "]";
}


}
