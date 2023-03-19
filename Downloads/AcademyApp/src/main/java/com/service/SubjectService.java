package com.service;

import com.dao.SubjectDao;
import com.entity.Subject;
import java.util.List;

public class SubjectService {
	
    SubjectDao jd = new SubjectDao();
	
	public String addSubject(Subject subject) {
		if(jd.addSubject(subject)>0) {
			return "Subject details stored successfully";
			
		}else  {
			return "Subject details didn't store";
			
		}
	}

	public List<Subject> findAllSubject() {
		return jd.findAllSubject();

}
}