package com.service;

import com.dao.GradeDao;
import com.entity.Grade;
import java.util.List;

public class GradeService {
	
    GradeDao gd = new GradeDao();
	
	public String addGrade(Grade grade) {
		if(gd.addGrade(grade)>0) {
			return "Grade data stored successfully";
			
		}else  {
			return "Grade details didn't store";
			
		}
	}

	public List<Grade> findAllGrade() {
		return gd.findAllGrade();

}
}