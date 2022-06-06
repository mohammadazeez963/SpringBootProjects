package com.zensar.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.zensar.bean.Doctor;
import com.zensar.util.JPAUtil;

public class Main3 {
		public static void test1() {
			EntityManager em = JPAUtil.createEntityManager("JPAIntro");
			Query query = em.createNamedQuery("readAll",Doctor.class);
			List doctors = query.getResultList();
			System.out.println(doctors);
			JPAUtil.shutDown();
					
		}
		public static void test2() {
			EntityManager em = JPAUtil.createEntityManager("JPAIntro");
			TypedQuery<Doctor> query = em.createNamedQuery("readById", Doctor.class);
			query.setParameter(1, 3);
			Doctor doctor = query.getSingleResult();
			System.out.println(doctor);
			
			
			JPAUtil.shutDown();
					
		}
		public static void main(String[] args) {
			test2();
		}
}
