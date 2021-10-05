package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertHibernetImpl {
	public static void main(String[] args) {
		Employee employee =  new Employee();
		employee.setId(2);
		employee.setName("Raj");
		employee.setDesignation("Manager");
		employee.setSal(100000);
		EntityManagerFactory factory = null;
		EntityManager entityManager =  null;
		EntityTransaction transaction=null;
		try {
			 factory = Persistence.createEntityManagerFactory("emp");
			 entityManager =  factory.createEntityManager();
			 transaction = entityManager.getTransaction();
			 transaction.begin();

			entityManager.persist(employee);
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
