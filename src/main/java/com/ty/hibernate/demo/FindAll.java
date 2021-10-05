package com.ty.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAll {
	public static void main(String[] args) {
		try {
			EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager manager = managerFactory.createEntityManager();
			Query query = manager.createQuery("from Employee where id=1");
			Query query2 = manager.createQuery("from Employee");
			List<Employee> list=  query2.getResultList();
			System.out.println(list);
		Employee employee =(Employee) query.getSingleResult();
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
