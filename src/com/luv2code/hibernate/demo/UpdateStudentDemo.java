package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
	try {
		int studentId = 1;
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve student based on the id
		System.out.println("getting student with id: +studentId");
		
		Student myStudent = session.get(Student.class, studentId);
		System.out.println("Updating Student...");
		
		
		// so when we do the line below, it is actully saved in the
		// memory,and once we do the commit in the lines belower than that, then
		// that will update it in the database
		myStudent.setFirstName("Scooby");
		
		//commit the transaction
		session.getTransaction().commit();
		
		//new code to update all the  emails of the all the data in the database
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		// update email for all the students	
		System.out.println("update email for all the students");
		
		session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("done");
		
		
	}
	
	finally {
		factory.close();
	}
		

	}

}
