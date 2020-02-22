package theory;

public class Theory {
	
	/*
	 
	  21_Hibernate:
				21.1_ what is hibernate:?
					it is a famework  for persisting/saving java obejcts in a database
					  
				21.2_Benefits of hibernate:
					hibernate handles all of the low level-SQL code.
					what that means is that it actually minimizes the amount of the code that we need to
					write for jdbc.
					hibernate provides the object-to-rational Mapping(ORM) and that makes it
					really easy to store and retrieve objects from the database. 
				
				21.3_How does Hibernate relate to jdbc??
					hibernate uses jdbc for all database communications, so really  hibernate
					is another layer of extraction on top of jdbc.  so when  our application
					uses the hibernate framework, my app store and retrieve obejcts using
					the hibernate API in the background. hibernate does all fthe low-level
					jdbc work and submitting SQL queries and so on.  so hibernate does a lot
					of the low level work for us, but in the background, it all goes through
					the standard JDBC API. so when we get into the section of learning of the
					hibernate learning work and coding,where we actully configure hibernate
					to talk to our database, we will actully configure hibernate to make use
					of jdbc driver. so again hibernate uses jdbc in the bacground for
					communicating with the database.
							to build hibernate applications the things mentioed below are required:
								1_ Java Intergrated Development Enviroment
								2_ Database 
										just create a new table in the existing exampledb schema
								3_ creating hibernate project and then in that java project we will create a
								new folder called lib. in this folder we will add our hibernate and jdbc jar files.
								after that we go to www.hibernate.org. then we see the option name Hibernate ORM
								then we click on more and then click on latest stable,then find the download file for 
								it and then download it(hibernate-release-5.4.11.Final), then i save in soft folder and extract it there to make use of the
								jars in our folders to get hibernate up and running.
								when it is downloaded then we will open it up then we will open it, then open lib, then
								open required, and copy all the jars in that folder in our lib folder in our hibernate project.
								 and in the end we will copy my-sql connector and then we paste it in the
								 same folder, and one last step which is really impottant which is 
								 adding all those jar files in our  projects class  path. and for that what we can do is just go to
	 							eclipse and then  click on our project and then we will right click on our project
	 							and then we click on properties and then click on java build path, then add jars
	 							then we go and select all the jars that we added in the lib folder,
	 							and choose all of them and then we click on apply and close.
	 							
			 				when all the steps above are done, we will test our jdbc connection if it is workin or not
			 				and to test that out we will create a new package called com.luv2code.jdbc
			 				and then create a new class in that package named TestJdbc.
			 	
			 	22_Hibernate development process
			 		22.1_ add hibernate configuration file
			 				to add this file we  will have to go to  hibernate zip file, the same one that we downloaded
			 			////the sql files to add the sql codes to the(D:\WorkSpaces\udemy\//springBoot and hibernate\new\spring-hibernate-source-code-v22\03-hibernate-5\hibernate-demo\starter-files)
			 			//	then we copy the xml file and paste it in the src of  our hibernate project
			 				
			 		//22.2_ annotate java class
			 		//	entity class is just java class that is mapped to a database table. it is class
			 		//	with fields, getter and setter methods, and then we add annotations on it to help with mapping it to a 
			 			//database. lets say we have a the class with fields, setters and getters and we want to map that class to a database
			 			//so somehow we need to tell hibernate how to map this class to the actual table and also how to map
			 			//fields to the actual colums and that is where we come to the whole mapping aspect of it. one thing to
			 			//keep in mind is that there are two ways of mapping,first option is with xml configuration file(XML), and the other one is with java annotations(modern, preferred)
			 			//so what we need to is first map our class to database table, then map fields to dayabase columns. to continue from here  go to hibernate tutorial.
			 			//first we create a new package called com.luv2code.hibernate.demo.entity.
						
						import javax.persistence.GeneratedValue;
						import javax.persistence.GenerationType;

							
			 			//then create e new class called Student and in that class we will add our mappings for the
			 			//table and the fields(means mapping our class to our database and then table,).
			 			after adding the the annotations of @Entity and @Table then we right click on that page,
			 			choose Source, then organize imports, then choose javax.persistence.Entity , then choose javax.persistence.Table 
			 			and these two are from java presistance API , which is a standard interface that hibernate implements
			 			then  we create a no argument constructor then we add  the fields and then we will 
			 			connect those fields with database using the annotations. then we will right click and
			 			then we will choose source, then organize imports and the imports for the id(when we click on orgnize imports,it will
			 			automatically add the imports that we need) . then after that we will right click choose source, then
			 			add generate constructor using fields we will not choose id because we wont use it later on becuse 
			 			it is auto-increment, after that we will create setters and getters.
			 			after that we click on source, then choose generate toString()
			 			and keep it as defult and then hit ok and then eclipse will automatically 
			 			will generate whatever is needed. the reason for generating to string is
			 			for ddebugging purposes so i can print out the obejct and get the actual
			 			details for it
			 			
			 	22.3_ develop java code to perform database operation
			 			22.3.1_firs t thing we need to know is how to save a java object when
			 			hibernating. and there are two key players that we need to be aware 
			 			and it is saved in the pictures folder of 21. first one is called
			 					SessionFactory class and we create it only once and then
			 					we keep on using it over and over again and it is a havy-weight object.and 
			 					once the session factory object is created, then that will create sessions
			 					and session is just a wrapper around a JDBC connection to the database.
			 					the session is the main object that we will use for saving and retrieving  objects
			 					from the database. unlike SessionFactory, session is short-lived object. we will
			 					use it and then throw it away again and again, so session is retrieved from the 
			 					SessionFactory.
			 			
			 			22.3.2_now we move to eclipse and start writing some code, and for that we need to
			 			right click on the src folder of our project, then we say new class and give the package 
			 			for that class as com.luv2code.hibernate.demo then  for class name we give it CreateStudentDemo.
			 			after that we will fix the imports and they are shown on top of the class.
			 				beside  all of these lets talk about primary key:primary key  
			 				uniquely identifies each row in a table and it must be a unique value
			  				and it cannot contain null. think of this way that in a university each 
			 				student has a unique student id, and so each student belongs to one student.
			 				so each primary key identifies each row in a table in database. in our model
			 				class of hibernate, we added the annotation of @Id, that means  the id is a 
			 				primary key. we will go to our Student and add the annotation for fild id(@GeneratedValue(strategy=GenerationType.IDENTITY) )
			 				after that we will create new class called primary key demo to
			 				check if this annotation is working or not.
			 				
			 				ok now one thing you might ask is how can i changge the auto
			 				incrementing valuses and customize it the way we want it to be done and incremented
			 				 if we want the table to start and increase from a certain numebr 
			 				 then we go to the database, on the top left we will  the
			 				 plus sign written sql on it. we click on it then 
			 				 write this in that new tab ALTER TABLE exmpledb.studnett AUTO_INCREMENT = 3000
			 				 Then the next id  when we enter a new value  will start from 3000.
			 				 
			 				 next if i want to reset the increment value to start from one and that can be done 
			 				 by runnig this query in the same place we run the old one: truncate exampledb.studentt
			 				 this will delete everything and it will delete all the rows of the table
			 					
			 			
			 		22.3.3_after learning the concepts above and knowing how to create an object 
			 			   in hibernate then  next we will learn about howe we can read objects in hibernate.
			 			   and to do that we will just copy the CreateStudentDemo and just change and modify it a little bit
			 			   one thing to keep in mind is that in hibernate world, we will always make use of transactions for updates and for reads
			 		
			 		22.3.4_ next we will learn about querying objects with hibernate
			 				it is a query language for retrieving objects and its
			 				nature is simillar to  SQL for example like,where, like,join
			 				for example we can create a query to retrieve all the students
			 				again for querying an object in hibernate,we will copy the 
			 				the class CreateStudentDemo.java and make changes to that class
			 				and create a new class called QueryStudents.
			 				
			 	 	22.3.4_next up  is we will learn how to update objects using hibernate:
			 	 		   one thing to keep in mind about the update part is that we simply
			 	 		   retrieve  the object,we set the value, and the we commit the transaction
			 	 		   there is no hard requirement for us to call session.save or session.update
	 						because this student object is a  continuous object that we retrieved it from
	 						database. we can simply call the appropriate setters and then fnally do a commit
	 						and that actually update the database. so after updating one student ,
	 						next we will update the first name of the all students to one 
	 						particular name.
	 						
	 				22.3.4_next up is deleting obejcts from database using hibernate
	 				there two approaches we can use to delete an object from a database,
	 				first one is we get student based on the id, and then we  use session.delete which is a 
	 				hibernate query and the second approch is using sql query delete from.
	 				
	 */

}
