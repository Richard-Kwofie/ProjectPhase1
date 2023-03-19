package com.service;

import com.dao.StudentDao;
import com.entity.Student;
import java.util.List;

public class StudentService {
	
    StudentDao sd = new StudentDao();
	
	public String addStudent(Student student) {
		if(sd.addStudent(student)>0) {
			return "Student data stored successfully";
			
		}else  {
			return "Student details didn't store";
			
		}
	}

	public List<Student> findAllStudent() {
		return sd.findAllStudent();

}
}
