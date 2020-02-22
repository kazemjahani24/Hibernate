package com.luv2code.hibernate.demo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//22.3.2_
public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//creata session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session  = factory.getCurrentSession();
		
		try {
		
			
			// start transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display students
			displayStudents(theStudents);
			
			/*
			now lets say i want to get the name of the sudents who's last names are baloch
		    and that can be done using the below
		    */
			theStudents = session.createQuery("from Student s where s.lastName ='baloch'").list();
			
			//display students who's last names are baloch
			System.out.println("\n\nthe students who's last name is baloch");
			displayStudents(theStudents);
			
			// query students:  last name baloch or  first name is yaser
			theStudents  = session.createQuery(" from Student s where s.lastName ='baloch' OR s.firstName = 'yaser'"  ).getResultList(); 
			
			//display students who's last names are baloch or first name is yaser
			System.out.println("\n\nthe students who's last name is baloch or first name is name is yaser");
			displayStudents(theStudents);
			
			
			// query students where email LIKE '%gmail.com'(this means all the emails ending with gmail.com, if we  put it at the end of the expression, then we are 
			//saying that all the emails that starts with gmail.com)
			theStudents =  session.createQuery("from Student s where s.email LIKE '%love2code.com'").getResultList();
			System.out.println("students who's email ends with love to code.com");
			displayStudents(theStudents);
			//commit transaction
			session.getTransaction().commit(); 
			System.out.println("done");
			
		}
		
		
		
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
