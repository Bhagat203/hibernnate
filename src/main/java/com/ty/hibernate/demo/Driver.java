package com.ty.hibernate.demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.resource.transaction.spi.TransactionStatus;

public class Driver {
	static Scanner scanner = new Scanner(System.in);
	 EntityManagerFactory factory = null;
	 EntityManager manager = null;
	 EntityTransaction transaction = null;

	private int check() {
		int rollno = 0;
		try {
			System.out.println("Enter the rollno : ");
			rollno = scanner.nextInt();
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("from Student where rollno=:rol");
			Student student = null;
			try {
				query.setParameter("rol", rollno);
				student = (Student) query.getSingleResult();
				System.out.println(student);
			} catch (NoResultException e) {
				// TODO Auto-generated catch block

				try {

					throw new IdNotFoundException();

				} catch (Exception e1) {
					// TODO: handle exception
					System.out.println(e1.getMessage());
					System.out.println(e1.getMessage());
					transaction.rollback();
					if (manager != null) {
						manager.close();
					}
					if (factory != null) {
						manager.close();
					}
					if (true) {
						return 0;
					}
					
				}
				try {
					throw new IdNotFoundException();
				} catch (Exception e1) {
					// TODO: handle exception
					e1.getMessage();
					new Driver().option3();
				}
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				manager.close();
			}

		}
		
		return rollno;
	}

	private void option1() {
		try {
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			Query query = manager.createQuery("from Student");

			List<Student> list = query.getResultList();
			for (Student student : list) {
				System.out.println(student);
			}
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

	private void option3() {
		int rollno = this.check();
		if (rollno == 0) {
			new Driver().option3();
		} else {
			try {
				new UpdateStudent().main(rollno);
				
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

	private void option2() {
		try {
			System.out.println("Enter the rollno : ");
			int rollno = scanner.nextInt();
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("from Student where rollno=:rol");
			Student student = null;
			try {
				query.setParameter("rol", rollno);
				student = (Student) query.getSingleResult();
				System.out.println(student);

			} catch (NoResultException e) {
				// TODO Auto-generated catch block
				try {
					throw new IdNotFoundException();
				} catch (Exception e1) {
					// TODO: handle exception
					System.out.println(e1.getMessage());
					transaction.rollback();
					if (manager != null) {
						manager.close();
					}
					if (factory != null) {
						manager.close();
					}

					new Driver().option2();
				}
			}

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

	private void option4() {
		try {
			System.out.println("Enter the rollno : ");
			int rollno = scanner.nextInt();
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			
			Query query = manager.createQuery("from Student where rollno=:rol");
			Student student = null;
			try {
				query.setParameter("rol", rollno);
				student = (Student) query.getSingleResult();

			} catch (NoResultException e) {
				// TODO Auto-generated catch block

				try {
					throw new IdNotFoundException();
				} catch (Exception e1) {
					// TODO: handle exception
					System.out.println(e1.getMessage());
					System.out.println(e1.getMessage());
					transaction.rollback();
					if (manager != null) {
						manager.close();
					}
					if (factory != null) {
						manager.close();
					}
					new Driver().option4();
				}

			}
			transaction.begin();
			query = manager.createQuery("delete from Student where rollno=:rollno");
			query.setParameter("rollno", rollno);
			if (query.executeUpdate() == 0) {
				System.out.println("Not deleted");
			} else {
				System.out.println("Deleted");
			}
			transaction.commit();
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
		do {
			System.out.println("Press 1 to see all the data");
			System.out.println("Press 2 to see any particular data");
			System.out.println("Press 3 to Update any particular data");
			System.out.println("Press 4 delete data");
			System.out.println("Press 5 to exit");
			int op = scanner.nextInt();
			switch (op) {
			case 1:
				new Driver().option1();
				break;
			case 2:
				new Driver().option2();
				break;
			case 3:
				new Driver().option3();
				break;
			case 4:
				new Driver().option4();
				break;

			case 5:
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);
	}
}
