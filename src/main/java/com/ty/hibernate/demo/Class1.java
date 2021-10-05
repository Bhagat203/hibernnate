package com.ty.hibernate.demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Class1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory= Persistence.createEntityManagerFactory("emp");
			manager= factory.createEntityManager();
			Query query = manager.createQuery("update Employee set name=:name, where id=:id");
			System.out.println("id : ");
			query.setParameter("id", scanner.nextInt());
			System.out.println("name : ");
			query.setParameter("name", scanner.next());
			EntityTransaction transaction =  manager.getTransaction();
			transaction.begin();
			
			
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
			if (factory!=null) {
				manager.close();
			}
		}
	
	}
}
