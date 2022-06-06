package com.zensar.ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.zensar.bean.Doctor;
import com.zensar.util.JPAUtil;

public class Main2 {
		 public static void test1() {
			EntityManager em = JPAUtil.createEntityManager("JPAIntro");
			
			TypedQuery<Doctor> query = em.createNamedQuery("findAll", Doctor.class);
			List<Doctor> list = query.getResultList();
			list.forEach(System.out::println);
			
			JPAUtil.shutDown();
		}
		 public static void test2() {
				EntityManager em = JPAUtil.createEntityManager("JPAIntro");
				
				TypedQuery<Doctor> query = em.createNamedQuery("findById", Doctor.class);
				query.setParameter("searchId", 3);
				Doctor doctor = query.getSingleResult();
				System.out.println(doctor);
				
				JPAUtil.shutDown();
				
			}
		 public static void test3() {
				EntityManager em = JPAUtil.createEntityManager("JPAIntro");
				
				em.getTransaction().begin();
				Query query = em.createNamedQuery("updateFees");
				System.out.println(query.executeUpdate());
				em.getTransaction().commit();
				
				JPAUtil.shutDown();
				
			}
		 
		 public static void test4() {
				EntityManager em = JPAUtil.createEntityManager("JPAIntro");
				
				TypedQuery<Doctor> query = em.createNamedQuery("findByGender", Doctor.class);
				query.setParameter("searchGender", "MALE");
				List<Doctor> doctors = query.getResultList();
				
				doctors.forEach(System.out::println);				
				JPAUtil.shutDown();
				
			}
		 public static void test5() {
			 EntityManager em = JPAUtil.createEntityManager("JPAIntro");
				
				em.getTransaction().begin();
				Query query = em.createNamedQuery("updateById");
				query.setParameter("searchId", 1);
				System.out.println(query.executeUpdate());
				em.getTransaction().commit();
				
				JPAUtil.shutDown();			}
		 	
		 
			public static void main(String[] args) {
				test5();
			}

}
