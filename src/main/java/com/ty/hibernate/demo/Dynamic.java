package com.ty.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Dynamic {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory= Persistence.createEntityManagerFactory("emp");
			manager= factory.createEntityManager();
			Query query = manager.createQuery("from Employee where id=:id");
			query.setParameter("id", Integer.parseInt(args[0]));
			Employee employee = (Employee) query.getSingleResult();
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (factory!=null) {
				manager.close();
			}
		}
	}
}
