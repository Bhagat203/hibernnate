package com.ty.hibernate.demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdatePrimaryKey {
	public static void main(String[] args) {
		
	

	EntityManagerFactory factory = null;
EntityManager manager = null;
Scanner scanner = new Scanner(System.in);
EntityTransaction transaction = null;
try {
	factory = Persistence.createEntityManagerFactory("student");
	manager = factory.createEntityManager();
   transaction = manager.getTransaction();
	Student student= manager.find(Student.class,1 );
	System.out.println(student);
	
	transaction.begin();
	Query query = manager.createQuery("UPDATE Student SET rollno ="
			+ "    CASE    WHEN rollno = 1 THEN 2"
			+ "    END"
			+ " WHERE rollno IN (1)");
	
	query.executeUpdate();
	
	

	transaction.commit();
	System.out.println("updatded");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	if (manager != null) {
		manager.close();
	}
	if (factory != null) {
		manager.close();
	}

}
}
}

