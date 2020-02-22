package com.luv2code.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//22.3.2_
public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//creata session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session  = factory.getCurrentSession();
		
		try {
		
			
			//create  a student object 
			System.out.println("creating new student object...");
			Student tempStudentOne = new  Student("badry","egypt","badry@gmail.com");
			Student tempStudentTwo = new  Student("yaser","mesr","yaser@gmail.com");
			Student tempStudentThree = new  Student("Kazem","baloch","kazembaloch@gmail.com");
			Student tempStudentFour = new  Student("Ali","baloch","Ali@gmail.com");
			// start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student...");
			session.save(tempStudentOne);
			session.save(tempStudentTwo);
			session.save(tempStudentThree);
			session.save(tempStudentFour);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		
		
		
		finally {
			factory.close();
		}
		
	}

}
