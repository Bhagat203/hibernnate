package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateUSingJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory =null;
		EntityManager manager = null;
		try {
			managerFactory= Persistence.createEntityManagerFactory("emp");
			manager=managerFactory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("update Employee set name='Ram',id=2,sal=10000 where id=1");
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (managerFactory!=null) {
				manager.close();
			}
		}
	}
}
