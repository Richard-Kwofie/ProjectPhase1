package com.dao;

import javax.persistence.TypedQuery;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Product;
import com.resource.DbResource;

public class ProductDao {
	
	public int storeProduct(Product product) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		   session.save(product);
		tran.commit();
		
		return 1;
	}
	
	public List<Product> findAllProduct() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.getCurrentSession();
		TypedQuery tq = session.createQuery("from Product");
		List<Product> listOfProduct = tq.getResultList();
		return listOfProduct;
}
}
