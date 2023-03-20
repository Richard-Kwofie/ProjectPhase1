package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import java.util.List;


@Entity
@Table(name="gradetable")
public class Grade {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int GradeID;
	private String Section;
	
	@OneToMany
	private List<Student> listofStd;

	@OneToMany
	private List<Subject> listofSubject;

	public int getGradeID() {
		return GradeID;
	}

	public void setGradeID(int gradeID) {
		GradeID = gradeID;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public List<Student> getListofStd() {
		return listofStd;
	}

	public void setListofStd(List<Student> listofStd) {
		this.listofStd = listofStd;
	}

	public List<Subject> getListofSubject() {
		return listofSubject;
	}

	public void setListofSubject(List<Subject> listofSubject) {
		this.listofSubject = listofSubject;
	}

	@Override
	public String toString() {
		return "Grade [GradeID=" + GradeID + ", Section=" + Section + ", listofStd=" + listofStd + ", listofSubject="
				+ listofSubject + "]";
	}	
	
	

}


