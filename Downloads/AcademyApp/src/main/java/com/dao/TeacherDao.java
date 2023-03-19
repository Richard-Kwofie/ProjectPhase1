package com.dao;

import javax.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Teacher;
import com.resource.DbResource;

public class TeacherDao {
	
	public int addTeacher(Teacher teacher) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		   session.save(teacher);
		tran.commit();
		
		return 1;
	}

	public List<Teacher> findAllTeacher() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Teacher");
		List<Teacher> listOfTeacher = tq.getResultList();
		return listOfTeacher;

}
}


