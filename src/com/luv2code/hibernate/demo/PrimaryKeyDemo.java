package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//creata session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session  = factory.getCurrentSession();
		
		try {
		
			
			//create  3 student objects
			System.out.println("creating 3 students objects...");
			Student tempStudentOne = new  Student("nach","baloch","Ali@gmail.com");
			Student tempStudentTwo = new  Student("sadta","sharabi","ahmed@gmail.com");
			Student tempStudentThree = new  Student("atif","aftab","asif@gmail.com");

			// start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving students...");
			session.save(tempStudentOne);
			session.save(tempStudentTwo);
			session.save(tempStudentThree);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		
		
		
		finally {
			factory.close();
		}

	}

}
