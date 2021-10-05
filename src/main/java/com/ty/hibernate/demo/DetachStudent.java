package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DetachStudent {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
	
		transaction.begin();
		Student employee= manager.getReference(Student.class, 2);
		manager.detach(employee);
		manager.remove(employee);
		
		transaction.commit();
		System.out.println(employee);
	}
}
