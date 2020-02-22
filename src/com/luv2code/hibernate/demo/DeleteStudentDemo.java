package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
	try {
		int studentId = 3;
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve student based on the id
		System.out.println("getting student with id: +studentId");
		
		Student myStudent = session.get(Student.class, studentId);
	
		//delete the student
	///	session.delete(myStudent);
		///System.out.println("deleting student" +myStudent);
		
		
		// using the othet approch to delete a student which is using delete query
		// which is called alternate delete approach
		//delete student id = 2;
		System.out.println("deleting the student with id 2");
		session.createQuery("delete from Student where id = 2").executeUpdate();
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
	
	finally {
		factory.close();
	}
		

	}

}
