package com.ty.hibernate.demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateStudent {
	public  void main(int roll) {
		 EntityManagerFactory factory = null;
		 EntityManager manager = null;
		 Scanner scanner = new Scanner(System.in);
		 EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
		    transaction = manager.getTransaction();
			Student student= manager.find(Student.class,roll );
			System.out.println(student);
			System.out.println("Enter the rollno you wish to update");
			int updated_rollno = scanner.nextInt();
			System.out.println("Do you want to update roll no (y/n)");
			updated_rollno=scanner.next().charAt(0)=='y'?updated_rollno:student.getRollno();
			System.out.println("Enter the name you wish to update");
			String name = scanner.next();
			System.out.println("Do you want to update roll no (y/n)");
			name=scanner.next().charAt(0)=='y'?name:student.getName();
			System.out.println("Enter the phone you wish to update");
			long phono = scanner.nextLong();
			System.out.println("Do you want to update roll no (y/n)");
			phono=scanner.next().charAt(0)=='y'?phono:student.getPhno();
			System.out.println("Enter the standard you wish to update");
			String standard = scanner.next();
			System.out.println("Do you want to update roll no (y/n)");
			standard=scanner.next().charAt(0)=='y'?standard:student.getStandrad();

			transaction.begin();
			student.setName(name);
			student.setPhno(phono);
			student.setStandrad(standard);
			manager.persist(student);
			transaction.commit();
			transaction.begin();
			Query query = manager.createQuery("UPDATE Student SET rollno ="
					+ "    CASE    WHEN rollno =:rollno THEN :up_no"
					+ "    END"
					+ " WHERE rollno IN (:rolno)");
			query.setParameter("rollno",roll );
			query.setParameter("up_no",updated_rollno );
			query.setParameter("rolno",roll );
			query.executeUpdate();
			transaction.commit();
			System.out.println(" updatded");
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
	public static void main(String[] args) {
		new UpdateStudent().main(2);
	}
	
}
