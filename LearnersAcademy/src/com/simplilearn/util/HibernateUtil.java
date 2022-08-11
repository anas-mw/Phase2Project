package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Courses;
import com.simplilearn.entity.EProduct;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(EProduct.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(PhoneNumber.class)
				.addAnnotatedClass(Courses.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}
