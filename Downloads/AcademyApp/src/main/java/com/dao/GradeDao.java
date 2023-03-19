package com.dao;

import javax.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Grade;
import com.resource.DbResource;

public class GradeDao {
	
	public int addGrade(Grade grade) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		   session.save(grade);
		tran.commit();
		
		return 1;
		
		
		
		
		
	}

	public List<Grade> findAllGrade() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Grade");
		List<Grade> listOfGrade = tq.getResultList();
		return listOfGrade;

}
}




	
	