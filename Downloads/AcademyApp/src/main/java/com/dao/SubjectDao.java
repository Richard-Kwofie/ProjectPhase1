package com.dao;

import javax.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.resource.DbResource;


public class SubjectDao {
	
	public int addSubject(Subject subject) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		   session.save(subject);
		tran.commit();
		
		return 1;
	}

	public List<Subject> findAllSubject() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Subject");
		List<Subject> listOfSubject = tq.getResultList();
		return listOfSubject;

}
	
	

}
