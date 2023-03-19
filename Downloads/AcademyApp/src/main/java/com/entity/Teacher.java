package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import java.util.List;


@Entity
@Table(name="teachertable")
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int TeacherID;
	private String TeacherName;
	
	
	@OneToMany
	private List<Subject> listofSubject;


	public int getTeacherID() {
		return TeacherID;
	}


	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}


	public String getTeacherName() {
		return TeacherName;
	}


	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}


	public List<Subject> getListofSubject() {
		return listofSubject;
	}


	public void setListofSubject(List<Subject> listofSubject) {
		this.listofSubject = listofSubject;
	}


	@Override
	public String toString() {
		return "Teacher [TeacherID=" + TeacherID + ", TeacherName=" + TeacherName + ", listofSubject=" + listofSubject
				+ "]";
	}

}





