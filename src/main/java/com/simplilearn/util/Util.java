package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.details.ClassDetails;

import com.simplilearn.details.StudentDetails;
import com.simplilearn.details.SubjectDetails;
import com.simplilearn.details.TeacherDetails;

public class Util {
	
		private static SessionFactory factory;
		
		public static SessionFactory buildConnection() {
			
			factory = new Configuration().configure("hibernate0.cfg.xml")
					.addAnnotatedClass(StudentDetails.class)	
					.addAnnotatedClass(TeacherDetails.class)
					.addAnnotatedClass(ClassDetails.class)
					.addAnnotatedClass(SubjectDetails.class)
					
					.buildSessionFactory();
			
			return factory;
		}
}