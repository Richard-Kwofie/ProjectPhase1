package com.service;

import com.dao.TeacherDao;
import com.entity.Teacher;
import java.util.List;

public class TeacherService {
	
	TeacherDao td = new TeacherDao();
	
	public String addTeacher(Teacher teacher) {
		if(td.addTeacher(teacher)>0) {
			return "Teacher data stored successfully";
			
		}else  {
			return "Teacher details didn't store";
			
		}
	}

	public List<Teacher> findAllTeacher() {
		return td.findAllTeacher();
		
	}
	
}