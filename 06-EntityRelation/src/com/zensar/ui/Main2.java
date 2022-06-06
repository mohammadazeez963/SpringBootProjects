package com.zensar.ui;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.zensar.bean.pack2.Course;
import com.zensar.bean.pack2.Subject;
import com.zensar.util.JPAUtil;

public class Main2 {
	
			public static void test1() {
				Subject sub1 = new Subject("English", 20);
				Subject sub2 = new Subject("Aptitude", 10);
				Subject sub3 = new Subject("Reasoning", 27);
				//Subject sub4 = new Subject("ReactJS", 40);
				
				Set<Subject>  subs = new HashSet<>();
				subs.add(sub1);
				subs.add(sub2);
				subs.add(sub3);
				//subs.add(sub4);
				
				EntityManager em = JPAUtil.createEntityManager("JPAIntro");
			//	Course courses = new Course("Web Technologies", 30000.0, subs);
				Course courses = new Course("CRT Training", 15000.0, subs);

				
				em.getTransaction().begin();
				em.persist(courses);
				em.getTransaction().commit();
				
				JPAUtil.shutDown();
				
			}
			public static void main(String[] args) {
				test1();
			}
}
