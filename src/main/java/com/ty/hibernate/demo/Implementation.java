package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.service.spi.Manageable;

public class Implementation {
	public static void main(String[] args) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Employee e= entityManager.find(Employee.class, 1);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			System.out.println(e);
			entityTransaction.begin();
			e.setName("ravi");
			System.out.println(e);
			entityTransaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
