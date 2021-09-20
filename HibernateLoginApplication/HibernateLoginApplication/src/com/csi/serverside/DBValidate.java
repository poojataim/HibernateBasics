package com.csi.serverside;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DBValidate {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	
	/*public static void main(String[] args) {
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Employee e1 = new Employee();
		
		e1.setUserName("csi");
		e1.setPassword("csi@123");
		session.save(e1);
		transaction.commit();
	}*/
	static boolean isValidate(String username, String password) {
		boolean status = false;

		Session session = factory.openSession();

		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e : empList) {
			if (e.getUserName().equalsIgnoreCase(username) && e.getPassword().equalsIgnoreCase(password)) {
				status = true;
			}
		}

		return status;
	}
}
