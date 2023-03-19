package com.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.resource.DbResource;

public class StudentDao {


public int addStudent(Student student) {
	SessionFactory sf = DbResource.getSessionFactory();
	Session session = sf.getCurrentSession();
	Transaction tran = session.getTransaction();
	tran.begin();
	   session.save(student);
	tran.commit();
	
	return 1;
}

public List<Student> findAllStudent() {
	SessionFactory sf = DbResource.getSessionFactory();
	Session session = sf.openSession();
	TypedQuery tq = session.createQuery("from Student");
	List<Student> listOfStudent = tq.getResultList();
	return listOfStudent;
	
}
}