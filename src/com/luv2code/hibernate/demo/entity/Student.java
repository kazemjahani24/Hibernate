package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//22.2_
@Entity 
@Table(name ="studentt")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private  String lastName;
	
	@Column(name = "email")
	private String email;
	
/*
	 
In java empty/default constructor is added automatically by compiler at the
compile time, if you don’t write it explicitly.If you ask about the usages,
 it is of no use UNTIL you have any overloaded constructor in your class.
When a class have a parameterized constructor it can not be instantiated
without passing the parameter values. In that can, if you want your class 
to be instantiated with out parameters, you will have to declare an empty constructor.
Second, many frameworks, like Hibernate, initialize all the java beans by 
calling their default/empty constructors. If default constructor is not found 
there will be an error.
	  
	 */
	public Student() {
		
	}

		// the line below is generated constructor using fields in Source option
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	

}
