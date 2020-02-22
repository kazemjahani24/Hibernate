package com.luv2code.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	
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
				Student tempStudent = new  Student("Kazem","baloch","kazembaloch@gmail.com");
				
				// start transaction
				session.beginTransaction();
				
				//save the student object
				System.out.println("saving the student...");
				System.out.println(tempStudent);
				session.save(tempStudent);
				
				//commit transaction
				session.getTransaction().commit();
				
				
				//22.3.3_New code to retrive or read data is as per line below:
					//find out student's id  that we just saved: primary key
				System.out.println( " the id of the saved student is: " + tempStudent.getId());
				
				//22.3.3_
					// now get a new session and start transaction
					session  = factory.getCurrentSession();
					session.beginTransaction();
					
					//retrive student based on the id or primary key
					 System.out.println("Getting student with id: " + tempStudent.getId());
					 Student myStudent = session.get(Student.class, tempStudent.getId());
					 System.out.println("Get complete: " + myStudent);
					 
					 //perform a commit on that transaction
					 session.getTransaction().commit();
				System.out.println("done");
				
			}
			
			
			
			finally {
				factory.close();
			}
			
		}

	}


