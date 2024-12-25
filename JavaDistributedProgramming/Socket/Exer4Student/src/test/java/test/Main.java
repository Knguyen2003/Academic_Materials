/*
 * @ (#) Main.java	1.0	Apr 1, 2024
 * 
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import dao.CourseDAO;
import dao.impl.CourseImpl;
import entity.Course;

public class Main {

	public static void main(String[] args) {
//		Persistence.createEntityManagerFactory("jpa-mssql");

		CourseDAO courseDAO = new CourseImpl();
//		Course course = courseDAO.findByTitle2("Trigonometry");
//		System.out.println(course);
		
		courseDAO.delete(2021);
		
		Course course = courseDAO.findByID(2021);
		System.out.println(course);
	}
}
