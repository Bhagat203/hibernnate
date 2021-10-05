package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertStudent {
	public static void main(String[] args) {
		Student s =new Student();
	
		s.setName("sad");
		EntityManagerFactory factory = null;
		EntityManager entityManager =  null;
		EntityTransaction transaction=null;
		try {
			 factory = Persistence.createEntityManagerFactory("student");
			 entityManager =  factory.createEntityManager();
			 transaction = entityManager.getTransaction();
			 transaction.begin();
			 entityManager.persist(s);
			
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}
		finally {
			if(factory!=null)
				factory.close();
			if(entityManager!=null)
				entityManager.close();
		}
	
	}
}
